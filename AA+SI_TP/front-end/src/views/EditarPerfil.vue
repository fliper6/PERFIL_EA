<template>
    <div id="editPerfil">
        <v-dialog max-width="900px" v-model="show">
            <template v-slot:activator="{ on }">
               <v-btn v-on="on" color='#53a6bf'> Editar perfil </v-btn>
            </template>
            <v-card >
                <v-card-text >
                   
                    
                    <v-container>
                        
                        <v-col id="titulo">
                            <h1 >Editar Perfil</h1>
                        </v-col>

                        <v-col class="pa-2">
                            <v-text-field 
                            hide-details
                            dense
                            type="text" 
                            v-model="nome" 
                            label="Nome"
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

                        <v-col class="pa-2">
                            <v-text-field 
                            hide-details
                            dense
                            type="text" 
                            v-model="tipo" 
                            label="Tipo"
                            outlined
                            ></v-text-field>
                        </v-col>

                        <v-col class="pa-2">
                            <v-text-field 
                            hide-details
                            dense
                            type="text" 
                            v-model="afiliacao" 
                            label="Afiliação"
                            outlined
                            ></v-text-field>
                        </v-col>
                        
                        
                        <v-col align="right">
                          <v-btn  v-ripple="{ class: 'primary--text' }" width="150" style="height:40px" class="white--text" elevation="1" v-on:click="submeter()" color="#00ace6">Submeter</v-btn>
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
    name: "editPerfil",
    data() {
        return{
          show:false,
          nome:'',
          descricao:'',
          tipo:'',
          afiliacao:'',
          role:{}
       
        }
    },
    props: {
        user: Object
    },
    methods: {
        cancelar() {
            this.show=false;
            this.nome='',
            this.descricao='',
            this.tipo='',
            this.afiliacao=''
        },
        created() { 
            console.log(this.user)
            
            
        },
        submeter() {
            var usr = {}
            usr = {
                name: this.nome,
                description: this.descricao,
                type : this.tipo, 
                affiliation : this.afiliacao
            }
           console.log(usr)
           

            axios({
                method: "post",
                url: "http://localhost:8081/api/user/update/"+this.user.idUser+"/",
                data: usr,
                headers: { "Authorization" : localStorage.getItem('jwt')},
            })
            .then(() => {
                    this.cancelar();
                    this.$router.go()
                })
            .catch(err => {
                    console.log(err)
                    alert('Não foi possível editar o perfil')
                    this.cancelar();
                })
        },
        remove(value) {
            var index = this.files.map(function(item) { return item.file.lastModified; }).indexOf(value);
            this.files.splice(index, 1);
        }
    }
}

</script>

<style> 

#titulo h1{
    color: #00ace6;
}


#app > div.v-dialog__content.v-dialog__content--active > div > div > div > div.container > div.col.col-1.offset-11 > div > div.v-input__prepend-outer > div > button {
    color:green
}




</style>