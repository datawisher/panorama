<template>
  <!--  <Person/>-->
  <!--  <Car/>-->
  <Car2/>
</template>

<script>
import Person from "@/components/Person.vue";
import Car from "@/components/Car.vue";
import Car2 from "@/components/Car2.vue";

export default {
  name: "App",
  components: {Car2, Car, Person}
}
</script>

<style>
.app {
  background-color: #ddd;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 20px;
}
</style>
