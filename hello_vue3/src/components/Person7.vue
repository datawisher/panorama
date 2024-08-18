<template>
    <div class="person7">
        <h2>姓名：{{ person.name }}</h2>
        <h2>年龄：{{ person.age }}</h2>
        <h2>汽车：{{ person.car.c1 }}、{{ person.car.c2 }}</h2>
        <button @click="changeName">修改姓名</button>
        <button @click="changeAge">修改年龄</button>
        <button @click="changeC1">修改第一台汽车</button>
        <button @click="changeC2">修改第二台汽车</button>
        <button @click="changeCar">修改汽车</button>
    </div>
</template>

<script setup lang="ts" name="Person7">
    import { reactive, watch } from "vue";

    // data
    let person = reactive({
        name: "张三",
        age: 18,
        car: {
            c1: "奔驰",
            c2: "宝马"
        }
    });
    // function
    function changeName() {
        person.name += "!";
    }
    function changeAge() {
        person.age += 1;
    }
    function changeC1() {
        person.car.c1 = "奥迪";
    }
    function changeC2() {
        person.car.c2 = "丰田";
    }
    function changeCar() {
        person.car = {
            c1: "兰博基尼",
            c2: "法拉利"
        };
    }
    // watch
    // 监视情况四：监视响应式对象中的某个属性，且该属性是基本类型的，要写成函数形式
    watch(() => person.name, (newValue, oldValue) => {
        console.log('person.name变化了', newValue, oldValue)
    });
    // 监视情况四：监视响应式对象中的某个属性，且该属性是对象类型的，推荐写成函数形式，对象类型内部属性用深度监视deep配置
    watch(() => person.car, (newValue, oldValue) => {
        console.log('person.car变化了', newValue, oldValue)
    }, { deep: true });
</script>

<style scoped>
    .person7 {
        background-color: skyblue;
        box-shadow: 0 0 10px;
        border-radius: 10px;
        padding: 20px;
    }

    button {
        margin: 0 2px;
    }
</style>