import { createApp } from 'vue'
import App from '@/App.vue'
// 引入 ElementPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 引入全局的 SVG 图标
import 'virtual:svg-icons-register'


console.log(import.meta.env)

const app = createApp(App)
// app.use(ElementPlus, {
//     locale: zhCn 
// })
app.mount('#app')
