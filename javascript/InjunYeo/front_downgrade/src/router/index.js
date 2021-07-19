
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

import GameMemberRegisterPage from '@/views/GameMemberRegisterPage.vue'

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
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components:{
      default: GameMemberRegisterPage
    } 
  },
  

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router