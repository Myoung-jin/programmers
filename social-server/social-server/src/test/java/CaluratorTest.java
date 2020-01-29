import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CaluratorTest {
	@Test
	public void testSum() {
		Calcurator c = new Calcurator();
		double result = c.sum(10, 50);
		assertEquals(60, result, 0);
	}

}
