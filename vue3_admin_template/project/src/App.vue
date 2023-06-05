<template>
  <div>
    <h3> SVG 图标测试 </h3>
    <svg>
      <use xlink:href="#icon-dropbox" fill="red"></use>
    </svg>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
  setup() {


    return {}
  }
})
</script>

<style scoped></style>