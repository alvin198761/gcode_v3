package org.alvin.home.v3.code.system.alvingencoderef;
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
* @类说明: 数据表字段关系记录--数据控制器层
* @author: 唐植超
* @date : 2020-02-23 15:41:10
**/
@Slf4j
@RestController
@RequestMapping("api/alvinGenCodeRef")
public class AlvinGenCodeRefController {

	@Autowired
	private AlvinGenCodeRefService service; //注入数据表字段关系记录数据逻辑层

    /**
    * @方法说明：  新增[数据表字段关系记录]记录
    */
	@PostMapping("save")
	public int save(@RequestBody AlvinGenCodeRef alvinGenCodeRef) {
		return service.save(alvinGenCodeRef);
	}

    /**
    * @方法说明： 删除市场记录(多条)
    */
	@RequestMapping("delete")
	public int delete(@RequestParam("id") Long id) {
		return service.delete(new Long[]{id});
	}

    /**
    * @方法说明： 修改数据表字段关系记录记录
    */
	@PostMapping("update")
	public int update(@RequestBody AlvinGenCodeRef alvinGenCodeRef) {
		return service.update(alvinGenCodeRef);
	}

    /**
    * @方法说明： 按条件查询分页数据表字段关系记录列表
    */
	@PostMapping("queryPage")
	public Page<AlvinGenCodeRef> queryPage(@RequestBody AlvinGenCodeRefCond cond ){
		return service.queryPage(cond);
	}

    /**
    * @方法说明： 按条件查询不分页数据表字段关系记录列表
    */
	@PostMapping("queryList")
	public List<AlvinGenCodeRef> queryList(@RequestBody AlvinGenCodeRefCond cond ){
		return service.queryList(cond);
	}

    /**
    * @方法说明： 按主键查单个数据表字段关系记录记录
    */
	@RequestMapping("findById")
	public AlvinGenCodeRef findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

    /**
    * @方法说明： 按条件查询数据表字段关系记录记录个数
    */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AlvinGenCodeRefCond cond ){
		return service.queryCount(cond);
	}
}