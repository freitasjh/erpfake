<script setup>
import { ref } from "vue";
const items = ref([
  {
    label: "Cadastro",
    icon: "pi pi-fw pi-file",
    items: [
      {
        label: "Cliente",
        icon: "pi pi-fw pi-plus",
        to: "/cliente",
      },
      {
        label: "Produto",
        icon: "pi pi-fw pi-trash",
        to: "/produto",
      },
    ],
  },

  {
    label: "Pedido",
    icon: "pi pi-fw pi-user",
    items: [
      {
        label: "Venda",
        icon: "pi pi-fw pi-user-plus",
      },
      {
        label: "Compra",
        icon: "pi pi-fw pi-user-minus",
      },
    ],
  },
]);
</script>

<template>
  <div class="card relative z-2">
    <Menubar :model="items" />
  </div>
</template>
