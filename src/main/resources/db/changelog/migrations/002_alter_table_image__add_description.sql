--liquibase formatted sql

--changeset johndoe:2 tag:2
ALTER TABLE `image` ADD COLUMN `description` VARCHAR(1024) DEFAULT NULL;

--rollback ALTER TABLE `image` DROP COLUMN `description`;