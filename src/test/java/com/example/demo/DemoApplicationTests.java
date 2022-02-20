package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {

		this.mockMvc.perform(get("/welcome")).andDo(print());

		Course fakeCourse = new Course(1, "Updated New Programming");

		this.mockMvc.perform(post("/")
		.contentType("application/json")
		.content(new ObjectMapper().writeValueAsString(fakeCourse))
		);

		this.mockMvc.perform(put("/")
		.contentType("application/json")
		.content(new ObjectMapper().writeValueAsString(fakeCourse))
		);

		this.mockMvc.perform(get("/"))
		.andDo(print());

	}

}
