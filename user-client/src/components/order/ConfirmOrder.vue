<template>
    <div>
        <h1>确认订单</h1>
        <div class="user-address">
            <h5>选择收货地址</h5>
            <div class="address-list">
                <div>
                    <h5 class="name">江江</h5>
                    <p class="phone">1999</p>
                    <footer class="address">广东珠海市斗门区白蕉镇南方it学院29号</footer>
                </div>
                <div>
                    <h5 class="name">江江</h5>
                    <p class="phone">1999</p>
                    <footer class="address">广东珠海市斗门区白蕉镇南方it学院29号</footer>
                </div>
                <div>
                    <h5 class="name">江江</h5>
                    <p class="phone">1999</p>
                    <footer class="address">广东珠海市斗门区白蕉镇南方it学院29号</footer>
                </div>
            </div>
            <el-button>添加地址</el-button>
        </div>

        <div class="user-order-info">
            <h5>确认订单信息</h5>
            <el-table
                    :data="tableData"
                    style="width: 100%">
                <el-table-column prop="title" label="鲜花" width="300">
                    <template v-slot="flower">
                        <div class="flower-title-cover">
                            <div>
                                <img :src="flower.row.coverSrc" width="60px">
                            </div>
                            <div>{{flower.row.title}}</div>
                        </div>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="price"
                        label="单价（￥）">
                </el-table-column>
                <el-table-column
                        label="数量">
                    <template>
                        <div>{{order.count}}</div>
                    </template>
                </el-table-column>
                <el-table-column
                        label="小计">
                    <template>
                        {{this.order.totalPrice}}
                    </template>
                </el-table-column>
            </el-table>

            <div class="wei">
                <span class="one">实付款：</span>
                <span class="two">￥</span>
                <span class="three">{{this.order.totalPrice}}</span>
                <span class="four">寄送至：</span>
                <span class="wu">广东 珠海 斗门 白蕉 白蕉南路29号南方IT学院</span>
                <span class="liu">收货人：</span>
                <span class="qi">卢勇傧 13878556346</span>
            </div>
            <div class="wei2">
                <span class="fh">返回购物车</span>
                <button class="an" @click="dialogVisible=true">提交订单</button>
            </div>

        </div>
        <!--        支付方式的对话框-->
        <el-dialog title="请选择你的支付方式"
                   :visible.sync="dialogVisible" width="30%">
            <div>
                <el-radio v-model="order.paymentMethod" label="1">支付宝</el-radio>
                <el-radio v-model="order.paymentMethod" label="2">微信</el-radio>
            </div>
            <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="addOrder">确 定</el-button>
             </span>
        </el-dialog>
    </div>

</template>

<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                user: JSON.parse(window.sessionStorage.getItem("user")),
                tableData: [],
                flowerId: this.$route.params.flowerId,
                order: {count: 0, paymentMethod: '1'}
            }
        },
        methods: {
            loadFlowerInfo() {
                this.$axios({
                    url: '/api/flower/info',
                    params: {flowerId: this.flowerId}
                }).then(result => {
                    if (result.data.code == 200) {
                        this.flower = result.data.data
                        this.tableData.push(this.flower)
                        this.order.count = 1
                        this.order.totalPrice = (1 * this.flower.price).toFixed(2)
                        this.order.subTotal = (1 * this.flower.price).toFixed(2)
                    } else {
                        alert(result.data.message)
                    }
                    console.log(result)
                })
            },
            addOrder() {
                // 组装数据
                let orderObj = {
                    userId: this.user.userId,
                    addressId: 1,
                    paymentMethod: this.order.paymentMethod,
                    orderSubtotal: this.order.subTotal,
                    orderMoney: this.order.totalPrice,
                    orderDetail: {flowerId: this.flowerId, subTotal: this.order.subTotal, count: this.order.count},
                }
                console.log(JSON.stringify(orderObj))
                this.$axios({
                    url: '/api/order/create',
                    method: 'post',
                    data: orderObj
                }).then(r => {
                    this.dialogVisible = false
                    console.log(r)
                })
            },
            handleChange() {

            },
        },
        created() {
            this.loadFlowerInfo()
        }
    }

</script>

<style scoped>
    .address-list {
        display: flex;
    }

    .address-list div {
        width: 300px;
        border: 1px solid #eeeeee;
        margin-right: 10px;
        margin-top: 10px;
        padding: 10px;
    }

    /*    订单信息样式 */
    .user-order-info h5 {
        margin-top: 15px;
        margin-bottom: 5px;
    }

    .flower-title-cover {
        display: flex;
    }

    .flower-title-cover div {
        margin: 5px;
    }

    /* ========== 老栋的代码，别动！ （提交订单的样式）=============*/
    .wei {
        margin-left: 800px;
        border: 1px solid red;
        width: 333px;
        height: 125px;
        position: relative; /* 绝对定位 */
    }

    .one {
        position: absolute;
        top: 30px;
        right: 105px;
        font-size: 10px;
    }

    .two {
        position: absolute;
        top: 20px;
        right: 85px;
        font-size: 25px;
        color: gray;
    }

    .three {
        position: absolute;
        top: 20px;
        right: 5px;
        font-size: 25px;
        color: red;
    }

    .four {
        position: absolute;
        top: 60px;
        right: 250px;
        font-size: 13px;
        font-weight: 500;
    }

    .wu {
        position: absolute;
        top: 60px;
        right: 5px;
        font-size: 10px;
    }

    .liu {
        position: absolute;
        top: 90px;
        right: 125px;
        font-size: 13px;
        font-weight: 500;
    }

    .qi {
        position: absolute;
        top: 90px;
        right: 5px;
        font-size: 10px;
    }

    .wei2 {
        margin-left: 802px;
        /*border: 1px solid red;*/
        width: 333px;
        height: 40px;
        position: relative; /* 绝对定位 */
    }

    .an {
        width: 180px;
        height: 40px;
        position: absolute;
        right: 0px;
        font-size: 15px;
        color: white;
        background-color: red;
        border: none;

    }

    .fh {
        position: absolute;
        font-size: 15px;
        color: #0086b3;
        top: 10px;
        left: 30px;
    }

</style>