package org.alvin.home.v3.code.system.alvingencodeconstvalue;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.ArrayList;
import org.alvin.code.gen.beans.BaseDao;
import org.alvin.code.gen.utils.Page;
import org.alvin.code.gen.utils.SqlUtil;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 常量值表--数据访问层
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Slf4j
@Repository
public class AlvinGenCodeConstValueDao extends BaseDao{

    private StringBuilder insert = new StringBuilder();

    /**
    * @方法说明：  构造方法,用于拼加SQL及初始化工作
    */
    public AlvinGenCodeConstValueDao () {
        insert.append("INSERT INTO t_alvin_gen_code_const_value (type_id,data_key,data_label) ");
        insert.append(" VALUES (:typeId,:dataKey,:dataLabel)");
    }

    /**
    * @方法说明：  新增常量值表记录
    */
    public int save(AlvinGenCodeConstValue vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO t_alvin_gen_code_const_value (id,type_id,data_key,data_label)");
        sql.append(" VALUES (?,?,?,?) ");
        Object[] params ={ vo.getId(),vo.getTypeId(),vo.getDataKey(),vo.getDataLabel() };
        //log.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
    * @方法说明：新增常量值表记录并返回自增涨主键值
    */
  //  public long saveReturnPK(AlvinGenCodeConstValue vo) {
  //       return saveKey(vo, insert.toString(), "id");
  //  }
    
    /**
    * @方法说明：批量插入常量值表记录
    */
    public int[] insertBatch(List<AlvinGenCodeConstValue> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
    * @方法说明：物理删除常量值表记录(多条)
    */
    public int delete(Long ids[]) {
        String sql = "DELETE FROM t_alvin_gen_code_const_value WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
    * @方法说明：更新常量值表记录
    */
    public int update(AlvinGenCodeConstValue vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_const_value SET type_id=?,data_key=?,data_label=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getTypeId(),vo.getDataKey(),vo.getDataLabel()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * @方法说明：更新常量值表记录,不为空的都更新掉
    */
    public int updateNotNull(AlvinGenCodeConstValue vo) {
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
                                                        
        if(vo.getTypeId() != null){
            fields.add(" type_id = ? ");
            values.add(vo.getTypeId());
        }   
                                
        if(vo.getDataKey() != null){
            fields.add(" data_key = ? ");
            values.add(vo.getDataKey());
        }   
                                
        if(vo.getDataLabel() != null){
            fields.add(" data_label = ? ");
            values.add(vo.getDataLabel());
        }   
                        
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_const_value SET ");
        sql.append(Joiner.on(",").join(fields));
        sql.append(" WHERE id=? ");
        values.add(vo.getId());
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * @方法说明：按条件查询分页常量值表列表
        */
    public Page<AlvinGenCodeConstValue> queryPage(AlvinGenCodeConstValueCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_const_value t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
		sb.append(" order by id desc ");
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, AlvinGenCodeConstValue.class);
    }
    
    /**
    * @方法说明：按条件查询不分页常量值表列表
    */
    public List<AlvinGenCodeConstValue> queryList(AlvinGenCodeConstValueCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_const_value t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
		sb.append(" order by id desc ");
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(AlvinGenCodeConstValue.class));
    }
    
    /**
    * @方法说明：按ID查找单个常量值表实体
    */
    public AlvinGenCodeConstValue findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM t_alvin_gen_code_const_value t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(AlvinGenCodeConstValue.class));
    }
    
    /**
    * @方法说明：按条件查询常量值表记录个数
    */
    public long queryCount(AlvinGenCodeConstValueCond cond) {
    	String countSql = "SELECT COUNT(1) FROM t_alvin_gen_code_const_value t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * @方法说明：按条件查询常量值表记录个数
    */
    public int deleteLogic(Long ids[]) {
    	String sql = "UPDATE t_alvin_gen_code_const_value SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }

    /**
    * @方法说明：查询参数定制
    */
    public String getSelectedItems(AlvinGenCodeConstValueCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.type_id,t.data_key,t.data_label"; //默认所有字段
        }
        return Joiner.on(",").join(cond.getSelectedFields());
    }

    /**
    * @方法说明：表连接代码
    * @return
    */
    public String getJoinTables(){
        return "";
    }
}