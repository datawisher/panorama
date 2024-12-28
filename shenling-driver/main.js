import { createSSRApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App'

// 在入口中执行 utils/utils.js
import './utils/utils.js'

export function createApp() {
  const app = createSSRApp(App)

  const pinia = createPinia()
  app.use(pinia)

  return {
    app,
  }
}
