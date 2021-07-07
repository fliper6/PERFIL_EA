<template>
    <div id="home" class="home">

     <v-container>
      
      <v-row no-gutters>
        <v-col cols="12" sm="6" md="8" class="publicacoes">
          <h1>Publicações</h1>
          <v-container class="pubs">
            <v-row no-gutters>
              <v-col v-for="n in list" :key="n.idPost" cols="12" sm="6">
                <v-card class="pa-6 pub" outlined  @click="handleClick(n.idPost)">
                  <v-row>
                    <v-col cols="12" sm="4" style="display:inline-flex">
                        <v-img :src="`http://localhost:8081/api/user/image/thumbnail/` + n.user.picture"></v-img>
                    </v-col>
                    <v-col cols="12" sm="8">
                        <span style="font-size: 20px; color: #53a6bf;"> {{ n.title }} <br/> </span>  <br/>
                        <span > <b>Recurso: </b>{{ n.resource.title }} </span>
                        
                    </v-col>
                  </v-row>
                  <v-row>
                    <span>  {{ n.user.name }} {{ n.createdAt | moment("from") }} </span>
                  </v-row>
                </v-card> 
              </v-col>
            </v-row>
          </v-container>

          <div v-if="bigger">
            <v-btn style="margin-top: 20px;" v-if="all" @click="handleLess">Ver menos</v-btn> 
            <v-btn style="margin-top: 20px;" v-else @click="handleMore"> Ver mais</v-btn> 
          </div>
          
        </v-col>

        <v-col cols="6" md="4" class="recursos">
            <h1>Novos Recursos</h1>
            <v-container class="recs">
            <v-row no-gutters>
              <v-col v-for="n in recs" :key="n.idResource" cols="12" sm="12">
                <v-card class="pa-6 rec" @click="handleClick2(n.idResource)">
                  <v-row>
                    <v-col cols="12" sm="4" style="display:inline-flex">
                        <v-img :src="`http://localhost:8081/api/user/image/thumbnail/` + n.idUser.picture"></v-img>
                    </v-col>
                    <v-col cols="12" sm="8">
                        <span style="font-size: 20px; text-decoration: underline"> {{ n.title }} <br/> </span>
                        <span v-if="n.available"> <b>Estado: </b> Disponível <br/> </span>
                        <span v-else> <b>Estado: </b> Indisponível <br/> </span>
                        <span> <b>Tipo: </b>{{ n.resourceType }} <br/> </span>
                        <span> {{ n.idUser.name }} {{ n.createdAt | moment("from") }} </span>
                    </v-col>
                  </v-row>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-col>
    
      </v-row>
    </v-container>
    
    </div>

</template>



<script>
import axios from 'axios'

export default {
    name: 'recursos',
    data() {
        return { 
            all: false,
            bigger: false,
            limite: 8,
            list: [],
            pubs: [], 
            recs: [], 
        }
    },
    components: {
    },
    watch: {
      'pubs' : function() {
          this.pubs.length > this.limite ? this.bigger = true : this.bigger = false
      }
    },
    created() {
        axios({
            method: "get",
            url: "http://localhost:8081/api/post/",
        })
        .then(data => {
            this.pubs = this.sorted(data.data)
            this.list = this.pubs.slice(0,this.limite)
            axios({
            method: "get",
            url: "http://localhost:8081/api/resource/recent/",
            headers: { "Authorization" : "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjM2MzE0MTUsInN1YiI6IkVBIiwiaWRVc2VyIjoxLCJuYW1lIjoiVsOhbHRlciBDYXJ2YWxobyIsImVtYWlsIjoiMUB1bWluaG8ucHQiLCJwYXNzd29yZCI6IjEiLCJsZXZlbCI6InByb2R1dG9yIiwicmVnaXN0ZXJEYXRlIjoxNjEyOTU2MDUzMDAwLCJkZXNjcmlwdGlvbiI6Ik91dHJhIERlc2MgIDExcmnDp8OjbyIsInBpY3R1cmUiOiIxLmpwZyIsImJsb2NrZWQiOmZhbHNlLCJyb2xlIjp7ImlkUm9sZSI6MTMsInR5cGUiOiJPbDExYSIsImFmZmlsaWF0aW9uIjoiT2wxMWUifSwiaXNzIjoiR3J1cG8gMDMifQ.hTywAawtTllFUOpQMedHIXuigU95c4kSXSc8_JK3iL8"},
            })
            .then(data => {
                this.recs = data.data;
            })
            .catch(err => {
                console.log(err)
            })
        })
        .catch(err => {
            console.log(err)
        })
    },
    methods: {
        handleMore(){
            this.list = this.pubs
            this.all = true
        },
        handleLess(){
            this.list = this.pubs.slice(0,this.limite)
            this.all = false
        },
        handleClick(value) {
          this.$router.push('/publicacao/' + value)      
        },
        handleClick2(value) {
          this.$router.push('/recursos/' + value)      
        },
        sorted(lista) {
            return lista.sort((a,b) => (a.createdAt < b.createdAt) ? 1 : ((b.createdAt < a.createdAt) ? -1 : 0))
        },
    }
}

</script>




<style>

.home {
    text-align: center;
    height: 100vh;
}

.home h1{
    font-size: 30px;
    text-decoration: underline;
    text-align: left;
    margin-top: 10px;
    text-underline-offset: 7px;
    text-decoration-thickness: 6px;
    text-decoration-color: #e88b00;
}

.publicacoes {
    padding-right: 30px !important;
}

.pubs {
    background-color: #a9a9a94a;
    border-radius: 5px;
    margin-top: 30px;
}

.pub {
    text-align: left;
    border-radius: 5px;
    margin: 10px;
}

.recursos {
    max-height: 840px;
    border-left: 2px solid #969090;
    background-color: white;
    padding-left: 30px !important;
    display: flex;
    flex-direction: column;
    align-items: center;
    right: 0;
    position: fixed;
}

.recursos h1 {
    text-align: center !important;
    text-decoration: none !important;
    background-color: #e88b00bd;
    width: fit-content;
    padding: 0px 5px;
}

.recs {
    margin-top: 20px;
}

.rec {
    text-align: left;
    border-radius: 5px;
    margin: 10px;
    margin-bottom: 30px;
}

.img {
    margin: auto;
    text-align: right;
    max-height: 80px;
    max-width: 80px;
}

</style>