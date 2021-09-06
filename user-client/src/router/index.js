import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from "../components/index";
import HomeContent from '../components/home/HomeContent'
import UserInfo from '../components/user/UserInfo'
import Userloign from '../components/user/Userloign'
import UserInfologon from "../components/user/UserInfologon";
import UserInfoSetting from "../components/user/UserInfoSetting"
import Reply from '../components/message/Message'
import UserInfoAvatar from "../components/user/UserInfoAvatar";
import UserInfoFlowerSelect from "../components/user/UserInfoFlowerSelect"
import UserInfoContact from "../components/user/UserInfoContact";
import FlowerDetailed from "../components/flower/FlowerDetailed";
import FlowerShopping from "../components/flower/FlowerShopping"
import AddressAdmin from "../components/address/AddressAdmin"
import ConfirmOrder from "../components/order/ConfirmOrder.vue"
import OrderAdmin from "../components/order/OrderAdmin"
import FlowerClass from "../components/class/FlowerClass"
import FlowerLanguage from "../components/class/FlowerLanguage"

Vue.use(VueRouter)

const routes = [

    // 重定向到首页
    {path: '/', redirect: '/index'},
    {
        path: '/index',
        component: Index,
        children: [
            {path: '/index', component: HomeContent},
            {path: '/flower-class', component: FlowerClass},
            {path: '/flower-language', component: FlowerLanguage},

            {
                path: '/user',
                component: UserInfo,
                children: [
                    {path: '/user/setting', component: UserInfoSetting},
                    {path: '/user/avatar', component: UserInfoAvatar},
                    {path: '/user/address-admin', component: AddressAdmin},
                    {path: '/user/order-admin', component: OrderAdmin}
                ]

            },
            {path: '/reply', component: Reply},
            {path: '/login', component: Userloign},
            {path: '/logon', component: UserInfologon},
            {path: '/flowersSelect/:name', component: UserInfoFlowerSelect},
            {path: '/detailed/:id', component: FlowerDetailed},
            {path: '/customer-service', component: UserInfoContact},
            {path: '/flower-shopping', component: FlowerShopping},
            {path: '/checkout/:ids', component: ConfirmOrder}

        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
