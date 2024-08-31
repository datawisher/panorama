# Vue 3 + Vite

This template should help get you started developing with Vue 3 in Vite. The template uses Vue 3 `<script setup>` SFCs,
check out the [script setup docs](https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup) to learn more.

Learn more about IDE Support for Vue in
the [Vue Docs Scaling up Guide](https://vuejs.org/guide/scaling-up/tooling.html#ide-support).

## 环境配置

node.js版本 v20.11.0

推荐使用nvm https://nvm.uihtm.com

vite https://cn.vitejs.dev/

vue-router https://router.vuejs.org/zh/

## 路由创建

1. 创建路由和对应页面
2. 引入 vue-router 创建路由实例
3. 挂载 router 到 vue 实例上
4. 对应页面使用 `<RouterView />` 配置路由显示

## UI 框架

1. element-plus https://element-plus.org/zh-CN
2. 按需引入

- 安装插件
```shell
 npm install -D unplugin-vue-components unplugin-auto-import
```
- 在vite的配置文件中加入

```js
// vite.config.ts
import {defineConfig} from 'vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'

export default defineConfig({
    // ...
    plugins: [
        // ...
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],
})
```

