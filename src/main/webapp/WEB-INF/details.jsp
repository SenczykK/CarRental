
<!DOCTYPE html>
<html>
<head>

<title>View One</title>
</head>
<body>
<h1>Details ${day.date }</h1>
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
<a href="/addCar"><button>Add</button></a><a href="/editCar"><button>Edit</button></a>
<a href="/delete"><button>Delete</button></a><a href="/details"><button>Details</button></a>
<a href="/"><button>Main page</button></a>
</body>
</html>