<template>
  <Person5 />
</template>

<script>
import Person from "@/components/Person.vue";
import Person2 from "@/components/Person2.vue";
import Person3 from "@/components/Person3.vue";
import Person4 from "@/components/Person4.vue";
import Person5 from "@/components/Person5.vue";
import Car from "@/components/Car.vue";
import Car2 from "@/components/Car2.vue";

export default {
  name: "App",
  components: { Car2, Car, Person, Person2, Person3, Person4, Person5 }
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
