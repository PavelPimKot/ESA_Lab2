CREATE TABLE `Client`
(
    `ID`         INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `firstName`  VARCHAR(255) NOT NULL,
    `lastName`   VARCHAR(255) NOT NULL,
    `middleName` VARCHAR(255),
    `birthDay`   DATE         NOT NULL,
    `email`      VARCHAR(255) NOT NULL,
    `login`      VARCHAR(255) NOT NULL UNIQUE,
    `password`   VARCHAR(255) NOT NULL,
    `phone`      VARCHAR(255) NOT NULL UNIQUE,
    `address`    VARCHAR(255) NOT NULL,
    `isDeleted`  BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `Product`
(
    `ID`          INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `price`       INT          NOT NULL,
    `count`       INT,
    `section_ID`  INT          NOT NULL,
    `category_ID` INT          NOT NULL,
    `picture`     blob,
    `isDeleted`   BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `Orders`
(
    `ID`           INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `client_ID`    INT          NOT NULL,
    `status`       VARCHAR(255) NOT NULL,
    `cost`         INT          NOT NULL,
    `orderDate`    DATE         NOT NULL,
    `deliveryDate` DATE         NOT NULL,
    `isDeleted`    BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `Element`
(
    `code`       INT     NOT NULL AUTO_INCREMENT UNIQUE,
    `product_ID` INT     NOT NULL,
    `order_ID`   INT     NOT NULL,
    `count`      INT     NOT NULL,
    `isDeleted`  BOOLEAN NOT NULL default 0,
    PRIMARY KEY (`code`)
);
CREATE TABLE `Admins`
(
    `ID`             INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `firstName`      VARCHAR(255) NOT NULL,
    `lastName`       VARCHAR(255) NOT NULL,
    `middleName`     VARCHAR(255),
    `login`          VARCHAR(255) NOT NULL UNIQUE,
    `password`       VARCHAR(255) NOT NULL,
    `position`       VARCHAR(255) NOT NULL,
    `workExperience` VARCHAR(255),
    `salary`         INT          NOT NULL,
    `phone`          VARCHAR(255) NOT NULL UNIQUE,
    `isDeleted`      BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `Section`
(
    `ID`          INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `isDeleted`   BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `Category`
(
    `ID`          INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `isDeleted`   BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `PromoCode`
(
    `name`      VARCHAR(255) NOT NULL UNIQUE,
    `discount`  INT          NOT NULL,
    `fromDate`  DATE         NOT NULL,
    `toDate`    DATE         NOT NULL,
    `count`     INT,
    `isDeleted` BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`name`)
);
CREATE TABLE `Review`
(
    `ID`         INT          NOT NULL AUTO_INCREMENT UNIQUE,
    `client_ID`  INT          NOT NULL,
    `product_ID` INT          NOT NULL,
    `content`    VARCHAR(255) NOT NULL,
    `isDeleted`  BOOLEAN      NOT NULL default 0,
    PRIMARY KEY (`ID`)
);
ALTER TABLE `Product`
    ADD CONSTRAINT `Product_fk0` FOREIGN KEY (`section_ID`) REFERENCES `Section` (`id`);
ALTER TABLE `Product`
    ADD CONSTRAINT `Product_fk1` FOREIGN KEY (`category_ID`) REFERENCES `Category` (`id`);
ALTER TABLE `Orders`
    ADD CONSTRAINT `Order_fk0` FOREIGN KEY (`client_ID`) REFERENCES `Client` (`id`);
ALTER TABLE `Element`
    ADD CONSTRAINT `Element_fk0` FOREIGN KEY (`product_ID`) REFERENCES `Product` (`id`);
ALTER TABLE `Element`
    ADD CONSTRAINT `Element_fk1` FOREIGN KEY (`order_Id`) REFERENCES `Orders` (`ID`);
ALTER TABLE `Review`
    ADD CONSTRAINT `Review_fk0` FOREIGN KEY (`client_ID`) REFERENCES `Client` (`id`);
ALTER TABLE `Review`
    ADD CONSTRAINT `Review_fk1` FOREIGN KEY (`product_ID`) REFERENCES `Product` (`id`);