package org.alvin.home.v3.code.system.alvingencodeconst;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.alvin.code.gen.beans.BaseCondition;

import java.util.List;

/**
 * @类说明: 常量字典表--查询条件实体类
 * @author: 唐植超
 * @date : 2020-02-22 17:44:21
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlvinGenCodeConstCond extends BaseCondition {


    /**
     * @方法说明: 拼加自定义条件
     **/
    @Override
    public void addCondition() {
        add(id, " AND t.id = ? ");
        add(typeKey, " AND t.type_key LIKE ? ", 3);
        add(typeLabel, " AND t.type_label LIKE ? ", 3);
        add(valueKey, " AND t.value_key = ? ");
        add(valueLabel, " AND t.value_label  LIKE ? ", 3);
         add(ids, "AND t.id IN ");
    }

    //属性
    private Long id;//  主键
    private String typeKey;//  常量类型唯一键
    private String typeLabel;//  常量类型显示文本
    private Integer valueKey;//  常量值唯一键
    private String valueLabel;//  常量值显示文本
     private List<Long> ids;// 主键列表
}