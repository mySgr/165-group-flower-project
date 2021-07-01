<template>
    <div class="login">
        <div class="login-screen">
            <div class="login-form">
                <div class="control-group">
                    <input v-model="userName" type="text" class="login-field" value="" placeholder="名字" id="login-name">
                </div>
                <div class="control-group">
                    <input  v-model="phone" type="password" class="login-field" value="" placeholder="手机号" >
                </div>
                <div class="control-group">
                    <input  v-model="password" type="password" class="login-field" value="" placeholder="密码">
                </div>
                <input type="button" class="zhuce" value="注册"  @click="usergoin"/>
            </div>
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
                this.$axios({
                    url: "/api/user/logon",
                    method: "post",
                    data: {password: this.password, phone: this.phone, userName: this.userName},// {id:1,name:'a'}
                    //params: {id=1&name=a}
                }).then(resp => {
                    if (resp.data.code == 200) {
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