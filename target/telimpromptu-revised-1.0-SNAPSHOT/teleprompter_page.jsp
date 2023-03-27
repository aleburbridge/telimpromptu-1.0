<%@ page import="com.example.telimprompturevised.GameInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Telimpromptu</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%=GameInfo.getInstance().generateText()%>

<script>
    const delay = ms => new Promise(res => setTimeout(res, ms));

    const scrollFunction = async () => {
        while (true) {
            await delay(100);

            window.scrollTo(0, window.scrollY + 1)
        }
    }

    scrollFunction()
</script>
</body>
</html>
