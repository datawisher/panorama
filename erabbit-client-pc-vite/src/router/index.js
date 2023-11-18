import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router'

const Layout = () => import('@/views/Layout.vue')
const Home = () => import('@/views/home/index.vue')

// 路由规则
const routes = [
  // 一级路由布局容器
  {
    path: '/',
    component: Layout,
    children: [{ path: '/', component: Home }]
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
