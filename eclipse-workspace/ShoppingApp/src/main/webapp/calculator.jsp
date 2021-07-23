<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.Product"%>
<%@ page import="com.shop.dao.ProductDao"%>
<%@ page import="com.shop.model.Cart"%>
<!DOCTYPE html>
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Boutique home</title>
</head>
<body>
	<div align="center">
		<h3 style="colour: grey; font-family: Arial;">Welcome to</h3>
		<h2 style="colour: grey; font-family: Arial;">The Boutique</h2>
	</div>
</body>
<div style="colour: grey; font-family: Arial;"custom-controlcustom-checkbox">
	<table id="table" class="table">
		<table id="table" class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Articolo</th>
					<th scope="col">Tipo</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Quantità in magazzino</th>
					<th scope="col">Spesa Totale</th>
					<th scope="col">Saldo</th>
					<th id="data" style="display: none;">Data</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Product> lista = ProductDao.getAllProducts();
				int i=0;
				for (Product p : lista) {
				%>
				<tr class="riga">
					<td id = "name"><%=p.getName()%></td>
					<td><%=p.getType().getType()%></td>
					<td onchange="formatString(this.value);" contenteditable='true'
						id="price" class="price"><%=p.getPrice()%></td>
					<td onchange="formatString(this.value);" contenteditable='true'
						id="quantity" class="quantity"><%=p.getQuantity()%></td>
					<td id="spesa"><%=p.getSpesaTotale()%></td>
					<td id="option" class="option"><select id="<%=i%>" class ="saldo"
						onchange="addInsertDataCol(this)">
							<option value="N">N</option>
							<option value="S">S</option>
					</select></td>
					<td id ="id" style="display: none;" class="data"><input type="date"
						id="dataId" value="Insert data" min="1950-01-01" max="2021-07-12"></td>
					<%
					i++;}
					%>
				</tr>

				<script src="file.js"></script>
			</tbody>
		</table>
	</table>
</html>