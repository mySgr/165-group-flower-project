<template>
    <el-form ref="form" :model="user" label-width="120px">
        <el-form-item label="昵称">
            <el-input v-model="user.userName"></el-input>
        </el-form-item>
        <el-form-item label="我的签名">
            <el-input type="textarea" v-model="user.autograph"></el-input>

        </el-form-item>
        <el-form-item label="xx">
            <el-date-picker
                    v-model="user.birthdate"
                    type="date"
                    placeholder="修改生日"
                    value-format="yyyy-MM-dd">
            </el-date-picker>
        </el-form-item>
        <el-form-item label="注册时间">
            <el-date-picker
                    readonly
                    v-model="user.created"
                    type="date">
            </el-date-picker>

        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="add">保存</el-button>
        </el-form-item>

    </el-form>
</template>
<script>
    export default {
        data() {
            return {
                user: {},

            }
        },
        methods: {
            loadUser: function () {
                this.user = JSON.parse(window.sessionStorage.getItem("user"))
                this.axios({
                    url: "/api/getuser",
                    method: "get",
                    params: {userId: this.user.userId}
                }).then(r => {
                    console.log(r)
                    if (r.data.code == 200) {
                        this.user = r.data.data;
                    }
                })

            },
            add() {

                this.axios({
                    url: "/api/UpdateUserInfo",
                    method: "post",
                    data: this.user,
                }).then(r => {
                    if (r.data.code == 200) {
                        window.sessionStorage.clear();
                        window.sessionStorage.setItem("user", JSON.stringify(this.user))
                        this.loadUser()
                        location.reload()
                        alert(r.data.message)
                    }
                })
            },
        },
        created() {
            this.loadUser()
        }
    }
</script>
