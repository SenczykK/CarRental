<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One</title>
</head>
<body>
<h1>Zapisano samochod o danych</h1>
	<br>
	<table>
		<th>
			<td> Rodzaj pojazdu </td>
			<td> Nazwa pojazdu </td>
			<td> Nazwa producenta </td>
			<td> Kolor </td>
			<td> Data produkcji </td>
			<td> Nazwa wypozyczajacego </td>
			<td> Data wypozyczenia </td>
			<td> Akcja </td>
		</th>
		<br>
		<tr>
			<td> </td>
			<td> ${day.typeOfVehicle} </td>
			<td> ${day.nameOfVehicle} </td>
			<td> ${day.producerName} </td>
			<td> ${day.color} </td>
			<td> ${day.productionDate} </td>
			<td> ${day.user} </td>
			<td> ${day.rentDate} </td>
			<td> <form><input type="radio"/></form> </td>
		</tr>
	</table>
	<a href="/"><button>Main page</button></a>
</body>
</html>