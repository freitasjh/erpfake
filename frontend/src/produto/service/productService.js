import http from "axios";

export default class ProductService {
    async findProduct() {
        const result = await http.get("/erp/v1/products");
        return result;
    }

    async save(product) {
        const result = await http.post("/erp/v1/products", product);

        return result;
    }
}