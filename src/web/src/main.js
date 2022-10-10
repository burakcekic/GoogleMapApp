import axios from 'axios'
import VueAxios from 'vue-axios' 
import VueGoogleMaps from "@fawmi/vue-google-maps";

import { createApp } from 'vue'
import App from './App.vue' 
 
createApp(App)
.use(VueAxios, axios)
.use(VueGoogleMaps, {
    load: {
      key: "AIzaSyBlLZZRK-h8P8uXNzWnqI_wFNAXBcStxKE"
    }
  }).mount('#app');

