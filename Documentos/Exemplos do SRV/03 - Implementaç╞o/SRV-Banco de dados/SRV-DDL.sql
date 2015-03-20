SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `srv` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `srv` ;

-- -----------------------------------------------------
-- Table `srv`.`servidor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `srv`.`servidor` (
  `matricula_siape` VARCHAR(7) NOT NULL ,
  `nome` VARCHAR(50) NOT NULL ,
  `senha` VARCHAR(8) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `perfil` TINYINT(1) NOT NULL ,
  `sexo` VARCHAR(10) NOT NULL ,
  `data_nascimento` DATE NOT NULL ,
  `cpf` VARCHAR(14) NOT NULL ,
  `rg` VARCHAR(15) NOT NULL ,
  `orgao_expedidor` VARCHAR(10) NOT NULL ,
  `naturalidade` VARCHAR(30) NULL DEFAULT NULL ,
  `estado` VARCHAR(2) NULL DEFAULT NULL ,
  `nacionalidade` VARCHAR(20) NULL DEFAULT NULL ,
  `estado_civil` VARCHAR(15) NULL DEFAULT NULL ,
  `telefone1` VARCHAR(14) NOT NULL ,
  `telefone2` VARCHAR(14) NULL DEFAULT NULL ,
  `motorista` TINYINT(1) NOT NULL ,
  `cnh` VARCHAR(11) NULL DEFAULT NULL ,
  `status_serv` TINYINT(1) NOT NULL ,
  `informacoes` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`matricula_siape`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `srv`.`veiculo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `srv`.`veiculo` (
  `placa` VARCHAR(8) NOT NULL ,
  `ano` VARCHAR(9) NOT NULL ,
  `marca` VARCHAR(15) NOT NULL ,
  `modelo` VARCHAR(30) NOT NULL ,
  `combustivel` VARCHAR(50) NOT NULL ,
  `renavam` VARCHAR(11) NOT NULL ,
  `capacidade` INT(2) NOT NULL ,
  `manutencao` TINYINT(1) NOT NULL ,
  `manutencao_data_inicial` DATE NULL DEFAULT NULL ,
  `manutencao_data_final` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`placa`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `srv`.`destino`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `srv`.`destino` (
  `id_destino` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_destino`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `srv`.`reserva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `srv`.`reserva` (
  `id_reserva` INT NOT NULL ,
  `matricula_siape` VARCHAR(7) NOT NULL ,
  `data_saida` DATETIME NOT NULL ,
  `data_retorno` DATETIME NOT NULL ,
  `placa` VARCHAR(8) NOT NULL ,
  `condutor` TINYINT(1) NOT NULL ,
  `matricula_siape_condutor` VARCHAR(7) NOT NULL ,
  `ocupantes` INT NOT NULL ,
  `id_destino` INT NULL ,
  `descricao_destino` VARCHAR(30) NULL ,
  `reserva_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`id_reserva`) ,
  INDEX `fk_reserva_servidor_idx` (`matricula_siape` ASC) ,
  INDEX `fk_reserva_veiculo_idx` (`placa` ASC) ,
  INDEX `reserva_data_saida_idx` (`data_saida` ASC) ,
  INDEX `reserva_data_retorno_idx` (`data_retorno` ASC) ,
  INDEX `fk_reserva_servidor_condutor_idx` (`matricula_siape_condutor` ASC) ,
  INDEX `fk_reserva_destino_idx` (`id_destino` ASC) ,
  CONSTRAINT `fk_reserva_servidor`
    FOREIGN KEY (`matricula_siape` )
    REFERENCES `srv`.`servidor` (`matricula_siape` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_veiculo1`
    FOREIGN KEY (`placa` )
    REFERENCES `srv`.`veiculo` (`placa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_servidor1`
    FOREIGN KEY (`matricula_siape_condutor` )
    REFERENCES `srv`.`servidor` (`matricula_siape` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_destino1`
    FOREIGN KEY (`id_destino` )
    REFERENCES `srv`.`destino` (`id_destino` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `srv` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

