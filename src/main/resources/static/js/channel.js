<!DOCTYPE html>
<html xmlns:th="http://thyemleaf.org">
    <head>
        <meta charset="UTF-8"/>
        <title>Chat Room</title>
        <script type="text/javascript" src="/js/channel.js"></script>
    </head>
    <body>
    <div>
        <h2 align="center" th:inline="text">Welcome, [[${user.name}]]</h2>
        <h3 align="center">Start a Conversation below</h3>
        <hr style="height: 2px; border:none; color: #333; background-color:#333;"/>
    </div>

    <div align="center" >
        <textarea style="width: 500px; height: 150px; margin: 50px" id="textBx" ></textarea>

    </div>

    </body>



</html>