import Vue from 'vue'
import VueRouter from 'vue-router'
import Utilizadores from '../views/Utilizadores.vue'
import Recursos from '../views/Recursos.vue'
import Recurso from '../views/Recurso.vue'
import RecursosSearch from '../views/RecursosSearch.vue'
import Publicacao from '../views/Publicacao.vue'
import Home from '../views/Home.vue'
import Perfil from '../views/Perfil.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/recursos/type/:type',
    name: 'Recursos',
    component: Recursos
  },
  {
    path: '/recursos/:id',
    name: 'Recurso',
    component: Recurso
  },
  {
    path: '/utilizadores',
    name: 'Utilizadores',
    component: Utilizadores
  },
  {
    path: '/perfil/:id',
    name: 'Perfil',
    component: Perfil
  },
  {
    path: '/publicacao/:id',
    name: 'Publicacao',
    component: Publicacao
  },
  {
    path: '/recursos-search',
    name: 'RecursosSearch',
    component: RecursosSearch
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
