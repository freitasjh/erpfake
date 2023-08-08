<script setup>
import { inject, onBeforeMount, ref } from "vue";
import ClientService from "../service/clientService";
import { useToast } from "primevue/usetoast";

const swal = inject("$swal");
const toast = useToast();
const clientService = new ClientService();
const listOfClient = ref([]);
const clientDialog = ref(false);
const client = ref({});

onBeforeMount(async () => {
  await findClient();
});

const openNew = () => {
  client.value = {};
  clientDialog.value = true;
};

const hideDialog = () => {
  clientDialog.value = false;
};

const findClient = async () => {
  try {
    const response = await clientService.findAll();
    listOfClient.value = response.data;
  } catch (error) {
    toast.add({
      severity: "error",
      summary: "Erro ao pesquisar os Clientes",
      detail: error.response,
      life: 3000,
    });
  }
};

const save = async () => {
  try {
    const response = await clientService.save(client.value);
    if (response.status === 200) {
      hideDialog();
      swal({
        title: "Cadastro",
        text: "Cliente cadastrado com sucesso",
        icon: "success",
      });
      await findClient();
    }
  } catch (error) {
    toast.add({
      severity: "error",
      summary: "Erro ao salvar",
      detail: error.response,
      life: 3000,
    });
  }
};
</script>
<template>
  <Toast />
  <div>
    <Card>
      <template #content>
        <Button class="mb-2" label="Novo" @click="openNew()" />
        <DataTable :value="listOfClient" showGridlines tableStyle="min-width: 50rem">
          <Column field="name" header="Nome"></Column>
          <Column field="federalId" header="CPF"></Column>
        </DataTable>
      </template>
    </Card>
    <Dialog
      v-model:visible="clientDialog"
      :style="{ width: '60%' }"
      header="Cliente Informações"
      :modal="true"
      class="p-fluid"
    >
      <div class="field">
        <label for="client-Name">Name</label>
        <InputText
          id="client-name"
          v-model.trim="client.name"
          required="true"
          autofocus
        />
      </div>
      <div class="field">
        <label for="client-federalId">CPF</label>
        <InputText
          id="client-federalId"
          v-model.trim="client.federalId"
          required="true"
        />
      </div>
      <template #footer>
        <Button
          label="Cancelar"
          icon="pi pi-times"
          class="p-button-text"
          @click="hideDialog"
        />
        <Button label="Salvar" icon="pi pi-check" class="p-button-text" @click="save" />
      </template>
    </Dialog>
  </div>
</template>
