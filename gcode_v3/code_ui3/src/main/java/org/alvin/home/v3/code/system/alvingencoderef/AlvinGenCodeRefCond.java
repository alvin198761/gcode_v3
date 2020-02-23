package org.alvin.home.v3.code.system.alvingencoderef;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.alvin.code.gen.beans.BaseCondition;
import java.util.List;

/**
* @类说明: 数据表字段关系记录--查询条件实体类
* @author: 唐植超
* @date : 2020-02-23 15:41:10
**/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlvinGenCodeRefCond extends BaseCondition {


    /**
    * @方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(id , " AND t.id = ? " );
                            add(tableSchema , " AND t.table_schema LIKE ? " ,3);
                            add(tableName , " AND t.table_name LIKE ? " ,3);
                            add(colName , " AND t.col_name LIKE ? " ,3);
                            add(refType , " AND t.ref_type = ? " );
                            add(refTableName , " AND t.ref_table_name LIKE ? " ,3);
                            add(refColName , " AND t.ref_col_name LIKE ? " ,3);
                            add(refConstTypeKey , " AND t.ref_const_type_key LIKE ? " ,3);
                 add(ids, "AND t.id IN ");
    }

    //属性
        private  Long  id ;//  主键
        private  String  tableSchema ;//  数据库
        private  String  tableName ;//  表名称
        private  String  colName ;//  字段名
        private  Integer  refType ;//  字段分类0=引用类 1=引用常量
        private  String  refTableName ;//  关联表
        private  String  refColName ;//  关联字段
        private  String  refConstTypeKey ;//  关联常量标识
         private List<Long> ids;// 主键列表
}