
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<title>View One</title>
</head>
<body>
<h1>Details ${date}</h1>
	<br>
	
	<table id = "table_1">
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
	</table>
	
	<script>
		var path = "http://localhost:8080/JSON/details";
		
		fetch(path, { method: "POST" })
		.then((resp) => {
			return resp.json()
		})
		.then((data) => {
			addRow(data);
			var checkedOption = Array.from(document.querySelectorAll('.radioSelector'))
	
			checkedOption.forEach(option => option.addEventListener('change', () => changePage(option.id)))
		})
		.catch((error) => {
			console.log(error);
		});
		
		
		var table = document.getElementById("table_1");
		
		function addRow(data){
			for(var i=0; i< data.length; i++ ){
				
				table.innerHTML += `<tr>
				<td></td>
				<td>`+data[i].typeOfVehicle+`</td>
				<td>`+data[i].nameOfVehicle+`</td>
				<td>`+data[i].producerName+`</td>
				<td>`+data[i].color+`</td>
				<td>`+data[i].productionDate+`</td>
				<td>`+data[i].user+`</td>
				<td>`+data[i].rentDate+`</td>
				<td><input class="radioSelector" type="radio" id="radio-` + data[i].id +`" name="drone"></td>
				</tr>`
			}
		}
		
		function changePage(optionId){
			var temp = document.getElementById("buttonEdit")
			var temp1 = document.getElementById("buttonDelete")

			temp.setAttribute("href", "localhost:8080/editCar/" + optionId.split('-')[1])
			temp1.setAttribute("href", "localhost:8080/delete/" + optionId.split('-')[1])
		}
		
	</script>
	
<a href="/addCar"><button>Add</button></a><a href="/editCar" id="buttonEdit" ><button>Edit</button></a>
<a href="/delete" id="buttonDelete"><button>Delete</button></a>
<a href="/"><button>Main page</button></a>
</body>
</html>