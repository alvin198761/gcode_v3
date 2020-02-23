package org.alvin.home.v3.code.system.alvingencodeconstvalue;
import java.util.List;
import org.alvin.code.gen.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 常量值表--数据逻辑层
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Slf4j
@Service
public class AlvinGenCodeConstValueService {

	@Autowired
	private AlvinGenCodeConstValueDao dao; //注入常量值表数据访问层

	/**
	* @方法说明：  新增[常量值表]记录
	*/
	@Transactional
	public int save(AlvinGenCodeConstValue alvinGenCodeConstValue) {
		return dao.save(alvinGenCodeConstValue);
	}

	/**
	* @方法说明：  删除常量值表记录(多条)
	*/
	public int delete(Long ids[]) {
		//return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);//物理删除
	}

	/**
	* @方法说明：  更新常量值表记录
	*/
	@Transactional
	public int update(AlvinGenCodeConstValue alvinGenCodeConstValue) {
		return dao.update(alvinGenCodeConstValue); 
	}

	 /**
    * @方法说明：更新常量值表记录,不为空的都更新掉
    */
    @Transactional
    public int updateNotNull(AlvinGenCodeConstValue alvinGenCodeConstValue) {
		return dao.updateNotNull(alvinGenCodeConstValue); 
    }

	/**
	* @方法说明： 按条件查询分页常量值表列表
	*/
	public Page<AlvinGenCodeConstValue> queryPage(AlvinGenCodeConstValueCond cond) {
		return dao.queryPage(cond);
	}

	/**
	* @方法说明： 按条件查询不分页常量值表列表(使用范型)
	*/
	public List<AlvinGenCodeConstValue> queryList(AlvinGenCodeConstValueCond cond) {
		return dao.queryList(cond);
	}

	/**
	* @方法说明： 按ID查找单个常量值表记录
	*/
	public AlvinGenCodeConstValue findById(Long id) {
		return dao.findById(id);
	}

	/**
	* @方法说明： 按条件查询常量值表记录个数
	*/
	public long queryCount(AlvinGenCodeConstValueCond cond) {
		return dao.queryCount(cond);
	}
}