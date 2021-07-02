<template>
    <div class="flowerInfo">

        <el-card v-for="i in flowers" :key="i.flowerId" class="flower">
            <img :src=" 'http://169.254.173.71:9090/upload/'+i.cover" class="cover" style="width: 200px;height: 200px">
            <div>
                介绍: {{i.title}}
            </div>
            <div>
                ￥{{i.price}}
            </div>

        </el-card>

    </div>

</template>


<script>
    export default {
        data() {
            return {
                value1: null,
                flowers: [],
                selectname: ""
            }

        },
        methods: {
            flowerlikename() {
                this.selectname = this.$route.params['name'];
                this.axios({
                    url: "/api/FlowerSelects?prams=" + this.selectname,
                    method: "post",
                }).then(r => {
                    this.flowers = r.data;
                })
            },

        },
        created() {
            this.selectname = this.$route.params['name'];

             // this.flowerlikename();

        },
        // 这个方法不用调用this,因为此时机组件还没生成,所以无this
        // 要调用刷新数据方法时,需要写在next回调里,
        // to: Route: 即将要进入的目标路由对象
        // from: Route: 当前导航正要离开的路由
        // next是在组件生成后会调用
        beforeRouteEnter(to, from, next) {
            next(vm => vm.flowerlikename())
        },
        // 这个方法是路由不变,只变参数时执行
        beforeRouteUpdate(to, from, next) {
            next();
            this.flowerlikename();
        }

    }

</script>


