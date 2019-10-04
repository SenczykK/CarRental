<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One</title>
</head>
<body>
<h1>Zapisano</h1>
	<br>
	Rodzaj pojazdu: ${day.vehicle} <br>
		Nazwa/Numer pojazdu: ${day.nameOfVehicle}<br>
		Kolor: ${day.color}<br>
		Data produkcji: ${day.productionDate}<br>
		Nazwa wypozyczajacego: ${day.user}<br>
		Data wypozyczenia: ${day.rentDate}<br>
	
</body>
</html>