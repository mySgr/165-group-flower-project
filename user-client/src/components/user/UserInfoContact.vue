<template>


        <el-container>
            <el-header>Header</el-header>
            <el-container>
                <el-aside width="200px">Aside</el-aside>
                <el-container>
                    <el-main>Main</el-main>
                    <el-footer>Footer</el-footer>
                </el-container>

            </el-container>

            <video id="shiping" muted="muted" autoplay="autoplay" controls="controls" :src="shipi">

            </video>
        </el-container>




</template>
<style>
    #shiping{
        width: 400px;
        height: 300px;
    }

</style>
<script>
    export default {
        data(){
            return{

                shipi:'https://video.hua.com/publicity_video_2020.mp4',
            }
        },
        methods:{

        }
    }

</script>

