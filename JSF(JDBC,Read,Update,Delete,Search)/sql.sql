CREATE DATABASE  IF NOT EXISTS `sbfp`;
use `sbfp`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,  
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `receiving` varchar(100) DEFAULT NULL,
  `profileType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` 
VALUES 
(00000001, 'James', 'Gosling', '514-123-1234', '123, Avenue', 'james@mail.ca', 'jamgos', '123abc456', 'Monthly discount email', 'Public'),
(00000002, 'Dennis', 'Ritchie', '514-321-1234', '321, Avenue', 'dennis@mail.ca', 'denrit', '321cba654', 'Weekly update for new products', 'Private');
UNLOCK TABLES;

select * from users;

