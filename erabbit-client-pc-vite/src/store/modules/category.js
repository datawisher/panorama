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
    }
  },
  // 获取分类函数
  actions: {
    async getList({ commit }) {
      const data = await findAllCategory()
      commit('setList', data.result)
    }
  }
}
