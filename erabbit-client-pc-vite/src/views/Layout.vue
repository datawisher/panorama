<template>
  <AppTopnav />
  <AppHeader />
  <AppHeaderSticky />
  <!--  内容容器-->
  <div class="main">
    <!--    二级路由-->
    <RouterView />
  </div>
  <AppFooter />
</template>
<script>
import AppTopnav from '@/components/app-topnav.vue'
import AppHeader from '@/components/app-header.vue'
import AppFooter from '@/components/app-footer.vue'
import AppHeaderSticky from '@/components/app-header-sticky.vue'
import { useStore } from 'vuex'

export default {
  name: 'Layout',
  components: { AppHeaderSticky, AppTopnav, AppHeader, AppFooter },
  // 获取分类数据
  setup() {
    const store = useStore()
    store.dispatch('category/getList')
  }
}
</script>
