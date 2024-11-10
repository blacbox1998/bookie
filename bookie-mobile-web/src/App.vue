<template>
  <div class="temp justify-content-stretch">
    <Calendar class="temp" />
  </div>


</template>
<script setup lang="ts">
import Calendar from './components/Calendar.vue'
</script>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}

.temp {
  width: 100% !important
}
</style>
