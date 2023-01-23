import { login } from '@/api/sys'
import md5 from 'md5'
import { getItem, setItem } from '@/utils/storage'
import { TOKEN } from '@/constant'

export default {
  namespace: true,
  state: () => ({
    token: getItem(TOKEN) || ''
  }),
  mutations: {
    setToken (state, token) {
      state.token = token
      setItem(TOKEN, token)
    }
  },
  actions: {
    /**
     * 登录请求动作
     * @param context
     * @param userInfo
     * @returns {Promise<unknown>}
     */
    login (context, userInfo) {
      const { username, password } = userInfo
      return new Promise((resolve, reject) => {
        login({
          username,
          password: md5(password)
        }).then(data => {
          this.commit('setToken', data.token)
          resolve()
        }).catch(err => {
          reject(err)
        })
      })
    }
  }
}
