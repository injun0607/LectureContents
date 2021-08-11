<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
        <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
        <v-btn class="indigo white--text">기본 버튼</v-btn>
        <v-btn class="teal" dark>
            <v-icon>bluetooth</v-icon>
        </v-btn>
        <v-btn fab color="orange" dark>
            <v-icon>bluetooth</v-icon>
        </v-btn>
        <v-btn color="blue" class="hidden-xs-only">Visibility -XS-ONLY</v-btn>
        <v-btn color="blue" class="hidden-sm-only">Visibility -SM-ONLY</v-btn>
        <v-btn color="blue" class="hidden-md-only">Visibility -MD-ONLY</v-btn>
        <!--앞서서 살펴봤던 container의 역할을 수행하며 
        grid 기능을 서포트해주고 기본적으로 페이지 중앙에 자동배치 
        추가적으로 너비를 자동확장할 경우 fluid옵션을 준다-->
        <v-container fluid>
            <!--Grid 시스템의 한 행을 정의함-->
            <v-layout row wrap>
                <!--12개의 컬럼으로 이뤄져 한 행에서 제일 작은것들이 12개 만들어지면
                다음으로 자동 넘김 처리-->
                <v-flex xs12 md6 class="primary white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md2 class="green white--text">
                    <div>{{message}}</div>
                </v-flex>
            </v-layout>
            <v-layout row wrap>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{message}}</div>
                </v-flex>
                <v-flex xs4 md3 class="teal white--text">
                    <div>{{message}}</div>
                </v-flex>
            </v-layout>
        </v-container>

        <v-layout row justify-center>
            <!--사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
            대화상자가 뜨면서 결제할것인지 취소할 것인지 어쩔건지 등등에 활용하기 좋음
            v-dialog에 template을 넣고 v-btn으로 아래와 같은 형식을 만들면 
            무조건 버튼 클릭시 v-card가 동작하게 된다.
            단 주의할점이라면 v-model에 dialog를 겹치게 만들면 안된다. 여러 대화상자를 사용한다면 dialog를 분리해주어야한다.-->
            <!--dialog가 v-card에 맵핑되는객체이다. 그러므로 v-card를 다르게 나오려면 dialog 의 v-model을 다르게 해줘야한다.-->
            <v-dialog v-model="dialog" persistent max-width="400">
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">결제</v-btn>
                </template>
                <v-card>
                    <v-card-title class="headline">
                        {{service.name}} 
                    </v-card-title>
                    <v-card-text>
                        5성급 호텔이 30%할인!
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            취소
                        </v-btn>
                        <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                            결제승인
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>

        <v-dialog v-model="loginDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">로그인</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">
                        Log in
                    </span> 
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field label="Email" v-model="userInfo.email" required>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Password" v-model="userInfo.password"
                                                type="password" required>
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                        확인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-toolbar>
            <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp">
                <v-btn text>First Test</v-btn>
                <v-btn text>Second Test</v-btn>
                <v-btn text>Third Test</v-btn>
            </v-toolbar-items>
            <v-toolbar-items calss="hidden-sm-and-down">
                <v-btn text>Home</v-btn>
                <v-btn text>집에갈랭</v-btn>
                <v-btn text>안되지롱</v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <!--
        <v-navigation-drawer app permanent>
            <v-list nav dense>
                <v-list-item-group active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-action>
                            <v-icon left>{{ link.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-title>
                            <v-list-item-title>
                                {{ link.text }}
                            </v-list-item-title>
                        </v-list-item-title>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
        -->
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">최고의 여행</span>
                <span>tip</span>
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.name" router :to="link.route">
                    {{link.text}}
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>
        <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
                <v-list-item-group active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-action>
                            <v-icon left>{{ link.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-title>
                            <v-list-item-title>
                                {{ link.text }}
                            </v-list-item-title>
                        </v-list-item-title>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
        
    </div>
</template>

<script>
export default {
    name:'VuetifyAllInOneTestPage',
    data(){
        return{
            message: '덥다',
            dialog: false,
            nav_drawer: false,
            group:false,
            service:{
                name: '7박8일 여행코스'
            },
            userInfo: {
                email:'',
                password: '',
            },
            loginDialog: false,
            links:[ 
                {
                    
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route:'/',

                },
                {
                    
                    icon: 'history',
                    text: 'History',
                    name: 'History',
                    route:'/product',

                },
                {
                    
                    icon: 'explore',
                    text: 'Explore',
                    name: 'Explore',
                    route:'/materialize',

                },
            ]
        }
    },
    methods: {
        btn_click($event){
            if($event.target.innerHTML == " 결제승인 "){
                alert('결제가 완료되었습니다')
                this.dialog= false
            }else if($event.target.innerHTML == " 취소 "){
                this.dialog= false
            }
        },
        roundBtnClick (){
            alert('Vuetify 버튼')
        },
        btnLoginClick($event){
            if($event.target.innerHTML == " 확인 "){
                alert('로그인이 완료 되었습니다!')
                console.log("입력된 정보 - 이메일: "+ this.userInfo.email+", 비밀번호: "+ this.userInfo.password)
                this.loginDialog=false
            }else if($event.target.innerHTML ==" 취소 "){
                this.loginDialog=false
            }
            this.userInfo.email='',
            this.userInfo.password=''
        },
        watch:{
            group(){
                this.nav_drawer = false
            }
        }
    }
}
</script>

<style scoped>

h1{
    margin: 10px;
}
p{
    padding: 10px;
    margin: 5px 10px;
}

</style>