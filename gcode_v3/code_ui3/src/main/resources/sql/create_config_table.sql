CREATE TABLE
IF NOT EXISTS `t_alvin_gen_code_config` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
	`table_schema` VARCHAR (200) NOT NULL COMMENT '数据库',
	`table_name` VARCHAR (200) NOT NULL COMMENT '表名称',
	`label_name` VARCHAR (200) NOT NULL COMMENT '显示字段名',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
ALTER TABLE `t_alvin_gen_code_config` COMMENT '数据表显示字段';