<template>
  <div>
    App
    <!-- 1. Use the data from the root module state -->
    <p>{{ $store.state.username }}</p>
  </div>
</template>

<script>
import {useStore} from "vuex";

export default {
  name: 'App',
  setup() {
    const store = useStore()
    console.log(store.state.username)
  }
}
</script>
