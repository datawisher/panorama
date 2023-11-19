<template>
  <AppTopnav />
  <AppHeader />
  <!--  内容容器-->
  <div class="main">
    <!--    二级路由-->
    <RouterView />
  </div>
  <!--  底部组件-->
  <footer>底部组件</footer>
</template>
<script>
import AppTopnav from '@/components/app-topnav.vue'
import AppHeader from '@/components/app-header.vue'

export default {
  name: 'Layout',
  components: { AppTopnav, AppHeader }
}
</script>
