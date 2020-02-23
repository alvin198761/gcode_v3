package org.alvin.home.v3.code.system.alvingencoderef;
import java.util.List;

import com.google.common.collect.Lists;
import org.alvin.home.v3.code.system.gencode.TableSettingsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.ArrayList;
import org.alvin.code.gen.beans.BaseDao;
import org.alvin.code.gen.utils.Page;
import org.alvin.code.gen.utils.SqlUtil;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 数据表字段关系记录--数据访问层
* @author: 唐植超
* @date : 2020-02-23 15:41:10
**/
@Slf4j
@Repository
public class AlvinGenCodeRefDao extends BaseDao{

    private StringBuilder insert = new StringBuilder();

    @Value("${db_name}")
    private String dbName;

    /**
    * @方法说明：  构造方法,用于拼加SQL及初始化工作
    */
    public AlvinGenCodeRefDao () {
        insert.append("INSERT INTO t_alvin_gen_code_ref (table_schema,table_name,col_name,ref_type,ref_table_name,ref_col_name,ref_const_type_key) ");
        insert.append(" VALUES (?,?,?,?,?,?,?)");
    }

    /**
    * @方法说明：  新增数据表字段关系记录记录
    */
    public int save(AlvinGenCodeRef vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("REPLACE INTO t_alvin_gen_code_ref (id,table_schema,table_name,col_name,ref_type,ref_table_name,ref_col_name,ref_const_type_key)");
        sql.append(" VALUES (?,?,?,?,?,?,?,?) ");
        Object[] params ={ vo.getId(),vo.getTableSchema(),vo.getTableName(),vo.getColName(),vo.getRefType(),vo.getRefTableName(),vo.getRefColName(),vo.getRefConstTypeKey() };
        //log.info(SqlUtil.showSql(sql.toString(), params));//显示SQL语句
        return jdbcTemplate.update(sql.toString(), params);
    }
    
    /**
    * @方法说明：新增数据表字段关系记录记录并返回自增涨主键值
    */
  //  public long saveReturnPK(AlvinGenCodeRef vo) {
  //       return saveKey(vo, insert.toString(), "id");
  //  }
    
    /**
    * @方法说明：批量插入数据表字段关系记录记录
    */
    public int[] insertBatch(List<AlvinGenCodeRef> list) {
       return batchOperate(list, insert.toString());
    }
    
    /**
    * @方法说明：物理删除数据表字段关系记录记录(多条)
    */
    public int delete(Long ids[]) {
        String sql = "DELETE FROM t_alvin_gen_code_ref WHERE id" + SqlUtil.ArrayToIn(ids);
        return jdbcTemplate.update(sql);
    }
    
    /**
    * @方法说明：更新数据表字段关系记录记录
    */
    public int update(AlvinGenCodeRef vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_ref SET table_schema=?,table_name=?,col_name=?,ref_type=?,ref_table_name=?,ref_col_name=?,ref_const_type_key=? ");
        sql.append(" WHERE id=? ");
        Object[] params = {vo.getTableSchema(),vo.getTableName(),vo.getColName(),vo.getRefType(),vo.getRefTableName(),vo.getRefColName(),vo.getRefConstTypeKey()};
        return jdbcTemplate.update(sql.toString(), params);
      }


