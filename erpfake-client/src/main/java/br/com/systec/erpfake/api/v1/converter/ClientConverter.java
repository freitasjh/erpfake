package br.com.systec.erpfake.api.v1.converter;

import java.util.List;
import java.util.stream.Collectors;

import br.com.systec.erpfake.api.v1.dto.ClientDTO;
import br.com.systec.erpfake.api.v1.dto.ClientInputDTO;
import br.com.systec.erpfake.client.model.Client;

public class ClientConverter {

	private static ClientConverter instance;

	public static ClientConverter getInstance() {
		if (instance == null) {
			instance = new ClientConverter();
		}

		return instance;
	}

	public Client toEntity(ClientInputDTO clientInput) {
		Client client = new Client();
		client.setId(clientInput.getId());
		client.setName(clientInput.getName());
		client.setFederalId(clientInput.getFederalId());
		
		return client;
	}

	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(client.getId());
		clientDTO.setName(client.getName());
		clientDTO.setFederalId(client.getFederalId());
		
		return clientDTO;
	}

	public ClientInputDTO toInputDTO(Client client) {
		ClientInputDTO clientInput = new ClientInputDTO();
		clientInput.setId(client.getId());
		clientInput.setName(client.getName());
		clientInput.setFederalId(client.getFederalId());
		
		return clientInput;
	}
	
	public List<ClientDTO> toListDTO(List<Client> listOfClient) {
		return listOfClient.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
