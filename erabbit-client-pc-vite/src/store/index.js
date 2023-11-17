import { createStore } from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import cart from '@/store/modules/cart'
import user from '@/store/modules/user'
import category from '@/store/modules/category'

const store = createStore({
  modules: {
    cart,
    user,
    category
  },
  // 配置插件
  plugins: [
    // 默认存储在local storage上
    createPersistedState({
      // 本地存储的名字
      key: 'erabbit-client-pc-vite-store',
      // 指定需要存储的模块
      paths: ['user', 'cart']
    })
  ]
})

// state() {
//     return {
//         username: 'tom'
//     }
// },
// state: { username: 'tom' },
// getters: {
//   newName(state) {
//     return state.username + '!!!'
//   }
// },
// mutations: {
//   updateName(state) {
//     state.username = 'ls'
//   }
// },
// actions: {
//   updateName(ctx) {
//     // send request
//     setTimeout(() => {
//       ctx.commit('updateName')
//     }, 1000)
//   }
// },
// modules: {}

export default store
