<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One</title>
</head>
<body>
<h1>Insert Car details to borrow it</h1>
	<br>
	
	<form method="post" action="/borrow">
		Id of vehicle: <input type="number" name="id"/><br>
		Nazwa wypozyczajacego: <input name="user"><br>
		Data wypozyczenia: <input type="text" name="rentDate"><br>
		<br>
		<input type="submit" value="Send">
	</form>

	
</body>
</html>