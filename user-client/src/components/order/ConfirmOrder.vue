<template>
    <div>
        <h1>确认订单</h1>
        <div class="user-address">
            <h5>选择收货地址</h5>
            <div class="address-list">
                <div class="address-item "
                     :class="address.addressId==item.addressId? 'active':''"
                     v-for="(item) in addressList"
                     :key="item.addressId"
                     @click="selectUserAddress(item)"
                >
                    <h5 class="name">{{item.receiver}}</h5>
                    <p class="phone">{{item.phone}}</p>
                    <footer class="address">{{item.address}}</footer>
                </div>
            </div>
            <el-button>添加地址</el-button>
        </div>

        <div class="user-order-info">
            <h5>确认订单信息</h5>
            <el-table
                    :data="goods"
                    style="width: 100%">
                <el-table-column prop="title" label="鲜花" width="300">
                    <template v-slot="flower">
                        <div class="flower-title-cover">
                            <div>
                                <img :src="flower.row.flower.coverSrc" width="60px">
                            </div>
                            <div>{{flower.row.flower.title}}</div>
                        </div>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="flower.price"
                        label="单价（￥）">
                </el-table-column>
                <el-table-column
                        label="数量"
                        prop="cartCount">
                </el-table-column>
                <el-table-column
                        label="小计（￥）"
                        prop="cartPrice">
                </el-table-column>
            </el-table>

            <div class="wei">
                <span class="one">实付款：</span>
                <span class="three">￥{{this.order.totalPrice}}</span>
                <span class="four">寄送至：</span>
                <span class="wu">{{address.address}}</span>
                <span class="liu">收货人：</span>
                <span class="qi">{{address.receiver}} {{address.phone}}</span>
            </div>
            <div class="wei2">
                <span class="fh" @click="$router.push('/flower-shopping')">返回购物车</span>
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
                addressList: [],
                address: {},// 选中的地址
                dialogVisible: false,
                user: JSON.parse(window.sessionStorage.getItem("user")) || undefined,
                goods: [],
                flowerId: this.$route.params.flowerId,
                order: {count: 0, paymentMethod: '1'}
            }
        },
        methods: {
            // 加载订单数据
            loadCartInfo(ids) {
                this.$axios({
                    url: '/api/order/create',
                    params: {ids}
                }).then(result => {
                    console.log(result)
                    if (result.data.code == 200) {
                        let showMessage = result.data.data
                        // 商品列表
                        this.goods = showMessage.list
                        this.order.totalPrice = showMessage.totalPrice.toFixed(2)
                    } else {
                        alert(result.data.message)
                    }

                })
            },
            // 加载用户收货地址
            loadAddress() {
                this.$axios({
                    url: '/api/selectAddress',
                    params: {userId: this.user.userId}
                }).then(result => {
                    if (result.data.code === 200) {
                        this.addressList = result.data.data
                        this.address = this.addressList[0]
                    }
                    console.log(result)
                })
            },
            // 添加订单
            addOrder() {
                if (!this.user) return this.$message("请先登陆")
                // 组装数据
                let goods = []
                this.goods.forEach(v => goods.push({
                    productCount: v.cartCount,
                    productPrice: v.cartPrice,
                    flowerId: v.flowerId
                }))
                let orderObj = {
                    userId: this.user.userId,
                    addressId: 1,
                    paymentMethod: this.order.paymentMethod,
                    orderMoney: this.order.totalPrice,
                    goods

                }
                this.$axios({
                    url: '/api/order/create',
                    method: 'post',
                    data: orderObj
                }).then(r => {
                    this.$message.success("购买成功，等待发货")
                    this.dialogVisible = false
                    this.$router.push("/flower-shopping")
                })
            },
            // 选择用户地址
            selectUserAddress(address) {
                this.address = address;
            },

            handleChange() {
            },
        },
        created() {
            const ids = this.$route.params.ids
            this.loadCartInfo(ids)
            this.loadAddress()
        }
    }

</script>

<style scoped>
    .address-list {
        display: flex;
    }

    .address-list .address-item {
        width: 300px;
        /*border: 1px solid #eeeeee;*/
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

    .flower-title-cover {
        margin: 5px;
    }

    .active {
        border: 1px solid #fa4b8b;
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
        right: 200px;
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
        right: 200px;
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
        right: 200px;
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
        cursor: pointer;

    }

    .fh {
        position: absolute;
        font-size: 15px;
        color: #0086b3;
        cursor: pointer;
        top: 10px;
        left: 30px;
    }

</style>