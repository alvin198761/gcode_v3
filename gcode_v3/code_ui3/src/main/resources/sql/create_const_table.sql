CREATE TABLE
IF NOT EXISTS `t_alvin_gen_code_const` (
	`id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
	`type_key` VARCHAR (100) NOT NULL COMMENT '常量类型唯一键',
	`type_label` VARCHAR (100) NOT NULL COMMENT '常量类型显示文本',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
ALTER TABLE `t_alvin_gen_code_const` COMMENT '常量字典表';