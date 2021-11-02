import java.io.File;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import cookie.CookieHandler;

public class ActiveCookieTest {

	File testFile;
	CookieHandler cookieHandler;

	public ActiveCookieTest() {
		this.testFile = new File("src/test/resources/cookie_log.csv");
		this.cookieHandler = new CookieHandler();
	}

	static Stream<Arguments> generateTestData() {
		return Stream.of(Arguments.of("2018-12-09", Arrays.asList("AtY0laUfhglK3lC7")),
				Arguments.of("2018-12-08", Arrays.asList("SAZuXPGUrfbcn5UA", "4sMM2LxV07bPJzwf", "fbcn5UAVanZf6UtG")));
	}

	@BeforeEach
	void setup() throws URISyntaxException {
		this.cookieHandler.createCookieMap(testFile);
	}

	@ParameterizedTest
	@MethodSource("generateTestData")
	@DisplayName("Most active cookie(s) test")
	public void sampleTest(String date, List<String> expectedActiveCookies) {
		List<String> actualActiveCookies = cookieHandler.getActiveCookies(LocalDate.parse(date));
		// Use CollectionUtils form Apache Commons to compare 2 lists regardless of
		// order
		Assertions.assertEquals(CollectionUtils.getCardinalityMap(expectedActiveCookies),
				CollectionUtils.getCardinalityMap(actualActiveCookies));
	}

}
