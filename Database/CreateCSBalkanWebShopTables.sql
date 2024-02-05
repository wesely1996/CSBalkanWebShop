CREATE SCHEMA IF NOT EXISTS `CSBalkanWebShop` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `idRole` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idUsers_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `UserRoleFK_idx` (`idRole` ASC) VISIBLE,
  CONSTRAINT `UserRoleFK`
    FOREIGN KEY (`idRole`)
    REFERENCES `CSBalkanWebShop`.`Roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Friends` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idFriend` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FriendsUserFK_idx` (`idUser` ASC) VISIBLE,
  INDEX `FriendsFriendFK_idx` (`idFriend` ASC) VISIBLE,
  CONSTRAINT `FriendsUserFK`
    FOREIGN KEY (`idUser`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FriendsFriendFK`
    FOREIGN KEY (`idFriend`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Inbox` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idSender` INT NOT NULL,
  `idReciver` INT NOT NULL,
  `subject` VARCHAR(256) NULL DEFAULT 'No subject',
  `message` VARCHAR(2048) NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idMessages_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FriendsFK_idx` (`idSender` ASC) VISIBLE,
  INDEX `ReciverFK_idx` (`idReciver` ASC) VISIBLE,
  CONSTRAINT `SenderFK`
    FOREIGN KEY (`idSender`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ReciverFK`
    FOREIGN KEY (`idReciver`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `description` VARCHAR(1028) NULL,
  `image` VARCHAR(1028) NULL,
  `quantity` INT NULL DEFAULT 0,
  `price` DECIMAL(16,2) NULL DEFAULT 0.00,
  `type` VARCHAR(64) NULL DEFAULT 'misc',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idProducts_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`FavoriteProducts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUsers` INT NOT NULL,
  `idProduct` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idFavoriteProducts_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `FavoritesUser_idx` (`idUsers` ASC) VISIBLE,
  INDEX `FavoritesProductFK_idx` (`idProduct` ASC) VISIBLE,
  CONSTRAINT `FavoritesUserFK`
    FOREIGN KEY (`idUsers`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FavoritesProductFK`
    FOREIGN KEY (`idProduct`)
    REFERENCES `CSBalkanWebShop`.`Products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`ShoppingLists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idUsers` INT NOT NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idShoppingList_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `ShoppingListFK_idx` (`idUsers` ASC) VISIBLE,
  CONSTRAINT `ShoppingListFK`
    FOREIGN KEY (`idUsers`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`ShoppingListItems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idShoppingList` INT NOT NULL,
  `idProducts` INT NOT NULL,
  `quantity` INT NULL DEFAULT 1,
  `price` DOUBLE(16,2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idShoppingListItems_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `ShoppingListItemsFK_idx` (`idShoppingList` ASC) VISIBLE,
  INDEX `ShoppingListProductsFK_idx` (`idProducts` ASC) VISIBLE,
  CONSTRAINT `ShoppingListItemsFK`
    FOREIGN KEY (`idShoppingList`)
    REFERENCES `CSBalkanWebShop`.`ShoppingLists` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ShoppingListProductsFK`
    FOREIGN KEY (`idProducts`)
    REFERENCES `CSBalkanWebShop`.`Products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idProducts` INT NOT NULL,
  `idUser` INT NOT NULL,
  `amount` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idShoppingListItems_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `ShoppingListProductsFK_idx` (`idProducts` ASC) VISIBLE,
  INDEX `CartUserFK_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `CartProductFK`
    FOREIGN KEY (`idProducts`)
    REFERENCES `CSBalkanWebShop`.`Products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CartUserFK`
    FOREIGN KEY (`idUser`)
    REFERENCES `CSBalkanWebShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;