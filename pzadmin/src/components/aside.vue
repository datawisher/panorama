<template>
  <el-menu
      active-text-color="#ffd04b"
      background-color="#545c64"
      class="aside-container"
      default-active="2"
      text-color="#fff"
      @open="handleOpen"
      @close="handleClose"
  >
    <p class="logo-lg">DIDI陪诊</p>
    <TreeMenu :index="1" :menuData="menuData"/>
  </el-menu>
</template>

<script setup lang="ts">
import TreeMenu from "./treeMenu.vue";
import {useRouter} from "vue-router";
import {reactive} from "vue";

const router = useRouter();
const menuData = reactive(router.options.routes[0].children);


const handleOpen = (key, keyPath) => {
}
const handleClose = (key, keyPath) => {
}
</script>

<style lang="less" scoped>
.aside-container {
  height: 100%;

  .logo-lg {
    font-size: 20px;
    text-align: center;
    height: 50px;
    line-height: 50px;
    font-weight: 600;
    color: #fff;
  }
}
</style>
