
import java.io.File;
import java.time.LocalDate;
import java.util.List;

import cookie.CookieHandler;
import services.Input;

public class Application {

	public static void main(String[] args) {
		Input.parseCliInput(args);
		File cookieFile = new File(args[0]);
		String date = args[2];
		CookieHandler cookieHandler = new CookieHandler();

		cookieHandler.createCookieMap(cookieFile);
		List<String> mostActiveCookies = cookieHandler.getActiveCookies(LocalDate.parse(date));
		mostActiveCookies.forEach((cookie) -> {
			System.out.println(cookie);
		});
	}
}
