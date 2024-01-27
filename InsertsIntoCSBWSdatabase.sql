INSERT INTO `CSBalkanWebShop`.`Users` (`idUsers`, `username`, `password`, `displayName`, `idCart`) VALUES (1, 'nikola', 'nikola', 'Nikola', NULL);
INSERT INTO `CSBalkanWebShop`.`Users` (`idUsers`, `username`, `password`, `displayName`, `idCart`) VALUES (2, 'aleksa', 'aleksa', 'Aleksa', NULL);
INSERT INTO `CSBalkanWebShop`.`Users` (`idUsers`, `username`, `password`, `displayName`, `idCart`) VALUES (3, 'milos', 'milos', NULL, NULL);
INSERT INTO `CSBalkanWebShop`.`Users` (`idUsers`, `username`, `password`, `displayName`, `idCart`) VALUES (4, 'ribar', 'Ribar22', 'Dzoni', NULL);

INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (1, 1, 2);
INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (2, 2, 1);
INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (3, 1, 3);
INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (4, 3, 1);
INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (5, 3, 4);
INSERT INTO `CSBalkanWebShop`.`FriendsList` (`idFriendsList`, `idUser`, `idFriend`) VALUES (6, 4, 3);

INSERT INTO `CSBalkanWebShop`.`Messages` (`idMessages`, `idConversation`, `idSender`, `idReciver`, `subject`, `message`, `timestamp`) VALUES (1, 1, 1, 2, 'Hi', 'Hey\\nHow are you doing m8?', '2024-01-01 23:02:12');
INSERT INTO `CSBalkanWebShop`.`Messages` (`idMessages`, `idConversation`, `idSender`, `idReciver`, `subject`, `message`, `timestamp`) VALUES (2, 1, 2, 1, 're:Hi', 'I am well, just keeping busy.\\nAnything new?', '2024-01-02 13:02:23');
INSERT INTO `CSBalkanWebShop`.`Messages` (`idMessages`, `idConversation`, `idSender`, `idReciver`, `subject`, `message`, `timestamp`) VALUES (3, 1, 1, 2, 're:Hi', 'Nothing much.', '2024-01-04 10:23:55');
INSERT INTO `CSBalkanWebShop`.`Messages` (`idMessages`, `idConversation`, `idSender`, `idReciver`, `subject`, `message`, `timestamp`) VALUES (4, 2, 3, 4, 'Happy new year', 'Happy new year :)', '2024-01-01 00:00:06');

INSERT INTO `CSBalkanWebShop`.`Products` (`idProducts`, `name`, `description`, `image`, `quantity`, `price`, `type`) VALUES (1, 'CSBalkan Black T-shirt', 'A black t-shirt with a CSB logo on it.', 'CSBblackT.png', 69, 18.99, 'clothes');
INSERT INTO `CSBalkanWebShop`.`Products` (`idProducts`, `name`, `description`, `image`, `quantity`, `price`, `type`) VALUES (2, 'CSBalkan White T-shirt', 'A white t-shirt with a CSB logo on it.', 'CSBwhiteT.png', 47, 16.99, 'clothes');
INSERT INTO `CSBalkanWebShop`.`Products` (`idProducts`, `name`, `description`, `image`, `quantity`, `price`, `type`) VALUES (3, 'CSBalkan Black Mug', 'A black coffee mug with the CSB logo on it.', 'CSBblackMug.png', 14, 39.99, 'mug');
INSERT INTO `CSBalkanWebShop`.`Products` (`idProducts`, `name`, `description`, `image`, `quantity`, `price`, `type`) VALUES (4, 'CSBalkan White Mug', 'A white coffee mug with the CSB logo on it.', 'CSBwhiteMug.png', 21, 39.99, 'mug');
