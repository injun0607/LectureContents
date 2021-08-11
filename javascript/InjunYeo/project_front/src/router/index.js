import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainPage from '../views/main/MainPage.vue'
//회원가입 페이지
import RegisterPage from '../views/register/RegisterPage.vue'
import ClearPage from '../views/register/ClearPage.vue'

import LoginPage from '../views/login/LoginPage.vue'
import SubPage from '../views/sub/SubPage.vue'
import MyPage from '../views/my/MyPage.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },
  //회원가입페이지
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },
  {
    path: '/clearPage',
    name: 'ClearPage',
    component: ClearPage
  },

  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/sub',
    name: 'SubPage',
    component: SubPage
  },
  {
    path: '/my',
    name: 'MyPage',
    component: MyPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
