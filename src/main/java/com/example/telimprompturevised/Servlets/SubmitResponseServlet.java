package com.example.telimprompturevised.Servlets;

import com.example.telimprompturevised.GameInfo;
import com.example.telimprompturevised.Player;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "submitResponse", value = "/submitResponse")
public class SubmitResponseServlet extends HttpServlet {

    public void handleResponseBySequenceNum(HttpServletRequest request) {
        HttpSession session = request.getSession();
        GameInfo gameInfo = GameInfo.getInstance();
        Player player = gameInfo.getPlayerByUserId((String) session.getAttribute("userId"));
        int sequence = gameInfo.getSequence();

        if (sequence < 4) {
            Player victim = gameInfo.getPlayerByRoleTitle(player.getPromptBySequenceNum(sequence).getRoleTitle());

            if (Objects.equals(victim.getRoleTitle(), "Guest Expert") && sequence == 1) {
                gameInfo.setExpertTitleAndField(request.getParameter("expertTitle"), request.getParameter("expertField"));
                player.getPromptBySequenceNum(sequence).setResponse("Title and Field Response");
            } else if (Objects.equals(victim.getRoleTitle(), "Host") && sequence == 2) {
                gameInfo.setHostQuestions(
                        request.getParameter("question_1"),
                        request.getParameter("question_2"),
                        request.getParameter("question_3")
                );
                player.getPromptBySequenceNum(sequence).setResponse("Host Questions Response");
            } else {
                if (Objects.equals(victim.getRoleTitle(), "Witness") && sequence == 1) {
                    gameInfo.setWitnessVoice(request.getParameter("playerResponse"));
                }
                String response = request.getParameter("playerResponse");
                player.getPromptBySequenceNum(sequence).setResponse(response);
                victim.setPartScriptBySequenceNum(sequence, response);
            }
        }

        gameInfo.incrementResponsesReceived();
        gameInfo.nextRoundCheck();
        System.out.println(sequence);

        if (sequence == 4) {
            System.out.println(gameInfo.generateText());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        GameInfo gameInfo = GameInfo.getInstance();
        Player player = gameInfo.getPlayerByUserId((String) session.getAttribute("userId"));

        if (gameInfo.getSequence() > 0) {
            handleResponseBySequenceNum(request);
        }

        if (gameInfo.checkIfPlayerIsHost(player.getUserId()) && gameInfo.getSequence() == 0) {
            String storyResponse = request.getParameter("storyResponse");
            gameInfo.setStory(storyResponse);
            gameInfo.incrementSequence();
        }

        response.sendRedirect("game.jsp");
    }

    public void destroy() {}
}
