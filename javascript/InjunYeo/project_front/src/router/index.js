import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainPage from '../views/main/MainPage.vue'
//회원가입 페이지
import RegisterPage from '../views/register/RegisterPage.vue'
import ClearPage from '../views/register/ClearPage.vue'

import LoginPage from '../views/login/LoginPage.vue'
import SubPage from '../views/sub/SubPage.vue'
//마이페이지
import MyPageBoard from '../views/my/MyPageBoard.vue'
import MyPageBoardRegister from '../views/my/MyPageBoardRegister.vue'
import MyPageBoardDetail from '../views/my/MyPageBoardDetail.vue'


//테스트 페이지
import Test from '../views/Test.vue'

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
  //서브페이지
  {
    path: '/sub',
    name: 'SubPage',
    component: SubPage
  },
  //마이페이지
  {
    path: '/my',
    name: 'MyPageBoard',
    component: MyPageBoard
  },
  {
    path: '/my-page-board-register',
    name:'MyPageBoardRegister',
    component: MyPageBoardRegister
  },
  {
    path: '/my-page-board-detail/:boardNo',
    name: 'MyPageBoardDetail',
    components: {
      default: MyPageBoardDetail
    },
    props:{
      default: true
    }
  },

  {
    path: '/test',
    name: 'Test',
    component: Test
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
