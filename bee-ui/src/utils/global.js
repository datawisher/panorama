/**
 * 全局常量、方法封装模块
 * 通过原型挂载到 Vue 属性
 * 通过 this.global 调用
 */

// 后台服务器地址
export const baseUrl = 'http://localhost:8001'

export default {
  baseUrl
}
