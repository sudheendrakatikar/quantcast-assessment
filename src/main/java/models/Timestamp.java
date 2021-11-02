package models;
import java.time.LocalDate;
import java.time.LocalTime;

public class Timestamp {
	
	private LocalDate date;
	private LocalTime time;
	
	public Timestamp(LocalDate date, LocalTime time) {
		super();
		this.date = date;
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Timestamp [date=" + date + ", time=" + time + "]";
	}
	
}
