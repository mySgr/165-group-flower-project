import Vue from 'vue'
import VueRouter from 'vue-router'

import Index from "../components/index";
import HomeContent from '../components/home/HomeContent'
import UserInfo from '../components/user/UserInfo'
import Userloign from '../components/user/Userloign'
import UserInfologon from "../components/user/UserInfologon";

import Reply from '../components/message/Message'

Vue.use(VueRouter)

const routes = [

    // 重定向到首页
    {path: '/', redirect: '/index'},
    {
        path: '/index',
        component: Index,
        children: [
            {path: '/index', component: HomeContent},
            {path: '/user', component: UserInfo},
            {path: '/reply', component: Reply},
            {path: '/login', component: Userloign},
            {path: '/logon', component: UserInfologon}
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
