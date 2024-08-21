<template>
  <div class="father">
    <h3>父组件</h3>
    <Child1/>
    <Child2/>
  </div>

</template>

<script setup lang="ts" name="Father">
import {ref} from 'vue';
import Child1 from "@/pages/03_mitt/Child1.vue";
import Child2 from "@/pages/03_mitt/Child2.vue";

// data


</script>

<style scoped>
.father {
  background-color: rgb(165, 164, 164);
  padding: 20px;
  border-radius: 10px;
}
</style>
