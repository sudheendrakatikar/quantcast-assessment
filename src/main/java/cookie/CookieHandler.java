package cookie;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import models.Cookie;
import services.Parser;

public class CookieHandler {

	private HashMap<LocalDate, HashMap<String, ArrayList<LocalTime>>> cookieMap;
	private HashMap<LocalDate, ArrayList<Cookie>> activeCookieMap;

	private Parser parser;

	public CookieHandler() {
		this.cookieMap = new HashMap<LocalDate, HashMap<String, ArrayList<LocalTime>>>();
		this.activeCookieMap = new HashMap<LocalDate, ArrayList<Cookie>>();
		this.parser = new Parser();
	}

	public HashMap<LocalDate, HashMap<String, ArrayList<LocalTime>>> getCookieMap() {
		return cookieMap;
	}

	public HashMap<LocalDate, ArrayList<Cookie>> getActiveCookieMap() {
		return activeCookieMap;
	}

	public void createCookieMap(File cookieFile) {
		Scanner scanner;
		try {
			scanner = new Scanner(cookieFile);
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] tokens = parser.parseLine(scanner.nextLine());
				Cookie cookie = new Cookie(tokens[0], parser.parseTimestamp(tokens[1]));
				addCookie(cookie);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void addCookie(Cookie cookie) {
		String id = cookie.getId();
		LocalDate date = cookie.getTimestamp().getDate();
		LocalTime time = cookie.getTimestamp().getTime();

		if (!cookieMap.containsKey(date))
			cookieMap.put(date, new HashMap<String, ArrayList<LocalTime>>());

		HashMap<String, ArrayList<LocalTime>> dateMap = cookieMap.get(date);
		if (!dateMap.containsKey(id))
			dateMap.put(id, new ArrayList<LocalTime>());

		ArrayList<LocalTime> timestamp = dateMap.get(id);
		timestamp.add(time);
	}

	public ArrayList<String> getActiveCookies(LocalDate date) {
		ArrayList<String> activeCookies = new ArrayList<String>();
		HashMap<String, ArrayList<LocalTime>> dateMap = cookieMap.get(date);
		long count = Long.MIN_VALUE;
		for (Entry<String, ArrayList<LocalTime>> entry : dateMap.entrySet()) {
			long tsLength = entry.getValue().size();
			if (tsLength > count) {
				activeCookies.clear();
				activeCookies.add(entry.getKey());
				count = tsLength;
			} else if (entry.getValue().size() == count) {
				activeCookies.add(entry.getKey());
			}
		}
		return activeCookies;
	}
}
