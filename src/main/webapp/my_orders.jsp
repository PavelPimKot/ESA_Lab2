<%@ page import="com.example.esa_lab2.entities.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Личный кабинет</title>
	<link href="src/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div id="wrapper">

		<header>
			<a href="/"><img src="src/img/logo3.png" alt="Geek shop logo"></a>
      <form name="sign_in">
        <a href="main.jsp" class="button">Главная</a>
        <a href="main.jsp" class="button">Выйти</a>
      </form>

		</header>
		<nav>
			<ul class="top-menu">
				<li><a href="lk_user">Корзина</a></li>
				<li><a  class="active">Мои заказы</a></li>
			</ul>
		</nav>
	</div>
	<div class="order-list">
      <!-- Title -->
      <div class="title">
        Мои заказы
      </div>
 
 	  <!-- Шапка -->
 	    <div class="order">
 
        <div class="order-id-main">
          <span>Номер заказа</span>
        </div>
        <div class = "order-date-main">Дата заказа</div>

        <div class = "order-status-main">Статус</div>
        <div class="order-price-main">Стоимость</div>
    </div>

        <%
            List<Order> orders = (List<Order>) request.getAttribute("orders");
            if(orders != null && !orders.isEmpty()){
            for(Order order : orders){
                out.println("<div class=\"order\">\n" +
" \n" +
"        <div class=\"order-id\">\n" +
"          <span>"+ order.getId() +"</span>\n" +
"        </div>\n" +
"        <div class = \"order-date\">" + order.getOrderDate()+"</div>\n" +
"\n" +
"        <div class = \"order-status\">"+ order.getStatus() +"</div>\n" +
" \n" +
"        <div class=\"order-price\">"+order.getCost() +"</div>\n" +
"      </div>");
            }
            }
        %>
</body>
</html>