<template>
    <div class="person5">
        <h1>情况二：监视【ref】定义的【对象类型】数据</h1>
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age }}</h2>
        <button @click="changeName">修改姓名</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="changePerson">修改整个人</button>
    </div>
</template>

<script setup lang="ts" name="Person5">
    import { ref, watch } from "vue";

    // data
    const person = ref({
        name: "张三",
        age: 18
    });

    // function
    function changeName() {
        person.value.name += "!";
    }
    function changeAge() {
        person.value.age += 1;
    }
    function changePerson() {
        person.value = {
            name: "李四",
            age: 20
        };
    }

    // watch
    /** 情况二：监视【ref】定义的【对象类型】数据，监视的是对象的地址值，若想监视对象内部属性的变化，需要手动开启深度监视
    watch的第一个参数是：被监视的数据
    watch的第二个参数是：回调函数
    watch的第三个参数是：配置对象(deep、immediate等等) */
    watch(person, (newValue, oldValue) => {
        console.log("监视【ref】定义的【对象类型】数据", newValue, oldValue);
    }, { deep: true, immediate: true });


</script>

<style scoped>
    .person5 {
        background-color: skyblue;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>