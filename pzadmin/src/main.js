import {createApp} from 'vue'
import './style.css'
import App from './App.vue'
import router from './router/index.js';
import store from "./store/index.js";

router.beforeEach((to, from) => {
    const token = localStorage.getItem('pz_token')
    if (!token && to.path !== '/login') {
        return '/login'
    } else if (token && to.path === '/login') {
        return '/'
    } else {
        return true
    }
})

import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.use(router)
app.use(store)
app.mount('#app')
