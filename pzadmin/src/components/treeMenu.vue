<template>
  <template v-for="item in props.menuData">
    <el-menu-item v-if="!item.children || item.children.length == 0"
                  :key="`${props.index}-${item.meta.id}`">
      <el-icon size="20">
        <component :is="item.meta.icon"></component>
      </el-icon>
      <span>{{ item.meta.name }}</span>
    </el-menu-item>
    <el-sub-menu v-else :index="`${props.index}-${item.meta.id}`" :key="`${props.index}-${item.meta.id}`">
      <template #title>
        <el-icon size="20">
          <component :is="item.meta.icon"></component>
        </el-icon>
        <span>{{ item.meta.name }}</span>
      </template>
      <tree-menu :menuData="item.children"/>
    </el-sub-menu>
  </template>
</template>

<script setup lang="ts">
const props = defineProps(['menuData', 'index']);
</script>

<style lang="less" scoped>

</style>
