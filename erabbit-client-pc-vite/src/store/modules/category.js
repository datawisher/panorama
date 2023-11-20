// 商品分类模块
import { topCategory } from '@/api/constants'
import { findAllCategory } from '@/api/category'

export default {
  namespaced: true,
  state() {
    return {
      // 分类信息集合，依赖topCategory重新设置，保证初始化就有数据，不至于白屏
      list: topCategory.map((item) => ({ name: item }))
    }
  },
  // 修改分类函数
  mutations: {
    setList(state, payload) {
      state.list = payload
    },
    show(state, id) {
      const currCategory = state.list.find((item) => item.id === id)
      currCategory.open = true
    },
    hide(state, id) {
      const currCategory = state.list.find((item) => item.id === id)
      currCategory.open = false
    }
  },
  // 获取分类函数
  actions: {
    async getList({ commit }) {
      const data = await findAllCategory()
      // 给每个分类加上open属性，用来显示或隐藏二级分类
      data.result.forEach((top) => {
        top.open = false
      })
      commit('setList', data.result)
    }
  }
}
