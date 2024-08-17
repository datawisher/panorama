<template>
  <div class="person">
    <h2>姓名：{{ name }}</h2>
    <h2>年龄：{{ age }}</h2>
    <button @click="changeName">修改名字</button>
    <button @click="changeAge">修改年龄</button>
    <button @click="showTel">查看联系方式</button>
  </div>
</template>

<script setup lang="ts" name="Person">
import {ref} from "vue"

let name = ref('张三')
let age = ref(18)
let tel = '123456789'
const changeName = () => {
  name = '李四'
}
const changeAge = () => {
  age += 1
}
const showTel = () => {
  alert(tel)
}

</script>


<style scoped>
.person {
  background-color: skyblue;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 20px;
}
</style>
