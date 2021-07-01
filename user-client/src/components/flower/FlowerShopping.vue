<template>

    <div class="zhuti">
        <div class="zi">
            <input id="quanxuan" @change="checkAllCartItemChange" v-model="checked" type="checkbox"/>
            全选
                <span class="yang">样品图</span>
                <span class="shangpingname">商品名称</span>
                <span class="price">价格</span>
                <span class="count">数量</span>
                <span class="xj">小计</span>
                <span class="caozuo">操作</span>
        </div>

        <div class="blkuai" v-for="(item,index) in cart.list" :key="index">
            <div class="bianlikuai">
                <input type="checkbox" @change="cartStatusChange(item)" :checked="item.cartStatus===1?true:false"
                       class="checkboxAll">
                <img :src="item.flower.coverSrc" class="tp">
                <span class="name">{{item.flower.title}}</span>
                <span class="jiage">{{item.flower.price}}</span>

                <el-input-number class="shu"
                                 :min="1" :max="10"
                                 label="描述文字"
                                 size="small"
                                 v-model="item.cartCount" @change="handleChange(item)">
                </el-input-number>
                <span class="xiaoji">{{item.cartPrice}}</span>
                <button class="an" @click="deleteShopping(item.cartListId)">删除
                </button>
            </div>
        </div>

        <el-button type="primary" round class="jiesuan" @click="jieSuan">结算</el-button>
        <span class="zongji">总计:{{cart.totalPrice==null?0:cart.totalPrice}}</span>

    </div>

</template>

<script>
    export default {
        data() {
            return {
                checked: false,
                total: 0,
                user: {},
                shopping: [],
                num: 1,
                cart: {}

            }
        },
        methods: {
            jieSuan(){
              alert("购买成功")
            },
            // 全选
            checkAllCartItemChange() {
                console.log(this.checked)
                let status = this.checked ? 1 : 0
                this.$axios({
                    url: '/api/cart/status/all',
                    params: {status:status, userId:this.user.userId}
                }).then(r => {
                    this.queryCart()
                    console.log(r)
                })
            },
            deleteShopping(cartId) {
                this.axios({
                    url: "/api/delete/shopping?cartId=" + cartId,
                    method: "get",
                }).then(r => {
                    alert("删除成功！" + cartId);
                    this.queryCart();
                })
            },

            // 查询购物车信息
            queryCart() {
                this.user = JSON.parse(window.sessionStorage.getItem("user"));
                this.axios({
                    url: "/api/cart/list",
                    method: "post",
                    params: {userId: this.user.userId}
                }).then(s => {
                    console.log(s)
                    this.cart = s.data.data;
                    console.log(this.cart)

                })
            },
            // 购物项里的数量发生改变时，执行访方法
            handleChange(item) {
                this.user = JSON.parse(window.sessionStorage.getItem("user"));
                this.axios({
                    url: "/api/cart/reckon",
                    params: {
                        userId: this.user.userId,
                        cartListId: item.cartListId,
                        price: item.flower.price,
                        count: item.cartCount
                    }
                }).then(r => {
                    if (r.data.code === 200) {
                        this.queryCart()
                    } else {
                        console.log(r.data.message)
                        alert(r.data.message)
                    }

                })
            },
            // 更新购物车状态
            cartStatusChange(item) {
                let status = item.cartStatus === 1 ? 0 : 1
                this.$axios({
                    url: '/api/cart/status/update',
                    params: {status: status, id: item.cartListId, userId: this.user.userId}
                }).then(r => {
                    if (r.data.code === 200) {
                        this.queryCart()
                    } else {
                        alert(r.data.message)
                    }
                })
            }
        },

        created() {
            this.user = JSON.parse(window.sessionStorage.getItem("user"));
            this.queryCart()
        }
    }

</script>

<style scoped>
    .zhuti {
        /*border: 1px solid red;*/
        /*border-left: 1px solid gray;*/
        height: 500px;
        width: 1100px;
    }

    .zi {
        border: 1px solid red;
        font-size: 18px;


    }
    #quanxuan{
        width: 30px;
        height: 30px;
        margin-left: 25px;
    }
    .yang{
        margin-left: 80px;
    }

    .shangpingname{
        margin-left: 50px;
    }
    .price{
        margin-left: 25px;
    }
    .count{
        margin-left: 40px;
    }
    .xj{
        margin-left: 22px;
    }
    .caozuo {
        margin-left: 60px;
    }

    .zi span {
        margin-right: 60px;
    }

    .blkuai {
        /*border: 1px solid red;*/
        width: 1100px;
    }

    .bianlikuai {
        position: relative;
        width: 1100px;
        height: 120px;
        margin-bottom: 10px;
        margin-top: 10px;
        /*margin-left: 20px;*/
        box-shadow: 1px 1px 6px #a7a79b;
        border-radius: 10px;
    }

    .checkboxAll {
        margin-top: 20px;
        position: absolute;
        left: 20px;
        top: 10px;
        width: 50px;
        height: 50px;
    }

    .tp {
        position: absolute;
        left: 160px;
        top: 10px;
        width: 100px;
        height: 100px;
        border-radius: 10px;
    }

    .name {
        position: absolute;
        left: 350px;
        top: 45px;
    }

    .jiage {
        position: absolute;
        left: 520px;
        top: 45px;
    }

    .shu {
        position: absolute;
        margin-left: 590px;
        margin-top: 41px;
    }

    .xiaoji {
        position: absolute;
        margin-left: 770px;
        margin-top: 45px;
    }

    .an {
        position: absolute;
        right: 140px;
        top: 45px;
        width: 65px;
        height: 35px;
        background: #0086b3;
        color: white;
        outline: none;
        border-radius: 10px;
        border: none;
    }

    .an:hover {
        background: #00CCFF;
        cursor: pointer;
        border-radius: 13px;
    }

    .zongji {
        position: absolute;
        margin-left: 620px;
        margin-top: 10px;
    }
    .jiesuan{
        position: absolute;
        margin-left: 700px;
    }
</style>
