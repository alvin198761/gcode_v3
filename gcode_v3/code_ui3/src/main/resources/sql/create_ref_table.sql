CREATE TABLE
IF NOT EXISTS `t_alvin_gen_code_ref` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
	`table_schema` VARCHAR (200) NOT NULL COMMENT '数据库',
	`table_name` VARCHAR (200) NOT NULL COMMENT '表名称',
	`col_name` VARCHAR (200) NOT NULL COMMENT '字段名',
	`ref_type` INT NOT NULL COMMENT '字段分类0=引用类 1=引用常量',
	`ref_table_name` VARCHAR(200) NOT NULL COMMENT '关联表',
	`ref_col_name` VARCHAR(200) NOT NULL COMMENT '关联字段',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
ALTER TABLE `t_alvin_gen_code_ref` COMMENT '数据表字段关系记录';