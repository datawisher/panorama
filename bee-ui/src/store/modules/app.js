export default {
  state: {
    appName: "Bee",
    themeColor: "#14889A",
    oldThemeColor: "#14889A",
    // 导航栏收缩状态
    collapse: false,
    // 菜单路由是否已加载
    menuRouteLoaded: false
  },
  getters: {
    collapse(state) {
      return state.collapse
    }
  },
  mutations: {
    onCollapse(state) {
      state.collapse = !state.collapse
    },
    setThemeColor(state, themeColor) {
      state.oldThemeColor = state.themeColor
      state.themeColor = themeColor
    },
    menuRouteLoaded(state, menuRouteLoaded) {
      state.menuRouteLoaded = menuRouteLoaded
    }
  },
  actions: {

  }
}
