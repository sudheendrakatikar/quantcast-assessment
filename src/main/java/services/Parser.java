package services;
import java.time.LocalDate;
import java.time.LocalTime;

import models.Timestamp;

public class Parser {

	public String[] parseLine(String line) {
		return line.split(",");
	}

	public Timestamp parseTimestamp(String timestampStr) {
		String[] tokens = timestampStr.split("T");
		LocalDate date = LocalDate.parse(tokens[0]);
		LocalTime time = LocalTime.parse(tokens[1].split("\\+")[0]);
		Timestamp timestamp = new Timestamp(date, time);
		return timestamp;
	}
}
