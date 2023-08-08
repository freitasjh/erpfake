import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/cliente",
      name: "clienteCadastro",
      component: () => import("../cliente/view/ClienteListView.vue")
    },
    {
      path: '/produto',
      name: 'produtoCadastro',
      component: () => import('../produto/view/ProdutoListView.vue')
  },
  ]
})

export default router
