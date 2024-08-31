<template>
  <div class="child2">
    <h3>弟弟</h3>
    <h4>电脑：{{ computer }}</h4>
    <h4 v-show="toy">哥哥给的玩具：{{ toy }}</h4>
  </div>
</template>

<script setup lang="ts" name="Child2">
import {onUnmounted, ref} from "vue";
import emitter from "@/utils/emitter";
// data
let computer = ref("Dell");
let toy = ref("");

// 监听事件
emitter.on("send-toy", (data: string) => {
  toy.value = data;
});

// 销毁事件
onUnmounted(()=>{
  emitter.off("send-toy");
})

</script>

<style scoped>
.child2 {
  background-color: yellowgreen;
  padding: 10px;
  box-shadow: 0 0 10px black;
  border-radius: 10px;
}
</style>
