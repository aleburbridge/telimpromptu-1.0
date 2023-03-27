package com.example.telimprompturevised.Servlets;

import com.example.telimprompturevised.GameInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "teleprompter", value = "/teleprompter")
public class TeleprompterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        GameInfo gameInfo = GameInfo.getInstance();

        // this servlet knows too much :O
        gameInfo.setIsGameStartedByHost(true);
        gameInfo.assignRoles();
        gameInfo.assignAllPrompts();
        // All users need to be redirected to story.jsp
        session.setAttribute("isStorySubmitted",true);

        response.sendRedirect("story.jsp");
    }

    public void destroy() {}
}
