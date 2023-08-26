package br.com.systec.sales.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.sales.api.v1.converter.SalesOrderConverter;
import br.com.systec.sales.api.v1.dto.SalesOrderDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderInputDTO;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.service.SalesOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@RestController
@RequestMapping("/api/v1/sales")
@Tag(name = "Vendas", description = "Pedido de vendas")
public class SalesOrderController {
	
	@Autowired
	private SalesOrderService service;
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(description = "Salva o pedido de venda")
	public ResponseEntity<SalesOrderInputDTO> save(@RequestBody SalesOrderInputDTO inputDTO) {
		SalesOrder salesOrder = SalesOrderConverter.getInstance().toEntity(inputDTO);
		
		SalesOrder salesOrderSave = service.save(salesOrder);
		
		return ResponseEntity.ok(SalesOrderConverter.getInstance().toInputDTO(salesOrderSave));
	}
	
	@PutMapping
	@Operation(description = "Atualiza o pedido de venda")
	public ResponseEntity<SalesOrderInputDTO> update(@RequestBody SalesOrderInputDTO inputDTO) {
		SalesOrder salesOrder = SalesOrderConverter.getInstance().toEntity(inputDTO);
		
		SalesOrder salesOrderSabe = service.update(salesOrder);
		
		return ResponseEntity.ok(SalesOrderConverter.getInstance().toInputDTO(salesOrderSabe));
	}
	
	@GetMapping
	@Operation(description = "Retorna todos as vendas cadastradas")
	public ResponseEntity<List<SalesOrderDTO>> findAll() {
		List<SalesOrder> listOfSalesOrder = service.findAll();
		
		List<SalesOrderDTO> listOfSalesOrderConverte = SalesOrderConverter.getInstance().toListDTO(listOfSalesOrder);
	
		return ResponseEntity.ok(listOfSalesOrderConverte);
	}
	
	@GetMapping(value = "/{salesOrderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(description = "Retorna os dados do pedido de venda")
	public ResponseEntity<SalesOrderInputDTO> findById(@PathVariable("salesOrderId") Long salesOrderId) {
		SalesOrder salesOrderReturn = service.findById(salesOrderId);
		
		return ResponseEntity.ok(SalesOrderConverter.getInstance().toInputDTO(salesOrderReturn));
	}
	
	@PatchMapping(value = "/finalize/{salesOrderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(description = "Finaliza o pedido de venda")
	public ResponseEntity<SalesOrderInputDTO> finalizeSalesOrder(@PathVariable("salesOrderId") Long salesOrderId) {
		SalesOrder salesOrder = service.finalize(salesOrderId);
		
		return ResponseEntity.ok(SalesOrderConverter.getInstance().toInputDTO(salesOrder));
	}
}
