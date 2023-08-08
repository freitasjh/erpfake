<script setup>
import AppTolbar from "./layout/AppTolbar.vue";
</script>

<template>
  <div>
    <AppTolbar />
    <div class="mt-3">
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped></style>
