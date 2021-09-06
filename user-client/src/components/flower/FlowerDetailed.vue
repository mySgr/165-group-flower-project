<template>


    <div class="flowerInfo">

        <div class="flowerLeft">
            <img :src=" detailed.coverSrc" width="200px" height="220px">
        </div>

        <div class="flowerRight">
            <h1> 标题:{{detailed.title}} </h1>
            <span class="blockStyle">售价:{{detailed.price}}</span>
            <span class="blockStyle"> 花语:{{detailed.flowerLanguage}}</span>
            <span class="blockStyle">  材料:{{detailed.material}}</span>
            <span class="blockStyle">  产品说明:{{detailed.details}}</span>
            <span class="blockStyle"> 已售数量:{{detailed.buyCount}}</span>


            <el-button type="danger" :loading="cartLoading" class="el-icon-shopping-cart-2" round
                       @click="queryIsCart">
                加入购物车
            </el-button>


        </div>

    </div>
</template>

<script>
    export default {
        data() {
            return {
                detailed: {},
                flowerId: null,
                user: {},
                cartItem: null,
                isCart: false,
                cartLoading: false
            }
        },
        methods: {
            flowerDefault() {
                this.axios({
                    url: "/api/detailed/flower",
                    method: "get",
                    params: {flowerId: this.flowerId}
                }).then(r => {
                    this.detailed = r.data
                })
            },
            addFlowerCart() {
                this.cartLoading = true
                if (this.isCart) {
                    this.$axios({
                        url: "/api/cart/item/add",
                        method: "post",
                        params: {
                            userId: this.user.userId,
                            flowerId: this.detailed.flowerId,
                            productAmount: 1,
                            price: this.detailed.price
                        }
                    }).then(s => {
                        this.cartLoading = false
                        if (confirm("成功加入购物车,是否去结算"))
                            this.$router.push("/flower-shopping")
                    })
                } else {
                    this.$axios({
                        url: "/api/cart/reckon",
                        params: {
                            userId: this.user.userId,
                            cartListId: this.cartItem.cartListId,
                            price: this.cartItem.flower.price,
                            count: this.cartItem.cartCount + 1
                        }
                    }).then(resp => {
                        this.cartLoading = false;
                        if (confirm("成功加入购物车,是否去结算"))
                            this.$router.push("/flower-shopping")
                    })
                }

            },
            // 查询是否已在加入购物车
            queryIsCart() {
                if (this.user == null || this.user == undefined) {
                    alert("你还没有登陆")
                    return
                }
                this.$axios({
                    url: '/api/cart/item/exist',
                    params: {flowerId: this.flowerId, userId: this.user.userId}
                }).then(result => {
                    this.cartItem = result.data.data
                    if (this.cartItem === null) {
                        this.isCart = true;
                    } else {
                        this.isCart = false;
                    }
                }).then(() => {
                    this.addFlowerCart()
                })


            }

        },
        created() {
            this.user = JSON.parse(window.sessionStorage.getItem("user"))
            this.flowerId = this.$route.params['id'];
            this.flowerDefault()

        }
    }
</script>


<style scoped>

    .flowerInfo {
        margin: auto;
        width: 1100px;
        height: 220px;
        display: flex;
        background: papayawhip;
        box-shadow: 1px 1px 6px peachpuff;

    }

    .flowerLeft {

    }

    .flowerRight {

    }

    .blockStyle {
        margin: 5px;
        display: block;
    }
</style>
