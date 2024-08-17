<template>
    <div class="person2">
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age }}</h2>
        <button @click="changeName">修改名字</button>
        <button @click="changeAge">修改年龄</button>
    </div>
</template>

<script setup lang="ts" name="Person2"">
import { reactive, toRefs, toRef } from "vue"; 

let person = reactive({ name: "John", age: 30 });

let {name, age} = toRefs(person);

let age2 = toRef(person, 'age');
console.log(age2.value)

const changeName = () => {
    name.value += '!';
};

const changeAge = () => {
    age.value += 1
};
</script>

<style scoped>
.person2 {
    background-color: skyblue;
    box-shadow: 0 0 10px;
    border-radius: 10px;
    padding: 20px;
}
</style>