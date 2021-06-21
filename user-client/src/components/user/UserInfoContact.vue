<template>

    <div>
        <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in dataImage" :key="item">
                <img :src="item" width="100%">
            </el-carousel-item>
        </el-carousel>

        <video id="shiping" muted="muted" autoplay="autoplay" controls="controls" :src="shipi">

        </video>
    </div>

</template>
<style>
    #shiping{
        width: 300px;
        height: 200px;
        align-content: center;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 300px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>
<script>
    export default {
        data(){
            return{
                dataImage: ["https://img02.hua.com/zhuanti/birthday/pc/banner_lover.png",
                    "https://img02.hua.com/zhuanti/ertongjie/2020/pc_banner.jpg",
                    "http://img.21xianhua.com/upload/2021/01/07/54ab24c633eddad34b5b790c1e09ba3b",
                    "https://img02.hua.com/zhuanti/graduation/2020/pc_banner.png"
                ],
                shipi:'https://video.hua.com/publicity_video_2020.mp4',
            }
        },
        methods:{

        }
    }

</script>

