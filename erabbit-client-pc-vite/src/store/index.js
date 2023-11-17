import { createStore } from 'vuex'

const store = createStore({})

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
