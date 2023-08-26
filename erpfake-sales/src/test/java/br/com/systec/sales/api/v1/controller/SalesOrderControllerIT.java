package br.com.systec.sales.api.v1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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

import br.com.systec.sales.AbstractIT;
import br.com.systec.sales.api.v1.dto.SalesOrderDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderInputDTO;
import br.com.systec.sales.enums.SalesOrderStatus;
import br.com.systec.sales.fake.SalesOrderFake;
import br.com.systec.sales.utils.JsonUtil;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalesOrderControllerIT extends AbstractIT{
	private static final String ENDPOINT = "/api/v1/sales";
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@Order(1)
	void saveSalesOrderTest() throws Exception {
		SalesOrderInputDTO salesOrderInput = SalesOrderFake.toFakeInputDTO();
		salesOrderInput.setId(null);
		
		salesOrderInput.getListOfSalesOrderItem().forEach(item -> item.setId(null));
		
		mockMvc.perform(MockMvcRequestBuilders
                .post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(salesOrderInput)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
	@Test
	@Order(2)
	void updateSalesOrderTest() throws Exception {
		SalesOrderInputDTO salesOrderInput = SalesOrderFake.toFakeInputDTO();
		salesOrderInput.setClientName("Cliente atualizado");
		
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                .put(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(salesOrderInput)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		SalesOrderInputDTO salesOrderReturn = mapper.readValue(result.getResponse().getContentAsString(), SalesOrderInputDTO.class);
		
		assertThat(salesOrderReturn.getClientName()).isEqualTo(salesOrderInput.getClientName());
	}
	
	@Test
	@Order(3)
	void findAllSalesOrderTest() throws Exception {
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                .get(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		List<SalesOrderDTO> listOfSalesOrder = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<SalesOrderDTO>>(){});
		
		assertThat(listOfSalesOrder).isNotEmpty();
		assertThat(listOfSalesOrder.get(0).getClientName()).isEqualTo("Cliente atualizado");
	}
	
	@Test
	@Order(4)
	void findSalesOrderByIdTest() throws Exception {
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                .get(ENDPOINT + "/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		SalesOrderInputDTO salesOrderReturn = mapper.readValue(result.getResponse().getContentAsString(), SalesOrderInputDTO.class);
		
		assertThat(salesOrderReturn.getClientName()).isEqualTo("Cliente atualizado");
	}
	
	@Test
	@Order(5)
	void finalizeSalesOrderTest() throws Exception {
		MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                .patch(ENDPOINT + "/finalize/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		SalesOrderInputDTO salesOrderReturn = mapper.readValue(result.getResponse().getContentAsString(), SalesOrderInputDTO.class);
		
		assertThat(salesOrderReturn.getSalesOrderStatus()).isEqualTo(SalesOrderStatus.FINALIZE);
	}
	
}
