import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {
	/// user-category-event-request-compilation
	public static void main(String[] args) {
		Exception ex = new Exception();

		//Корректно
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
		String error = stringWriter.toString();
		System.out.println(error);
	}
}
