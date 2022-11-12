package tempconverter.domain;

import java.time.Instant;

public class Conversion {
	
	static int count;
	
	private int id;
	{
		id = ++count;
	}
	
	private String source;
	private String target;
	private double sourceTemperature;
	private double targetTemperature;
	private Instant date;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public double getSourceTemperature() {
		return sourceTemperature;
	}

	public void setSourceTemperature(double sourceTemperature) {
		this.sourceTemperature = sourceTemperature;
	}

	public double getTargetTemperature() {
		return targetTemperature;
	}

	public void setTargetTemperature(double targetTemperature) {
		this.targetTemperature = targetTemperature;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Conversion(String source, String target, double sourceTemperature, double targetTemperature) {
		this.source = source;
		this.target = target;
		this.sourceTemperature = sourceTemperature;
		this.targetTemperature = targetTemperature;
		date = Instant.now();
	}
}
