CREATE SCHEMA IF NOT EXISTS `CSBalkanWebShop` DEFAULT CHARACTER SET utf8;

-- Create Tables
CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `displayName` VARCHAR(32) NULL,
  `email` VARCHAR(128) NULL,
  `firstName` VARCHAR(64) NOT NULL,
  `lastNameusers` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`idUsers`),
  UNIQUE INDEX `idUsers_UNIQUE` (`idUsers` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Adresses` (
  `idAdresses` INT NOT NULL AUTO_INCREMENT,
  `idUsers` INT NOT NULL,
  `address` VARCHAR(128) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postalCode` INT NULL,
  PRIMARY KEY (`idAdresses`),
  UNIQUE INDEX `idAdresses_UNIQUE` (`idAdresses` ASC) VISIBLE,
  INDEX `AddressUserFK_idx` (`idUsers` ASC) VISIBLE,
  CONSTRAINT `AddressUserFK`
    FOREIGN KEY (`idUsers`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`FriendsList` (
  `idFriendsList` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idFriend` INT NOT NULL,
  PRIMARY KEY (`idFriendsList`),
  UNIQUE INDEX `idFriendsList_UNIQUE` (`idFriendsList` ASC) VISIBLE,
  INDEX `UserFK_idx` (`idUser` ASC) VISIBLE,
  INDEX `FriendFK_idx` (`idFriend` ASC) VISIBLE,
  CONSTRAINT `UserFK`
    FOREIGN KEY (`idUser`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FriendFK`
    FOREIGN KEY (`idFriend`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Messages` (
  `idMessages` INT NOT NULL AUTO_INCREMENT,
  `idConversation` INT NOT NULL,
  `idSender` INT NOT NULL,
  `idReciver` INT NOT NULL,
  `subject` VARCHAR(256) NULL DEFAULT 'No subject',
  `message` VARCHAR(2048) NULL,
  `timestamp` DATETIME NULL,
  PRIMARY KEY (`idMessages`),
  UNIQUE INDEX `idMessages_UNIQUE` (`idMessages` ASC) VISIBLE,
  INDEX `FriendsFK_idx` (`idSender` ASC) VISIBLE,
  INDEX `ReciverFK_idx` (`idReciver` ASC) VISIBLE,
  CONSTRAINT `SenderFK`
    FOREIGN KEY (`idSender`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ReciverFK`
    FOREIGN KEY (`idReciver`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`Products` (
  `idProducts` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `description` VARCHAR(1028) NULL,
  `image` VARCHAR(1028) NULL,
  `quantity` INT NULL DEFAULT 0,
  `price` DECIMAL(16,2) NULL DEFAULT 0.00,
  `type` VARCHAR(64) NULL DEFAULT 'misc',
  PRIMARY KEY (`idProducts`),
  UNIQUE INDEX `idProducts_UNIQUE` (`idProducts` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`ShoppingLists` (
  `idShoppingList` INT NOT NULL AUTO_INCREMENT,
  `idUsers` INT NOT NULL,
  `timestamp` DATETIME NULL,
  `shippingAddress` INT NOT NULL,
  PRIMARY KEY (`idShoppingList`),
  UNIQUE INDEX `idShoppingList_UNIQUE` (`idShoppingList` ASC) VISIBLE,
  INDEX `ShoppingListFK_idx` (`idUsers` ASC) VISIBLE,
  INDEX `ShippingAddressFK_idx` (`shippingAddress` ASC) VISIBLE,
  CONSTRAINT `ShoppingListFK`
    FOREIGN KEY (`idUsers`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ShippingAddressFK`
    FOREIGN KEY (`shippingAddress`)
    REFERENCES `CSBalkanWebShop`.`Adresses` (`idAdresses`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`ShoppingListItems` (
  `idShoppingListItems` INT NOT NULL AUTO_INCREMENT,
  `idShoppingList` INT NOT NULL,
  `idProducts` INT NOT NULL,
  `quantity` INT NULL DEFAULT 1,
  `price` DOUBLE(16,2) NULL DEFAULT 0.00,
  PRIMARY KEY (`idShoppingListItems`),
  UNIQUE INDEX `idShoppingListItems_UNIQUE` (`idShoppingListItems` ASC) VISIBLE,
  INDEX `ShoppingListItemsFK_idx` (`idShoppingList` ASC) VISIBLE,
  INDEX `ShoppingListProductsFK_idx` (`idProducts` ASC) VISIBLE,
  CONSTRAINT `ShoppingListItemsFK`
    FOREIGN KEY (`idShoppingList`)
    REFERENCES `CSBalkanWebShop`.`ShoppingLists` (`idShoppingList`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ShoppingListProductsFK`
    FOREIGN KEY (`idProducts`)
    REFERENCES `CSBalkanWebShop`.`Products` (`idProducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`FavoriteProducts` (
  `idFavoriteProducts` INT NOT NULL AUTO_INCREMENT,
  `idUsers` INT NOT NULL,
  `idProduct` INT NOT NULL,
  PRIMARY KEY (`idFavoriteProducts`),
  UNIQUE INDEX `idFavoriteProducts_UNIQUE` (`idFavoriteProducts` ASC) VISIBLE,
  INDEX `FavoritesUser_idx` (`idUsers` ASC) VISIBLE,
  INDEX `FavoritesProductFK_idx` (`idProduct` ASC) VISIBLE,
  CONSTRAINT `FavoritesUserFK`
    FOREIGN KEY (`idUsers`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FavoritesProductFK`
    FOREIGN KEY (`idProduct`)
    REFERENCES `CSBalkanWebShop`.`Products` (`idProducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `CSBalkanWebShop`.`CartItems` (
  `idCart` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idProduct` INT NOT NULL,
  `amount` INT NULL DEFAULT 1,
  PRIMARY KEY (`idCart`),
  UNIQUE INDEX `idCart_UNIQUE` (`idCart` ASC) VISIBLE,
  INDEX `CartUserFK_idx` (`idUser` ASC) VISIBLE,
  INDEX `CartProductFK_idx` (`idProduct` ASC) VISIBLE,
  CONSTRAINT `CartUserFK`
    FOREIGN KEY (`idUser`)
    REFERENCES `CSBalkanWebShop`.`Users` (`idUsers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CartProductFK`
    FOREIGN KEY (`idProduct`)
    REFERENCES `CSBalkanWebShop`.`Products` (`idProducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;