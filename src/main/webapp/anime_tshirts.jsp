<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Аниме и манга - Geek shop</title>
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
        <a href="sign_in.jsp" class="button">Вход</a>
        <a href="create_user.jsp" class="button">Регистрация</a>
      </form>

		</header>
		<nav>
			<ul class="top-menu">
				<li><a href="main.jsp">Главная</a></li>
				<li class="active">Каталог</li>
			</ul>
		</nav>
			<aside>
			<nav>
				<ul class="aside-menu">
					<li><a href="anime.jsp">Все товары</a></li>
					<li class="active">Футболки</li>
					<li><a href="">Кружки</a></li>
					<li><a href="">Постеры</a></li>
					<li><a href="">Носки</a></li>
					<li><a href="">Брелки</a></li>
					<li><a href="">Книги и комиксы</a></li>
					<li><a href="">Игрушки</a></li>
					<li><a href="">Стикеры</a></li>
				</ul>
			</nav>
			</aside>
<div class="container content">
	<div class="row">
		<div class="col-md-8 products">
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="src/img/naruto1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Футболка "Наруто"</a>
						</p>
						<p class="product-desc">Хлопковая футболка. Размер М (унисекс)</p>
						<p class="product-price">Цена: 1000р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<script>
$(function(){



});
	</script>

</body>
</html>