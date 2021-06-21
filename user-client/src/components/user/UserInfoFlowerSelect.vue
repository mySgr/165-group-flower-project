<template>
    <div class="flowerInfo">

        <el-card v-for="i in flowers" :key="i.flowerId" class="flower">
            <img :src=" 'http://169.254.173.71:9090/upload/'+i.cover" class="cover">
            <div>
                标题: {{i.title}}
            </div>
            <div>price:99$</div>
            <div class="block">
                <span class="demonstration">默认不区分颜色</span>
                <el-rate v-model="value1"></el-rate>
            </div>
        </el-card>

    </div>

</template>


<script>
    export default {
        data(){
            return{
                flowers:[],
                selectname:""
            }

        },
        methods:{
            flowerlikename(){
                this.axios({
                    url:"/api/FlowerSelects?prams=" + this.selectname,
                    method:"post",
                }).then(r=>{
                    this.flowers=r.data;
                })
            },

        },
        created() {
           this.selectname=this.$route.params['name'];
           this.flowerlikename();

        }

    }

</script>


