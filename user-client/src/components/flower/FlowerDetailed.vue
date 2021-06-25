<template>


    <div class="flowerInfo">

        <div class="flowerLeft">
            <img :src=" detailed.coverSrc">
        </div>

        <div class="flowerRight">
            <h1> 标题:{{detailed.title}} </h1>
            <span class="blockStyle">售价:{{detailed.price}}</span>
            <span class="blockStyle"> 花语:{{detailed.flowerLanguage}}</span>
            <span class="blockStyle">  材料:{{detailed.material}}</span>
            <span class="blockStyle">  产品说明:{{detailed.details}}</span>
            <span class="blockStyle"> 已售数量:{{detailed.buyCount}}</span>

            <el-button type="danger" class="el-icon-shopping-cart-2" round @click="addFlowerCart">
                加入购物车
            </el-button>
        </div>

    </div>
</template>
<style scoped>
    .flowerInfo {
        margin: auto;
        width: 1100px;
        height: 300px;
        border: solid 1px red;
        display: flex;

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
<script>
    export default {

        data() {
            return {
                detailed: {},
                flowerId: null,
                user: {},
            }
        },
        methods: {
            flowerDefault() {
                this.axios({
                    url: "/api/detailed/flower",
                    method: "get",
                    params: {flowerId: this.flowerId}
                }).then(r => {
                    console.log(r)
                    this.detailed = r.data
                })
            },
            addFlowerCart() {
                this.user = JSON.parse(window.sessionStorage.getItem("user"))
                if (this.user == null || this.user == undefined) {
                    alert("你还没有登陆")
                    return
                }
                this.axios({
                    url: "/api/add/shopping/flower",
                    method: "post",
                    params: {
                        userId: this.user.userId,
                        flowerId: this.detailed.flowerId,
                        productAmount: 1,
                        price: this.detailed.price
                    }
                }).then(s => {
                    if (s.data.code == -1) {
                        alert(s.data.message)
                    }
                    console.log(s)
                    this.$router.push("/flower-shopping")

                })

            }

        },
        created() {
            this.flowerId = this.$route.params['id'];

            this.flowerDefault()
        }
    }
</script>
