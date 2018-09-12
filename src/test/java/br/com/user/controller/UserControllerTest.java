package br.com.user.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.user.model.User;
import br.com.user.service.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	User mockUser = new User(1, "Vanessa", "645.823.879-00", "xdre.lp@gmail.com");

	String exampleUserJson = "{\"name\":\"Vanessa\",\"cpf\":\"645.823.879-00\",\"email\":\"xdre.lp@gmail.com\",}";

//	@Test
//	public void findUserById() throws Exception {
//
//		Mockito.when(
//				userService.findUserById(Mockito.anyInt())).thenReturn(mockUser);
//
//	
//		mockMvc.perform(MockMvcRequestBuilders.
//		        get("/users/1")
//		        .content(convertObjectToJsonString(mockUser))
//		        .contentType(MediaType.APPLICATION_JSON)
//		        .accept(MediaType.APPLICATION_JSON))
//		        .andExpect(MockMvcResultMatchers.content().json(convertObjectToJsonString(mockUser))); 
//
//
//	}
	
	//Converts Object to Json String
	private String convertObjectToJsonString(User user) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
	   
	    return mapper.writeValueAsString(user);
	}
	
	@Test
	public void findAllUsers() throws Exception {
		List<User> list = new ArrayList<User>();
		list.add(mockUser);
		Mockito.when(
				userService.findAllUsers()).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users/all").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{id:1,name:Vanessa,cpf:645.823.879-00,email:xdre.lp@gmail.com}]";
	
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

//	@Test
//	public void createUser() throws Exception {
//		User mockUser = new User(3, "Ana", "645.823.879-22", "aninha@gmail.com");
//
//		Mockito.when(
//				userService.addUser(Mockito.any(User.class))).thenReturn(mockUser);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/users/add")
//				.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		MockHttpServletResponse response = result.getResponse();
//
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//		assertEquals("http://localhost/users/1",
//				response.getHeader(HttpHeaders.LOCATION));
//
//	}

}
