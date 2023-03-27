package com.example.telimprompturevised.Servlets;

import com.example.telimprompturevised.GameInfo;
import com.example.telimprompturevised.Player;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GameInfo gameInfo = GameInfo.getInstance();
        HttpSession session = request.getSession(true);

        String userName = request.getParameter("userName");
        String userId = UUID.randomUUID().toString();

        if (userName.isEmpty()) {
            session.setAttribute("errorMessage", "Username cannot be empty");
            response.sendRedirect("index.jsp");
            return; // Stops the code from continuing with an empty name
        }

        for (Player player : gameInfo.getPlayers()) {
            if (player.getUserName().toLowerCase().equals(userName.toLowerCase())) {
                session.setAttribute("errorMessage", "There is already a user with the name " + userName);
                response.sendRedirect("index.jsp");
                return;
            }
        }

        Player player = new Player(userName, userId);
        userName = player.getUserName();
        gameInfo.addPlayer(player);
        if (gameInfo.getNumJoined() == 1) {
            gameInfo.setHost(player); // Will only happen with the first player
        }

        session.setAttribute("userName", userName);
        session.setAttribute("userId", userId);
        session.setAttribute("isHost", gameInfo.checkIfPlayerIsHost(userId));

        response.sendRedirect("index.jsp");
    }

    public void destroy() {
    }
}