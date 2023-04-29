package sk.fzdp.ciphers.swappairs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

@SpringBootTest
class SwappairsApplicationTests {

	@Autowired
	private SwappairsService swappairsService;
	
	@Test
	void encode() {
		String text = swappairsService.encode("Filip");
		Assert.assertEquals("Chyba", "iFilp", text);
	}
	
	@Test
	void decode() {
		String text = swappairsService.decode("iFilp");
		Assert.assertEquals("Chyba", "Filip", text);
	}

}
