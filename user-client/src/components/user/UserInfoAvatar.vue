<template>

    <div>
        <el-form>
            <el-form-item>
                <div class="form-group" style="display: none">
                    <input type="file" ref="x" @change="filePick">
                </div>
            </el-form-item>
        </el-form>
        <img :src="previewSrc">
        <el-button type="success" @click="$refs.x.click()">请选择更换的头像</el-button>
        <el-button type="success" @click="huqu">保存</el-button>

    </div>


</template>
<script>
    export default {
        data() {
            return {
                user: {},
                from: {
                    userId: null,
                    avatar: null,
                },
                previewSrc: ''
            }
        },
        methods: {

            userLoad() {
                let uu = new URLSearchParams()
                this.user = JSON.parse(window.sessionStorage.getItem("user"))
                this.$axios({
                    method: 'get',
                    url: '/api/getuser',
                    params: {
                        userId: this.user.userId,

                    },
                }).then(result => {
                    if (result.data.code == 200) {
                        this.user = result.data.data
                        this.previewSrc = this.user.avatarSrc

                    }
                })
            },
            huqu: function () {

                let tupian = new FormData();
                tupian.append("avatar", this.from.avatar)
                tupian.append("userId", this.user.userId)
                this.axios({
                    url: "/api/user/AvatarReplace",
                    method: "post",
                    headers: {
                        'Content-Type': ' multipart/form-data '
                    },
                    data: tupian,
                }).then(u => {
                        console.log(u)
                        location.reload()
                    }
                )
            },
            filePick() {
                this.previewSrc = URL.createObjectURL(this.$refs.x.files[0]);
                this.from.avatar = this.$refs.x.files[0];
            },
        },
        created() {
            this.userLoad()
        }
    }
</script>
