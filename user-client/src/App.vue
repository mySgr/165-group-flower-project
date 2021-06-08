<template>
    <div id="app">

        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: "app",
        data() {
            return {
                user: {}
            }

        },
        methods: {
            test() {
                this.$axios({
                    method: 'post',
                    url: '/api/user/login',
                    data: {phone: 110, password: 123123}
                }).then((result) => {
                    this.user = result.data.data
                })

            },
        },
        created() {
            this.test();
        },
    };
</script>

<style>
    * {
        margin: 0px;
        padding: 0px;
    }
</style>
