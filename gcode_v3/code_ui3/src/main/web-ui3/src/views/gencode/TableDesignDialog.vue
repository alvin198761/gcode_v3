<template>
    <el-dialog title="数据表设计" :visible.sync="show" width="80%" :close-on-click-modal="false"
               :close-on-press-escape="false">

        <el-tabs v-model="tabActiveName" type="card" @tab-click="changeTab" tab-position="bottom">
            <el-tab-pane label="设计" name="edit">
                <el-form :model="entity" :rules="rules" label-width="60px">
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <el-form-item label="表名">
                                <el-input v-model="entity.name" size="small"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label="注释">
                                <el-input v-model="entity.remark" size="small"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>

                <hr/>
                <el-table :data="entity.fields">
                    <el-table-column prop="name" label="属性名">
                        <template slot-scope="props">
                            <el-input v-model="props.row.name" size="small"></el-input>
                        </template>
                    </el-table-column>
                    <el-table-column prop="type" label="类型" width="250">
                        <template slot-scope="props">
                            <el-select size="small" v-model="props.row.type" placeholder="请选择类型"
                                       @change="(val) => changeType(val,props.row)">
                                <el-option
                                        v-for="item in types"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item">
                                </el-option>
                            </el-select>
                        </template>
                    </el-table-column>
                    <el-table-column prop="length" label="长度" width="200">
                        <template slot-scope="props">
                            <el-input-number v-model="props.row.length" :disabled="props.row.type != 'java.lang.String'"
                                             :min="0" :max="999999" size="small"
                            ></el-input-number>
                        </template>
                    </el-table-column>
                    <el-table-column prop="remark" label="注释">
                        <template slot-scope="props">
                            <el-input size="small" v-model="props.row.remark"></el-input>
                        </template>
                    </el-table-column>
                    <el-table-column prop="isNull" label="为空" width="50">
                        <template slot-scope="props">
                            <el-checkbox v-model="props.row.isNullChecked"></el-checkbox>
                        </template>
                    </el-table-column>
                    <el-table-column label="主键" width="50">
                        <template slot-scope="props">
                            <el-checkbox v-model="props.row.isPrimaryKeyChecked"></el-checkbox>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作" width="150">
                        <template slot-scope="props">
                            <el-button type="text" size="small" @click="removeArray(entity.fields,props.row)">删除
                            </el-button>
                            <el-button type="text" size="small" @click="entity.fields.push({})">追加</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="源码" name="preview">
                <pre v-highlightjs="sqlText"><code class="sql">
                </code></pre>
            </el-tab-pane>
        </el-tabs>


        <div slot="footer">
            <el-button @click="show=false">取 消</el-button>
            <el-button type="primary" @click="executeSql" :disabled="tabActiveName != 'preview'">确 定</el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {remove} from '../../utils/ArraysUtils';
    import {MYSQL_TYPES} from '../../utils/MySqlConst';

    export default {
        props: ["refresh"],
        components: {},
        data: function () {
            return {
                show: false,
                tabActiveName: 'edit',
                form: {
                    //属性名称
                    name: null,
                    //属性类型
                    type: null,
                    //引用类型对应的实体
                    refName: null,
                    //列名称
                    colName: null,
                    //列备注
                    remark: null,
                    //数据长度
                    length: 50,
                    //数据库类型（包含长度）
                    sqlType: null,
                    //是否为空
                    isNull: 'NULL'
                },
                rules: {
                    name: [
                        {required: true, message: '请输入项目名称', trigger: 'blur'},
                    ],

                },
                entity: {
                    name: null,
                    remark: null,
                    fields: [{}]
                },
                types: MYSQL_TYPES,
                sqlText: '',
                executable: false
            }
        },
        computed: {},
        created: function () {

        },
        methods: {
            showDialog() {
                this.entity = {};
                this.entity.fields = [{}];
                this.sqlText = null;
                this.show = true;
            },
            removeArray(_arr, _obj) {
                remove(_arr, _obj);
                if (_arr.length === 0) {
                    _arr.push({});
                }
            },
            executeSql() {
                if (this.sqlText === null || this.sqlText.length === 0) {
                    return;
                }
                const that = this;
                this.$http.get("/api/code/executeSql", {params: {sql: this.sqlText}}).then(res => {
                    that.show = false;
                    that.refresh();
                    this.$message.success("创建成功！");
                }).catch(res => {
                    this.$notify.error({title: 'SQL执行失败', message: '请输入正确的建表语句!'});
                });
            },
            saveValidate() {
                const that = this;
                if (this.entity.name === null || (this.entity.name && this.entity.name.length === 0)) {
                    this.$message.error("实体类名称不能为空")
                    return false;
                }
                if (this.entity.remark === null || (this.entity.remark && this.entity.remark.length === 0)) {
                    this.$message.error("实体类注释不能为空")
                    return false;
                }
                if (this.entity.fields.length <= 1) {
                    this.$message.error("实体类不能只有一个字段")
                    return false;
                }
                for (let i = 0; i < this.entity.fields.length; i++) {
                    let fi = this.entity.fields[i];
                    if (fi.name === null || fi.name.length === 0) {
                        this.$message.error("属性名不能为空")
                        return false;
                    }
                    for (let j = 0; j < this.entity.fields.length; j++) {
                        if (j === i) {
                            continue;
                        }
                        let cfi = this.entity.fields[j];
                        if (cfi.name === fi.name) {
                            this.$message.error("属性名不能重名")
                            return false;
                        }
                    }
                    if (fi.type === null) {
                        this.$message.error("属性类型不能为空")
                        return false;
                    }
                    if (fi.type === "java.lang.String" && fi.length === null) {
                        this.$message.error("属性长度不能为空")
                        return false;
                    }
                    if (fi.type === "ref" && fi.ref_name === null) {
                        this.$message.error("引用类不能为空")
                        return false;
                    }
                    if (fi.remark === null || fi.remark.length === 0) {
                        this.$message.error("注释不能为空")
                        return false;
                    }
                }
                let idField = null;
                this.entity.fields = this.entity.fields.map(field => {
                    field.isNull = field.isNullChecked ? "NULL" : "NOT NULL";
                    if (field.isPrimaryKeyChecked === true) {
                        that.entity.idName = field.name;
                        idField = field;
                    }
                    if (field.type === "java.lang.String") {
                        field.sqlTtype = "VARCHAR(" + field.length + ")";
                    }
                    return field;
                });
                if (this.entity.idName === null) {
                    this.$message.error("主键必须不能为空")
                    return false;
                }
                if (idField.type !== "java.lang.Long" && idField.type !== 'java.lang.Integer') {
                    this.$message.error("主键只能选 java.lang.Long ,java.lang.Integer 类型")
                    return false;
                }
                return true;
            },
            changeType(type, row) {
                debugger
                if (type.value === 'java.lang.String') {
                    if (!row.length) {
                        row.length = 50;
                    }
                    row.sqlType = type.db_type + "(" + row.length + ")"
                } else {
                    row.sqlType = type.db_type
                }
                row.type = type.value;
            },
            changeTab(tab, event) {
                this.executable = true;
                if (tab.name !== "preview") {
                    return;
                }
                if (this.saveValidate() === false) {
                    return;
                }
                const that = this;
                that.$postBody("/api/code/designPreview", that.entity).then(res => {
                    if (res.code !== 0) {
                        that.$notify.error(res.errmsg);
                        return;
                    }
                    that.sqlText = res.data;
                    that.executable = that.sqlText === null && that.sqlText.length === 0;
                }).catch(err => {
                    that.$notify.error("预览sql失败");
                });
            },
            editDialog(table) {
                const that = this;
                that.tabActiveName = 'edit';
                this.$postBody("/api/code/queryField", {"t_name_eq": table.t_name}).then(res => {
                    that.show = true;
                    let idName = null;
                    let flist = res.data.map(item => {
                        if (item.isKey) {
                            item.isPrimaryKeyChecked = true;
                            idName = item.name;
                        }
                        item.isNullChecked = item.isNull === "NULL";
                        return item;
                    });
                    that.entity = {
                        name: table.t_name,
                        remark: table.comment,
                        fields: flist,
                        idName: idName
                    }
                }).catch(res => {
                    that.$notify.error({title: '失败', message: '加载表信息败!'});
                });
            }
        },
    }
</script>
<style>
    .hljs-keyword {
        font-weight: bold;
    }

    .hljs-literal {
        /*font-weight: bold;*/
        color: #e06c75;
    }

    .hljs {
        /*background: #909399 !important;*/
        /*color: white;*/
        border: 1px solid black;
        min-height: 300px;
    }
</style>
