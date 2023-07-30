package br.com.systec.erpfake.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systec.erpfake.client.model.Client;
import br.com.systec.erpfake.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	@Transactional
	public Client save(Client client) {
		Client clientSave = repository.save(client);
		
		return clientSave;
	}
	
	@Transactional
	public Client update(Client client) {
		if(client.getId() == null) {
			throw new RuntimeException("Cliente sem o ID para atualizar");
		}
		
		Client clientUpdate = repository.save(client);
		
		return clientUpdate;
	}
}
