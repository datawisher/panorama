<template>
  <AppTopnav />
  <!--  顶部组件-->
  <header>顶部组件</header>
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

export default {
  name: 'Layout',
  components: { AppTopnav }
}
</script>
