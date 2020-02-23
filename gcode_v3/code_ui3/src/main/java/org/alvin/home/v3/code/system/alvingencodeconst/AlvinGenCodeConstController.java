package org.alvin.home.v3.code.system.alvingencodeconst;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.alvin.code.gen.utils.Page;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
/**
* @类说明: 常量字典表--数据控制器层
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Slf4j
@RestController
@RequestMapping("api/alvinGenCodeConst")
public class AlvinGenCodeConstController {

	@Autowired
	private AlvinGenCodeConstService service; //注入常量字典表数据逻辑层

    /**
    * @方法说明：  新增[常量字典表]记录
    */
	@PostMapping("save")
	public int save(@RequestBody AlvinGenCodeConst alvinGenCodeConst) {
		return service.save(alvinGenCodeConst);
	}

    /**
    * @方法说明： 删除市场记录(多条)
    */
	@RequestMapping("delete")
	public int delete(@RequestParam("id") Long id) {
		return service.delete(new Long[]{id});
	}

    /**
    * @方法说明： 修改常量字典表记录
    */
	@PostMapping("update")
	public int update(@RequestBody AlvinGenCodeConst alvinGenCodeConst) {
		return service.update(alvinGenCodeConst);
	}

    /**
    * @方法说明： 按条件查询分页常量字典表列表
    */
	@PostMapping("queryPage")
	public Page<AlvinGenCodeConst> queryPage(@RequestBody AlvinGenCodeConstCond cond ){
		return service.queryPage(cond);
	}

    /**
    * @方法说明： 按条件查询不分页常量字典表列表
    */
	@PostMapping("queryList")
	public List<AlvinGenCodeConst> queryList(@RequestBody AlvinGenCodeConstCond cond ){
		return service.queryList(cond);
	}

    /**
    * @方法说明： 按主键查单个常量字典表记录
    */
	@RequestMapping("findById")
	public AlvinGenCodeConst findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
    * @方法说明： 按条件查询常量字典表记录个数
    */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AlvinGenCodeConstCond cond ){
		return service.queryCount(cond);
	}
}