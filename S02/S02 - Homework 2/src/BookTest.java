import org.junit.Before;
import org.junit.Test;

public class BookTest {

	Book courseText;

	@Before
	public void setup() {
		courseText = new Book("Horstmann/Cornell",
				"Core Java2, Volume I - Fundamentals", "Manning",
				Binding.PAPERBACK, 762);
	}

	@Test
	public void checkGetMethods() {
		System.out.println(courseText.getAuthor());
		System.out.println(courseText.getTitle());
		System.out.println(courseText.getPublisher());
		System.out.println(courseText.getBinding());
		System.out.println(courseText.getPages());
		System.out.println(courseText.getRefNumber());
	}

	@Test
	public void checkPrintMethods() {
		courseText.printAuthor();
		courseText.printTitle();
		courseText.printPublisher();
		courseText.printBinding();
		courseText.printDetails();
	}

	@Test
	public void checkRefNumberMethods() {
		courseText.setRefNumber("ABC");
		System.out.println(courseText.getRefNumber());
		courseText.setRefNumber("XY");
		System.out.println(courseText.getRefNumber());
		courseText.printDetails();
	}
}
