package com.demo.restful;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulApplicationTests {

	@Autowired
	private RestfulMessageController controller;

	private int LONDON_USERS=6;
	private int LOS_ANGELES_USERS=1;

	@Test
	public void givenNullLocationExpectLondon() {
		Response response = controller.getUsers(null);
		int actual = response.getCount();
		Assert.assertEquals(actual, LONDON_USERS);
	}

	@Test
	public void givenEmptyLocationExpectLondon() {
		Response response = controller.getUsers("");
		int actual = response.getCount();
		Assert.assertEquals(actual, LONDON_USERS);
	}

	@Test
	public void givenLondonExpectSix() {
		Response response = controller.getUsers("London");
		int actual = response.getCount();
		Assert.assertEquals(actual, LONDON_USERS);
	}

	@Test
	public void givenLosAnglesExpectOne() {
		Response response = controller.getUsers("Los Angeles");
		int actual = response.getCount();
		Assert.assertEquals(actual, LOS_ANGELES_USERS);
	}

	// users tests

	@Test
	public void givenIDOf1Expect1() {
		User user = controller.getUser(1);
		float actual = user.getId();
		Assert.assertTrue( actual == 1.0);
	}

}
