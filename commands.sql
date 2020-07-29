create schema 'librarymanagement';
CREATE TABLE `librarymanagement`.`books` (
  `Acc_No` INT NOT NULL,
  `Title` VARCHAR(45) NOT NULL,
  `Author` VARCHAR(45) NULL DEFAULT 'NA',
  `Publisher` VARCHAR(45) NOT NULL,
  `noca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Acc_No`));

ALTER TABLE `librarymanagement`.`books` 
CHANGE COLUMN `Title` `Title` VARCHAR(100) NOT NULL ,
CHANGE COLUMN `Publisher` `Publisher` VARCHAR(150) NOT NULL ;


CREATE TABLE `librarymanagement`.`members` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `first_name` VARCHAR(50) NULL,
  `last_name` VARCHAR(45) NULL,
  `dob` DATE NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `read_books` VARCHAR(1500) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
books
CREATE TABLE `librarymanagement`.`issue_table` (
  `issue_id` INT NOT NULL AUTO_INCREMENT,
  `accNo` INT NULL,
  `member_id` INT NOT NULL,
  `dbi` DATE NOT NULL,
  `dtbr` DATE NOT NULL,
  `odbr` DATE NULL,
  `fines` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`issue_id`),
  INDEX `accNo_idx` (`accNo` ASC) VISIBLE,
  CONSTRAINT `accNo`
    FOREIGN KEY (`accNo`)
    REFERENCES `librarymanagement`.`books` (`Acc_No`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION);


CREATE TABLE `librarymanagement`.`books_read` (
  `member_id` INT NOT NULL,
  `acc_No` INT NULL,
  PRIMARY KEY (`member_id`),
  INDEX `accessionNumber_idx` (`acc_No` ASC) VISIBLE,
  CONSTRAINT `accessionNumber`
    FOREIGN KEY (`acc_No`)
    REFERENCES `librarymanagement`.`issue_table` (`accNo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE `librarymanagement`.`followers` (
  `member_id` INT NOT NULL,
  `following` VARCHAR(150) NULL DEFAULT 0,
  `followers` VARCHAR(150) NULL DEFAULT 0,
  PRIMARY KEY (`member_id`));


