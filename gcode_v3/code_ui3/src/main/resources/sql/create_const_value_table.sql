CREATE TABLE
IF NOT EXISTS `t_alvin_gen_code_const_value` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
	`type_id`  BIGINT NOT NULL  COMMENT '主键',
	`data_key` TINYINT NOT NULL COMMENT '数据唯一键',
	`data_label` VARCHAR (100) NOT NULL COMMENT '数据显示文本',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
ALTER TABLE `t_alvin_gen_code_const_value` COMMENT '常量值表';