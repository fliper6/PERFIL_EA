<template>
    <div id="editRecurso">
        <v-dialog max-width="900px" v-model="show">
            <template v-slot:activator="{ on }">
                <v-icon style="font-size:26px;margin-right:-60px;margin-top:6px" v-on="on"> mdi-pencil </v-icon>
            </template>
            <v-card >
                <v-card-text >
                   
                    <v-dialog
                      v-model="hover"
                      max-width= '500px'
                      max-height= '500px'
                      >
                      <v-card v-if="this.ficheiroAtual">
                         <v-img v-if="this.ficheiroAtual.type.split('/')[0]=='image'" :src="url"></v-img>
                         <embed v-else-if="this.ficheiroAtual.type=='application/pdf'" :src="url"/>
                         <embed v-else-if="this.ficheiroAtual.type.split('/')[0]=='text'" :src="url"/>
                         <v-card-title v-else>Não é possível visualizar o ficheiro! {{this.ficheiroAtual.mimetype}}</v-card-title>
                       </v-card>
                    </v-dialog>
                    
                    <v-container>
                        
                        <v-col id="titulo">
                            <h1 >Editar Recurso</h1>
                        </v-col>

                        <v-col class="pa-2">
                            <v-text-field 
                            hide-details
                            dense
                            type="text" 
                            v-model="titulo" 
                            label="Título"
                            outlined
                            ></v-text-field>
                        </v-col>

                        <v-col class="pa-2">
                            <v-text-field 
                            hide-details
                            dense
                            type="text" 
                            v-model="descricao" 
                            label="Descrição"
                            outlined
                            ></v-text-field>
                        </v-col>

                        <v-col class="pa-2" style="margin-bottom:-25px">
                            <v-autocomplete
                              v-model="tipo"
                              :items="types"
                              outlined
                              dense
                              label="Seleciona o tipo"
                            ></v-autocomplete>
                        </v-col>

                        <div style="align:center; display:flex">
                            <span style="padding: 18px 0 0 10px"> Visibilidade: </span>
                            <v-switch
                             style="margin-left:10px;"
                             v-model="visibilidade"
                            ></v-switch>
                            <div style="margin-top:18px;margin-left:10px">
                                <span v-if="visibilidade"> (Público) </span>
                                <span v-else> (Privado) </span>
                            </div>
                        </div>

                        <v-row >
                            <v-col cols=2>
                                <span style="padding: 18px 0 0 10px"> Ficheiros: </span>
                            </v-col>
                            <v-col cols="10"> 
                              <v-data-table
                                hide-default-footer
                                :headers="headers"
                                :items="files"
                                item-key="name"
                                class="elevation-1">
                                <template v-slot:[`item.file.idFile`]="{ value }" >
                                    <v-btn
                                      @click="remove(value)"
                                      color="red"
                                      outlined
                                      small
                                      elevation="8"
                                      icon
                                    >
                                    X 
                                    </v-btn>
                                </template>
                                <template v-slot:[`item.file.size`]="{ value }" >
                                    {{(value/1024).toFixed(1)}}KB
                                </template>
                                <template v-slot:[`item.url`]="{ value }" >
                                    <span @click="hover = true; getFile(value)">
                                        <v-icon>mdi-eye</v-icon>
                                    </span>
                                </template>
                                </v-data-table>
                            </v-col>
                        </v-row>
                        
                        <v-col cols="1" offset="11">
                            <v-file-input
                              v-model="filesInput"
                              hide-input
                              prepend-icon="mdi-plus"
                              multiple
                            ></v-file-input>
                        </v-col>
                        
                        <v-col align="right">
                          <v-btn :loading="loading" v-ripple="{ class: 'primary--text' }" width="150" style="height:40px" class="white--text" elevation="1" v-on:click="submeter()" color="#00ace6">Guardar</v-btn>
                          <v-btn v-ripple="{ class: 'primary--text' }" width="150" style="margin-left:10px;height:40px" class="white--text" elevation="1" v-on:click="cancelar()" color="#527a7a">Cancelar</v-btn>
                        </v-col>

                    </v-container>
                </v-card-text>
            </v-card>
        </v-dialog> 
    </div>
</template>


<script>
import axios from 'axios'

