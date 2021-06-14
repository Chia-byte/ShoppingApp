<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.shop.model.Product"%>
<%@ page import="com.shop.model.Cart"%>
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
	fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
  <path
		d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
</svg>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Boutique home</title>
</head>
<body>
	<div align="center">
		<h3 style="colour: grey; font-family: Arial;">Welcome to</h3>
		<h2 style="colour: grey; font-family: Arial;">The Boutique</h2>
	</div>
	<div align="center">
		<form id="tipoForm" action="ServletDashboard" method="get">
			<select name="tipo" onchange="cambiaTipo(this.value);">
				<option selected>What are you looking for?</option>
				<option value="0">See all</option>
				<option value="1">Top</option>
				<option value="2">Dresses</option>
				<option value="3">Shoes</option>
				<option value="4">Pants</option>
				<option value="5">Accessorize</option>
			</select>
		</form>
	</div>
	<form action="ServletDashboard" method="post">
		<div style="colour: grey; font-family: Arial;"custom-controlcustom-checkbox">
			<%
			List<Product> l = (List<Product>) request.getAttribute("lista");
			for (Product p : l) {
			%><input type="checkbox" name="product" value="<%= p.getName() %>"><%=p.getName()%>
			&ensp;&emsp;Price:<%=p.getPrice()%><hr>
			<br>
			<%
			}
			%>
			<input type="submit" value="Add to cart">
			</td>
		</div>
	</form>
	<h3>Your cart</h3>
	<form action="ServletDashboard" method="post">
		<div style="colour: grey; font-family: Arial;"custom-controlcustom-checkbox">
			<%
				List<Product> k = (List <Product>) request.getAttribute("listadelcarrello");
				if (k.isEmpty()){
			%>
			<p>Your cart is empty!</p>
			<%
				}else{
				for (Product p : k) {
			%>
			<ul class="list-group">
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<%=p.getName()%> <span class="badge badge-primary badge-pill"><%=p.getPrice()%></span>
				</li>
			</ul>

		    <%
				}
			}
			%>
			<p>Total: ${totale} </p>
				</form>	</div>
		<script type="text/javascript">
			function cambiaTipo(value) {
				var form = document.getElementById('tipoForm');
				form.action = "ServletDashboard?tipo=" + value;
				form.submit();
			}
		</script>
</body>
</html>