-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Dentista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dentista` (
  `idDEntista` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `especialidade` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`idDEntista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Paciente` (
  `IdPaciente` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `idade` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `Dentista_idDentista` INT NULL,
  `DEntista_idDEntista` INT NOT NULL,
  PRIMARY KEY (`IdPaciente`, `DEntista_idDEntista`),
  INDEX `fk_Paciente_DEntista_idx` (`DEntista_idDEntista` ASC) VISIBLE,
  CONSTRAINT `fk_Paciente_DEntista`
    FOREIGN KEY (`DEntista_idDEntista`)
    REFERENCES `mydb`.`Dentista` (`idDEntista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Auxiliar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Auxiliar` (
  `idAuxiliar` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `Dentista_idDentista` INT NULL,
  `Dentista_idDEntista` INT NOT NULL,
  PRIMARY KEY (`idAuxiliar`, `Dentista_idDEntista`),
  INDEX `fk_Auxiliar_Dentista1_idx` (`Dentista_idDEntista` ASC) VISIBLE,
  CONSTRAINT `fk_Auxiliar_Dentista1`
    FOREIGN KEY (`Dentista_idDEntista`)
    REFERENCES `mydb`.`Dentista` (`idDEntista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Secretario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Secretario` (
  `idSecretario` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  PRIMARY KEY (`idSecretario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Dentista_has_Secretario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dentista_has_Secretario` (
  `Dentista_idDEntista` INT NOT NULL,
  `Secretario_idSecretario` INT NOT NULL,
  PRIMARY KEY (`Dentista_idDEntista`, `Secretario_idSecretario`),
  INDEX `fk_Dentista_has_Secretario_Secretario1_idx` (`Secretario_idSecretario` ASC) VISIBLE,
  INDEX `fk_Dentista_has_Secretario_Dentista1_idx` (`Dentista_idDEntista` ASC) VISIBLE,
  CONSTRAINT `fk_Dentista_has_Secretario_Dentista1`
    FOREIGN KEY (`Dentista_idDEntista`)
    REFERENCES `mydb`.`Dentista` (`idDEntista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dentista_has_Secretario_Secretario1`
    FOREIGN KEY (`Secretario_idSecretario`)
    REFERENCES `mydb`.`Secretario` (`idSecretario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
