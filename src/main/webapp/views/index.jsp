<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
html, body {
	display: flex;
	justify-content: center;
	font-family: Roboto, Arial, sans-serif;
	font-size: 15px;
}

form {
	border: 5px solid #f1f1f1;
}

input[type=text], input[type=text] {
	width: 100%;
	padding: 16px 8px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #8ebf42;
	color: white;
	padding: 14px 0;
	margin: 10px 0;
	border: none;
	cursor: grabbing;
	width: 100%;
}

h1 {
	text-align: center;
	fone-size: 18;
}

button:hover {
	opacity: 0.8;
}

.formcontainer {
	text-align: left;
	margin: 24px 50px 12px;
}

.container {
	padding: 16px 0;
	text-align: left;
}

span.amount {
	float: right;
	padding-top: 0;
	padding-right: 15px;
}
</style>
<title>Add Expenses</title>
</head>
<body>

	<div class="container">
		
			<h2>Expense Tracker</h2>
			<h3>YOUR BALANCE</h3>
			<h3>
				<span>&#8377;</span> ${amount}
			</h3>
	
	<div class="w3-panel w3-card">
			<table border="0" width="500px">
				<tr>
					<th>Income</th>
					<th>Expense</th>
				</tr>
				<tr>
				
					<td><span>&#8377;</span> ${incomeVal}</td>
					<td><span>&#8377;</span> ${expense}</td>
				
				</tr>
			</table>
		</div>
		
		<div class="w3-panel w3-card">
		<h3>History</h3>
		<h5>(Remove previous history)</h5>
		<table border="0" width="500px">
			<tr class="w3-panel w3-card">
				<th>Name</th>
				<th>Amount</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${expList}">
				<tr class="w3-panel w3-card">
					<td>${item.getName()}</td></div>
					<td><span>&#8377;</span> ${item.getAmount()}</td>
					<td><a
						href="${pageContext.request.contextPath }/${item.getId()}"
						onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>

		<form action="addExpense" method="post">
			<h1>Add new expenses</h1>
			<div class="formcontainer">
				<hr />
				<label for="name"><strong>Name</strong></label> <input type="text"
					placeholder="Enter items.." name="name" required> <label
					for="amount"><strong>Amount</strong></label> 
					<br>
					<strong>(negative -expense, positive +income)</strong> <input type="text"
					placeholder="Enter amount" name="amount" required>
			</div>
			<button type="submit">Add Transaction</button>

		</form>
	</div>
</body>
</html>