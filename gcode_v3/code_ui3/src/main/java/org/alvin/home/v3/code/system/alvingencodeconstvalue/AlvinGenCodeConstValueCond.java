package org.alvin.home.v3.code.system.alvingencodeconstvalue;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.alvin.code.gen.beans.BaseCondition;
import java.util.List;

/**
* @类说明: 常量值表--查询条件实体类
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlvinGenCodeConstValueCond extends BaseCondition {


    /**
    * @方法说明: 拼加自定义条件
    **/
    @Override
    public void addCondition() {
                    add(id , " AND t.id = ? " );
                            add(typeId , " AND t.type_id = ? " );
                            add(dataKey , " AND t.data_key = ? " );
                            add(dataLabel , " AND t.data_label LIKE ? " ,3);
                 add(ids, "AND t.id IN ");
    }

    //属性
        private  Long  id ;//  主键
        private  Long  typeId ;//  主键
        private  Byte  dataKey ;//  数据唯一键
        private  String  dataLabel ;//  数据显示文本
         private List<Long> ids;// 主键列表
}