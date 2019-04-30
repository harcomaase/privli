CREATE TABLE `link_entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `link_alias` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `full_link` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_link_alias` (`link_alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
