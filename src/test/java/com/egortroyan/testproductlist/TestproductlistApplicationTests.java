package com.egortroyan.testproductlist;

import com.egortroyan.testproductlist.controller.MainController;
import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TestproductlistApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MainController mainController;


	@Test
	void getProductsTest() throws Exception {
		this.mockMvc.perform(get("/api/getproducts"))
				.andDo(print())
				.andExpect(content()
						.string(containsString("{\"id\":1,\"name\":\"Item1\",\"description\":\"Best Item1\",\"kcal\":333}")));
	}

	@Test
	void addProductToListTest() throws Exception {
		this.mockMvc.perform(post("/api/addproducttolist")
						.param("product", "Item1")
						.param("list", "List2"))
				.andDo(print())
				.andExpect(content()
						.string(containsString("{\"response\":")));
	}

	@Test
	void getListsTest() throws Exception {
		this.mockMvc.perform(get("/api/getproductslists"))
				.andDo(print())
				.andExpect(content()
						.string(containsString("{\"id\":4,\"name\":\"List1\",\"products\":[]}")));
	}

	@Test
	void addProductTest() throws Exception {
		ProductEntity product = new ProductEntity("Item44", "Desc", 666);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(product);
		this.mockMvc.perform(post("/api/addnewproduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andDo(print())
				.andExpect(content()
						.string(containsString("{\"response\":")));
	}
}
