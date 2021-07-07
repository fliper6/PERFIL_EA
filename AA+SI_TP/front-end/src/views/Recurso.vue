<template>
    <div id="recurso" class="recurso" >

        <v-dialog
          v-model="hover"
          max-width= '500px'
          max-height= '500px'
          >
          <v-card v-if="this.ficheiroAtual">
            <v-img v-if="this.ficheiroAtual.type.split('/')[0]=='image'" :src="url"></v-img>
            <embed v-else-if="this.ficheiroAtual.type=='application/pdf'" :src="url"/>
            <embed v-else-if="this.ficheiroAtual.type=='text/plain'" :src="url"/>
            <embed v-else-if="this.ficheiroAtual.type=='application/javascript'" :src="url"/>
            <v-card-title v-else>Não é possível visualizar o ficheiro! {{this.ficheiroAtual.mimetype}}</v-card-title>
          </v-card>
        </v-dialog>

        <v-container v-if="item">
            
            <h1> {{item.title}}</h1>
            <v-col v-if="item.posts.length>0" align="center">
                <a style="color:black;" v-scroll-to="'#pubs'" href="#">Ver Publicações</a>
            </v-col>
            <v-row v-if="idUser==item.idUser.idUser">
                <v-col offset="10">
                    <EditRec :recurso="item"/>
                </v-col>
                <v-col>
                    <v-icon color="red" large @click="removeResource()"> mdi-close </v-icon>
                </v-col>
            </v-row>

            <v-row style="padding: 25px 0 0 0">
                <v-col cols=2 offset=2 class="pa-0" @click="updateSelected('info')">   
                  <v-card elevation="0" outlined :style="selected=='info' ? 'background-color: inherit' : 'background-color:#ddd'">
                      <v-card-title class="justify-center">Informação</v-card-title>
                  </v-card>
                </v-col>

                <v-col cols=2 class="ma-0 pa-0" @click="updateSelected('view')">
                  <v-card elevation="0" outlined :style="selected=='view' ? 'background-color: inherit' : 'background-color:#ddd'">
                      <v-card-title class="justify-center">Visualizar</v-card-title>
                  </v-card>   
                </v-col>
            </v-row>

            <v-row>
                <v-col cols=8 offset="2" class="pa-0">
                    <v-card v-if="this.selected=='info'" elevation="0" outlined style="background-color: inherit;text-align: left;">
                        <v-row >
                            <v-col cols=6 class="pa-10">
                                <b>Tipo: </b> {{this.item.resourceType}}<br>
                                <br>
                                <b>Descrição: </b> {{this.item.description}}<br>
                                <br>
                                <b>Data de Criação: </b> {{this.item.createdAt.split("T")[0]}}<br>
                                <br>
                                <b>Data de Registo: </b> {{this.item.registeredAt.split("T")[0]}}<br>
                                <br>
                                <b>Classificação: </b> 
                                <v-rating
                                  v-model="rating"
                                  color="yellow darken-3"
                                  background-color="grey darken-1"
                                  empty-icon="$ratingEmpty"
                                  half-increments
                                  readonly
                                ></v-rating>
                                <br>
                            </v-col>
                            <v-col cols=6 class="pa-10">
                                <b>Autor: </b> {{this.item.idUser.name}}<br>
                                <br>
                                <b>Ultima Modificação: </b> {{this.item.lastModifiedAt.split("T")[0]}}<br>
                                <br>
                                <b>Número de publicações: </b> {{this.item.posts.length}} <br>
                                <br>
                                <b>Número de downloads: </b> {{this.item.nDownloads}}<br>
                                <br>
                                <b>Tamanho total: </b> {{getTotalSize()}} KB<br>
                            </v-col>
                        </v-row>
                    </v-card>
                    <v-card v-else elevation="0" outlined style="background-color: inherit">
                        <v-row class="pa-6">
                            <v-col >
                                <v-data-table
                                    height= '190px'
                                    hide-default-footer
                                    :headers="headers"
                                    :items="item.files"
                                    item-key="name"
                                    class="elevation-1">
                                    <template v-slot:[`item.size`]="{ value }" >
                                            {{(value/1024).toFixed(1)}}KB
                                    </template>
                                    <template v-slot:[`item.idFile`]="{ value }" >
                                        <span @click="hover = true; getFile(value)">
                                            <v-icon>mdi-eye</v-icon>
                                        </span>
                                    </template>

                                </v-data-table>
                            </v-col>
                        </v-row>

                        <v-row class="pa-0 ma-0">
                            <v-col align="left" class="pa-8">
                                <v-btn v-ripple="{ class: 'primary--text' }" width="150" style="height:40px" class="white--text" elevation="1" v-on:click="download()" color="#00ace6">Download</v-btn>
                            </v-col>
                        </v-row>
                    </v-card>   
                </v-col>
            </v-row>


            <v-row style="margin-top:40px">
                <v-col cols="10" align="right">
                    <NewRate :value="item.idResource"/>
                </v-col>
                <v-col >
                    <NewPub :value="item.idResource"/>
                </v-col>
            </v-row>

            <v-container id="pubs" style="margin-top:90px;max-width: 85%">
              <v-row no-gutters >
                <v-col v-for="n in item.posts" :key="n.name" cols="12" sm="4">
                  <v-card class="pa-6 user" color="grey lighten-2" outlined @click="handleClick(n.idPost)" min-width="100px">
                    <v-row>
                       <v-col cols="12">
                          <span style="font-size: 20px; color: #53a6bf;"> {{n.title}} <br/> </span>
                          <span style="font-size: 14px;"> <b>Autor: </b> {{n.user.name}} <br/> </span>
                          <span style="font-size: 14px;"> <i> Publicado em {{n.createdAt.split("T")[0]}} </i></span>
                      </v-col>
                    </v-row>
                  </v-card> 
                </v-col>
              </v-row>
            </v-container>

        </v-container>

    </div>
