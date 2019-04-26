CREATE USER 'smarthome_user'@'localhost' IDENTIFIED BY 'smarthome_user';
GRANT ALL PRIVILEGES ON smarthome_db.* TO 'smarthome_user'@'localhost';

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT;


CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB;


CREATE TABLE `users_roles` (
  `user_id` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB;



CREATE TABLE `setting` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `port` varchar(255) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqvqqgmefl0aco34akdtpe` (`port`)
) ENGINE=InnoDB;


CREATE TABLE `setting_roles` (
  `setting_id` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0r1weyk393bdgt107vdx0x` (`setting_id`),
  KEY `FKgd3iendfoyh04b95ykqise6qh` (`role_id`),
  CONSTRAINT `FKgd3iendfoyh04b95ykqise6qh` FOREIGN KEY (`setting_id`) REFERENCES `setting` (`id`),
  CONSTRAINT `FKt4v0r1weyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB;


INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Administrator'),
(2, 'External');