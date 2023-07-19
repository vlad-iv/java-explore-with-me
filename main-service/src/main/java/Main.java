import java.io.PrintWriter;
import java.io.StringWriter;

import ewm.client.StatClient;

public class Main {
	/// user-category-event-request-compilation
	public static void main(String[] args) {

		// 1. user->
		// 2. category->
		// 3. event->
		// 4. request->
		// 5. compilation

		// CONSTRAINT UQ_USER_EMAIL UNIQUE (email)
		Exception ex = new Exception();
		StatClient statClient = new StatClient();
		statClient.
				//Корректно
				StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
		String error = stringWriter.toString();
		System.out.println(error);
	}
}