</template>



<script>
import axios from 'axios'
import NewPub from '@/views/NovaPublicação.vue'
import NewRate from '@/views/Classificar.vue'
import FileDownload from 'js-file-download';
import EditRec from '@/views/EditarRecurso.vue'


export default {
    name: 'Recurso',
    data() {
        return { 
            rating:0,
            idUser:null,
            ficheiroAtual: null,
            url:'',
            hover: false,
            selected: "info",     
            item: '',
            headers: [
                { text: 'Nome', sortable: false, value: 'name'},
                { text: 'Tamanho', align: 'center',sortable: false, value: 'size' },
                { text: 'Visualizar', align: 'center',sortable: false, value: 'idFile' }
            ],  
        }
    },
    components: {
        NewPub,
        NewRate,
        EditRec
    },
    methods: {
        updateSelected(value) {
            this.selected = value
        },
        handleClick(value) {
            this.$router.push('/publicacao/' + value)      
        },
        removeResource(){
            if(confirm("Tem a certeza que deseja remover?")){
            var id = this.$route.params.id
            var token = localStorage.getItem('jwt')
            axios({
                method: "post",
                url: "http://localhost:8081/api/resource/delete/"+id,
                headers: { "Authorization" : token }
            })
            .then(() => {
                this.$router.push('/')
            })
            .catch(err => {
                console.log(err)
            })}
        },
        getTotalSize() {
            var total = 0
            this.item.files.forEach( f => {
                total += f.size
            })
            return (total/1024).toFixed(1)
        },
        getFile(id) {
            axios({
                method: "get",
                url: "http://localhost:8081/api/resource/file/"+id,
                responseType: 'blob',
                })
                .then(data => {
                    this.ficheiroAtual = data.data
                    this.url = URL.createObjectURL(data.data)
                })
                .catch(err => {
                    console.log(err)
                })
        },
        download() {
            var json = {
                ids:[this.$route.params.id]
            }
            axios({
                method: "post",
                url: "http://localhost:8081/api/resource/download/",
                data: json,
                responseType: 'blob',
            })
            .then(response => {
                let fileName = Date.now() + ".zip"
                FileDownload(response.data, fileName)
            })
            .catch(err => {
                    console.log(err)
                    alert('Não foi possível realizar o download')
                })
            
        },
        getRating(lista){
            var rating = 0
            lista.forEach(elem => rating += elem.rating)
            rating = rating / lista.length
            if (lista.length==0) return 0
            else return rating * 5 / 100
        }
    },
    created() {
        var token = localStorage.getItem('jwt')
        axios({
            method: "get",
            url: "http://localhost:8081/api/resource/"+this.$route.params.id,
            headers: { "Authorization" : token},
        })
        .then(data => {
            this.item = data.data;
            var posts = this.item.posts.sort((a,b) => (a.createdAt < b.createdAt) ? 1 : ((b.createdAt < a.createdAt) ? -1 : 0))
            this.item.posts = posts
            this.rating = this.getRating(this.item.ratings)
            axios({
                method: "post",
                url: "http://localhost:8081/api/user/token/",
                data: token,
            })
            .then(data => {
                this.idUser = data.data.idUser
            })
            .catch(err => {
                console.log(err)
            })
        })
        .catch(err => {
            console.log(err)
        })
    }
}

</script>




<style>


.recurso {
    text-align: center;
    height: 100vh;
}

.recurso h1{
    margin-top:20px;
    color: #00ace6
}


#recurso > .user {
    text-align: left;
    border-radius: 5px;
    margin: 10px;
}



</style>