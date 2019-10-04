<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One</title>
</head>
<body>
<h1>Insert Car details</h1>
	<br>
	
	<form method="post" action="/addCar">
		Id: <input type="number" name="id"/><br>
		Data wypozyczenia: <input name="date"/><br>
		Nazwa/Numer pojazdu: <input name="nameOfVehicle"><br>
		Nazwa producenta: <input name="producerName"/><br>
		Kolor: <input name="color"><br>
		Data produkcji: <input type="text" name="productionDate"><br>
		Nazwa wypozyczajacego: <input name="user"><br>
		Data wypozyczenia: <input type="text" name="rentDate"><br>
		<br>
		<input type="submit" value="Send">
	</form>

	
</body>
</html>