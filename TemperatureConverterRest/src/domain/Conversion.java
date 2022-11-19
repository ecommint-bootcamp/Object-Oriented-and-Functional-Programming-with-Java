package domain;

import java.time.Instant;

public class Conversion {

	static int counter;
	private int convertId;
	{
		convertId = ++counter;
	}
	private String from;
	private String to;
	private double fromTemperature;
	private double toTemperature;
	private Instant convertDate;

	public Conversion() {

	}

	public Conversion(String from, String to, double fromTemperature, double toTemperature) {
		this.from = from;
		this.to = to;
		this.fromTemperature = fromTemperature;
		this.toTemperature = toTemperature;
		convertDate = Instant.now();
	}

	public int getConvertId() {
		return convertId;
	}

	public void setConvertId(int convertId) {
		this.convertId = convertId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getFromTemperature() {
		return fromTemperature;
	}

	public void setFromTemperature(double fromTemperature) {
		this.fromTemperature = fromTemperature;
	}

	public double getToTemperature() {
		return toTemperature;
	}

	public void setToTemperature(double toTemperature) {
		this.toTemperature = toTemperature;
	}

	public Instant getConvertDate() {
		return convertDate;
	}

	public void setConvertDate(Instant convertDate) {
		this.convertDate = convertDate;
	}

}
