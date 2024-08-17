<template>
    <div class="person3">
        姓：<input type="text" v-model="firstName"> <br>
        名：<input type="text" v-model="lastName"> <br>
        全名：<span>{{ fullName }}</span> <br>
        <button @click="changeFullName">修改全名</button>
    </div>
</template>

<script setup lang="ts" name="Person3">
    import { ref, computed } from "vue";

    // data
    let firstName = ref("张");
    let lastName = ref("三");

    // computed
    const fullName = computed({
        get() {
            return firstName.value + "-" + lastName.value;
        },
        set(val) {
            const [str1, str2] = val.split("-");
            firstName.value = str1;
            lastName.value = str2;
        }
    });
    const changeFullName = () => {
        fullName.value = "李-si";
    };
</script>

<style scoped>
    .person3 {
        background-color: skyblue;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>