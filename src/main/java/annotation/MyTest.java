package annotation;

public class MyTest {
	@RetentionTest(hello = "beijing", world = "shanghai")
	@Deprecated
	@SuppressWarnings("unchecked")
	public void output() {
		System.out.println("output");
	}
}