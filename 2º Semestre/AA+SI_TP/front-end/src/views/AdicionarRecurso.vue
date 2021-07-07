<template>
    <div id="addRecurso">
        <v-dialog max-width="900px" v-model="show">
            <template v-slot:activator="{ on }">
               <v-btn v-on="on" color='#80dfff'> Novo recurso </v-btn>
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
                            <h1 >Adicionar Recurso</h1>
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

                        <v-col class="pa-2">
                            <v-menu
                              ref="menu"
                              v-model="menu"
                              :close-on-content-click="false"
                              transition="scale-transition"
                              offset-y
                              min-width="auto"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                  <v-text-field
                                    v-model="data"
                                    hide-details
                                    dense
                                    outlined
                                    label="Data de criação"
                                    readonly
                                    v-bind="attrs"
                                    v-on="on"
                                   ></v-text-field>
                                </template>

                                <v-date-picker
                                  ref="picker"
                                  v-model="data"
                                  color="#4F4E81"
                                  :max="new Date().toISOString().substr(0, 10)"
                                  min="1900-01-01"
                                  @change="save"
                                ></v-date-picker>
                            </v-menu>
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
                                <template v-slot:[`item.file.lastModified`]="{ value }" >
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
                          <v-btn :loading="loading" v-ripple="{ class: 'primary--text' }" width="150" style="height:40px" class="white--text" elevation="1" v-on:click="submeter()" color="#00ace6">Submeter</v-btn>
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
    name: "addRecurso",
    data() {
        return{
          ficheiroAtual: null,
          url:'',
          urls:[],
          hover: false,
          show:false,
          types:[],
          visibilidade:true,
          titulo:'',
          descricao:'',
          data:null,
          menu: false,
          loading:false,
          tipo:'',
          filesInput:[],
          files:[],
          headers: [
                { text: 'Nome', align: 'center',sortable: false, value: 'file.name'},
                { text: 'Tamanho', align: 'center',sortable: false, value: 'file.size' },
                { text: 'Visualizar', align: 'center',sortable: false, value: 'url' },
                { text: '', align: 'center', sortable: false, value: 'file.lastModified'}
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
            this.data=null,
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
            bodyFormData.append('registeredAt', this.data + " 00:00:00");
            bodyFormData.append('visibility', this.visibilidade);
            bodyFormData.append('type', this.tipo);

            for (let i = 0; i < this.files.length; i++) {
              const file = this.files[i].file;
              bodyFormData.append('file', file, file.name);
            }

            var token = localStorage.getItem('jwt')
            axios({
                method: "post",
                url: "http://localhost:8081/api/resource/",
                data: bodyFormData,
                headers: { "Authorization" : token},
            })
            .then(data => {
                    alert('Recurso adicionado com sucesso!')
                    this.cancelar();
                    this.$router.push('/recursos/' + data.data.idResource)
                })
            .catch(err => {
                    console.log(err)
                    alert('Não foi possível adicionar novo recurso')
                    this.cancelar();
                })
        },
        remove(value) {
            var index = this.files.map(function(item) { return item.file.lastModified; }).indexOf(value);
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