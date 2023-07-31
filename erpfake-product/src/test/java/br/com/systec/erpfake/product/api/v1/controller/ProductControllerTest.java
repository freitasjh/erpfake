package br.com.systec.erpfake.product.api.v1.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.systec.erpfake.product.AbstractIT;
import br.com.systec.erpfake.product.JsonUtil;
import br.com.systec.erpfake.product.ProductFake;
import br.com.systec.erpfake.product.api.v1.dto.ProductInputDTO;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest extends AbstractIT{
	private static final String ENDPOINT = "/api/v1/products";
	
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@Order(1)
	void saveProductTest() throws Exception{
		ProductInputDTO productInput = ProductFake.fakeInputDTO();
		productInput.setId(null);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(productInput)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		ProductInputDTO productSave = mapper.readValue(result.getResponse().getContentAsString(), ProductInputDTO.class);
		
		Assertions.assertThat(productSave.getId()).isNotNull();
	}
	
	@Test
	@Order(2)
	void updateProductTest() throws Exception{
		ProductInputDTO productInput = ProductFake.fakeInputDTO();
		productInput.setId(1L);
		productInput.setDescription("Produto teste 222");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .put(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(productInput)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		ProductInputDTO productSave = mapper.readValue(result.getResponse().getContentAsString(), ProductInputDTO.class);
		
		Assertions.assertThat(productSave.getDescription()).isEqualTo("Produto teste 222");
	}
	
	@Test
	@Order(3)
	void findAllClients() throws Exception {
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		List<ProductInputDTO> listOfProduct = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ProductInputDTO>>(){});
		
		Assertions.assertThat(listOfProduct).isNotEmpty();
		Assertions.assertThat(listOfProduct).hasSize(1);
	}
}
