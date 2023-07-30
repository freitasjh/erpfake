package br.com.systec.erpfake.api.v1.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import br.com.systec.erpfake.api.v1.dto.ClientDTO;
import br.com.systec.erpfake.api.v1.dto.ClientInputDTO;
import br.com.systec.erpfake.client.model.Client;
import br.com.systec.erpfake.fake.ClientFake;

public class ClientConverterTest {
	
	@Test
	void converterClientToClientDTO() {
		Client client = ClientFake.fakeClient();
		
		ClientDTO clientDTO = ClientConverter.getInstance().toDTO(client);
		
		assertThat(client.getId()).isEqualTo(clientDTO.getId());
		assertThat(client.getName()).isEqualTo(clientDTO.getName());
		assertThat(client.getFederalId()).isEqualTo(clientDTO.getFederalId());
	}
	
	@Test
	void converterClientToClientInputDTO() {
		Client client = ClientFake.fakeClient();
		
		ClientInputDTO clientDTO = ClientConverter.getInstance().toInputDTO(client);
		
		assertThat(client.getId()).isEqualTo(clientDTO.getId());
		assertThat(client.getName()).isEqualTo(clientDTO.getName());
		assertThat(client.getFederalId()).isEqualTo(clientDTO.getFederalId());
	}
	
	@Test
	void converterClientInputDTOToClient() {
		ClientInputDTO clientDTO = ClientFake.fakeClientInputDTO();
		
		Client client = ClientConverter.getInstance().toEntity(clientDTO);
		
		assertThat(client.getId()).isEqualTo(clientDTO.getId());
		assertThat(client.getName()).isEqualTo(clientDTO.getName());
		assertThat(client.getFederalId()).isEqualTo(clientDTO.getFederalId());
	}
}
