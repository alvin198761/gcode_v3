package org.alvin.home.v3.code.system.alvingencodeconstvalue;
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
* @类说明: 常量值表--数据控制器层
* @author: 唐植超
* @date : 2020-02-23 14:37:44
**/
@Slf4j
@RestController
@RequestMapping("api/alvinGenCodeConstValue")
public class AlvinGenCodeConstValueController {

	@Autowired
	private AlvinGenCodeConstValueService service; //注入常量值表数据逻辑层

    /**
    * @方法说明：  新增[常量值表]记录
    */
	@PostMapping("save")
	public int save(@RequestBody AlvinGenCodeConstValue alvinGenCodeConstValue) {
		return service.save(alvinGenCodeConstValue);
	}

    /**
    * @方法说明： 删除市场记录(多条)
    */
	@RequestMapping("delete")
	public int delete(@RequestParam("id") Long id) {
		return service.delete(new Long[]{id});
	}

    /**
    * @方法说明： 修改常量值表记录
    */
	@PostMapping("update")
	public int update(@RequestBody AlvinGenCodeConstValue alvinGenCodeConstValue) {
		return service.update(alvinGenCodeConstValue);
	}

    /**
    * @方法说明： 按条件查询分页常量值表列表
    */
	@PostMapping("queryPage")
	public Page<AlvinGenCodeConstValue> queryPage(@RequestBody AlvinGenCodeConstValueCond cond ){
		return service.queryPage(cond);
	}

    /**
    * @方法说明： 按条件查询不分页常量值表列表
    */
	@PostMapping("queryList")
	public List<AlvinGenCodeConstValue> queryList(@RequestBody AlvinGenCodeConstValueCond cond ){
		return service.queryList(cond);
	}

    /**
    * @方法说明： 按主键查单个常量值表记录
    */
	@RequestMapping("findById")
	public AlvinGenCodeConstValue findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
    * @方法说明： 按条件查询常量值表记录个数
    */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AlvinGenCodeConstValueCond cond ){
		return service.queryCount(cond);
	}
}