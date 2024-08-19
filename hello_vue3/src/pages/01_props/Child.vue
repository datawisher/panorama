<template>
    <div class="child">
        <h3>子组件</h3>
        <h4>玩具：{{ toy }}</h4>
        <h4>父亲给的车：{{ car }}</h4>
        <button @click="sendToy(toy)">送给父亲玩具</button>
    </div>
</template>

<script setup lang="ts" name="Child">
    import { ref } from "vue";

    // data
    let toy = ref("奥特曼");

    // def
    defineProps(["car", "sendToy"])
</script>

<style scoped>
    .child {
        background-color: skyblue;
        padding: 10px;
        box-shadow: 0 0 10px black;
        border-radius: 10px;
    }
</style>