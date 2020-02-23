package org.alvin.home.v3.code.system.alvingencoderef;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
* @类说明: 数据表字段关系记录--实体类
* @author: 唐植超
* @date : 2020-02-23 15:41:10
**/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class AlvinGenCodeRef {

    //数据库中的字段
        private Long id ;//  主键
        private String tableSchema ;//  数据库
        private String tableName ;//  表名称
        private String colName ;//  字段名
        private Integer refType ;//  字段分类0=引用类 1=引用常量
        private String refTableName ;//  关联表
        private String refColName ;//  关联字段
        private String refConstTypeKey ;//  关联常量标识
    
    //此处可添加查询显示辅助字段
    private String refTableShortName; //简写表名
    private String comment;//注释

}