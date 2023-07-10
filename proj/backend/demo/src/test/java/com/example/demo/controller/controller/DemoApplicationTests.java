package com.example.demo.controller.controller;

import com.example.demo.controller.ToDoListController;
import com.example.demo.models.ToDoList;

import com.example.demo.servise.ToDoListServise;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebMvcTest(ToDoListController.class)
@SpringJUnitConfig
class ToDoListControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ToDoListServise toDoListService;

	@Test
	void createUser_ValidRequestBody_ReturnsToDoList() throws Exception {

	
		// Mock request body
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("name", "Task1");
		requestBody.put("description", "Description1");
		requestBody.put("startdate", "2023-06-20");
		requestBody.put("enddate", "2023-06-25");
		requestBody.put("category_id", "1");

		// Mock ToDoList object
		ToDoList mockToDoList = new ToDoList();
		// mockToDoList.setId(1);
		mockToDoList.setName("Task1");
		mockToDoList.setDescription("Description1");

		// Convert startdate and enddate strings to Date objects
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = dateFormat.parse((String) requestBody.get("startdate"));
		Date endDate = dateFormat.parse((String) requestBody.get("enddate"));
		mockToDoList.setStartdate(startDate);
		mockToDoList.setEnddate(endDate);
		mockToDoList.setCategory_id(1);

		// Mock the service method
		Mockito.when(toDoListService.create(Mockito.anyMap())).thenReturn(mockToDoList);

		// Perform the POST request
		mockMvc.perform(MockMvcRequestBuilders.post("/todolist/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody.toString()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				// .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Task1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Description1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.startdate").value("startdate"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.enddate").value("enddate"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("id"));
		// Verify that the service method was called with the correct parameters
		Mockito.verify(toDoListService).create(requestBody);
	}
}
