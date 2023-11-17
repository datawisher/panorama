import { createStore } from 'vuex'
import cart from '@/store/modules/cart'
import user from '@/store/modules/user'
import category from '@/store/modules/category'

const store = createStore({
  modules: {
    cart,
    user,
    category
  }
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
