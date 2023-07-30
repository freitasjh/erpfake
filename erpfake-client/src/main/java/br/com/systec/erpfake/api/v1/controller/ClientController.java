package br.com.systec.erpfake.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.erpfake.api.v1.converter.ClientConverter;
import br.com.systec.erpfake.api.v1.dto.ClientDTO;
import br.com.systec.erpfake.api.v1.dto.ClientInputDTO;
import br.com.systec.erpfake.client.model.Client;
import br.com.systec.erpfake.client.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api/v1/clients")
@Tag(name = "/clients", description = "Cadastro de clientes")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON})
	@Operation(description = "Retorna todos os clientes cadastrados")
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<Client> listOfClient = service.findAll();
		
		return ResponseEntity.ok(ClientConverter.getInstance().toListDTO(listOfClient));
	}
	
	@PostMapping
	@Operation(description = "Salva os dados do cliente")
	public ResponseEntity<ClientInputDTO> save(@RequestBody ClientInputDTO clientInputDTO) {
		Client client = ClientConverter.getInstance().toEntity(clientInputDTO);
		
		Client clientSave = service.save(client);
		
		return ResponseEntity.ok(ClientConverter.getInstance().toInputDTO(clientSave));
	}
	
	@PutMapping
	@Operation(description = "Atualiza dados do cliente")
	public ResponseEntity<ClientInputDTO> update(@RequestBody ClientInputDTO clientInputDTO) {
		Client client = ClientConverter.getInstance().toEntity(clientInputDTO);
		
		Client clientUpdate = service.update(client);
		
		return ResponseEntity.ok(ClientConverter.getInstance().toInputDTO(clientUpdate));
	}
}
