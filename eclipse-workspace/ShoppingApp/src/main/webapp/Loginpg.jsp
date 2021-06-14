<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Boutique Login</title>
</head>
<body>
	<div align="center">
		<h2 style="colour: grey; font-family: Arial;">Login into the Boutique</h2>
		<form action="LoginServlet" method="post">
			<table>
				<tr>
					<td>Username: <input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password: <input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="enter"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>