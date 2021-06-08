<template>
    <div>
        <div id="user-login">

            <el-input placeholder="输入名字" v-model="userName"></el-input>
            <el-input placeholder="输入手机号" v-model="phone"></el-input>
            <br>
            <el-input placeholder="输入你的密码" v-model="password" show-password></el-input>


            <input type="button" value="注册" @click="usergoin"/>
        </div>

    </div>
</template>
<script>
    export default {
        data() {
            return {
                password: "",
                phone: "",
                userName: ""
            }
        },
        methods: {
            usergoin: function () {
                this.axios({
                    url: "/api/user/logon",
                    method: "post",
                    data: {password: this.password, phone: this.phone, userName: this.userName}
                }).then(resp => {
                    if (resp.data.code !== 200) {
                        alert(resp.data.message)
                    }else
                    console.log(resp)
                    this.$router.push('/login')
                })


            }
        }
    }


</script>


<style>


</style>