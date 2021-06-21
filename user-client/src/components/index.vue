<template>
    <div>
        <!--   顶部导航栏   -->
        <el-menu
                router
                :default-active="$route.path"
                mode="horizontal"
                active-text-color="#FB7299"

        >
            <!--  导航栏菜单项  -->
            <el-menu-item><img width="90" src="../assets/image/logo.png"></el-menu-item>
            <el-menu-item index="/index">首页</el-menu-item>
            <el-menu-item index="/class">分类</el-menu-item>
            <el-menu-item index="/class">花语大全</el-menu-item>

            <el-menu-item index="/customer-service">联系我们</el-menu-item>


            <el-submenu index="2" style="float: right" v-if="user!=null||user!=undefined">
                <template slot="title">

                    <el-avatar size="medium" :src="user.avatarSrc"></el-avatar>
                    <span>{{user.userName}}</span>
                </template>
                <el-menu-item index="/user/setting">
                    <i class="el-icon-user"></i>
                    <span>个人中心</span>
                </el-menu-item>
                <el-menu-item index="2-2">
                    <i class="el-icon-s-order"></i>
                    <span>订单管理</span>

                </el-menu-item>
                <el-menu-item index="/" @click="userLogout">
                    <i class="el-icon-switch-button"></i>
                    <span>退出用户</span>
                </el-menu-item>
            </el-submenu>
            <el-menu-item v-else index="/login" style="float: right">login</el-menu-item>
            <el-menu-item index="/reply" style="float: right">消息中心</el-menu-item>
            <el-menu-item index="/cart" style="float: right">购物车</el-menu-item>
            <el-menu-item index="#" style="float: right">店铺会员</el-menu-item>
            <el-menu-item style="float: right">
                <el-input placeholder="商品搜索" v-model="flower">
                    <el-button slot="append" icon="el-icon-search" @click="$router.push('/flowersSelect/' +flower)" ></el-button>
                </el-input>
            </el-menu-item>
        </el-menu>

        <!--  路由 -->
        <div id="body" >
            <router-view></router-view>
        </div>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                flower:"",
                user: {}

            };
        },
        methods: {
            userLogout() {
                window.sessionStorage.clear();
                location.reload()
            },
            userLoad() {
                this.$axios({
                    method: 'get',
                    url: '/api/getuser',
                    params: {
                        userId: this.user.userId
                    }
                }).then(result => {
                    if (result.data.code == 200) {
                        this.user = result.data.data
                        console.log(this.user)
                    }
                })
            },

        },

        created() {
            this.user = JSON.parse(window.sessionStorage.getItem("user"))
            if (this.user != undefined || this.user != null) {
                 this.user.avatarSrc=' http://172.16.1.152:9090/upload/4.png'
                this.userLoad()
            }

        },
    };
</script>

<style scoped>
    #body {
        margin: 0% auto;
        width: 80%;
    }

</style>