<template>
    <div class="content">


        <div class="carouserl">
            <el-carousel height="480px" direction="vertical">
                <el-carousel-item v-for="item in dataImage" :key="item">
                    <img :src="item">
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

        </div>

    </div>


</template>

<script>
    export default {
        data() {
            return {
                dataImage: ["https://img02.hua.com/zhuanti/birthday/pc/banner_lover.png",
                    "https://img02.hua.com/zhuanti/ertongjie/2020/pc_banner.jpg",
                    "http://img.21xianhua.com/upload/2021/01/07/54ab24c633eddad34b5b790c1e09ba3b"
                ]
            }
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
        height: 480px;
        background: url("../../assets/image/black-bg.png");
    }

    .left-nav > h5 {
        font-size: 16px;
        padding: 10px;
        border-bottom: 1px solid #e6e6e6;
    }

    /* 鲜花类型样式 艰难困苦，玉汝于成。*/
    .flowr-class h5{
        margin-top: 10px;
        margin-left: 10px;
        margin-bottom: 3px;
    }
    .flowr-class span{
        font-size: 14px;
        margin-left: 10px;
    }
    .flowr-class span:hover{
        color: #FB7299;
    }


</style>