<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View One</title>
</head>
<body>
<h1>Ekran 1</h1>
Wpisz date w formacie dd-mm-yyyy aby zobaczyc wypozyczenie.</br></br>

<form action="/details" method="POST">
Data: <input name="date" />
<button>Submit</button>
</form>	
	
</body>
</html>