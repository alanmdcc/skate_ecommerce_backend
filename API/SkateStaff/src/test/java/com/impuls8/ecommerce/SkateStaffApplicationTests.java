package com.impuls8.ecommerce;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.impuls8.ecommerce.models.Product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;



@SpringBootTest
@AutoConfigureMockMvc
class SkateStaffApplicationTests {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Disabled("Desabilitado")
	public void pruebaPut() throws Exception {
		this.mockMvc.perform(put("/api/products/3").queryParam("nombre", "Super Skate Dog")
				.header("Authorization", "Impuls8 eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGFuIE1hcnRpbiBkZWwgQ2FtcG8iLCJyb2xlIjoidXNlck5hbWUiLCJpYXQiOjE2NDkzNTA2ODUsImV4cCI6MTY0OTM4NjY4NX0.p4Gi0H0gtBBGGu-8hNJuGxE2zRIielcMB3Kc_6Yxv2E"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Super")));
	}//pruebaDelete
	
	
	@Test
	@Disabled("Desabilitado")
	public void pruebaDelete() throws Exception {
		this.mockMvc.perform(delete("/api/products/7").header("Authorization", "Impuls8 eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGFuIE1hcnRpbiBkZWwgQ2FtcG8iLCJyb2xlIjoidXNlck5hbWUiLCJpYXQiOjE2NDkzNTA2ODUsImV4cCI6MTY0OTM4NjY4NX0.p4Gi0H0gtBBGGu-8hNJuGxE2zRIielcMB3Kc_6Yxv2E"))
		.andDo(print()) 
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("imk.jpg")));
	}
	
	@Test
	@Disabled("Desabilitado")
	public void pruebaPost() throws Exception  {
		Product p = new Product();
		p.setNameProduct("skate blue");
		p.setDescriptionProduct("patineta azul");
		p.setProductPicture("imk.jpg");
		p.setPriceProduct(1200.00);
		p.setIdCategory(2l);
		this.mockMvc.perform(post("/api/products/").header("Authorization", "Impuls8 eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGFuIE1hcnRpbiBkZWwgQ2FtcG8iLCJyb2xlIjoidXNlck5hbWUiLCJpYXQiOjE2NDkzNTA2ODUsImV4cCI6MTY0OTM4NjY4NX0.p4Gi0H0gtBBGGu-8hNJuGxE2zRIielcMB3Kc_6Yxv2E")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))) .andExpect(status().isOk());
				 
		}
	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString


	@Test
	@Disabled("Desabilitado")
	public void pruebaGets() throws Exception {
		this.mockMvc.perform(get("/api/products/1"))
				.andDo(print()) 
				.andExpect(status().isOk()).andExpect(content().string(containsString("skatePulpo")));
	}


}
