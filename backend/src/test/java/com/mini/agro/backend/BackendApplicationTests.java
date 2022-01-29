package com.mini.agro.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Test
	@DisplayName("Test function main")
	void main() {
		Assertions.assertNotNull(BackendApplication.class);
		BackendApplication.main(new String[] {});
	}

}
