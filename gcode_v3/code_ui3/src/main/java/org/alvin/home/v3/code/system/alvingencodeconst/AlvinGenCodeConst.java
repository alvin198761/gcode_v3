package org.alvin.home.v3.code.system.alvingencodeconst;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
* @类说明: 常量字典表--实体类
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Setter
@Getter
@Accessors(chain = true)
@Builder	
@AllArgsConstructor
@NoArgsConstructor
public class AlvinGenCodeConst {

    //数据库中的字段
        private Long id ;//  主键
        private String typeKey ;//  常量类型唯一键
        private String typeLabel ;//  常量类型显示文本
    
    //此处可添加查询显示辅助字段

}