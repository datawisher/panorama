import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import store from './store'

// 导入自定义UI组件库
import UI from '@/components/library'

// 1.重置样式
import 'normalize.css'
// 2.自定义重置样式和公共样式
import '@/assets/styles/common.less'

const app = createApp(App)
app.use(store)
app.use(router)
app.use(UI)
app.mount('#app')
