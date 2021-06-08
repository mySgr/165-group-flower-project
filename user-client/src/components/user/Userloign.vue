<template>
    <div>
        <div id="user-login">
            <input type="text" name="" placeholder="请输入手机号码" v-model="phone"/><br>
            <input type="password" name="" placeholder="请输入密码" v-model="password"/><br>
            <input type="button" @click="userlogin" value="登录"/>
            <input type="button" value="注册" @click="$router.push('/logon')"  />
        </div>

    </div>
</template>
<script>
    export default {
        data() {
            return {
                phone: "",
                password: "",
            }
        },
        methods: {
            userlogin: function () {

                this.axios({
                    url: "/api/user/login",
                    method: "post",
                    data: {phone: this.phone, password: this.password}
                }).then(resp => {
                    if (resp.data.code == 200) {
                        window.sessionStorage.setItem("user", JSON.stringify(resp.data.data))
                        this.$router.push("/")
                        location.reload()
                    }else{
                        alert(resp.data.message)
                    }
                });
            },


        }
    }


</script>


<style>


</style>