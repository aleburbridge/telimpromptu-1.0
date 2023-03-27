<%@ page import="com.example.telimprompturevised.GameInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tellimpromptu</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="content">

<% GameInfo gameInfo = GameInfo.getInstance(); %>
<% if ((boolean) session.getAttribute("isHost")) { %>

    <form action="submitResponse" method="post">
        <p>Congratulations! Since you're the host, you get to decide what the story is for today's broadcast. Feel free to poll the other players (or not).
        <br>Ex. "Scrappy-doo has been found dead in Miami"</p>
        <input id="storyResponse" name="storyResponse" style="width: 400px"></input>
        <button type="Submit">Submit</button>
    </form>

<% } else if (!(boolean) session.getAttribute("isHost")) { %>

    <p>The host is currently coming up with the story. Refresh this page once the story is submitted</p>

<% } if  (gameInfo.getSequence() > 0) {
    response.sendRedirect("game.jsp");
    }
%>

</div>
</body>
</html>