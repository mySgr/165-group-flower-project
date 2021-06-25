<template>

    <div class="zhuti">
        <span class="zi">
            <span ><input type="checkbox"/> 全选</span>
                <span>样品图</span>
                <span>商品名称</span>
                <span>价格</span>
                <span>数量</span>
                <span>小计</span>
                <span>操作</span>
        </span>

        <div class="blkuai" v-for="(item,index) in shopping" :key="index">

            <div class="bianlikuai">
                <input type="checkbox"  class="checkboxAll">
                <img :src="item.flowerinfoEntity.coverSrc" class="tp">
                <span class="name">{{item.flowerinfoEntity.title}}</span>
                <span class="jiage">{{item.price}}</span>

                <el-input-number class="shu"
                                 :min="1" :max="10"
                                 label="描述文字"
                                 size="small"
                                 v-model="item.productAmount" @change="handleChange(item.cartId)">
                </el-input-number>
                <span class="xiaoji">{{item.subtotal}}</span>
                <button class="an" @click="deleteShopping(item.cartId)">删除
                </button>

            </div>

        </div>
        <span class="zongji">总计:{{total}}</span>

    </div>

</template>

<script>
    export default {
        data() {
            return {
                total: 0,
                user: {},
                shopping: [],
                num: 1,

            }
        },
        methods: {
            deleteShopping(cartId) {
                this.axios({
                    url: "/api/delete/shopping?cartId=" + cartId,
                    method: "get",
                }).then(r => {
                    alert("删除成功！" + cartId);
                    this.selectFlowerShooping();
                })
            },
// 小计
            show(price, count) {
                if (!price) {
                    return ''
                }
                return
            },
            // 总计
            showTotal() {

                this.shopping.forEach(r => {
                    r.subtotal = r.price * r.productAmount
                    this.total += r.subtotal

                })
            },
            selectFlowerShooping() {
                this.user = JSON.parse(window.sessionStorage.getItem("user"));
                this.axios({
                    url: "/api/shopping/flower",
                    method: "post",
                    params: {userId: this.user.userId}
                }).then(s => {
                    this.shopping = s.data.data;
                    this.shopping.forEach(r => {
                        r.subtotal = r.price * r.productAmount
                        this.total += r.subtotal
                    })
                })
            },
            handleChange(value) {
                console.log(value)
                this.shopping.forEach(r => {
                    r.subtotal = r.price * r.productAmount
                    if (r.cartId === value)
                        this.total += r.price * r.productAmount
                })

            },
        },

        created() {
            this.selectFlowerShooping();
        }
    }

</script>

<style scoped>
    .zhuti {
        /*border: 1px solid red;*/
        /*border-left: 1px solid gray;*/
        height: 500px;
        width: 1100px;
        padding-left: 20px;
    }

    .zi {
        /*border: 1px solid red;*/
        width: 400px;
        font-size: 18px;
        padding-left: 30px;
    }

    .zi span {
        margin-right: 100px;
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

    .checkboxAll{
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
</style>
