package br.com.systec.erpfake.fake;

import br.com.systec.erpfake.api.v1.dto.ClientInputDTO;
import br.com.systec.erpfake.client.model.Client;

public class ClientFake {
	
	public static Client fakeClient() {
		Client client = new Client();
		client.setId(1L);
		client.setName("Cliente teste");
		client.setFederalId("05405868973");
		
		return client;
	}
	
	public static ClientInputDTO fakeClientInputDTO() {
		ClientInputDTO client = new ClientInputDTO();
		client.setId(1L);
		client.setName("Cliente teste");
		client.setFederalId("05405868973");
		
		return client;
	}
}
