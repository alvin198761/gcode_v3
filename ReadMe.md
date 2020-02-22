# 代码生成器第三版本

##编译和运行
1.安装 jdk8 +
2.安装nodejs 8+
3.到 gcode_v3/code_ui3/src/main/web-ui3  目录下,执行命令
```sql
    npm install --registry=https://registry.npm.taobao.org
    
    npm run build
```
4.到 gcode_v3 目录下,执行命令
```sql
    mvn install
```
5.运行 code_ui3 项目
6.浏览器输入地址: [http://localhost:8090](http://localhost:8090)

## 新版介绍
* 1.实现跨表生成
* 2.集成sqleditor
* 3.集成element-admin
* 4.优化界面和操作
* 5.去掉不必要的配置
* 6.增加更多变量,优化不必要的变量


## 后续需求
* 1.完成数据库设计文档
* 2.解决多级查询的封装
* 3.常量字段并没有完整的生成方案
* 4.生成项目的方案 即原来的模板管理和项目生成方案的重新考虑和实现
* 5.完成多种项目的模板 (iview ,spring cloud ,mybaties plus 等 )
* 6.swagger 反向生成 (完成或者搬过来)

## 注意事项
* 1.完全不兼容 v3.0.4 以前版本
* 2.swagger api 反向生成暂时未迁移过来
* 3.模板管理未迁移
* 4.项目生成为迁移
* 5.数据导出,表结构导出未迁移过来