package org.alvin.home.v3.code.system.alvingencoderef;
import java.util.List;
import org.alvin.code.gen.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 数据表字段关系记录--数据逻辑层
* @author: 唐植超
* @date : 2020-02-23 15:41:10
**/
@Slf4j
@Service
public class AlvinGenCodeRefService {

	@Autowired
	private AlvinGenCodeRefDao dao; //注入数据表字段关系记录数据访问层

	/**
	* @方法说明：  新增[数据表字段关系记录]记录
	*/
	@Transactional
	public int save(AlvinGenCodeRef alvinGenCodeRef) {
		return dao.save(alvinGenCodeRef);
	}

	/**
	* @方法说明：  删除数据表字段关系记录记录(多条)
	*/
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	* @方法说明：  更新数据表字段关系记录记录
	*/
	@Transactional
	public int update(AlvinGenCodeRef alvinGenCodeRef) {
		return dao.update(alvinGenCodeRef); 
	}

	 /**
    * @方法说明：更新数据表字段关系记录记录,不为空的都更新掉
    */
    @Transactional
    public int updateNotNull(AlvinGenCodeRef alvinGenCodeRef) {
		return dao.updateNotNull(alvinGenCodeRef); 
    }

	/**
	* @方法说明： 按条件查询分页数据表字段关系记录列表
	*/
	public Page<AlvinGenCodeRef> queryPage(AlvinGenCodeRefCond cond) {
		return dao.queryPage(cond);
	}

	/**
	* @方法说明： 按条件查询不分页数据表字段关系记录列表(使用范型)
	*/
	public List<AlvinGenCodeRef> queryList(AlvinGenCodeRefCond cond) {
		return dao.queryList(cond);
	}

	/**
	* @方法说明： 按ID查找单个数据表字段关系记录记录
	*/
	public AlvinGenCodeRef findById(Long id) {
		return dao.findById(id);
	}

	/**
	* @方法说明： 按条件查询数据表字段关系记录记录个数
	*/
	public long queryCount(AlvinGenCodeRefCond cond) {
		return dao.queryCount(cond);
	}
}