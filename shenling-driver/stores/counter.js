import { defineStore } from 'pinia'
import { ref } from 'vue'

defineStore('counter', () => {
  // 响应式的数据
  const count = ref(0)

  // 目的是要外部能访问 count 这个响应式数据
  return { count }
})
