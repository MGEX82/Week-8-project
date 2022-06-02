package com.qa.F1.database;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootTest(classes=com.qa.F1.database.F1DatabaseApplication.class)

public class F1DatabaseApplicationTest {
	@Test
	void contextLoads() {
	}

}
