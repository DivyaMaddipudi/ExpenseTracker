<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h2>Expense Tracker</h2>
<hr>
<h3>Add initial salary</h3>
<form action="addInitialAmount" method="post">
	Text :
	<br>
	<input type="text" name="initialAmount" placeholder="Initial amount">
	<br> 
	Enter Monthly Amount :
	<br>
	(negative -expense, positive +income)
	<br>
	<input type="text" name="basicAmount" placeholder="Add initial amount">
	<br>	
	<input type="submit">
</form>
</body>
</html>