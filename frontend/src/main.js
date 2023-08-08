import { createApp } from 'vue'
import '../src/assets/style.scss';
import api from '../src/config/axios'

import App from './App.vue'
import router from './router'
import PrimeVue from 'primevue/config';
import 'primevue/resources/themes/bootstrap4-light-blue/theme.css';
import Menubar from 'primevue/menubar';
import Card from 'primevue/card';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Row from 'primevue/row';        
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import InputMask from 'primevue/inputmask';
import InputNumber from 'primevue/inputnumber';

import VueSweetAlert from 'vue-sweetalert2'
import 'sweetalert2/dist/sweetalert2.min.css'
import Toast from 'primevue/toast';
import ToastService from 'primevue/toastservice';

const app = createApp(App)
app.use(PrimeVue);
app.use(router)
app.use(ToastService);
app.use(VueSweetAlert);

app.config.globalProperties.$axios = api;

app.component("Menubar", Menubar);
app.component("Card", Card);
app.component("DataTable", DataTable);
app.component("Column", Column);
app.component("Row", Row);
app.component("Button", Button);
app.component("Dialog", Dialog);
app.component("InputText", InputText);
app.component("InputMask", InputMask);
app.component("InputNumber", InputNumber);
app.component('Toast', Toast);

app.mount('#app')
