<template>
    <div class="child">
        <h3>子组件</h3>
        <h4>玩具：{{ toy }}</h4>
        <button @click="emit('send-toy', toy)">送玩具</button>
    </div>
</template>

<script setup lang="ts" name="Child">
    import { ref } from "vue";
    // data
    let toy = ref("小汽车");

    // def
    const emit = defineEmits(["send-toy"]);

</script>

<style scoped>
    .child {
        background-color: skyblue;
        padding: 10px;
        box-shadow: 0 0 10px black;
        border-radius: 10px;
    }
</style>