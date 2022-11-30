<%@ page import="com.example.esa_lab2.entities.Product" %>
<%@ page import="com.example.esa_lab2.entities.Section" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Каталог товаров</title>
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
				<li><a href="main">Главная</a></li>
				<li class="active">Каталог</li>
			</ul>
		</nav>
			<aside>
			<nav>
				<ul class="aside-menu">
					<%
						List<Section> sections =  (List<Section>) request.getAttribute("sections");
						if(!sections.isEmpty()) {
							for (Section section : sections) {
								out.println(
										"<li>" +
												"<a href=\"items?sectionId="+ section.getId() + "\" >" + section.getName() + "</a>" +
												"</li>"
								);
							}
						}
					%>
				</ul>
			</nav>
			</aside>
		</div>
<div class="container content">
	<div class="row">
		<div class="col-md-8 products">
		<%
            List<Product> productList = (List<Product>) request.getAttribute("products");
            if(!productList.isEmpty()) {
				int i = 0;
				if (productList.size() >= 3) {
					for (; i < productList.size(); i += 3) {
						if(productList.size() - i < 3){
							break;
						}
						Product currProduct1 = productList.get(i);
						Product currProduct2 = productList.get(i + 1);
						Product currProduct3 = productList.get(i + 2);
						out.println(
								"<div class=\"row\">\n" +
										"\t\t\t\t<div class=\"col-sm-4\">\n" +
										"\t\t\t\t\t<div class=\"product\">\n" +
										"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
										"<div class=\"product-img\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct1.getPicture()+"\" alt=\"\"></a>\n" +
										"\t\t\t\t\t\t</div>\n" +
										"\t\t\t\t\t\t<p class=\"product-title\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct1.getName()+"</a>\n" +
										"\t\t\t\t\t\t</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct1.getDescription()+"</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct1.getPrice() +"р.</p>\n" +
										"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct1.getId()+ " >"+
										"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
										"\t\t\t\t\t</form>\n" +
										"\t\t\t\t\t</div>\n" +
										"\t\t\t\t</div>" +
										"\t\t\t\t<div class=\"col-sm-4\">\n" +
										"\t\t\t\t\t<div class=\"product\">\n" +
										"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
										"<div class=\"product-img\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct2.getPicture()+"\" alt=\"\"></a>\n" +
										"\t\t\t\t\t\t</div>\n" +
										"\t\t\t\t\t\t<p class=\"product-title\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct2.getName()+"</a>\n" +
										"\t\t\t\t\t\t</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct2.getDescription()+"</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct2.getPrice() +"р.</p>\n" +
										"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct2.getId()+ " >"+
										"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
										"\t\t\t\t\t</form>\n" +
										"\t\t\t\t\t</div>\n" +
										"\t\t\t\t</div>" +
										"\t\t\t\t<div class=\"col-sm-4\">\n" +
										"\t\t\t\t\t<div class=\"product\">\n" +
										"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
										"<div class=\"product-img\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct3.getPicture()+"\" alt=\"\"></a>\n" +
										"\t\t\t\t\t\t</div>\n" +
										"\t\t\t\t\t\t<p class=\"product-title\">\n" +
										"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct3.getName()+"</a>\n" +
										"\t\t\t\t\t\t</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct3.getDescription()+"</p>\n" +
										"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct3.getPrice() +"р.</p>\n" +
										"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct3.getId()+ " >"+
										"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
										"\t\t\t\t\t</form>\n" +
										"\t\t\t\t\t</div>\n" +
										"\t\t\t\t</div>" +
										"\t\t\t</div>"
						);
					}
				}
				if ((productList.size() - i) == 2) {
					Product currProduct = productList.get(i);
					Product currProduct2 = productList.get(i +1);
					out.println(
							"<div class=\"row\">\n" +
									"\t\t\t\t<div class=\"col-sm-4\">\n" +
									"\t\t\t\t\t<div class=\"product\">\n" +
									"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
									"<div class=\"product-img\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct.getPicture()+"\" alt=\"\"></a>\n" +
									"\t\t\t\t\t\t</div>\n" +
									"\t\t\t\t\t\t<p class=\"product-title\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct.getName()+"</a>\n" +
									"\t\t\t\t\t\t</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct.getDescription()+"</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct.getPrice() +"р.</p>\n" +
									"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct.getId()+ " >"+
									"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
									"\t\t\t\t\t</form>\n" +
									"\t\t\t\t\t</div>\n" +
									"\t\t\t\t</div>" +
									"\t\t\t\t<div class=\"col-sm-4\">\n" +
									"\t\t\t\t\t<div class=\"product\">\n" +
									"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
									"<div class=\"product-img\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct2.getPicture()+"\" alt=\"\"></a>\n" +
									"\t\t\t\t\t\t</div>\n" +
									"\t\t\t\t\t\t<p class=\"product-title\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct2.getName()+"</a>\n" +
									"\t\t\t\t\t\t</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct2.getDescription()+"</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct2.getPrice() +"р.</p>\n" +
									"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct2.getId()+ " >"+
									"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
									"\t\t\t\t\t</form>\n" +
									"\t\t\t\t\t</div>\n" +
									"\t\t\t\t</div>" +
									"\t\t\t</div>"
					);
				}
				if((productList.size() - i) == 1){
					Product currProduct = productList.get(i);
					out.println(
							"<div class=\"row\">\n" +
									"\t\t\t\t<div class=\"col-sm-4\">\n" +
									"\t\t\t\t\t<div class=\"product\">\n" +
									"\t\t\t\t\t<form name = \"buy_item\" action=\"" + request.getContextPath() + "/buy_item\" method  = \"get\">" +
									"<div class=\"product-img\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\"><img src=\""+currProduct.getPicture()+"\" alt=\"\"></a>\n" +
									"\t\t\t\t\t\t</div>\n" +
									"\t\t\t\t\t\t<p class=\"product-title\">\n" +
									"\t\t\t\t\t\t\t<a href=\"#\">"+ currProduct.getName()+"</a>\n" +
									"\t\t\t\t\t\t</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-desc\">"+currProduct.getDescription()+"</p>\n" +
									"\t\t\t\t\t\t<p class=\"product-price\">Цена: "+ currProduct.getPrice() +"р.</p>\n" +
									"\t\t\t\t\t\t<input type=hidden name= \"productId\" value ="+ currProduct.getId()+ " >"+
									"\t\t\t\t\t\t<button type=\"submit\">Купить</button>\n" +
									"\t\t\t\t\t</form>\n" +
									"\t\t\t\t\t</div>\n" +
									"\t\t\t\t</div>" +
									"\t\t\t</div>"
					);
				}
			}

		%>
			<!--<div class="row">
				<div class="col-sm-4">
					<div class="product">
					<form name = "buy_item" action="<%=request.getContextPath()%>/buy_item" method  = "post">
						<div class="product-img">
							<a href="#"><img src="img/naruto1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Футболка "Наруто"</a>
						</p>
						<p class="product-desc">Хлопковая футболка. Размер М (унисекс)</p>
						<p class="product-price">Цена: 1000р.</p>
						<button type="submit">Купить</button>
					</form>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/naruto2.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Кружка Акацки</a>
						</p>
						<p class="product-desc">Керамическая кружка с принтом из аниме "Наруто"</p>
						<p class="product-price">Цена: 300р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/naruto3.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Брелок Какаши</a>
						</p>
						<p class="product-desc">Круглый пластиковый брелок из аниме "Наруто"</p>
						<p class="product-price">Цена: 50р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/deathnote_poster1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Постер "Тетрадь смерти"</a>
						</p>
						<p class="product-desc">Постер 20х30 см из аниме "Тетрадь смерти"</p>
						<p class="product-price">Цена: 120р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/anime_book1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Манга Наруто. Том 2</a>
						</p>
						<p class="product-desc">Наруто. Книга 2. Мост героя. Твердый переплет</p>
						<p class="product-price">Цена: 500р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/anime_socks1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Носки Наруто</a>
						</p>
						<p class="product-desc">Высокие носки 36-40 размер (унисекс)</p>
						<p class="product-price">Цена: 200р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/anime_toy1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Фигурка "Атака титанов"</a>
						</p>
						<p class="product-desc">Фигурка Funko Pop Леви из аниме "Атака титанов"</p>
						<p class="product-price">Цена: 800р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/anime_stickers1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Стикеры Наруто</a>
						</p>
						<p class="product-desc">Виниловые наклейки из аниме "Наруто". Формат А5</p>
						<p class="product-price">Цена: 150р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/anime_tshirt2.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Футболка Акацки</a>
						</p>
						<p class="product-desc">Хлопковая футболка. Размер М (унисекс)</p>
						<p class="product-price">Цена: 1000р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/films_tshirt1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Футболка "Гарри Поттер"</a>
						</p>
						<p class="product-desc">Хлопковая футболка. Размер М (унисекс)</p>
						<p class="product-price">Цена: 1000р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/films_mug1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Кружка "Pulp Fiction"</a>
						</p>
						<p class="product-desc">Кружка с принтом из фильма "Криминальное чтиво"</p>
						<p class="product-price">Цена: 300р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/films_poster1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Постер "Большой Лебовски"</a>
						</p>
						<p class="product-desc">Постер 20х30 см из фильма "Большой Лебовски"</p>
						<p class="product-price">Цена: 120р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/serials_tshirt1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Футболка "Во все тяжкие"</a>
						</p>
						<p class="product-desc">Хлопковая футболка. Размер М (унисекс)</p>
						<p class="product-price">Цена: 1000р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/serials_mug1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Кружка "Friends"</a>
						</p>
						<p class="product-desc">Кружка с принтом из фильма "Друзья"</p>
						<p class="product-price">Цена: 300р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/films_poster1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Комикс "Во все тяжкие"</a>
						</p>
						<p class="product-desc">Комикс "Во все тяжкие: Все плохое"</p>
						<p class="product-price">Цена: 120р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/cartoons_toy1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Фигурка "Симпсоны"</a>
						</p>
						<p class="product-desc">Фигурка Funko pop "Гомер Симпсон"</p>
						<p class="product-price">Цена: 1100р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/cartoons_mug1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Кружка "Futurama"</a>
						</p>
						<p class="product-desc">Кружка с принтом из мультсериала "Futurama"</p>
						<p class="product-price">Цена: 300р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="product">
						<div class="product-img">
							<a href="#"><img src="img/cartoons_poster1.jpg" alt=""></a>
						</div>
						<p class="product-title">
							<a href="#">Постер "Рик и Морти"</a>
						</p>
						<p class="product-desc">Плакат 20х30 из мультсериала "Рик и Морти"</p>
						<p class="product-price">Цена: 120р.</p>
						<a href="" class="button">Купить</a>
					</div>
				</div>
			</div>-->
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