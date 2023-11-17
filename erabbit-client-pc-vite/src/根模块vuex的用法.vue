<template>
  <div>
    App
    <!-- 1. Use the data from the root module state -->
    <p>{{ $store.state.username }}</p>
    <!-- 2. Use the data from the root module getters -->
    <!--    <p>{{ $store.getters.newName }}</p>-->
    <p>{{ $store.getters['newName'] }}</p>
    <button @click="mutationFn">mutationFn</button>
    <button @click="actionsFn">actionsFn</button>
  </div>
</template>

<script>
import { useStore } from 'vuex'

export default {
  name: 'App',
  setup() {
    const store = useStore()
    console.log(store.state.username)
    console.log(store.getters['newName'])
    const mutationFn = () => {
      store.commit('updateName')
    }
    const actionsFn = () => {
      store.dispatch('updateName')
    }
    return { mutationFn, actionsFn }
  }
}
</script>
