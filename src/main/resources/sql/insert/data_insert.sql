insert into section(ID, name, description)
values (1, 'Anime and Manga', 'Here you will find paraphernalia from popular anime!'),
       (2, 'Films', 'Here you will find paraphernalia of popular cinematographic works!'),
       (3, 'Series', 'Here you will find paraphernalia for popular and favorite TV series!'),
       (4, 'Cartoons and animated series',
        'Here you will find paraphernalia based on your favorite cartoons and animated series of childhood and not only!'),
       (5, 'MARVEL Universe',
        'Here you will find paraphernalia of your favorite characters from the famous MARVEL universe!'),
       (6, 'DC Universe', 'Here you will find paraphernalia of your favorite characters from the famous DC Universe!'),
       (7, 'Games', 'Here you will find paraphernalia for the games you spent so much time in!'),
       (8, 'Other', 'Here you can find many other cool products that you might like!');
insert into category (ID, name, description)
values (1, 'T-shirts', 'Choose what you like!'),
       (2, 'Mugs', 'Choose what you like!'),
       (3, 'Posters', 'Choose what you like!'),
       (4, 'Socks', 'Choose what you like!'),
       (5, 'Keychains', 'Choose what you like!'),
       (6, 'Books and comics', 'Choose what you like!'),
       (7, 'Toys', 'Choose what you like!'),
       (8, 'Stickers', 'Choose what you like!');
insert into promocode (name, discount, fromDate, toDate, count)
values ('WEB', 10, '2021.04.10', '2022.04.10', 5),
       ('GEEKS', 50, '2021.04.01', '2021.05.31', 20);
insert into client (ID, firstName, lastName, middleName, birthDay, email, login, password, phone, address)
values (1, 'Nikolay', 'Nikolaev', 'Nikolaevich', '1980.01.02', 'nikolaevich@gmail.com', 'nikolya', 'koko1980',
        '89213467238', 'Samara, Novo- station, 200-21 '),
       (2, 'Tina', 'Kandelaki', 'Ilyinichna', '1992.03.09', 'tinakandek@mail.ru', 'tinki', 'kantin92', '89287572361',
        'Sochi, Krasivaya st., 76 '),
       (3, 'Naruto', 'Uzumaki', 'Minatovich', '2001.11.23', 'evergiveup@gmail.com', 'rassengun', 'hokage1',
        '89357295518', 'Kazan, st.Chak- chuck, 88-2 ');
insert into admins (ID, firstName, lastName, middleName, login, password, position, workExperience, salary, phone)
values (1, 'Petya', 'Funny', 'Alexandrovich', 'administrator00', 'geekadmin228', 'Seller', '3 years', 20000,
        '89227649912');
insert into orders (ID, client_ID, status, cost, orderDate, deliveryDate)
values (1, 1, 'Accepted', 5000, '2021.04.16', '2021.04.22'),
       (2, 2, 'Issued', 3500, '2021.04.08', '2021.04.14'),
       (3, 3, 'Accepted', 2100, '2021.04.15', '2021.04.21');
insert into product (ID, name, description, price, picture, count, section_ID, category_ID)
values (1, 'T-shirt Naruto', 'T-shirt, size M', 1000, 'src/img/naruto1.jpg', 20, 1, 1),
       (2, 'Akatsuki mug', 'Ceramic mug with a print from the anime "Naruto"', 300, 'src/img/naruto2.jpg', 15, 1, 2),
       (3, 'Kakashi keychains', 'Round plastic keychain from the anime "Naruto"', 50, 'src/img/naruto3.jpg', 30, 1, 5),
       (4, 'Death note Poster', 'Poster 20x30 cm from the anime "Death Note"', 120, 'src/img/deathnote_poster1.jpg', 25,
        1, 3),
       (5, 'Manga Naruto. Volume 2', 'Naruto. Book 2. The Heros Bridge. Hard cover', 500, 'src/img/anime_book1.jpg', 50,
        1, 6),
       (6, 'Naruto socks', 'High socks 36-40 size (unisex)', 200, 'src/img/anime_socks1.jpg', 20, 1, 4),
       (7, 'Attack on Titan figurine', 'Attack on Titan Funko Pop Levi Action Figure', 800, 'src/img/anime_toy1.jpg',
        20, 1, 7),
       (8, 'Naruto stickers', 'Vinyl stickers from the anime "Naruto". A5 format', 150, 'src/img/anime_stickers1.jpg',
        20, 1, 8),
       (9, 'Akatsuki T-shirt', 'T-shirt, size M', 1000, 'src/img/anime_tshirt2.jpg', 20, 1, 1),
       (10, 'Harry Potter T-shirt', 'T-shirt, size M', 1000, 'src/img/films_tshirt1.jpg', 20, 2, 1),
       (11, 'Mug "Pulp Fiction"', 'Mug with a print from the movie "Pulp Fiction"', 300, 'src/img/films_mug1.jpg', 20,
        2, 2),
       (12, 'Poster "The Big Lebowski"', 'Poster 20x30 cm from the movie "The Big Lebowski"', 120,
        'src/img/films_poster1.jpg', 20, 2, 3),
       (13, 'Breaking Bad T-shirt', 'T-shirt, size M', 1000, 'src/img/serials_tshirt1.jpg', 20, 3, 1),
       (14, 'Mug "Friends"', 'Mug with a print from the TV series "Friends"', 300, 'src/img/serials_mug1.jpg', 20, 3,
        2),
       (15, 'Breaking Bad Comic', 'Breaking Bad: All Bad Comics', 500, 'src/img/serials_book1.jpg', 20, 3, 6),
       (16, 'The Simpsons Figurine', 'Funko pop Homer Simpson Action Figure', 1100, 'src/img/cartoons_toy1.jpg', 20, 4,
        7),
       (17, 'Mug "Futurama"', 'Mug with print from the animated series "Futurama"', 300, 'src/img/cartoons_mug1.jpg',
        20, 4, 2),
       (18, 'Rick and Morty poster', '20x30 poster from the animated series "Rick and Morty"', 120,
        'src/img/cartoons_poster1.jpg', 20, 4, 3);
insert into element (code, product_ID, order_ID, count)
values (1, 1, 1, 10),
       (2, 2, 2, 5),
       (3, 3, 3, 5),
       (4, 4, 3, 1);