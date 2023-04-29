-- drop database  if exists `faraway`;
-- create database `faraway`;

use faraway;
-- show tables;

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
    `id`	bigint	NOT NULL COMMENT 'Long',
    `member_id`	bigint	NOT NULL	COMMENT 'Long',
    `category`	varchar(20)	NOT NULL	COMMENT 'String',
    `title`	varchar(30)	NOT NULL	COMMENT 'String',
    `content`	text	NOT NULL	COMMENT 'String',
    `hit`	bigint	NOT NULL	COMMENT 'Long',
    `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime',
    `modified_date`	timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
    `id`	bigint	NOT NULL COMMENT 'Long',
    `member_id`	bigint	NOT NULL	COMMENT 'Long',
    `title`	varchar(30)	NOT NULL	COMMENT 'String',
    `content`	text	NOT NULL	COMMENT 'String',
    `hit`	bigint	NULL	COMMENT 'Long',
    `plan`	varchar(255)	NOT NULL	COMMENT 'String',
    `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime',
    `modified_date`	timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
    `id`	bigint	NOT NULL	COMMENT 'Long',
    `login_id`	varchar(20)	NOT NULL	COMMENT 'String',
    `login_pwd`	varchar(255)	NOT NULL	COMMENT 'String',
    `last_name`	varchar(20)	NOT NULL	COMMENT 'String',
    `first_name`	varchar(30)	NOT NULL	COMMENT 'String',
    `birth`	varchar(6)	NOT NULL	COMMENT 'String',
    `email`	varchar(100)	NOT NULL	COMMENT 'String',
    `zipcode`	varchar(5)	NOT NULL	COMMENT 'String',
    `main_address`	varchar(255)	NOT NULL	COMMENT 'String',
    `sub_address`	varchar(255)	NULL	COMMENT 'String',
    `salt`	varchar(45)	NOT NULL	COMMENT 'String',
    `mileage`	bigint	NOT NULL DEFAULT 0	COMMENT 'Long',
    `role`	int	NOT NULL DEFAULT 1 COMMENT 'Integer',
    `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime',
    `modified_date`	timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `hotplace`;
CREATE TABLE `hotplace` (
    `id`	bigint	NOT NULL	COMMENT 'Long',
    `member_id`	bigint	NOT NULL	COMMENT 'Long',
    `title`	varchar(30)	NULL	COMMENT 'String',
    `content`	text	NULL	COMMENT 'String',
    `zipcode`	varchar(5)	NULL	COMMENT 'String',
    `main_address`	varchar(255)	NULL	COMMENT 'String',
    `sub_address`	varchar(255)	NULL	COMMENT 'String',
    `rating`	int	NULL	COMMENT 'Integer',
    `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime',
    `modified_date`	timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `post_like`;
CREATE TABLE `post_like` (
     `member_id`	bigint	NOT NULL	COMMENT 'Long',
     `post_id`	bigint	NOT NULL	COMMENT 'Long',
     `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `plan_like`;
CREATE TABLE `plan_like` (
    `plan_id`	bigint	NOT NULL	COMMENT 'Long',
    `member_id`	bigint	NOT NULL	COMMENT 'Long',
    `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
     `id`	bigint	NOT NULL COMMENT 'Long',
     `hotplace_id`	bigint	NOT NULL	COMMENT 'Long',
     `name`	varchar(50)	NULL	COMMENT 'String',
     `path`	varchar( 100)	NULL	COMMENT 'String'
    -- created_date 보류
);

DROP TABLE IF EXISTS `hotplace_like`;
CREATE TABLE `hotplace_like` (
     `hotplace_id`	bigint	NOT NULL	COMMENT 'Long',
     `member_id`	bigint	NOT NULL	COMMENT 'Long',
     `created_date`	timestamp	NOT NULL DEFAULT CURRENT_TIMESTAMP	COMMENT 'LocalDateTime'
);

ALTER TABLE `post` ADD CONSTRAINT `PK_POST` PRIMARY KEY AUTO_INCREMENT  (
    `id`
    );

ALTER TABLE `plan` ADD CONSTRAINT `PK_PLAN` PRIMARY KEY AUTO_INCREMENT (
    `id`
    );

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY AUTO_INCREMENT (
    `id`
    );

ALTER TABLE `hotplace` ADD CONSTRAINT `PK_HOTPLACE` PRIMARY KEY AUTO_INCREMENT (
    `id`
    );

ALTER TABLE `post_like` ADD CONSTRAINT `PK_POST_LIKE` PRIMARY KEY AUTO_INCREMENT (
    `member_id`,
    `post_id`
    );


ALTER TABLE `plan_like` ADD CONSTRAINT `PK_PLAN_LIKE` PRIMARY KEY AUTO_INCREMENT (
    `plan_id`,
    `member_id`
    );

ALTER TABLE `image` ADD CONSTRAINT `PK_IMAGE` PRIMARY KEY AUTO_INCREMENT (
    `id`
    );

ALTER TABLE `hotplace_like` ADD CONSTRAINT `PK_HOTPLACE_LIKE` PRIMARY KEY AUTO_INCREMENT (
    `hotplace_id`,
    `member_id`
    );

ALTER TABLE `post_like` ADD CONSTRAINT `FK_post_like_id_TO_member_id` FOREIGN KEY (
                                                                                   `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `post_like` ADD CONSTRAINT `FK_post_like_post_id_TO_post_id` FOREIGN KEY (
                                                                                      `post_id`
    )
    REFERENCES `post` (
                       `id`
        );

ALTER TABLE `plan_like` ADD CONSTRAINT `FK_plan_like_plan_id_TO_plan_id` FOREIGN KEY (
                                                                                      `plan_id`
    )
    REFERENCES `plan` (
                       `id`
        );

ALTER TABLE `plan_like` ADD CONSTRAINT `FK_plan_like_member_id_TO_member_id` FOREIGN KEY (
                                                                                          `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `hotplace_like` ADD CONSTRAINT `FK_hotplace_like_hotplace_id_TO_hotplace_id` FOREIGN KEY (
                                                                                                      `hotplace_id`
    )
    REFERENCES `hotplace` (
                           `id`
        );

ALTER TABLE `hotplace_like` ADD CONSTRAINT `FK_hotplace_like_member_id_TO_member_id` FOREIGN KEY (
                                                                                                  `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `post` ADD CONSTRAINT `FK_post_member_id_TO_member_id` FOREIGN KEY (
                                                                                `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `hotplace` ADD CONSTRAINT `FK_hotplace_member_id_TO_member_id` FOREIGN KEY (
                                                                                        `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `plan` ADD CONSTRAINT `FK_plan_member_id_TO_member_id` FOREIGN KEY (
                                                                                `member_id`
    )
    REFERENCES `member` (
                         `id`
        );

ALTER TABLE `image` ADD CONSTRAINT `FK_image_hotplace_id_TO_hotplace_id` FOREIGN KEY (
                                                                                      `hotplace_id`
    )
    REFERENCES `hotplace` (
                           `id`
        );