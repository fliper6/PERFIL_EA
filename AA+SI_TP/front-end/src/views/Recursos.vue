<template>
  <div id="recursos"  >

    <v-container>
        <v-row align="center" style="margin-top:-10px">
            <AddRec/>
            <v-col cols=2>
                <v-text-field @keydown.enter="search()" label="Filtro" v-model="filtro"></v-text-field>
            </v-col>
            <v-icon @click="search()"> mdi-magnify </v-icon>
            <v-col align="right">
                <v-btn @click="download()" color='#ff9966'> Download </v-btn>
            </v-col>
        </v-row>
    
        <v-row >
            <v-col cols="12" class="ma-0 pa-0"> 
              <v-data-table
                id="mytable"
                show-select
                v-model="selected"
                :headers="headers"
                :items="resources"
                :items-per-page="10"
                :loading="loading"
                class="elevation-1 click"
                :value="null"
                @click:row="handleClick"
                item-key="title">
                    <template v-slot:[`item.idResource`]="{ value }" >
                        <NewPub :value="value"/>
                    </template>
                    <template v-slot:[`item.ratings`]="{ value }" >
                        <v-rating
                          :value="getRating(value)"
                          color="yellow darken-3"
                          background-color="grey darken-1"
                          empty-icon="$ratingEmpty"
                          half-increments
                          readonly
                          small
                        ></v-rating>
                    </template>
                    <template v-slot:[`item.lastModifiedAt`]="{ value}" >
                        {{value.split("T")[0]}}
                    </template>

                </v-data-table>
            </v-col>
        </v-row>
    </v-container>

  </div>
</template>




<script>
import AddRec from '@/views/AdicionarRecurso.vue'
import NewPub from '@/views/NovaPublicação.vue'
import axios from 'axios'
import FileDownload from 'js-file-download';


export default {
    name: 'recursos',
    data() {
        return { 
            selected: [],
            filtro: '',
            resources: [],
            resourcesInitial: [],
            loading: false,
            headers: [
                { text: 'Título', align: 'center', value: 'title'},
                { text: 'Tipo', align: 'center',value: 'resourceType' },
                { text: 'Autor',align: 'center', value: 'idUser.name' },
                { text: 'Classificação', sortable: false, align: 'center', value: 'ratings' },
                { text: 'Nº de downloads',align: 'center', value: 'nDownloads' },
                { text: 'Data de modificação',align: 'center', value: 'lastModifiedAt' },
                { text: '',align: 'center', sortable: false, value: 'idResource' }
            ],
        }
    },
    components: {
        AddRec,
        NewPub
    },
    methods: {
        handleClick(value) {
          this.$router.push('/recursos/' + value.idResource)      
        },
        sorted(lista) {
            return lista.sort((a,b) => (a.lastModifiedAt < b.lastModifiedAt) ? 1 : ((b.lastModifiedAt < a.lastModifiedAt) ? -1 : 0))
        },
        download() {
            if (this.selected.length>0) {
            var ids = []
            this.selected.forEach(elem => {
                ids.push(elem.idResource)
            })
            var json = {}
            json['ids'] = ids
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
            }
            else {
                alert('Não selecionou nenhum recurso!')
            }
        },
        getRating(lista){
            var rating = 0
            lista.forEach(elem => rating += elem.rating)
            rating = rating / lista.length
            if (lista.length==0) return 0
            else return rating * 5 / 100
        },
        filtrar(obj) {
            var name = obj.title
            var re = new RegExp(this.filtro, 'i');
            return name.match(re)
        },
        search() {
            if (this.filtro!=""){
                this.resources = this.resourcesInitial.filter(this.filtrar)
            }
            else {
                this.resources = this.resourcesInitial 
            }
         }
    },
    created() {
        this.loading=true
        var type = this.$route.params.type
        if (type=="all") {
            axios({
                method: "get",
                url: "http://localhost:8081/api/resource/",
            })
            .then(data => {
                var recursos = this.sorted(data.data)
                this.resources = recursos;
                this.resourcesInitial = recursos;
                this.loading=false
            })
            .catch(err => {
                console.log(err)
            })
        }
        else {
            axios({
                method: "get",
                url: "http://localhost:8081/api/resource/type/" +  type,
            })
            .then(data => {
                this.resources = data.data;
                this.resourcesInitial = data.data;
                this.loading=false
            })
            .catch(err => {
                console.log(err)
            })
        }
    }
}

</script>




<style>

#mytable table thead {
  background: #80dfff;
}

.click {
	position:relative;
}

.click[value="null"]:BEFORE {
	display:none;
}

</style>