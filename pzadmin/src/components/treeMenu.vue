<template>
  <template v-for="item in props.menuData">
    <el-menu-item
        @click="handleClick(item, `${props.index}-${item.meta.id}`)"
        v-if="!item.children || item.children.length == 0"
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
import {useRouter} from "vue-router";
import {useStore} from "vuex";

const props = defineProps(['menuData', 'index']);
// 创建路由实例
const router = useRouter();
// 创建状态管理实例
const store = useStore();

// methods
const handleClick = (item, active) => {
  store.commit('addMenu', item.meta)
  router.push(item.meta.path)
}
</script>

<style lang="less" scoped>

</style>
