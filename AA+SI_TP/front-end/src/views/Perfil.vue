<template>
  <div id="perfil"  v-if="user">
    
    <v-container style="max-width: 85%" class="perfil">
        <v-card class="pa-6 user" color="grey lighten-5" outlined> 
            <v-row>
              <v-col v-if="this.visivel" sm="3" class="pa-6">
                
                  <input style="display: none" type="file" @change="onFileSelected" ref="fileInput">
                  <v-avatar @click="$refs.fileInput.click()" size="150">
                      <v-img v-if="imageTemp" :src="image" @mouseover="image=imageHover" @mouseleave="image=url"></v-img>
                      <v-img v-else :src="image" @mouseover="image=imageHover" @mouseleave="image=imageOri"></v-img>
                  </v-avatar>
                
              </v-col>
              <v-col v-else sm="3" class="pa-6">

                  <v-avatar size="150">
                      <v-img :src="image"></v-img>
                  </v-avatar>
                
              </v-col>
              <v-col cols="6" sm="6" align="start">
                  <span style="font-size: 30px; color: #53a6bf;"> {{user.name}} <br/> </span>
                  <span style="font-size: 22px;"> <b>Estatuto: </b> {{user.role.type}} <br/> </span>
                  <span style="font-size: 22px;"> <b>Filiação: </b> {{user.role.affiliation}} <br/> </span>
                  <span style="font-size: 22px;"> <b>Tipo: </b> {{user.role.type}} <br/> </span>
                  <span style="font-size: 22px;"> <b>Descrição: </b> {{user.description}} <br/> </span>
                  <span style="font-size: 22px;"> <i> Registado desde {{user.registerDate.split("T")[0]}} </i></span>
              </v-col>
              
              <v-col v-if="this.visivel" align="right">
                <EditPerfil :user="this.user"/>
              </v-col>
            </v-row>

            <v-row>
              <v-col cols="2" class="pa-0" align="center">
                <v-btn small v-if="imageTemp" @click="mudarFoto" color='#53a6bf'> Guardar </v-btn>
              </v-col>
            </v-row>

        </v-card> 

        <v-col v-for="n in list" :key="n.data">

            <v-card light flat >
              <v-container @click="openAndClose(n)">
                
                <v-layout align-center>                 
                  <strong class="display-1 font-weight-regular mr-4">
                    <v-icon>mdi-menu-down</v-icon>
                    {{n.date.split("-")[2]}}
                  </strong>
                  <v-layout column justify-end>
                    <div class="title font-weight-light">{{dataToDia(n.date)}}</div>
                    <div class="text-uppercase font-weight-light">{{dataToMes(n.date)}}</div>
                  </v-layout>
                 </v-layout>
               </v-container>
            </v-card>

            <v-card-text v-if="isOpen(n)" class="py-0">
              <v-col v-for="x in n.timeline" :key="x.hora" cols="12" sm="6">
                <v-timeline align-top dense>
                  <v-timeline-item color="teal lighten-2" small>
                        <v-layout pt-3>
                          <v-flex xs3>
                            <strong style="font-size: 20px;">{{x.time.slice(0,5)}}</strong>
                          </v-flex>
                          <v-flex>
                            <span style="font-size: 20px;">{{getText(x.state)}}</span>
                          </v-flex>
                        </v-layout>
                    </v-timeline-item>
                </v-timeline>
              </v-col>            
            </v-card-text>

        </v-col>    
        
    </v-container>
    
  

    

    
  </div>
</template>




<script>
import axios from 'axios'
import EditPerfil from "@/views/EditarPerfil.vue"

export default {
    name: 'perfil',
    data() {
        return { 
            open: [],
            list:[],
            user: '',
            id:'',
            url: '',
            hover: false,
            image: null,
            imageTemp: null,
            imageOri: null,
            imageHover: "https://i.ibb.co/rf1BNkr/unknown.png",
            visivel: false,
            token: localStorage.getItem('jwt')
        }
    },
    components: {
      EditPerfil
    },
    created() {
        axios({
        method: "post",
        url: "http://localhost:8081/api/user/token/",
        data: this.token,
        })
        .then(data => {
            this.id = data.data.idUser
            if(this.$route.params.id==this.id){this.visivel=true}
            else{this.visivel=false}

        })
        .catch(err => {
            console.log(err)
        })


        axios({
            method: "get",
            url: "http://localhost:8081/api/user/"+this.$route.params.id+"/",
        })
        .then(data => {
            this.user = data.data;
            this.imageOri = "http://localhost:8081/api/user/image/thumbnail/"+this.user.picture
            this.image = this.imageOri
        })
        .catch(err => {
            console.log(err)
        })

        axios({
        method: "get",
        url: "http://localhost:8081/api/user/timeline/"+this.$route.params.id+"/",})
        .then(res => {
          this.list = res.data
          this.list.sort((a,b) => (a.date < b.date) ? 1 : ((b.date < a.date) ? -1 : 0))
        })
        .catch(err => {
          console.log(err)
        })
        
        
    },
    methods: {
      dataToDia(data) {
       
        let date = new Date(data.split("-")[0],data.split("-")[1], data.split("-")[2]); // 2020-06-21
        let day = date.toLocaleString('pt-pt', { weekday: 'long' });

        return day.charAt(0).toUpperCase() + day.substring(1) 
      },
      dataToMes(data) {
       
        let date = new Date(data.split("-")[0],data.split("-")[1], data.split("-")[2]); // 2020-06-21
        let Month = date.toLocaleString('pt-pt', { month: 'long' });
        return Month.charAt(0).toUpperCase() + Month.substring(1) +" "+data.split("-")[0]
      },
      onFileSelected(event){
        this.imageTemp = event.target.files[0]
        this.url = URL.createObjectURL(this.imageTemp)
        this.image = this.url
      },
      getText(texto) {
        if (texto=="Novo Post") return "Fez uma nova publicação"
        if (texto=="Update Post") return "Atualizou uma publicação"
        if (texto=="Novo Recurso") return "Adicionou um novo recurso"
        if (texto=="Update Recurso") return "Atualizou um recurso"
      },
      openAndClose(n) {
        if (this.isOpen(n)) {
          var index = this.open.map(function(item) { return item; }).indexOf(n)
          this.open.splice(index, 1) 
        } 
        else {
          this.open.push(n)
        } 
      },
      isOpen(n) {
        return this.open.includes(n)
      },
      mudarFoto(){
        const fd =  new FormData();
        fd.append('image', this.imageTemp, this.imageTemp.name)
        var token = localStorage.getItem('jwt')
        axios({
          method: "post",
          url: "http://localhost:8081/api/user/image/"+this.$route.params.id,
          data: fd,
          headers: { "Authorization" : token},
        })
        .then( () => {
          this.image = URL.createObjectURL(this.imageTemp)
          this.imageTemp = null
        })
        .catch(err => {
          console.log(err)
          alert('Não foi possível alterar fotografia')  
        })
      }
    }
}

</script>




<style>

.user {
    text-align: left;
    border-radius: 5px;
    margin: 10px;
}
.active {
  background: grey;
}
.perfil {
    background-color: #a9a9a94a;
    border-radius: 5px;
    margin-top: 20px;
}

</style>