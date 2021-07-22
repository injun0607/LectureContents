
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Game from '../views/Game.vue'
import Todo from '../views/Todo.vue'
import Homework from '../views/Homework.vue'

//..:상위폴더 @:src폴더를 의미 
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

import GameMemberRegisterPage from '@/views/GameMemberRegisterPage.vue'

//삼목
import Concave from '@/views/Concave.vue'

//product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/game',
    name: 'Game',
    component: Game
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
  },
  //board
  {
    path: '/board',
    name: 'BoardListPage',
    components:{
      default: BoardListPage
    } 
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components:{
      default: BoardReadPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components:{
      default: BoardRegisterPage
    } 
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components:{
      default: BoardModifyPage
    },
    props: {
      //라우팅 피라미터를 props에 자동으로 설정하게 서포트함
      default: true
    } 
  },
  //member
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components:{
      default: GameMemberRegisterPage
    } 
  },
    {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components:{
      default: GameMemberRegisterPage
    } 
  },
  //삼목
  {
    path: '/concave',
    name: 'Concave',
    components:{
      default: Concave
    } 
  },
  //product
  {
    path: '/product',
    name: 'ProductListPage',
    components:{
      default: ProductListPage
    } 
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components:{
      default: ProductRegisterPage
    } 
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components:{
      default: ProductReadPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components:{
      default: ProductModifyPage
    },
    props: {
      //라우팅 피라미터를 props에 자동으로 설정하게 서포트함
      default: true
    } 
  },


  

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router