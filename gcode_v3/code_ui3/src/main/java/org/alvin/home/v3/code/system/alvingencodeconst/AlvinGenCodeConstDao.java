package org.alvin.home.v3.code.system.alvingencodeconst;
import java.util.List;

import org.alvin.code.gen.beans.BaseDao;
import org.alvin.code.gen.utils.Page;
import org.alvin.code.gen.utils.SqlUtil;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.ArrayList;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 常量字典表--数据访问层
* @author: 唐植超
* @date : 2020-02-22 17:44:21
**/
@Slf4j
@Repository
public class AlvinGenCodeConstDao extends BaseDao {

    private StringBuilder insert = new StringBuilder();

    /**
    * @方法说明：  构造方法,用于拼加SQL及初始化工作
    */
    public AlvinGenCodeConstDao () {
        insert.append("INSERT INTO t_alvin_gen_code_const (type_key,type_label,value_key,value_label) ");
        insert.append(" VALUES (:typeKey,:typeLabel,:valueKey,:valueLabel)");
    }

    /**
    * @方法说明：  新增常量字典表记录
    */
    public int save(AlvinGenCodeConst vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO t_alvin_gen_code_const (id,type_key,type_label,value_key,value_label)");
        sql.append(" VALUES (?,?,?,?,?) ");
        Object[] params ={ vo.getId(),vo.getTypeKey(),vo.getTypeLabel(),vo.getValueKey(),vo.getValueLabel() };
        //log.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
    * @方法说明：新增常量字典表记录并返回自增涨主键值
    */
//    public long saveReturnPK(AlvinGenCodeConst vo) {
//         return saveKey(vo, insert.toString(), "id");
//    }
    
    /**
    * @方法说明：批量插入常量字典表记录
    */
    public int[] insertBatch(List<AlvinGenCodeConst> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
    * @方法说明：物理删除常量字典表记录(多条)
    */
    public int delete(Long ids[]) {
        String sql = "DELETE FROM t_alvin_gen_code_const WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
    * @方法说明：更新常量字典表记录
    */
    public int update(AlvinGenCodeConst vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_const SET type_key=?,type_label=?,value_key=?,value_label=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getTypeKey(),vo.getTypeLabel(),vo.getValueKey(),vo.getValueLabel()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * @方法说明：更新常量字典表记录,不为空的都更新掉
    */
    public int updateNotNull(AlvinGenCodeConst vo) {
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
                                                        
        if(vo.getTypeKey() != null){
            fields.add(" type_key = ? ");
            values.add(vo.getTypeKey());
        }   
                                
        if(vo.getTypeLabel() != null){
            fields.add(" type_label = ? ");
            values.add(vo.getTypeLabel());
        }   
                                
        if(vo.getValueKey() != null){
            fields.add(" value_key = ? ");
            values.add(vo.getValueKey());
        }   
                                
        if(vo.getValueLabel() != null){
            fields.add(" value_label = ? ");
            values.add(vo.getValueLabel());
        }   
                        
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_const SET ");
        sql.append(Joiner.on(",").join(fields));
        sql.append(" WHERE id=? ");
        values.add(vo.getId());
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * @方法说明：按条件查询分页常量字典表列表
        */
    public Page<AlvinGenCodeConst> queryPage(AlvinGenCodeConstCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_const t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
		sb.append(" order by id desc ");
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, AlvinGenCodeConst.class);
    }
    
    /**
    * @方法说明：按条件查询不分页常量字典表列表
    */
    public List<AlvinGenCodeConst> queryList(AlvinGenCodeConstCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_const t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
		sb.append(" order by id desc ");
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(AlvinGenCodeConst.class));
    }
    
    /**
    * @方法说明：按ID查找单个常量字典表实体
    */
    public AlvinGenCodeConst findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM t_alvin_gen_code_const t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(AlvinGenCodeConst.class));
    }
    
    /**
    * @方法说明：按条件查询常量字典表记录个数
    */
    public long queryCount(AlvinGenCodeConstCond cond) {
    	String countSql = "SELECT COUNT(1) FROM t_alvin_gen_code_const t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * @方法说明：按条件查询常量字典表记录个数
    */
    public int deleteLogic(Long ids[]) {
    	String sql = "UPDATE t_alvin_gen_code_const SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }

    /**
    * @方法说明：查询参数定制
    */
    public String getSelectedItems(AlvinGenCodeConstCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.type_key,t.type_label,t.value_key,t.value_label"; //默认所有字段
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