<template>
  <div class="car">
    <h2>一辆{{ car.brand }}车，价格是{{ car.price }}万，产于{{ car.year }}年</h2>
    <button @click="changePrice">加10万</button>
    <br>
    <h2>汽车列表：</h2>
    <ul>
      <li v-for="c in cars" :key="c.id">
        {{ c.brand }}
      </li>
    </ul>
    <button @click="changeCarBrand">修改第一个车品牌</button>
  </div>
</template>

<script setup lang="ts">
// data
import {reactive} from "vue";

let car = reactive({brand: "BMW", price: 100, year: 2015});

let cars = reactive([
  {id: 1, brand: "BMW", price: 100, year: 2015},
  {id: 2, brand: "Audi", price: 200, year: 2016}
]);

// function
function changePrice() {
  car.price += 10;
}
function changeCarBrand() {
  cars[0].brand = "Benz";
}
</script>

<style scoped>
.car {
  background-color: lightpink;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 20px;
}
button {
  margin: 0 5px;
}
li {
  font-size: 20px;
}
</style>
