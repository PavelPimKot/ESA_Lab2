<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Личный кабинет - Принятые заказы</title>
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
        <a href="main" class="button">Главная</a>
      </form>
		</header>
	</div>
	<div>
	<form name = "sign_into" action="<%=request.getContextPath()%>/logIn">
  	<ul>
    <li>
      <label for="login">Логин:</label>
      <input type="sign_text" id="login" name="login" required>
	</li>
	<p></p>
    <li>
      <label for="password">Пароль:</label>
      <input type="sign_text" id="password" name="password" required>
    </li>
    <p></p>
    <li class="but">
  		<button type="submit">Войти</button>
	</li>
  	</ul>
  </form>
</div>
</body>
</html>