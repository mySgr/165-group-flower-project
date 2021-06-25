<template>
    <div class="flower-info-list">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>商品管理</el-breadcrumb-item>
            <el-breadcrumb-item>商品列表</el-breadcrumb-item>
        </el-breadcrumb>


        <el-card>
            <div class="top-operation">

                <el-button type="primary" size="mini" @click="$router.push('/addflower')">添加商品</el-button>

                <el-dropdown>
                    <el-button type="primary" size="mini" :disabled="multipleSelection.length==0?true:false">
                        批量操作<i class="el-icon-arrow-down el-icon--right"></i>
                    </el-button>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>删除选中</el-dropdown-item>
                        <el-dropdown-item>上架选中</el-dropdown-item>
                        <el-dropdown-item>下架选中</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <button @click="loadFlowerList" style="margin-right: 5px">刷新</button>
                <span>已选择：{{multipleSelection.length}}/{{flowerInfoList.size}}</span>
            </div>
            <!--鲜花列表 -->
            <el-table
                    border
                    ref="multipleTable"
                    :data="flowerInfoList.list"
                    tooltip-effect="dark"
                    style="width: 100%"
                    @selection-change="handleSelectionChange">
                <el-table-column
                        type="selection"
                        width="50">
                </el-table-column>
                <el-table-column
                        label="正图"
                        width="100">
                    <template slot-scope="scope">
                        <img height="70px" :src="scope.row.coverSrc">
                    </template>
                </el-table-column>
                <el-table-column
                        prop="title"
                        label="标题">
                </el-table-column>
                <el-table-column
                        prop="flowerPurposeEntity.purposeName"
                        label="鲜花用途">
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="价格(￥)">
                    <template slot-scope="flower">
                        {{showPrice(flower.row.price)}}
                    </template>
                </el-table-column>
                <el-table-column
                        label="上架">
                    <template slot-scope="flower">
                        <el-switch
                                :value="flower.row.status==1?true:false"
                                @change="flowerStatusChange(flower.row)"
                                active-color="#13ce66"
                                inactive-color="#ff4949">
                        </el-switch>

                    </template>
                </el-table-column>
                <el-table-column
                        prop="stock"
                        label="库存">
                </el-table-column>

                <el-table-column label="操作">
                    <template slot-scope="flower">
                        <el-button type="primary" icon="el-icon-edit" size="mini"
                                   @click="$router.push('/flower/edit/'+flower.row.flowerId)"></el-button>
                        <el-button type="danger" icon="el-icon-delete" size="mini"
                                   @click="flowerDelete(flower.row.flowerId)"></el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="flowerQuery.pageNum"
                    :page-sizes="[5, 10, 20, 30]"
                    :page-size="flowerQuery.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="flowerInfoList.total">
            </el-pagination>
        </el-card>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                value: true,
                flowerInfoList: [],
                flowerQuery: {pageNum: 1, pageSize: 10},
                multipleSelection: [],

            }
        },

        methods: {
            // 加载鲜花列表
            loadFlowerList() {
                this.$axios({
                    url: '/api/flower/paging',
                    params: this.flowerQuery,
                }).then(result => {
                    this.flowerInfoList = result.data.data

                })
            },
            // 显示价格
            showPrice(money) {
                if (!money) {//在这里进行一次传递数据判断.如果传递进来的为空值,返回其空字符串.解决其问题
                    return '';
                }
                return money.toFixed(2);
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;

            },
            // 当前页码值发生改变时触发
            handleCurrentChange(num) {
                this.flowerQuery.pageNum = num
                this.loadFlowerList()
            },
            // 当前页最大数量发生改变时触发
            handleSizeChange(size) {
                this.flowerQuery.pageSize = size
                this.loadFlowerList()
            },
            // 上下架商品
            flowerStatusChange(r) {

                let status = r.status == 1 ? 2 : 1

                this.$axios({
                    url: '/api/flower/update/status',
                    params: {status, id: r.flowerId}
                }).then(result => {
                    if (result.data.code === 200) {
                        if (status == 1)
                            this.$message.info("上架成功")
                        else
                            this.$message.info("下架成功")

                        this.loadFlowerList()
                    } else {
                        this.$message(result.data.message)
                    }
                })
            },
        },
        created() {
            this.loadFlowerList()
        }
    }
</script>
<style scoped>
    .el-card {
        margin-top: 10px;
    }

    /*    表格操作*/
    .top-operation > span {
        font-size: 14px;
    }

    .top-operation {
        margin-bottom: 5px;
    }

    .top-operation .el-button {
        margin-right: 5px;
    }
</style>