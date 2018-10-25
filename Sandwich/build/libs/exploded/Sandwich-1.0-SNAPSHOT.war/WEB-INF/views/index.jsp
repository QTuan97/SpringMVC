<%--
  Created by IntelliJ IDEA.
  User: quet
  Date: 10/25/18
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="post">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="lettuce" value="lettuce" name="condiment">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="tomato" value="tomato" name="condiment">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="mustard" value="mustard" name="condiment">
    <label for="sprouts">Sprouts</label>
    <input type="checkbox" id="sprouts" value="sprouts" name="condiment">
    <input type="submit" value="OK">
</form>
    <h1>${say} ${condiments}</h1>
</body>
</html>
