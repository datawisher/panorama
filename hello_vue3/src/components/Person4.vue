<template>
    <div class="person4">
        <h1>情况一：监视【ref】定义的【基本类型】数据</h1>
        <h2>当前求和为：{{ sum }}</h2>
        <button @click="changeSum">+1</button>
    </div>
</template>

<script setup lang="ts" name="Person4">
    import { ref, watch } from "vue";

    // data
   let sum = ref(0);

   // function
   function changeSum() {
       sum.value += 1;
   }

   // watch
   // 情况一：监视【ref】定义的【基本类型】数据
   const stopWatch = watch(sum, (newValue, oldValue) => {
       console.log(newValue, oldValue);
       if (newValue >= 10) {
           stopWatch();
       }
   })
   
</script>

<style scoped>
    .person4 {
        background-color: skyblue;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>