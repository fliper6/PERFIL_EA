<template>
    <div id="recursos-search" class="recursos-search" >
        <v-container style="padding: 40px 10% 0px">
            <h1 class="title">Tipo de Recursos</h1>
            <br/>
            <v-col align="center">
                <a style="color:black;" href="http://localhost:8080/recursos/type/all">Ver Todos</a>
            </v-col>
            <!--
            <v-col v-for="n in ordered" :key="n.idRecurso" cols="12" sm="12">
                <span class="letter" v-if="n.length == 1"> {{ n.toUpperCase() }} <hr> </span>
                <li style="cursor: pointer;" v-else @click="handleClick(n)"> {{ n }} </li>
            </v-col>-->
            <v-list rounded>
             
              <v-list-item-group
                color="primary"
              >
                <v-list-item v-for="i in types" :key="i">
                  <v-list-item-icon>
                    <v-icon>mdi-chevron-right-box</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title style="font-size: 22px" @click="handleClick(i)" v-text="i"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
            
        </v-container>
    </div>
</template>


<script>
import axios from 'axios'

export default {
    name: 'RecursosSearch',
    data() {
        return { 
            //abc: 'a',
            //ordered: [],
            types: []
        }
    },
    created() {
        axios({
            method: "get",
            url: "http://localhost:8081/api/resource/types/",
        })
        .then(data => {
            this.types = data.data.types.sort((a,b) => (a.toLowerCase() < b.toLowerCase()) ? -1 : ((b.toLowerCase() < a.toLowerCase()) ? 1 : 0))
            this.loading=false
        })
        .catch(err => {
            console.log(err)
        })
        /*
        var abc = ""
        var ord = this.recs1.sort((a,b) => (a.tipo > b.tipo) ? 1 : ((b.tipo > a.tipo) ? -1 : 0))
        for(var i = 0; i < ord.length; i++) {
            if (i == 0) {
                abc = ord[i].tipo.charAt(0).toLowerCase()
                this.ordered.push(abc,ord[i].tipo+" ")
            } else {
                if(ord[i].tipo.charAt(0).toLowerCase() == this.abc) {
                    this.ordered.push(ord[i].tipo+" ")
                }
                else {
                    abc = ord[i].tipo.charAt(0).toLowerCase()
                    this.ordered.push(abc,ord[i].tipo+" ")
                }
            }
        }
        console.log(this.ordered)  */  
    },
    methods: {
        handleClick(value) {
            this.$router.push('/recursos/type/' + value)      
        }
    }
}

</script>


<style>

#recursos-search .letter{
    font-size: 40px;
    margin: 0px !important;
}

#recursos-search .title {
    font-size: 30px !important;
    text-decoration: underline;
    text-align: center;
    margin-top: 10px;
    text-underline-offset: 7px;
    text-decoration-thickness: 6px;
    text-decoration-color: #e88b00;
}



</style>