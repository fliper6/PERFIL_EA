<template>
  <div id="users" class="users" >

    <v-row >
        <v-col cols=2 offset="9">
            <v-text-field @keydown.enter="search()" label="Filtro" v-model="filtro"></v-text-field>
        </v-col>
        <v-icon @click="search()"> mdi-magnify </v-icon>
    </v-row>

    <v-container style="max-width: 85%">
      <v-row no-gutters >
        <v-col v-for="n in list" :key="n.name" cols="12" sm="4">
          <v-card class="pa-6 user" color="grey lighten-2" outlined @click="handleClick(n.idUser)" min-width="400px">
            <v-row>
              <v-col cols="12" sm="4">
                  <v-avatar size="100">
                      <v-img :src="`http://localhost:8081/api/user/image/thumbnail/` + n.picture"></v-img>
                  </v-avatar>
              </v-col>
              
              <v-col cols="12" sm="8" >
                  <span style="font-size: 20px; color: #53a6bf;"> {{n.name}} <br/> </span>
                  <span style="font-size: 14px;"> <b>Estatuto: </b> {{n.role.type}} <br/> </span>
                  <span style="font-size: 14px;"> <b>Filiação: </b> {{n.role.affiliation}} <br/> </span>
                  <span style="font-size: 14px;"> <i> Registado desde {{n.registerDate.split("T")[0]}} </i></span>
              </v-col>
            </v-row>
          </v-card> 
        </v-col>
      </v-row>
    </v-container>

    <div v-if="list.length==0">
        <h1 style="text-align:center"> Sem Resultados! </h1>
    </div>

    <div v-if="maiorQueLimite">
        <v-btn v-if="all" :style="{left: '50%', transform:'translateX(-50%)'}" class="justify-center" @click="handleLess">Ver menos</v-btn> 
        <v-btn v-else :style="{left: '50%', transform:'translateX(-50%)'}" @click="handleMore"> Ver mais</v-btn> 
    </div>

  </div>
</template>




<script>
import axios from 'axios'

export default {
    name: 'users',
    data() {
        return { 
            filtrou: false,
            filtrado: [],
            filtro: '',
            limite:9,
            list:[],
            users: [],
            all: false,
            maiorQueLimite: false
        }
    },
    components: {
    },
    created() {
        axios({
            method: "get",
            url: "http://localhost:8081/api/user/",
        })
        .then(data => {
            this.users = data.data;
            this.list = this.users.slice(0,this.limite);
            this.users.length > this.limite ? this.maiorQueLimite = true : this.maiorQueLimite = false
        })
        .catch(err => {
            console.log(err)
        })
    },
    watch: {
        'all' : function() {
            this.filtrou ? this.list = this.filtrado : this.list = this.users
            if (!this.all) { this.list = this.list.slice(0,this.limite) }
        }
    },
    methods: {
        handleMore(){
            this.all = true
        },
        handleLess(){
            this.all = false
        },
        handleClick(value) {
            this.$router.push('/perfil/' + value)      
        },
        filtrar(obj) {
            var name = obj.name
            var re = new RegExp(this.filtro, 'i');
            return name.match(re)
        },
        search() {
            if (this.filtro!=""){
                this.filtrado = this.users.filter(this.filtrar)
                this.filtrado.length > this.limite ? this.maiorQueLimite = true : this.maiorQueLimite = false
                this.list = this.filtrado.slice(0,this.limite)
                this.filtrou = true
            }
            else {
                this.users.length > this.limite ? this.maiorQueLimite = true : this.maiorQueLimite = false
                this.list = this.users.slice(0,this.limite) 
                this.filtrou = false
            }
            this.all = false
        }
    }
}

</script>




<style>

#users > .user {
    text-align: left;
    border-radius: 5px;
    margin: 10px;
}


</style>