import { createStore } from 'vuex'
import user from '@/store/modules/user'
import app from '@/store/modules/app'
import getters from './getters'

export default createStore({
  getters,
  modules: {
    user,
    app
  }
})
