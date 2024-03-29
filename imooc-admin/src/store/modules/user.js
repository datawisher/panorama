import { login, getUserInfo } from '@/api/sys'
import md5 from 'md5'
import { getItem, setItem, removeAllItem } from '@/utils/storage'
import { TOKEN } from '@/constant'
import router from '@/router'
import { setTimeStamp } from '@/utils/auth'

export default {
  namespace: true,
  state: () => ({
    token: getItem(TOKEN) || '',
    userInfo: {}
  }),
  mutations: {
    setToken (state, token) {
      state.token = token
      setItem(TOKEN, token)
    },
    setUserInfo (state, userInfo) {
      state.userInfo = userInfo
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
          // 跳转
          router.push('/')
          // 保存登录时间
          setTimeStamp()
          resolve()
        }).catch(err => {
          reject(err)
        })
      })
    },
    /**
     * 获取用户信息
     * @param context
     * @returns {Promise<*>}
     */
    async getUserInfo (context) {
      const res = await getUserInfo()
      this.commit('setUserInfo', res)
      return res
    },
    /**
     * 退出登录
     */
    logout () {
      this.commit('setToken', '')
      this.commit('setUserInfo', {})
      removeAllItem()
      // TODO: 清理掉权限相关配置
      router.push('/login')
    }
  }
}