export default {
    name: "editarRecurso",
    data() {
        return{
          ficheiroAtual: null,
          url:'',
          urls:[],
          hover: false,
          show:false,
          types:[],
          visibilidade: this.recurso.visibility,
          titulo: this.recurso.title,
          descricao: this.recurso.description,
          menu: false,
          loading:false,
          tipo: this.recurso.resourceType,
          filesInput: [],
          filesEntry: this.recurso.files,
          files: [],
          headers: [
                { text: 'Nome', align: 'center',sortable: false, value: 'file.name'},
                { text: 'Tamanho', align: 'center',sortable: false, value: 'file.size' },
                { text: 'Visualizar', align: 'center',sortable: false, value: 'url' },
                { text: '', align: 'center', sortable: false, value: 'file.idFile'}
            ],
        }
    },
    watch: {
        menu (val) {
            val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
        },
        'filesInput' : function() {
            this.filesInput.forEach(file => {
                var url = URL.createObjectURL(file)
                var json = {}
                json['url'] = url
                json['file'] = file
                this.files.push(json)
            })
        }
    },
    props: {
        recurso: Object
    },
    methods: {
        getFile(url) {            
            this.files.forEach(json => {
                if (json.url==url) {
                    this.url = url
                    this.ficheiroAtual = json.file;
                }
            })
        },
        cancelar() {
            this.show=false;
            this.visibilidade=true,
            this.titulo='',
            this.descricao='',
            this.tipo='',
            this.files=[],
            this.filesInput=[],
            this.urls=[],
            this.loading=false
        },
        save(date) {
            this.$refs.menu.save(date)
        },
        submeter() {
            this.loading=true
            var bodyFormData = new FormData();
            bodyFormData.append('title', this.titulo);
            bodyFormData.append('description', this.descricao);
            bodyFormData.append('registeredAt', this.recurso.registeredAt.slice(0, 19).replace('T', ' '));
            bodyFormData.append('visibility', this.visibilidade);
            bodyFormData.append('type', this.tipo);

            for (let i = 0; i < this.filesInput.length; i++) {
              const file = this.filesInput[i];
              bodyFormData.append('file', file, file.name);
            }

            bodyFormData.append('delete', this.getDelete(this.filesEntry, this.files));

            var token = localStorage.getItem('jwt')
            axios({
                method: "post",
                url: "http://localhost:8081/api/resource/update/"+this.recurso.idResource,
                data: bodyFormData,
                headers: { "Authorization" : token},
            })
            .then(() => {
                    this.cancelar();
                    this.$router.go()
                })
            .catch(err => {
                    console.log(err)
                    alert('Não foi possível editar recurso')
                    this.cancelar();
                })
        },
        getDelete(listaEntrada, listaSaida){
            var idsEntry = []
            var idsOut = []
            listaEntrada.forEach(elem => idsEntry.push(elem.idFile))
            listaSaida.forEach(elem => {
                if (elem.file.idFile) idsOut.push(elem.file.idFile)
                })
            return idsEntry.filter(n => !idsOut.includes(n))
        },
        remove(value) {
            var index = this.files.map(function(item) { return item.file.idFile; }).indexOf(value);
            this.files.splice(index, 1);
        }
    },
    created() {
        axios({
            method: "get",
            url: "http://localhost:8081/api/resource/types/",
        })
        .then(data => {
            this.types = data.data.types
            this.loading=false
            this.filesEntry.forEach(file => {
                axios({
                method: "get",
                url: "http://localhost:8081/api/resource/file/"+file.idFile,
                responseType: 'blob',
                })
                .then(data => {
                    var f = data.data
                    f['idFile'] = file.idFile
                    f['name'] = file.name
                    var url = URL.createObjectURL(data.data)
                    var json = {}
                    json['url'] = url
                    json['file'] = f
                    this.files.push(json)
                })
                .catch(err => {
                    console.log(err)
                })
            })
        })
        .catch(err => {
            console.log(err)
        })
    }
}

</script>

<style> 
.switch {
 margin-top: 0px;
 padding-top: 0px;
}

#titulo h1{
    color: #00ace6;
}



embed{
  height: 500px;
  width: 500px;    
}

#app > div.v-dialog__content.v-dialog__content--active > div > div > div > div.container > div.col.col-1.offset-11 > div > div.v-input__prepend-outer > div > button {
    color:green
}




</style>