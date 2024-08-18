<template>
    <div class="person6">
        <h1>情况三：监视【reactive】定义的【对象类型】数据</h1>
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age }}</h2>
        <button @click="changeName">修改姓名</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="changePerson">修改整个人</button>
    </div>
</template>

<script setup lang="ts" name="Person6">
    import { reactive, watch } from "vue";

    // data
    let person = reactive({
        name: "张三",
        age: 18
    });

    // function
    function changeName() {
        person.name += "!";
    }
    function changeAge() {
        person.age += 1;
    }
    function changePerson() {
        // person = {
        //     name: "李四",
        //     age: 20
        // };
        Object.assign(person, {
            name: "王五",
            age: 30
        });
    }

    // watch
    // 情况三：监视【reactive】定义的【对象类型】数据，且默认是开启深度监视的
    watch(person, (newValue, oldValue) => {
        console.log("监视【ref】定义的【对象类型】数据", newValue, oldValue);
    });


</script>

<style scoped>
    .person6 {
        background-color: skyblue;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }
</style>