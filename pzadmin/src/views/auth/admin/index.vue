<template>
  <div>auth/admin</div>
</template>

<script setup lang="ts">
import {authAdmin} from '../../../api'
import {reactive, onMounted} from "vue";

const paginationData = reactive({
  pageNum: 1,
  pageSize: 10
})

onMounted(() => {
  authAdmin(paginationData).then(({data}) => {
    console.log(data, 'authAdmin')
  })
})
</script>

<style lang="less" scoped>

</style>
