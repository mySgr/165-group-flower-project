<template>
    <div class="login">
        <div class="login-screen">
            <div class="login-form">
                <div class="control-group">
                    <input v-model="phone" type="text" class="login-field" value="" placeholder="phone" id="login-name">
                </div>
                <div class="control-group">
                    <input v-model="password" type="password" class="login-field" value="" placeholder="password"
                           id="login-pass">

                </div>
                <input type="button" class="btn btn-primary btn-large btn-block" @click="userlogin" value="登录"/>
                <input type="button" class="zhuce" value="注册" @click="$router.push('/logon')"/>
            </div>
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
                if (this.phone.length <= 0 || this.password.length <= 0) {
                    return this.$message("账号或密码不能空")
                }
                this.axios({
                    url: "/api/user/login",
                    method: "post",
                    data: {phone: this.phone, password: this.password}
                }).then(resp => {
                    if (resp.data.code == 200) {
                        window.sessionStorage.setItem("user", JSON.stringify(resp.data.data))
                        this.$router.push("/")
                        location.reload()
                    } else {
                        alert(resp.data.message)
                    }
                });
            },


        }
    }


</script>


<style>

    .login {
        margin: 20px auto;
        width: 300px;
    }

    .login-screen {
        background-color: #FFF;
        padding: 20px;
        border-radius: 5px
    }

    .login-form {
        text-align: center;
    }

    .control-group {
        margin-bottom: 10px;
    }

    input {
        text-align: center;
        background-color: #ECF0F1;
        border: 2px solid transparent;
        border-radius: 3px;
        font-size: 16px;
        font-weight: 200;
        padding: 10px 0;
        width: 250px;
        transition: border .5s;
    }

    input:focus {
        border: 2px solid #3498DB;
        box-shadow: none;
    }

    .btn {
        border: 2px solid transparent;
        background: pink;
        color: #ffffff;
        font-size: 16px;
        line-height: 25px;
        padding: 10px 0;
        text-decoration: none;
        text-shadow: none;
        border-radius: 3px;
        box-shadow: none;
        transition: 0.25s;
        display: block;
        width: 250px;
        margin: 0 auto;
    }

    .btn:hover {
        background-color: lightpink;
    }

    .zhuce {
        border: 2px solid transparent;
        background: pink;
        color: #ffffff;
        font-size: 16px;
        line-height: 25px;
        padding: 10px 0;
        text-decoration: none;
        text-shadow: none;
        border-radius: 3px;
        box-shadow: none;
        transition: 0.25s;
        display: block;
        width: 250px;
        margin: 0 auto;
        margin-top: 10px;
    }

    .zhuce:hover {
        background-color: lightpink;
    }


</style>