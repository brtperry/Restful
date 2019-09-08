package com.demo.restful;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulApplicationTests {

	//@Autowired
	//MockMvc mockMvc;

	@Autowired
	private RestfulMessageController controller;

	@Test
	public void contexLoads() {

		Message m = controller.getMessage("Brett");
		String expected = "Hello, Brett!";
		String actual = m.getContent();
		// when zero actual equals expected
		int i = actual.compareTo(expected);
		Assert.assertTrue(i == 0);
	}

}
