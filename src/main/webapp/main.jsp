<%@ page import="java.util.List" %>
<%@ page import="com.example.esa_lab2.entities.Category" %>
<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Geek shop</title>
	<link href="src/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">

	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
	<div id="wrapper">

		<header>
			<a href=""><img src="src/img/logo3.png" alt="Geek shop logo"></a>
      <form name="sign_in">
        <a href="sign_in.jsp" class="button">Вход</a>
        <a href="create_user.jsp" class="button">Регистрация</a>
		  <%
			  String userRole = (String)request.getSession().getAttribute("userRole");
			  if(userRole != null) {
				  if (userRole.equals("Admin")) {
					  out.println("<a href=\"lk_admin\" class=\"button\">Личный кабинет</a>");
				  } else {
					  out.println("<a href=\"lk_user\" class=\"button\">Личный кабинет</a>");
				  }
			  }
		  %>
      </form>
		</header>
		<nav>
			<ul class="top-menu">
				<li class="active">Главная</li>
				<li>
                	<a href="items?categoryId=0" >Все товары</a>
                </li>
			</ul>
		</nav>
			<aside>
			<nav>
				<ul class="aside-menu">
					<%
						List<Category> categories =  (List<Category>) request.getAttribute("categories");
						if( categories == null){
							categories = (List<Category>) request.getSession().getAttribute("categories");
						}
						if(!categories.isEmpty()) {
							for (Category category : categories) {
								out.println(
										"<li>" +
												"<a href=\"items?categoryId="+ category.getId() +"\" >" + category.getName() + "</a>" +
												"</li>"
								);
							}
						}
					%>
				</ul>
			</nav>
			</aside>
		<div id="heading">
			<h1>О нас</h1>
		</div>
		<section>
			<blockquote>
			<p>
				“Раньше мне было стыдно за то, что я обычный автор комиксов, в то время как другие строили мосты или делали карьеру в медицине. Но потом я начал понимать: развлечения – одна из важнейших вещей в жизни людей. Без них люди бы ушли в глубокую депрессию.”
			</p>
			<cite>Стэн Ли</cite>
			</blockquote>
			<p>Добро пожаловать в магазин комиксов "Geek shop"</p>
			<p>Мы стараемся как можно чаще пополнять ассортимент товаров, чтобы ты всегда смог найти здесь всё, что захочется!</p>
			<p>А так же в нашем магазине ты можешь найти подарки почти для каждого, ведь у нас очень большой выбор тематик!</p>
<h2>Создатели</h2>
<div class="team-row">
	<figure>
		<img src="src/img/pavel.jpg" alt="">
		<figcaption>Пимуков Павел<span>Программист</span></figcaption>
	</figure>
	<figure>
		<img src="src/img/irina.jpg" alt="">
		<figcaption>Уральцева Ира<span>Программист</span></figcaption>
	</figure>

</div>
		</section>
	</div>
	<footer>
		<div id="footer">
			<div id="twitter"></div> 
			<div id="sitemap"></div>
			<div id="social"></div>
			<div id="footer-logo"></div>
		</div>
	</footer>
</body>

