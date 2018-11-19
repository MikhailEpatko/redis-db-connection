package ru.epatko.redisconnector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.epatko.redisconnector.controller.Controller;
import ru.epatko.redisconnector.model.RedisPaymentData;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConnectionApplicationTests {

	@Autowired
	private Controller controller;

	@Test
	public void contextLoads() {
	}

}
