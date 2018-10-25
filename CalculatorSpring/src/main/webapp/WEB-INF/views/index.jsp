<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post">
<h1>Calculator</h1>
<label for="fristnum">Frist number</label>
<input name="frist" id="fristnum">
<label for="secnum">Second number</label>
<input name="second" id="secnum">
<br>
<input type="submit" name="operation" id="addition" value="Addition(+)">
<input type="submit" name="operation" id="subtraction" value="Subtraction(-)">
<input type="submit" name="operation" id="multipilication" value="Multiplication(*)">
<input type="submit" name="operation" id="division" value="Division(/)">
<br>
<p>${say} ${result}</p>
</form>
</body>
</html>
