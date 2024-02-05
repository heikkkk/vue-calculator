<script setup lang="ts">
import CalculatorView from './views/CalculatorView.vue';
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <div id="app">
    <div id="nav">
            <RouterLink :to="{ name: 'calculator' }">Calculator</RouterLink>|<RouterLink :to="{name: 'feedback'}">Feedback</RouterLink>
        </div>
    <RouterView/>
  </div>
</template>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smooting: antialiased;
  -moz-osx-font-smoting: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #97b6d2;
}
#nav a.router-link-exact-active {
  color: #42b983;
}

</style>