     /**
    * @方法说明：更新数据表字段关系记录记录,不为空的都更新掉
    */
    public int updateNotNull(AlvinGenCodeRef vo) {
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
                                                        
        if(vo.getTableSchema() != null){
            fields.add(" table_schema = ? ");
            values.add(vo.getTableSchema());
        }   
                                
        if(vo.getTableName() != null){
            fields.add(" table_name = ? ");
            values.add(vo.getTableName());
        }   
                                
        if(vo.getColName() != null){
            fields.add(" col_name = ? ");
            values.add(vo.getColName());
        }   
                                
        if(vo.getRefType() != null){
            fields.add(" ref_type = ? ");
            values.add(vo.getRefType());
        }   
                                
        if(vo.getRefTableName() != null){
            fields.add(" ref_table_name = ? ");
            values.add(vo.getRefTableName());
        }   
                                
        if(vo.getRefColName() != null){
            fields.add(" ref_col_name = ? ");
            values.add(vo.getRefColName());
        }   
                                
        if(vo.getRefConstTypeKey() != null){
            fields.add(" ref_const_type_key = ? ");
            values.add(vo.getRefConstTypeKey());
        }   
                        
        if(fields.isEmpty()){
            return 0;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE t_alvin_gen_code_ref SET ");
        sql.append(Joiner.on(",").join(fields));
        sql.append(" WHERE id=? ");
        values.add(vo.getId());
        Object[] params = values.toArray();
        return jdbcTemplate.update(sql.toString(), params);
      }

        /**
        * @方法说明：按条件查询分页数据表字段关系记录列表
        */
    public Page<AlvinGenCodeRef> queryPage(AlvinGenCodeRefCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_ref t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
        sb.append(cond.getCondition());
		sb.append(" order by id desc ");
        //sb.append(cond.getOrderSql());//增加排序子句;
        //logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
        return queryPage(sb.toString(), cond, AlvinGenCodeRef.class);
    }
    
    /**
    * @方法说明：按条件查询不分页数据表字段关系记录列表
    */
    public List<AlvinGenCodeRef> queryList(AlvinGenCodeRefCond cond) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(cond));
        sb.append(" FROM t_alvin_gen_code_ref t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(cond.getCondition());
		sb.append(" order by id desc ");
    	//sb.append(" ORDER BY operate_time DESC");
    	return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(AlvinGenCodeRef.class));
    }
    
    /**
    * @方法说明：按ID查找单个数据表字段关系记录实体
    */
    public AlvinGenCodeRef findById(Long id) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append(this.getSelectedItems(null));
        sb.append(" FROM t_alvin_gen_code_ref t ");
        sb.append(getJoinTables());
        sb.append(" WHERE 1=1 ");
    	sb.append(" AND t.id=?");
    	return jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, new BeanPropertyRowMapper<>(AlvinGenCodeRef.class));
    }
    
    /**
    * @方法说明：按条件查询数据表字段关系记录记录个数
    */
    public long queryCount(AlvinGenCodeRefCond cond) {
    	String countSql = "SELECT COUNT(1) FROM t_alvin_gen_code_ref t WHERE 1=1" + cond.getCondition();
    	return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
    }
    
    /**
    * @方法说明：按条件查询数据表字段关系记录记录个数
    */
    public int deleteLogic(Long ids[]) {
    	String sql = "UPDATE t_alvin_gen_code_ref SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
    	return jdbcTemplate.update(sql);
    }

    /**
    * @方法说明：查询参数定制
    */
    public String getSelectedItems(AlvinGenCodeRefCond cond){
        if(cond == null || cond.getSelectedFields() == null || cond.getSelectedFields().isEmpty()){
        return "t.id,t.table_schema,t.table_name,t.col_name,t.ref_type,t.ref_table_name,t.ref_col_name,t.ref_const_type_key"; //默认所有字段
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


    /**
     * 根据表名查询相应关系配置
     *
     * @param tableName
     * @return
     */
    public List<AlvinGenCodeRef> queryListByTableName(String tableName) {
        String sql = "SELECT "+this.getSelectedItems(null)+" from  t_alvin_gen_code_ref t where t.table_name=?";
        return jdbcTemplate.query(sql, new Object[]{tableName}, new BeanPropertyRowMapper<>(AlvinGenCodeRef.class));
    }

    /**
     * 批量添加关系
     *
     * @param settings
     */
    public void batchInsert(TableSettingsDto settings) {
        String deleteSql = "delete from t_alvin_gen_code_ref where table_name = ? and table_schema=?";
        this.jdbcTemplate.update(deleteSql, new Object[]{settings.getTableName(), dbName});
        List<Object[]> params = Lists.newArrayList();
        for (AlvinGenCodeRef vo : settings.getFields()) {
            params.add(new Object[]{ dbName, vo.getTableName(), vo.getColName(),vo.getRefType(), vo.getRefTableName(), vo.getRefColName(),vo.getRefConstTypeKey()});
        }
        this.jdbcTemplate.batchUpdate(insert.toString(), params);
    }
}