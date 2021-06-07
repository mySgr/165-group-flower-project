import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import './plugins/element.js'
import router from './router'

// 导入图标
import './assets/fonts/iconfont.css'
// 导入全局样式
import './assets/css/global.css';

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
