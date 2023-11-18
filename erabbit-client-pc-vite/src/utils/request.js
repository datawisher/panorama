// 1. 初始化axios实例
// 2. 请求拦截器，带token
// 3. 响应拦截器，拿出响应数据，拦截token失效
// 4. 定义一个函数，使用配置好的axios发请求，返回值promise

import axios from 'axios'
import store from '@/store'
import router from '@/router'

// 存在非axios请求的地址，所以需要export出去
export const baseURL = 'http://pcapi-xiaotuxian-front-devtest.itheima.net/'

const instance = axios.create({
  // 配置
  baseURL,
  timeout: 5000
})

instance.interceptors.request.use(
  (config) => {
    // 拦截的业务逻辑
    // 获取用户信息对象
    const { profile } = store.state.user
    // 判断是否有token
    if (profile.token) {
      // 设置token
      config.headers.Authorization = `Bearer ${profile.token}`
    }
    return config
  },
  (err) => {
    return Promise.reject(err)
  }
)

instance.interceptors.response.use(
  (res) => res.data,
  (err) => {
    if (err.response && err.response.status === 401) {
      // 清空无效用户信息，跳转回登录页，并记录重定向地址
      store.commit('user/setUser', {})
      const fullPath = encodeURIComponent(router.currentRoute.value.fullPath)
      router.push('/login?redirectUrl=' + fullPath)
    }
    return Promise.reject(err)
  }
)
