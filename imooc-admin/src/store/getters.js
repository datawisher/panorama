import variables from '@/styles/variables.scss'
// 快捷访问
const getters = {
  token: state => state.user.token,
  hasUserInfo: state => {
    return JSON.stringify(state.user.userInfo) !== '{}'
  },
  userInfo: state => state.user.userInfo,
  cssVar: state => variables
}

export default getters
