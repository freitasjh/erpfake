import http from "axios"


export default class ClientService {
    async findAll() {
        return await http.get("/erp/v1/clients");
    }

    async save(client) {
        return await http.post("/erp/v1/clients", client);
    }
}