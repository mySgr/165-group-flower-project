<template>
    <div class="address-container">
        <div class="address-list">
            <div class="address-item "
                 v-for="(item) in addressList"
                 :key="item.addressId"
                 @click="selectUserAddress(item)"
            >
                <h5 class="name">收货人：{{item.receiver}}</h5>
                <p class="phone">手机号：{{item.phone}}</p>
                <footer class="address">收货地址：{{item.address}}</footer>
            </div>
        </div>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                addressList: []
            }
        },
        methods: {
            selectUserAddress(item) {
            },
            // 加载用户收货地址
            loadAddress() {
                const user = JSON.parse(window.sessionStorage.getItem("user"));

                this.$axios({
                    url: '/api/selectAddress',
                    params: {userId: user.userId}
                }).then(result => {
                    if (result.data.code === 200) {
                        this.addressList = result.data.data
                    }
                })
            },
        },
        created() {
            this.loadAddress()
        }
    }
</script>

<style scoped>

    .address-item{
        margin-top: 10px;
        border-bottom: 1px solid #999999;
        height: 80px;
    }
</style>

