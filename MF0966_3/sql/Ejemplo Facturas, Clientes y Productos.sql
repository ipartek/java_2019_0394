-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ejemplodiagrama
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ejemplodiagrama
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ejemplodiagrama` DEFAULT CHARACTER SET utf8 ;
USE `ejemplodiagrama` ;

-- -----------------------------------------------------
-- Table `ejemplodiagrama`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejemplodiagrama`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nif` CHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ejemplodiagrama`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejemplodiagrama`.`facturas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` CHAR(9) NOT NULL,
  `fecha` DATE NOT NULL,
  `clientes_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) VISIBLE,
  INDEX `fk_facturas_clientes_idx` (`clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `ejemplodiagrama`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ejemplodiagrama`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejemplodiagrama`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TEXT(1000) NULL,
  `precio` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ejemplodiagrama`.`facturas_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejemplodiagrama`.`facturas_has_productos` (
  `facturas_id` INT NOT NULL,
  `productos_id` INT NOT NULL,
  PRIMARY KEY (`facturas_id`, `productos_id`),
  INDEX `fk_facturas_has_productos_productos1_idx` (`productos_id` ASC) VISIBLE,
  INDEX `fk_facturas_has_productos_facturas1_idx` (`facturas_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_has_productos_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `ejemplodiagrama`.`facturas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_has_productos_productos1`
    FOREIGN KEY (`productos_id`)
    REFERENCES `ejemplodiagrama`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
