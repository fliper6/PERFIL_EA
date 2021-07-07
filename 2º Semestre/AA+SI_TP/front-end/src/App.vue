<template>
  <v-app id="app">
    <Navbar/>
    <div v-if="token">
      <router-view></router-view>
    </div>
    <div class="frontpage" v-else>
      <span class="bigtext"> A plafatorma ideal para encontrares todos os recursos que precisas e receber feedbacks nos teus próprios projetos.</span>
      <v-img
          class="logo"
          max-height="300"
          max-width="300"
          src="./assets/frontpage.png"
      ></v-img>
    </div>
  </v-app>
</template>

<script>
import Navbar from './components/Navbar.vue' 

export default {

  name: 'App',
  data() {
    return {
      token:localStorage.getItem('jwt'),
    }
  },
  components:{
    Navbar
  }
};
</script>


<style>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap');

html, body {
  font-family: Arial, Helvetica, sans-serif;
}

#app {
  font-family: Arial, Helvetica, sans-serif;
  height: 64px;
}

body {
    height: 100vh;
} 

html { overflow-y: hidden }

.dropdown {
  overflow: hidden;
}

.bigtext{
  font-family: "Arial Black", "Arial Bold", Gadget, sans-serif;
  width: 700px;
  font-size: 25px;
  margin: 0px 0px 40px;
  text-align: center;
  color: #575d65;

}
.frontpage{
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: auto;
}

</style>


