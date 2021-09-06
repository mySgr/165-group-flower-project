<template>
    <div class="userinfo">
        <el-container>
            <el-header><h5>个人中心</h5></el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu :default-active="$route.path" router>

                        <el-menu-item index="/user/setting">
                            <i class="el-icon-user"></i>
                            <span>我的信息</span>
                        </el-menu-item>
<!--                        <el-menu-item index="2">-->
<!--                            <span>会员信息</span>-->
<!--                        </el-menu-item>-->
                        <el-menu-item index="/user/avatar">
                            <span>我的头像</span>
                        </el-menu-item>
                        <el-menu-item index="/user/address-admin">
                            <span>地址管理</span>
                        </el-menu-item>
                        <el-menu-item index="/user/order-admin">
                            <span>订单管理</span>
                        </el-menu-item>

                    </el-menu>
                </el-aside>

                <el-main>
                    <router-view></router-view>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                user: 'cctv',
            }

        },
        methods: {}
    }
</script>

<style scoped>
    .userinfo {
        margin-top: 10px;
    }

    .el-container {
        min-height: 500px;
    }

    .el-header, .el-aside {
        border: 1px solid #e6e6e6;
    }

    .el-header h5 {
        width: 200px;
        color: #999;
    }

    .el-row {
        margin-bottom: 20px;
    }
</style>