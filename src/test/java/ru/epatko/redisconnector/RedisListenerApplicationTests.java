package ru.epatko.redisconnector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.epatko.redisconnector.controller.Controller;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisListenerApplicationTests {

	@Autowired
	private Controller controller;

	@Test
	public void contextLoads() {
	}

}
