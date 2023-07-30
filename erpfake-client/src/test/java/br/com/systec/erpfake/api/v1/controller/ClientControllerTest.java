package br.com.systec.erpfake.api.v1.controller;

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

import br.com.systec.erpfake.AbstractIT;
import br.com.systec.erpfake.JsonUtil;
import br.com.systec.erpfake.api.v1.dto.ClientInputDTO;
import br.com.systec.erpfake.fake.ClientFake;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientControllerTest extends AbstractIT{
	private static final String ENDPOINT = "/api/v1/clients";
	
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper mapper = new ObjectMapper();


	@Test
	@Order(1)
	void saveClientTest() throws Exception{
		ClientInputDTO clientInputDTO = ClientFake.fakeClientInputDTO();
		clientInputDTO.setId(null);	
		
		mockMvc.perform(MockMvcRequestBuilders
                .post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(clientInputDTO)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}
	
	@Test
	@Order(2)
	void findAllClients() throws Exception {
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		List<ClientInputDTO> listOfClient = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<ClientInputDTO>>(){});
		
		Assertions.assertThat(listOfClient).isNotEmpty();
		Assertions.assertThat(listOfClient).hasSize(1);
	}
	
	@Test
	@Order(3)
	void updateClientTest() throws Exception {
		ClientInputDTO clientInputDTO = ClientFake.fakeClientInputDTO();
		clientInputDTO.setName("Teste 2");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .put(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.converteObjetoParaString(clientInputDTO)))
        .andExpect(MockMvcResultMatchers.status().is(200))
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		
		ClientInputDTO clientReturn = mapper.readValue(result.getResponse().getContentAsString(), ClientInputDTO.class);
		
		Assertions.assertThat(clientReturn.getName()).isEqualTo("Teste 2");
	}
}
