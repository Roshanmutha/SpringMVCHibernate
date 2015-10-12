
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `modified_date` datetime NOT NULL,
  `name` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `available_count` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `t_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `TransactionFKEY_idx` (`t_id`),
  CONSTRAINT `TransactionFKEY` FOREIGN KEY (`t_id`) REFERENCES `transaction` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--delimiter $$
--
--CREATE TABLE `item_transaction` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `item_id` int(11) DEFAULT NULL,
--  `transaction_id` int(11) DEFAULT NULL,
--  PRIMARY KEY (`id`),
--  KEY `transactionFKey` (`transaction_id`),
--  CONSTRAINT `transactionFKey` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
--) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

