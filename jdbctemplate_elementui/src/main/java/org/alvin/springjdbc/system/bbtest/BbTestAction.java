package org.alvin.springjdbc.system.bbtest;

/**
* 类说明: 测试表B--Swagger控制器类 ,使用requestbody 实现
* @author 唐植超
* 生成日期 2020-02-20 20:09:06
**/
@lombok.extern.slf4j.Slf4j
@io.swagger.annotations.Api(value = "[测试表B]控制器", description = "[测试表B]相关操作")
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/bbTest")
public class BbTestAction {

    @org.springframework.beans.factory.annotation.Autowired
    private BbTestService bbTestService; //注入[测试表B]业务逻辑类

    /**
     * 方法说明： 新增[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "新增[测试表B]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTest", name = "bbTest", value = "收寄信息", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("save")
    public org.alvin.code.gen.beans.RestfullResp<Integer> save(@org.springframework.web.bind.annotation.RequestBody BbTest bbTest) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.save(bbTest));
    }


    /**
     * 方法说明： 删除[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "删除[测试表B]", notes = "返回影响记录行数")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[测试表B]的主键", required = true, dataType = "array", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("delete")
    public org.alvin.code.gen.beans.RestfullResp<Integer> delete(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.delete(id));
    }


    /**
     * 方法说明： 修改[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[测试表B]", notes = "返回影响记录行数,(必须传入完整对象,否则会有数据丢失)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTest", name = "bbTest", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("update")
    public org.alvin.code.gen.beans.RestfullResp<Integer> update(@org.springframework.web.bind.annotation.RequestBody BbTest bbTest) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.update(bbTest));
    }

    /**
     * 方法说明： 修改[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "修改[测试表B]", notes = "返回影响记录行数(传入需要修改的属性和主键即可,其他可以为空)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTest", name = "bbTest", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("updateNotNull")
    public org.alvin.code.gen.beans.RestfullResp<Integer> updateNotNull(@org.springframework.web.bind.annotation.RequestBody BbTest bbTest) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.updateNotNull(bbTest));
    }

    /**
     * 方法说明： 按条件查询分页[测试表B]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[测试表B]列表", notes = "返回分页[测试表B]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestCond", name = "cond", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<BbTest>> queryPage(@org.springframework.web.bind.annotation.RequestBody BbTestCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryPage(cond));
    }

    /**
     * 方法说明： 按条件查询不分页[测试表B]列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[测试表B]列表", notes = "返回不分页[测试表B]列表")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestCond", name = "cond", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<BbTest>> queryList(@org.springframework.web.bind.annotation.RequestBody BbTestCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryList(cond));
    }

    /**
     * 方法说明： 按条件查询一个 测试表B 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 测试表B 对象", notes = "返回 测试表B对象")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestCond", name = "cond", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findOne")
    public org.alvin.code.gen.beans.RestfullResp<BbTest> findOne(@org.springframework.web.bind.annotation.RequestBody BbTestCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.findOne(cond));
    }

    /**
     * 方法说明： 按条件查询[测试表B]记录个数
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询[测试表B]记录个数", notes = "返回记录个数")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestCond", name = "cond", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryCount")
    public org.alvin.code.gen.beans.RestfullResp<Long> queryCount(@org.springframework.web.bind.annotation.RequestBody BbTestCond cond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryCount(cond));
    }

    /**
     * 方法说明： 按主键查询单条[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[测试表B]记录", notes = "返回单个[测试表B]对象")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[测试表B]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findById")
    public org.alvin.code.gen.beans.RestfullResp<BbTest> findById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.findById(id));
    }

    /**
     * 方法说明： 按主键查询单条[测试表B]记录
     */
    @io.swagger.annotations.ApiOperation(value = "按主键查询单个[测试表B]记录(带标签)", notes = "返回单个[测试表B]对象(带标签)")
    @io.swagger.annotations.ApiImplicitParams({@io.swagger.annotations.ApiImplicitParam(name = "id", value = "[测试表B]的主键", required = true, dataType = "Long", paramType = "query")})
    @org.springframework.web.bind.annotation.PostMapping("findFkById")
    public org.alvin.code.gen.beans.RestfullResp<BbTestFk> findFkById(@org.springframework.web.bind.annotation.RequestParam("id") Long id) {
        return  new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.findFkById(id));
    }

    /**
     * 方法说明： 按条件查询一个 测试表B 对象
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 测试表B 对象(带外键标签)", notes = "返回 测试表B对象 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestFkCond", name = "{table.varName}Cond", value = "测试表B(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("findFkOne")
    public org.alvin.code.gen.beans.RestfullResp<BbTestFk> findFkOne(@org.springframework.web.bind.annotation.RequestBody BbTestFkCond bbTestCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.findFkOne(bbTestCond));
    }

    /**
     * 方法说明: 只显示标签和id的列表
     *
     * @param bbTestFkCond
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询一个 测试表B 对象(只显示标签和id的列表)", notes = "返回 测试表B对象 (只显示标签和id的列表)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestFkCond", name = "bbTestFkCond", value = "测试表B", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryLabelList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<org.alvin.code.gen.beans.SelectOption>> queryLabelList(@org.springframework.web.bind.annotation.RequestBody BbTestFkCond bbTestFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryLabelList(bbTestFkCond));
    }

    /**
     * 方法说明：按条件查询不分页测试表B列表 (带关系表标签)
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询不分页[测试表B]列表 (带外键标签)", notes = "返回不分页[测试表B]列表 (带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestFkCond", name = "bbTestFkCond", value = "测试表B (外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkList")
    public org.alvin.code.gen.beans.RestfullResp<java.util.List<BbTestFk>> queryFkList(@org.springframework.web.bind.annotation.RequestBody BbTestFkCond bbTestFkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryFkList(bbTestFkCond));
    }

    /**
     * 方法说明：按条件查询分页测试表B列表
     */
    @io.swagger.annotations.ApiOperation(value = "按条件查询分页[测试表B]列表(带外键标签)", notes = "返回分页[测试表B]列表(带外键标签)")
    @io.swagger.annotations.ApiImplicitParams(
            {
                    @io.swagger.annotations.ApiImplicitParam(paramType = "body", dataType = "BbTestFkCond", name = "fkCond", value = "测试表B(外键)", required = true)
            })
    @io.swagger.annotations.ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 0, message = "操作成功")
    })
    @org.springframework.web.bind.annotation.PostMapping("queryFkPage")
    public org.alvin.code.gen.beans.RestfullResp<org.alvin.code.gen.utils.Page<BbTestFk>> queryFkPage(@org.springframework.web.bind.annotation.RequestBody BbTestFkCond fkCond) {
        return new org.alvin.code.gen.beans.RestfullResp<>(this.bbTestService.queryFkPage(fkCond));
    }

}

