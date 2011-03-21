CREATE TABLE `items` (
	`id` INTEGER  NOT NULL AUTO_INCREMENT,
	`userid` INTEGER NOT NULL,
	`summary` VARCHAR(255) NOT NULL,
	`url` VARCHAR(255) DEFAULT NULL,
	`date_added` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `items` VALUES
	(0, 1, 'Modernist Cuisine', 'http://www.amazon.com/Modernist-Cuisine-Art-Science-Cooking/dp/0982761007/ref=sr_1_1?s=books&ie=UTF8&qid=1300733351&sr=1-1', NOW()),
	(0, 1, 'Art of Computer Programming, Vols 1-4A', 'http://www.amazon.com/Computer-Programming-Volumes-1-4A-Boxed/dp/0321751043/ref=sr_1_2?s=books&ie=UTF8&qid=1300733453&sr=1-2', NOW()),
	(0, 1, 'Sausage Grinder', 'http://www.amazon.com/Villaware-V268-10-Manual-Meat-Grinder/dp/B000I1YIW2', NOW());