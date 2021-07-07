<template>
    <div id="login">
        <v-dialog max-width="400px" v-model="dialog">
            <template v-slot:activator="{ on }">
                <v-btn
                color="#212121"
                text
                x-large
                plain
                elevation="0"
                v-on="on"
                >Login</v-btn>
            </template>
            
            <v-tabs v-model="tab" show-arrows color="#57a2bf" background-color="white" icons-and-text light grow>
                <v-tabs-slider color="#57a2bf"></v-tabs-slider>
                <v-tab v-for="i in tabs" :key="i.name" >
                    <v-icon large class="tab">{{ i.icon }}</v-icon>
                    <div class="caption py-1" >{{ i.name }}</div>
                </v-tab>
                <v-tab-item>
                    <v-card>
                        <v-card-text>
                            <v-container pa-0>
                                <p v-if="alert" class="alert">{{this.message}}</p>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="email" 
                                    :rules="[rules.required]"
                                    label="Email">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    :append-icon="valueLogin ? 'mdi-eye' : 'mdi-eye-off'" 
                                    :type="valueLogin ? 'password' : 'text'" 
                                    v-model="password" 
                                    label="Password"
                                    :rules="[rules.required]"
                                    @click:append="() => (valueLogin = !valueLogin)">
                                    </v-text-field>
                                </v-col>
                            </v-container>
                        </v-card-text>

                        <v-card-actions class="justify-center">
                            <v-btn 
                            :loading="loading" 
                            v-ripple="{ class: 'primary--text' }" 
                            width="300" 
                            style="height:40px;" 
                            class="white--text" 
                            elevation="1" 
                            v-on:click="login()" 
                            color="#57a2bf"
                            >Login</v-btn>
                        </v-card-actions>

                    </v-card>
                </v-tab-item>
                
                <v-tab-item >
                    <v-card >
                        <v-card-text>
                            <v-container pa-0>
                                <p v-if="alert" class="alert">{{this.message}}</p>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="username" 
                                    :rules="[rules.required,rules.length]"
                                    label="Username" >
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="email" 
                                    :rules="[rules.required]"
                                    label="Email">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    :append-icon="valueRegistarPass ? 'mdi-eye' : 'mdi-eye-off'" 
                                    :type="valueRegistarPass ? 'password' : 'text'"
                                    :rules="[rules.required]"  
                                    v-model="password" label="Password"
                                    @click:append="() => (valueRegistarPass = !valueRegistarPass)">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    :append-icon="valueRegistarConfirPass ? 'mdi-eye' : 'mdi-eye-off'" 
                                    :type="valueRegistarConfirPass ? 'password' : 'text'"
                                    :rules="[rules.required, passwordMatch]" 
                                    block 
                                    v-model="passverify"
                                    label="Confirm Password"
                                    @click:append="() => (valueRegistarConfirPass = !valueRegistarConfirPass)">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="description" 
                                    :rules="[rules.required]"
                                    label="Descrição">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="tipo" 
                                    :rules="[rules.required]"
                                    placeholder="(ex:professor,aluno,empregado,etc)"
                                    label="Tipo">
                                    </v-text-field>
                                </v-col>
                                <v-col cols="12">
                                    <v-text-field 
                                    type="text" 
                                    v-model="affiliation" 
                                    :rules="[rules.required]"
                                    placeholder="(ex:empresa,escola,etc)"
                                    label="Afiliação">
                                    </v-text-field>
                                </v-col>
                            </v-container>
                        </v-card-text>

                        <v-card-actions class="justify-center">
                            <v-btn 
                            :loading="loading" 
                            v-ripple="{ class: 'primary--text' }" 
                            width="300" style="height:40px;" 
                            class="white--text" 
                            elevation="1" 
                            v-on:click="register()" 
                            color="#57a2bf"
                            >Register</v-btn>
                        </v-card-actions>          
                    </v-card>
                </v-tab-item>

            </v-tabs>   
        </v-dialog>
    </div>
</template>


<script>
import axios from 'axios'

    export default {
        name: 'Login',
        data() {
            return {
                tab: 0,
                tabs: [
                    {name:"Login", icon:"mdi-account"},
                    {name:"Register", icon:"mdi-account-outline"}
                ],
                rules: {
                    required: value => !!value || "This camp is required.",
                    length: v => (v || '' ).length <= 20 || 'Username deverá conter 20 caracteres ou menos'
                },
                description: "",
                username: "",
                password: "",
                passverify: "",
                email: "",
                type: "password",
                message:'',
                tipo:"",
                affiliation:"",
                alert: false,
                loading: false,
                dialog: false,
                valueLogin: String,
                valueRegistarPass: String,
                valueRegistarConfirPass: String,
            }
        },
        computed: {
            passwordMatch() {
                return () => this.password === this.passverify || "Password must match";
            }
        },  
        methods: {
            login() {
                this.loading = true
                var json = {}
                json['email'] = this.email
                json['password'] = this.password
                axios.post("http://localhost:8081/api/user/login/", json)
                    .then(data => {
                        console.log(data)
                        localStorage.setItem('jwt',data.data)
                        this.$router.go()
                        this.dialog = false
                        this.loading = false
                    })
                    .catch(() => {
                        this.alert = true
                        this.message = 'Email ou Password incorretos!'
                        this.loading = false
                    })
            },
            register() {
                this.loading=true
                var json = {}
                json['name'] = this.username
                json['email']    = this.email
                json['password'] = this.password
                json['registerDate'] = new Date().toISOString();
                json['description'] = this.description
                json['type'] = this.tipo
                json['affiliation'] = this.affiliation
                axios.post("http://localhost:8081/api/user/register/", json)
                    .then( () => {
                        this.login()
                    })
                    .catch(() => {
                        this.alert = true
                        this.message = 'Email '+this.email+' já se encontra registado!'
                        this.loading = false
                    })       
            },            
        }
    }
  
</script>



<style>

#login {
    margin: auto;
}

.alert {
    text-align: center;
    color: red;
}
#login .tab {
    color: #57a2bf;
}

</style>