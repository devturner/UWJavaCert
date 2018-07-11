import static org.junit.Assert.*;

import org.junit.Test;


public class LunchMenuTest {

	@Test
	public void test() {
		LunchMenu newOrder = new LunchMenu (5, 5, 5, 5, 0, 0); 
		System.out.println(newOrder.total());
	
	
		LunchMenu newOrder2 = new LunchMenu (1, 1, 1, 0, 0, 0); 
		System.out.println(newOrder2.total());
	}
}