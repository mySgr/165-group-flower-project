import Vue from 'vue'
import VueRouter from 'vue-router'

// 导航组件
import Home from '../components/Home.vue'
import AddFlower from '../components/commodity/AddFlower'
import EditFlower from '../components/commodity/EtidFlower'
import FlowerInfoList from '../components/commodity/FlowerInfoList'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: Home,
        children: [
            {path: '/addflower', component: AddFlower},
            {path: '/flower/list', component: FlowerInfoList},
            {path: '/flower/edit/:flowerId', component: EditFlower}

        ]
    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
