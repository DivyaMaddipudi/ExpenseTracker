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
<h3>Add initial amount</h3>
<form action="addInitialAmount" method="post">
	 
	Enter total monthly Amount :
	<br>
	<br>
	<input type="text" name="basicAmount" placeholder="Add initial amount" required>
	<br>	
	<input type="submit">
</form>
</body>
</html>