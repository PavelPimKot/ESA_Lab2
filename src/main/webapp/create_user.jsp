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
	<form name = "create_user" action="<%=request.getContextPath()%>/register">
  	<ul>
    <li>
      <label for="name">Имя:</label>
      <input type="sign_text" id="name" name="user_name" required>
	</li>
	<p></p>
    <li>
      <label for="lastname">Фамилия:</label>
      <input type="sign_text" id="lastname" name="user_lastname" required>
    </li>
    <p></p>
    <li>
      <label for="secondname">Отчество:</label>
      <input type="sign_text" id="secondname" name="user_secondname">
    </li>
    <p></p>
    <li>
      <label for="birthday">Дата рождения:</label>
      <input type="sign_text" id="birthday" name="user_birthday" required>
    </li>
    <p></p>
    <li>
      <label for="mail">Email:</label>
      <input type="sign_text" id="mail" name="user_mail" required>
    </li>
    <p></p>
    <li>
      <label for="login">Логин:</label>
      <input type="sign_text" id="login" name="user_login" required>
    </li>
    <p></p>
    <li>
      <label for="pass">Пароль:</label>
      <input type="sign_text" id="pass" name="user_pass" required>
    </li>
    <p></p>
    <li>
      <label for="phone">Телефон:</label>
      <input type="sign_text" id="phone" name="user_phone" required>
    </li>
    <p></p>
    <li>
      <label for="adr">Адрес:</label>
      <input type="sign_text" id="adr" name="user_adr" required>
    </li>
    <p></p>
    <li class="but">
  		<button type="submit">Зарегистрироваться</button>
	</li>
  	</ul>
  </form>
  <p></p>
</div>
</body>
</html>