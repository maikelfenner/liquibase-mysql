--liquibase formatted sql

--changeset maikelfenner:1 tag:1
CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `id_parent_product` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_id_parent_product_idx` (`id_parent_product` ASC),
  CONSTRAINT `fk_product_id_parent_product`
  FOREIGN KEY (`id_parent_product`)
  REFERENCES `product` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);

CREATE TABLE `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_id_product_idx` (`id_product` ASC),
  CONSTRAINT `fk_image_id_product`
  FOREIGN KEY (`id_product`)
  REFERENCES `product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

--rollback DROP TABLE image;
--rollback DROP TABLE product;