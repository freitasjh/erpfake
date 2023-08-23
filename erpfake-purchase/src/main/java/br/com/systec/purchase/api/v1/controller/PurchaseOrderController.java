package br.com.systec.purchase.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.purchase.api.v1.converter.PurchaseOrderConverter;
import br.com.systec.purchase.api.v1.dto.PurchaseOrderDTO;
import br.com.systec.purchase.api.v1.dto.PurchaseOrderInputDTO;
import br.com.systec.purchase.model.PurchaseOrder;
import br.com.systec.purchase.service.PurchaseOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/purchase")
@Tag(name = "Pedido de Compra")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Cadastra um novo pedido de compra")
	public ResponseEntity<PurchaseOrderInputDTO> save(@RequestBody PurchaseOrderInputDTO purchaseOrderInput) {
		PurchaseOrder purchaseOrder = PurchaseOrderConverter.getInstance().toEntity(purchaseOrderInput);

		PurchaseOrder purchaseOrderSave = service.save(purchaseOrder);

		return ResponseEntity.ok(PurchaseOrderConverter.getInstance().toInputDTO(purchaseOrderSave));
	}

	@PatchMapping(value = "/finalize/{purchaseOrderId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(description = "Finaliza o pedido de compra")
	public ResponseEntity<PurchaseOrderInputDTO> finalizePurchaseOrder(
			@PathVariable("purchaseOrderId") Long purchaseOrderId) {
		PurchaseOrder purchaseOrder = service.finalizePurchaseOrder(purchaseOrderId);

		return ResponseEntity.ok(PurchaseOrderConverter.getInstance().toInputDTO(purchaseOrder));

	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@Operation(description = "Retorna todos os pedidos de compra")
	public ResponseEntity<List<PurchaseOrderDTO>> findAll() {
		List<PurchaseOrder> listOfPurchaseOrder = service.findAll();
		
		List<PurchaseOrderDTO> listOfPurchaseOrderDTO = PurchaseOrderConverter.getInstance().toListDTO(listOfPurchaseOrder);
		
		return ResponseEntity.ok(listOfPurchaseOrderDTO);
	}
}
