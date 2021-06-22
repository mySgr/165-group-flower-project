<template>


    <div class="flowerInfo"  >
        <el-card>
            <div>
                <img :src=" detailed.coverSrc" >
            </div>
            <div>
               标题:{{detailed.title}}
               价格：{{detailed.price}}
                材料:{{detailed.material}}
                花语:{{detailed.flower_language}}
                产品说明:{{detailed.details}}
                已售数量:{{detailed.buy_Count}}
            </div>

        </el-card>

    </div>
</template>
<style>

</style>
<script>
    export  default{


        data(){
            return{
                detailed:{},
                flowerId:null,

            }
        },
        methods:{
            flowerDefault(){
                this.axios({
                  url:"/api/detailed/flower",
                    method:"get",
                    params:{flowerId:this.flowerId }
                }).then(r=>{
                    console.log(r)
                  this.detailed=r.data
                })
            },

        },
        created() {
            this.flowerId = this.$route.params['id'];
            console.log(this.id)
            this.flowerDefault()
        }
    }
</script>
