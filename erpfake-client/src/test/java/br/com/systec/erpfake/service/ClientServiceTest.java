package br.com.systec.erpfake.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.systec.erpfake.client.model.Client;
import br.com.systec.erpfake.client.service.ClientService;
import br.com.systec.erpfake.fake.ClientFake;
import br.com.systec.erpfake.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
	
	@Mock
	private ClientRepository repository;
	
	@InjectMocks
	private ClientService service;
	
	@Test
	void saveClientTest() {
		Client client = ClientFake.fakeClient();
		client.setId(null);
		
		when(repository.save(client)).thenReturn(ClientFake.fakeClient());
		
		Client clientSave = service.save(client);
		
		assertThat(clientSave.getId()).isNotNull();
		
		verify(repository).save(client);
	}
	
	@Test
	void updateClientExceptionNullIdTest() {
		Client client = ClientFake.fakeClient();
		client.setId(null);
		
		assertThrows(RuntimeException.class, () -> {
			service.update(client);
		});
	}
	
	@Test
	void findAllClientTest() {
		List<Client> listOfClient = new ArrayList<>();
		listOfClient.add(ClientFake.fakeClient());
		
		doReturn(listOfClient).when(repository).findAll();
		
		List<Client> listOfClientReturn = service.findAll();
		
		assertThat(listOfClientReturn).isNotEmpty();
		
		verify(repository).findAll();
	}
}
