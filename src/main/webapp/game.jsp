<%@ page import="com.example.telimprompturevised.GameInfo" %>
<%@ page import="com.example.telimprompturevised.Player" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tellimpromptu</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<% GameInfo gameInfo = GameInfo.getInstance(); %>
<% Player thisSessionPlayer = gameInfo.getPlayerByUserId((String) session.getAttribute("userId")); %>

<div class="players">
    <% for (Player player : gameInfo.getPlayers()) { %>
    <p><%= player.getRoleTitle() %>: <%= player.getUserName() %></p>
    <% } %>
</div>
<div class="content">

    <% if (gameInfo.getSequence() == 4) { %>
    <% response.sendRedirect("teleprompter_page.jsp");%>
    <% }  else { %>

    <p>Story of the night: <%= gameInfo.getStory() %></p>

    <% if (thisSessionPlayer.getPromptBySequenceNum(gameInfo.getSequence()).getResponse() != null) { %>

    <% for (Player player : gameInfo.getPlayers()) { %>
    <% if (player.getPromptBySequenceNum(gameInfo.getSequence()).getResponse() == null) { %>
    <p><%=player.getUserName()%> has sticky fingers!</p>
    <% }  %>
    <% }  %>
    <% } else { %>
    <% if (thisSessionPlayer.getPromptBySequenceNum(gameInfo.getSequence()).getNumOfInputBoxesNeeded() == 3) { %>

    <form action="submitResponse" method="post">
        <p><%= gameInfo.getPlayerByUserId((String) session.getAttribute("userId")).getPromptBySequenceNum(gameInfo.getSequence()).getText() %></p><br>
        <label for="question_1">Question 1</label>
        <input id="question_1" name="question_1" style="width: 400px"></input><br>
        <label for="question_2">Question 2</label>
        <input id="question_2" name="question_2" style="width: 400px"></input><br>
        <label for="question_3">Question 3</label>
        <input id="question_3" name="question_3" style="width: 400px"></input><br>
        <button type="Submit">Submit</button>
    </form>

    <% } else if (thisSessionPlayer.getPromptBySequenceNum(gameInfo.getSequence()).getNumOfInputBoxesNeeded() == 2) { %>

    <form action="submitResponse" method="post">
        <p><%= gameInfo.getPlayerByUserId((String) session.getAttribute("userId")).getPromptBySequenceNum(gameInfo.getSequence()).getText() %></p><br>
        <label for="expertTitle">Expert Title</label>
        <input id="expertTitle" name="expertTitle" style="width: 400px"></input><br>
        <label for="expertField">Expert Field</label>
        <input id="expertField" name="expertField" style="width: 400px"></input><br>
        <button type="Submit">Submit</button>
    </form>

    <% } else { %>
    <% if (gameInfo.getSequence() == 2 &&  thisSessionPlayer.getPromptBySequenceNum(2).getRoleTitle() == "Guest Expert") { %>
    <p>Guest Expert Title: <%=gameInfo.getExpertTitle()%></p>
    <p>Guest Expert Field of Expertise: <%=gameInfo.getExpertField()%></p>
    <% } %>

    <% if (gameInfo.getSequence() == 2 || gameInfo.getSequence() == 3 && thisSessionPlayer.getPromptBySequenceNum(gameInfo.getSequence()).getRoleTitle() == "Witness") { %>
    <p>The Witness will talk in a <%=gameInfo.getWitnessVoice()%> voice</p>
    <% } %>


    <form action="submitResponse" method="post">
        <p><%= gameInfo.getPlayerByUserId((String) session.getAttribute("userId")).getPromptBySequenceNum(gameInfo.getSequence()).getText() %></p><br>
        <input id="playerResponse" name="playerResponse" style="width: 400px"></input><br>
        <button type="Submit">Submit</button>
    </form>

    <% } %>
    <% } %>
    <% } %>

</div>
</body>
</html>