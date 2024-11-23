import { createApp } from 'vue'
import App from './App.vue';
import PrimeVue from 'primevue/config';
import Avatar from 'primevue/avatar';
import Button from 'primevue/button';
import  Panel from 'primevue/panel';
import 'primeicons/primeicons.css';
import '/node_modules/primeflex/primeflex.css';
import 'primevue/resources/themes/lara-light-indigo/theme.css';
import 'primevue/resources/primevue.min.css';

const app = createApp(App);

app.component('Avatar', Avatar);
app.component('Button', Button);
app.component('Panel', Panel)
app.use(PrimeVue);
app.mount('#app');
