import Vue from "vue";
import App from "./App.vue";

import vuetify from "./plugins/vuetify";
import "vuetify/dist/vuetify.min.css";

import router from './router'

Vue.config.productionTip = false;

const moment = require('moment')
require('moment/locale/pt')
var VueScrollTo = require('vue-scrollto');
 
Vue.use(VueScrollTo)
Vue.use(require('vue-moment'), {
    moment
})


new Vue({
  router,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
