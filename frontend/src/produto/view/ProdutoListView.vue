<script setup>
import { inject, onBeforeMount, ref } from "vue";
import ProductService from "../service/productService";
import { useToast } from "primevue/usetoast";

const listaDeProdutos = ref([{ nome: "Produto 1", valor: 10 }]);
const listOfProduct = ref([]);
const productDialog = ref(false);
const product = ref({});
const swal = inject("$swal");
const toast = useToast();

const productService = new ProductService();

onBeforeMount(async () => {
  await findProduct();
});

const openNew = () => {
  product.value = {};
  productDialog.value = true;
};

const hideDialog = () => {
  productDialog.value = false;
};

const save = async () => {
  try {
    const response = await productService.save(product.value);
    if (response.status === 200) {
      await findProduct();
      hideDialog();
      swal({
        title: "Cadastro",
        text: "Produto cadastrada com sucesso",
        icon: "success",
      });
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

const findProduct = async () => {
  try {
    const result = await productService.findProduct();
    listOfProduct.value = result.data;
  } catch (error) {
    toast.add({
      severity: "error",
      summary: "Erro ao pesquisar os Produtos",
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
        <DataTable :value="listOfProduct" showGridlines tableStyle="min-width: 50rem">
          <Column field="description" header="Descrição"></Column>
          <Column field="price" header="Valor"></Column>
        </DataTable>
      </template>
    </Card>
    <Dialog
      v-model:visible="productDialog"
      :style="{ width: '60%' }"
      header="Product Details"
      :modal="true"
      class="p-fluid"
    >
      <div class="field">
        <label for="product-description">Descrição</label>
        <InputText
          id="product-description"
          v-model.trim="product.description"
          required="true"
          autofocus
        />
      </div>
      <div class="field">
        <label for="product-price">Valor</label>
        <InputNumber
          id="product-price"
          v-model="product.price"
          mode="currency"
          currency="BRL"
          locale="pt-BR"
        />
      </div>
      <div class="field">
        <label for="product-code">Code</label>
        <InputText id="product-code" required="true" v-model="product.code" />
      </div>
      <div class="field">
        <label for="product-codeEan">Codigo EAN</label>
        <InputText id="product-codeEan" required="true" v-model="product.codeEan" />
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
