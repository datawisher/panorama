import path from 'path'

/**
 * 所有的子集路由
 */
const getChildrenRoutes = routes => {
  const result = []
  routes.forEach(route => {
    if (route.children && route.children.length > 0) {
      result.push(...route.children)
    }
  })
  return result
}

/**
 * 处理脱离层级的路由
 */
export const filterRoutes = routes => {
  // 所有的子集路由
  const childrenRoutes = getChildrenRoutes(routes)
  // 根据子集路由进行查重操作
  return routes.filter(route => {
    // 根据 route 在 childrenRoutes 中进行查重，把所有重复路由表剔除
    return !childrenRoutes.find(childrenRoute => {
      return childrenRoute.path === route.path
    })
  })
}

/**
 * 判断数据是否为空值
 */
function isNull (data) {
  if (!data) return true
  if (JSON.stringify(data) === '{}') return true
  if (JSON.stringify(data) === '[]') return true
  return false
}

/**
 * 根据 routes(filterRoutes) 数据，返回对应的 menu 规则数据
 */
export const generateMenus = (routes, basePath = '') => {
  const result = []
  // 遍历路由表
  routes.forEach(item => {
    // 不存在 meta && 不存在 children，直接 return
    if (isNull(item.meta) && isNull(item.children)) return
    // 不存在 meta && 存在 children，迭代 generateMenus
    if (isNull(item.meta) && !isNull(item.children)) {
      result.push(...generateMenus(item.children))
      return
    }
    // 不存在 children， 存在 meta
    // 因为最终的 menu 需要跳转，此时我们需要合并 path
    const routePath = path.resolve(basePath, item.path)
    // 路由分离之后，可能存在同名父路由的情况
    let route = result.find(item => item.path === routePath)
    // 当前路由尚未加入到 result
    if (!route) {
      route = {
        ...item,
        path: routePath,
        children: []
      }
      // icon && title 必须全部存在
      if (route.meta.icon && route.meta.title) {
        result.push(route)
      }
    }
    // 存在 children， 存在meta
    if (item.children) {
      route.children.push(...generateMenus(item.children, route.path))
    }
  })
  return result
}
