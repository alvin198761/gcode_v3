package org.alvin.home.v3.code.system.alvingencodeconst;
import java.util.List;
import org.alvin.code.gen.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 常量字典表--数据逻辑层
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Slf4j
@Service
public class AlvinGenCodeConstService {

	@Autowired
	private AlvinGenCodeConstDao dao; //注入常量字典表数据访问层

	/**
	* @方法说明：  新增[常量字典表]记录
	*/
	@Transactional
	public int save(AlvinGenCodeConst alvinGenCodeConst) {
		return dao.save(alvinGenCodeConst);
	}

	/**
	* @方法说明：  删除常量字典表记录(多条)
	*/
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	* @方法说明：  更新常量字典表记录
	*/
	@Transactional
	public int update(AlvinGenCodeConst alvinGenCodeConst) {
		return dao.update(alvinGenCodeConst); 
	}

	 /**
    * @方法说明：更新常量字典表记录,不为空的都更新掉
    */
    @Transactional
    public int updateNotNull(AlvinGenCodeConst alvinGenCodeConst) {
		return dao.updateNotNull(alvinGenCodeConst); 
    }

	/**
	* @方法说明： 按条件查询分页常量字典表列表
	*/
	public Page<AlvinGenCodeConst> queryPage(AlvinGenCodeConstCond cond) {
		return dao.queryPage(cond);
	}

	/**
	* @方法说明： 按条件查询不分页常量字典表列表(使用范型)
	*/
	public List<AlvinGenCodeConst> queryList(AlvinGenCodeConstCond cond) {
		return dao.queryList(cond);
	}

	/**
	* @方法说明： 按ID查找单个常量字典表记录
	*/
	public AlvinGenCodeConst findById(Long id) {
		return dao.findById(id);
	}

	/**
	* @方法说明： 按条件查询常量字典表记录个数
	*/
	public long queryCount(AlvinGenCodeConstCond cond) {
		return dao.queryCount(cond);
	}
}