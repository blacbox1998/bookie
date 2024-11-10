import { createApp } from 'vue'
import './style.css';
import 'vant/lib/index.css';
import App from './App.vue';
import { Button } from 'vant';
import Panel from "primevue/panel"
import PrimeVue from 'primevue/config';
import { Avatar } from 'primevue';
import Lara from '@primevue/themes/lara';
import 'primeicons/primeicons.css';
import '/node_modules/primeflex/primeflex.css';
import { Collapse, CollapseItem } from 'vant';
import { definePreset } from '@primevue/themes';


const app = createApp(App);

var preset = definePreset(Lara, {
    semantic: {
        primary: {
            50: '{green.50}',
            100: '{green.100}',
            200: '{green.200}',
            300: '{green.300}',
            400: '{green.400}',
            500: '{green.500}',
            600: '{green.600}',
            700: '{green.700}',
            800: '{green.800}',
            900: '{green.900}',
            950: '{green.950}'
        }
    }
})
app.component('primevue-panel', Panel);
app.component('primevue-avatar', Avatar);
app.component('button', Button);
app.component('collapse', Collapse);
app.component('collapse-item', CollapseItem);
app.use(PrimeVue, {
    theme: {
        preset: preset,
    }
},);
app.use(Button);
app.use(Collapse);
app.use(CollapseItem)
app.mount('#app');
