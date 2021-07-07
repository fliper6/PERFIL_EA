<template>
  
  <div id="navbar-max">
    <div v-if="token">
      <v-layout row justify-center class="navbar">
        <v-toolbar color="#57a2bf" class="hidden-xs-and-down">
          <v-img
          class="logo"
          max-height="40"
          max-width="40"
          src="../assets/redu.png"
          ></v-img>
            <v-toolbar-items>
             <v-btn class="navbar-button">
                <span class="hyperlink" @click="goToLink('/')"><b>Home</b></span>
             </v-btn>
             <v-btn class="navbar-button">
                <span class="hyperlink" @click="goToLink('/recursos-search')"><b>Recursos</b></span>
             </v-btn>
             <v-btn class="navbar-button">
                <span class="hyperlink" @click="goToLink('/utilizadores')"><b>Utilizadores</b></span>
             </v-btn>
            </v-toolbar-items>
            <v-spacer></v-spacer>
            <v-toolbar-items>
             <v-btn class="navbar-button">
                <span class="hyperlink" @click="goToLink(link)"><b>Perfil</b></span>
             </v-btn>
             <v-btn class="navbar-button">
                <span @click="handleLogout()"> Logout </span>
             </v-btn>
            </v-toolbar-items>
          </v-toolbar>
      </v-layout>
    </div>
    <div v-else>
      <v-layout row justify-center class="navbar">
        <v-toolbar color="#57a2bf" class="hidden-xs-and-down">
          <v-img
          class="logo"
          max-height="40"
          max-width="40"
          src="../assets/redu.png"
          ></v-img>
            <v-spacer></v-spacer>
            <v-toolbar-items>
             <v-btn class="navbar-button">
                <Login/>
             </v-btn>
            </v-toolbar-items>
          </v-toolbar>
      </v-layout>
    </div>
  </div>

</template>

<script>
import Login from "@/views/Login.vue";
import axios from 'axios'

export default {
  name: "App",
  components: {
    Login
  },
  methods: {
    handleLogout() {
      localStorage.clear();
      this.$router.go()
      window.location.href = '/'
    },
    goToLink(link) {
      var currentUrl = window.location.pathname;
      if (currentUrl!=link) this.$router.push(link)
    }
  },
  data () {
    return {
      link: '/perfil/',
      idUser: null,
      dialog: false,
      token: localStorage.getItem('jwt'),
      nav: [
        {
          icon: 'home',
          text: 'Home',
          link: '../views/Recurso.vue',
          title: '../views/Recurso.vue',
          active: true
        },
        {
          icon: 'recursos',
          text: 'Recursos',
          //title: '',
          active: false
        },
        {
          icon: 'utilizadores',
          text: 'Utilizadores',
          //title: '',
          active: false
        },
        {
          icon: 'perfil',
          text: 'Perfil',
          //title: '',
          active: false
        },
        {
          icon: 'logout',
          text: 'Logout',
          //title: '',
          active: false
        }
      ]
    }
  },
  created() {
    if (this.token) {
      axios({
          method: "post",
          url: "http://localhost:8081/api/user/token/",
          data: this.token,
      })
      .then(data => {
          this.idUser = data.data.idUser
          this.link = this.link + this.idUser
      })
      .catch(err => {
          console.log(err)
      })
    }
  }
};
</script>

<style>

#navbar-max {
    margin-bottom: 70px;
}

.navbar {
    z-index: 10; 
    width:100%; 
    position: fixed;
    margin-left: 0px !important;
}

.navbar-button {
    background-color: #57a2bf !important; 
    padding-top: 10px !important; 
    box-shadow: 0px 0px 0px 0px rgb(0 0 0 / 20%) !important;
}

.hyperlink {
    text-decoration: none;
    color: #212121 !important;
}

.logo{
    margin-left: 10px;
    margin-right: 10px;
    margin-top: 10px;
}
</style>

