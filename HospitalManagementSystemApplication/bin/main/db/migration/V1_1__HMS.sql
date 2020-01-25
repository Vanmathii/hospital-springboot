CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_role` (
  `pk_role_id` INT(2) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(32) NULL,
  PRIMARY KEY (`pk_role_id`));
  
  CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_branch` (
  `pk_branch_id` INT(2) NOT NULL AUTO_INCREMENT,
  `branch_name` VARCHAR(32) NULL,
  PRIMARY KEY (`pk_branch_id`));

  CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_user` (
  `pk_user_id` INT(2) NOT NULL AUTO_INCREMENT,
  `fk_role_id` INT(2) NULL,
  `first_name` VARCHAR(32) NULL,
  `last_name` VARCHAR(32) NULL,
  `user_age` INT(2) NULL,
  `user_mobile_number` VARCHAR(45) NULL,
  `user_addressline1` VARCHAR(45) NULL,
  `user_addressline2` VARCHAR(45) NULL,
  `user_addressline3` VARCHAR(45) NULL,
  `is_active` CHAR(1) NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`pk_user_id`),
  INDEX `fk_role_id_idx` (`fk_role_id` ASC) VISIBLE,
  UNIQUE INDEX `pk_user_id_UNIQUE` (`pk_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_id`
    FOREIGN KEY (`fk_role_id`)
    REFERENCES `hospital_management_system`.`t_role` (`pk_role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
    CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_patient` (
  `patient_disease` VARCHAR(32) NULL,
  `fk_user_id_patient` INT(2) NULL,
  `patient_blood_group` VARCHAR(32) NULL,
  `is_active_patient` CHAR(1) NULL,
  `pk_patient_id` INT(2) NOT NULL AUTO_INCREMENT,
  INDEX `fk_user_id_patient_idx` (`fk_user_id_patient` ASC) VISIBLE,
  PRIMARY KEY (`pk_patient_id`),
  UNIQUE INDEX `pk_patient_id_UNIQUE` (`pk_patient_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id_patient`
    FOREIGN KEY (`fk_user_id_patient`)
    REFERENCES `hospital_management_system`.`t_user` (`pk_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_doctor` (
  `specialization` VARCHAR(32) NOT NULL,
  `fk_user_id_doctor` INT(2) NULL,
  `is_active_doctor` CHAR(1) NULL,
  `pk_doctor_id` INT(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`specialization`, `pk_doctor_id`),
  INDEX `fk_user_id_doctor_idx` (`fk_user_id_doctor` ASC) VISIBLE,
  UNIQUE INDEX `pk_doctor_id_UNIQUE` (`pk_doctor_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id_doctor`
    FOREIGN KEY (`fk_user_id_doctor`)
    REFERENCES `hospital_management_system`.`t_user` (`pk_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    CREATE TABLE IF NOT EXISTS `hospital_management_system`.`t_patient_doctor_mapping` (
  `pk_patient_doctor_mapping_id` INT(2) NOT NULL AUTO_INCREMENT,
  `fk_user_id_patient_mapping` INT(2) NULL,
  `fk_user_id_doctor_mappings` INT(2) NOT NULL,
  INDEX `fk_user_id_patient_idx` (`fk_user_id_patient_mapping` ASC) VISIBLE,
  INDEX `fk_user_id_doctor_idx` (`fk_user_id_doctor_mappings` ASC) VISIBLE,
  PRIMARY KEY (`pk_patient_doctor_mapping_id`),
  UNIQUE INDEX `pk_patient_doctor_mapping_id_UNIQUE` (`pk_patient_doctor_mapping_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id_patient_mappig`
    FOREIGN KEY (`fk_user_id_patient_mapping`)
    REFERENCES `hospital_management_system`.`t_patient` (`fk_user_id_patient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id_doctor_mapping`
    FOREIGN KEY (`fk_user_id_doctor_mappings`)
    REFERENCES `hospital_management_system`.`t_doctor` (`fk_user_id_doctor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
