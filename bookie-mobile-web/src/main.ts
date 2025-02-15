import { createApp } from 'vue'
import App from './App.vue';
import PrimeVue from 'primevue/config';
import Avatar from 'primevue/avatar';
import Button from 'primevue/button';
import Panel from 'primevue/panel';
import Sidebar from 'primevue/sidebar';
import DataTable from 'primevue/datatable';
import DataView from 'primevue/dataview';
import AutoComplete from 'primevue/autocomplete';
import Dropdown from 'primevue/dropdown';
import Dialog from 'primevue/dialog';
import ToastService from 'primevue/toastservice';
import BlockUI from 'primevue/blockui';
import 'primeicons/primeicons.css';
import '/node_modules/primeflex/primeflex.css';
import 'primevue/resources/themes/lara-light-indigo/theme.css';
import 'primevue/resources/primevue.min.css';

const app = createApp(App);

app.component('Avatar', Avatar);
app.component('Button', Button);
app.component('Panel', Panel);
app.component('Sidebar', Sidebar);
app.component('DataTable', DataTable);
app.component('DataView', DataView);
app.component('AutoComplete', AutoComplete);
app.component('Dropdown', Dropdown);
app.component('Dialog', Dialog);
app.component('BlockUI', BlockUI)
app.use(PrimeVue);
app.use(ToastService);
app.mount('#app');
