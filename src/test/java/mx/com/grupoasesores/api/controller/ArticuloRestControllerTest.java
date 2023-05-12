package mx.com.grupoasesores.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import lombok.extern.slf4j.Slf4j;
import mx.com.grupoasesores.api.ApiRestApplication;

@SpringBootTest(classes = {ApiRestApplication.class})
@AutoConfigureMockMvc
@Slf4j
public class ArticuloRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void debeObtenerListadoArticulo() throws Exception {
		log.debug("Entrando a debeObtenerListadoPaginado");
		
		 MvcResult result =  mockMvc.perform(get("/api/v1/articulo/listar"))
		.andExpect(status().isOk()).andReturn();
		
		 MockHttpServletResponse response = result.getResponse();
		 
		 JSONObject json = new JSONObject(response.getContentAsString());
		 
		 log.debug(response.getContentAsString());

		
	}
	
	@Test
	public void debeObtenerDetalleArticulo() throws Exception {
		log.debug("Entrando a debeObtenerListadoPaginado");
		
		 MvcResult result =  mockMvc.perform(post("/api/v1/articulo/obtenerArticulo").param("id", "P0001"))
		.andExpect(status().isOk()).andReturn();
		
		 MockHttpServletResponse response = result.getResponse();
		 
		 JSONObject json = new JSONObject(response.getContentAsString());
		 
		 log.debug(response.getContentAsString());
		 
		 assertEquals(200,json.getInt("status"));
			
	    
		
	}

}
