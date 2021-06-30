<template>
    <div class="content">
        <div class="carouserl">
            <el-carousel height="305px" direction="vertical">
                <el-carousel-item v-for="item in dataImage" :key="item">
                    <img :src="item" width="100%">
                </el-carousel-item>
                <div class="left-nav">
                    <h5>鲜花导购</h5>
                    <div class="flowr-class">
                        <h5>鲜花用途</h5>
                        <div>
                            <span>爱情鲜花</span>
                            <span>生日鲜花</span>
                            <span>友情鲜花</span>
                            <span>商务鲜花</span>
                            <span>问候鲜花</span>
                            <span>探病鲜花</span>
                            <span>道歉鲜花</span>
                            <span>纪念鲜花</span>
                            <span>领导长辈</span>

                        </div>
                    </div>
                    <div class="flowr-class">
                        <h5>鲜花花材</h5>
                        <div>
                            <span>玫瑰</span>
                            <span>红玫瑰</span>
                            <span>白玫瑰</span>
                            <span>康乃馨</span>
                            <span>郁金香</span>
                            <span>马蹄莲</span>
                            <span>向日葵</span>
                        </div>
                    </div>
                </div>
            </el-carousel>


            <span style="font-size: 24px;"  class="title"><b>鲜花热销</b></span>
            <span style="font-size: 22px">  · 你值得拥有</span>
            <hr style="color: #666666;" >
            <div class="flowerInfo">
                <el-card  v-for="i in flowerHotList" :key="i.flowerId" class="flower">
                    <div @click="$router.push('/detailed/'+i.flowerId)" class="allClass">
                        <img :src="i.coverSrc" class="cover">
                        <div class="allClass">
                            <div class="title">
                                <span >{{i.title}}</span>
                            </div>
                            <div class="title">
                                <span>价格: {{i.price}}</span>
                            </div>
                        </div>

                    </div>

                </el-card>

            </div>
            <span style="font-size: 24px;"  class="title"><b>新品上市</b></span>
            <span style="font-size: 22px">  · 你值得查看</span>
            <hr style="color: #666666;margin-bottom:10px " >
            <div id="xinpin">
                <div class="newTp">
                    <img style="width: 230px;height: 560px" src="http://169.254.173.71:9090/upload/flower/111.png">
                </div>
                <div class="Tp-right">

                    <el-card id="newxinpin" v-for="i in flowerSelect" :key="i.flowerId" >

                        <img :src=i.coverSrc class="cover">
                        <div class="allClass">
                            <div class="title">
                                     {{i.title}}
                            </div>
                            <div  class="title">
                                价格: {{i.price}}
                            </div>

                        </div>

                    </el-card>


                </div>

            </div>

        </div>


    </div>


</template>

<script>
    export default {
        data() {
            return {
                dataImage: ["https://img02.hua.com/zhuanti/birthday/pc/banner_lover.png",
                    "https://img02.hua.com/zhuanti/ertongjie/2020/pc_banner.jpg",
                    "http://img.21xianhua.com/upload/2021/01/07/54ab24c633eddad34b5b790c1e09ba3b",
                    "https://img02.hua.com/zhuanti/graduation/2020/pc_banner.png"
                ],
                flowerSelect: [],
                flowerHotList:[],
            }
        },
        created: function() {
            this.flowerGetAll()
            this.flowerHotALl()
        },
        methods:{
            flowerGetAll(){
                this.axios({
                    url:"/api/user/selectFlower",
                    method:"post",
                }).then(r => {
                    this.flowerSelect = r.data;
                })
            },
            flowerHotALl(){
                this.axios({
                    url:"/api/flower/hot",
                    method:"post",
                }).then(hot=>{
                    this.flowerHotList = hot.data.data;
                })
            },


        }
    }
</script>

<style scoped>
    /*标题默认值*/
    h1, h2, h3, h4, h5 {
        padding: 0px;
        margin: 0px;
    }

    /**/
    .content {
        margin-top: 10px;
    }

    .carouserl {
        position: relative;
    }

    .left-nav {
        color: #fff;
        width: 210px;
        position: absolute;
        z-index: 999;
        height: 305px;
        background: url("../../assets/image/black-bg.png");
    }

    .left-nav > h5 {
        font-size: 16px;
        padding: 10px;
        border-bottom: 1px solid #e6e6e6;
    }

    /* 鲜花类型样式 艰难困苦，玉汝于成。*/
    .flowr-class h5 {
        margin-top: 10px;
        margin-left: 10px;
        margin-bottom: 3px;
    }

    .flowr-class span {
        font-size: 14px;
        margin-left: 10px;
    }

    .flowr-class span:hover {
        cursor: pointer;
        color: #FB7299;
    }


    /*    flower */
    .flowerInfo {
        display: flex;
        flex-wrap: wrap;
    }
    .flower {
        padding-left: 2px;
        margin: 5px;
        width: 200px;
        border: 1px solid #e6e6e6;
        height: 300px;
    }
    .allClass{
        margin-top: 5px;
    }
    .cover{
        margin-right: 10px;
        width: 170px;
        height: 170px;
    }
    .cover:hover{
        transform: scale(1.1)
    }
    .cover  {
        cursor: pointer;
        transition: all 0.5s;
    }
    .title > span:hover{
        color: pink;
    }
    .title:hover{
        color: pink;
    }

    /*新品上市*/
    #xinpin {
        /*border: 1px solid red;*/
        height: 640px;
    }

    .newTp{
        margin-top: 4px;
        width: 230px;
        height: 560px;
        /*border: solid 1px red;*/
        position: relative;
        float: left;
    }
    .Tp-right{

        width:1100px ;
        height: 600px;
        /*border: solid 1px yellow;*/
    }


    #newxinpin{
        float: left;
        /*border: 1px solid red;*/
        width: 200px;
        height: 275px;
        margin: 3px ;
    }

</style>