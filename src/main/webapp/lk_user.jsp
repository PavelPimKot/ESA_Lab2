
<%@ page import="com.example.esa_lab2.dto.ShoppingCardElementRecord" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Личный кабинет - Корзина</title>
	<link href="src/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
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
        <a href="main" class="button">Главная</a>
        <a href="main" class="button">Выйти</a>
      </form>

		</header>
		<nav>
			<ul class="top-menu">
				<li><a class="active">Корзина</a></li>
				<li><a href="my_orders">Мои заказы</a></li>
			</ul>
		</nav>
	</div>
<div class="shopping-cart">
      <!-- Title -->
      <div class="title">
        Корзина
      </div>
<form name = "offer_order" action="<%=request.getContextPath()%>/offerOrder ">
    <%
        List<ShoppingCardElementRecord> recordList = (List<ShoppingCardElementRecord>) request.getAttribute("shoppingCardList");
        if (recordList != null && !recordList.isEmpty()) {
            for (ShoppingCardElementRecord record : recordList) {
                out.println("<div class=\"item\">\n" +
                        " \n" +
                        "        <div>\n" +
                        "          <img src=\""+record.getPictureUrl()+"\" alt=\"\" />\n" +
                        "        </div>\n" +
                        " \n" +
                        "        <div class=\"shoppingcart_desc\">\n" +
                        "          <span>"+ record.getName() +"</span>\n" +
                        "        </div>\n" +
                        " \n" +
                        "        <div class=\"shopping\">\n" +
                        "          <button class=\"bminus\" type=\"submit\" name=\"button\">-</button>\n" +
                        "          <input type=\"text\" id=\"counter\" name=\""+ record.getElementId() +"\" value=\"1\" min=\"1\" step=\"1\" title=\"Кол-во\">\n" +
                        "          <button class=\"bplus\" type=\"submit\" name=\"button\">+</button>\n" +
                        "        </div>\n" +
                        " \n" +
                        "        <div class=\"total-price\">"+record.getCost()+"р.</div>\n" +
                        "      </div>");
            }
        }
    %>
    <li class="but">
        <button type="submit">Оформить заказ</button>
    </li>
</form>
    </div>
    <script type="text/javascript">
      $('.bminus').on('click', function(e) {
    e.preventDefault();
    var $this = $(this);
    var $input = $this.closest('div').find('input');
    var value = parseInt($input.val());
 
    if (value > 1) {
        value = value - 1;
    } else {
        value = 0;
    }
 
  $input.val(value);
 
});
 
$('.bplus').on('click', function(e) {
    e.preventDefault();
    var $this = $(this);
    var $input = $this.closest('div').find('input');
    var value = parseInt($input.val());
 
    if (value < 100) {
        value = value + 1;
    } else {
        value =100;
    }
 
    $input.val(value);
});
    </script>

</body>
</html>