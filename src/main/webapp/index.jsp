<%@ page import="com.example.telimprompturevised.GameInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tellimpromptu</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="teleprompter-drawing">
    <img src="./teleprompter_drawing.png" alt="lil teleprompter" id="teleprompter" width="250" height="250">
</div>
<div class="content">
    <% Object userId = session.getAttribute("userId"); %>
    <% if (userId == null) { %>

        <form action="login" method="post">
            <label for="userName">Enter your name</label>
            <input type="text" id="userName" name="userName">
            <button type="submit">Login</button>
        </form>

        <% String errorMessage = (String) session.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>

            <br>
            <div class="error-message"><%= errorMessage %></div>

        <% } %>
    <% } else { %>
        <% GameInfo gameInfo = GameInfo.getInstance(); %>
        <% Object userName = session.getAttribute("userName"); %>

        <p>Playing as <%= userName %></p>
        <p>Waiting for <span class="pulse-animation"><%= gameInfo.getNumberOfPlayersNeededToStartGame() %></span> players</p>

            <% if ((boolean) session.getAttribute("isHost")) { %>

            <p>You are the host. Refresh the page once all players are connected to see the Start Game button.</p>

                <% if (gameInfo.getNumberOfPlayersNeededToStartGame() == 0) { %>

                <form action="startGame" method="post">
                    <button type="submit">Start Game</button>
                </form>

                <% } %>
            <% } %>
        <% if (gameInfo.isGameStartedByHost()) { %>
            <% response.sendRedirect("story.jsp"); %>
        <% } %>
    <% } %>
</div>
</body>
<script>
    const teleprompter = document.getElementById("teleprompter");
    setInterval(function() {
        if (teleprompter.src.includes("teleprompter_drawing.png")) {
            teleprompter.src = "./teleprompter_drawing2.png";
        } else {
            teleprompter.src = "./teleprompter_drawing.png";
        }
    }, 500); // Change the time interval (in milliseconds) to control the speed of the animation
</script>
</html>