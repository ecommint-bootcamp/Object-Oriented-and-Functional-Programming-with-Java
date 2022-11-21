package temperatureconverter.domain;

import java.time.Instant;

public class Conversion {
	private static int count;
	private int id;

	{
		id = ++count;
	}

	private Temperature sourceTemperature;
	private Temperature targetTemperature;

	private double sourceAmount;
	private double targetAmount;

	private Instant date;

	public Conversion() {

	}

	public Conversion(Temperature sourceTemperature, Temperature targetTemperature, double sourceAmount) {
		this.sourceTemperature = sourceTemperature;
		this.targetTemperature = targetTemperature;
		this.sourceAmount = sourceAmount;
		date = Instant.now();
	}

	public Conversion(Temperature sourceTemperature, Temperature targetTemperature, double sourceAmount, double targetAmount) {
		this.sourceTemperature = sourceTemperature;
		this.targetTemperature = targetTemperature;
		this.sourceAmount = sourceAmount;
		this.targetAmount = targetAmount;
		date = Instant.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Temperature getSourceTemperature() {
		return sourceTemperature;
	}

	public void setSourceTemperature(Temperature sourceTemperature) {
		this.sourceTemperature = sourceTemperature;
	}

	public Temperature getTargetTemperature() {
		return targetTemperature;
	}

	public void setTargetTemperature(Temperature targetTemperature) {
		this.targetTemperature = targetTemperature;
	}

	public double getSourceAmount() {
		return sourceAmount;
	}

	public void setSourceAmount(double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Conversion [Source temperature=" + sourceTemperature + ", Target temperature=" + targetTemperature + ", sourceAmount="
				+ sourceAmount + ", Target amount=" + targetAmount + ", Date=" + date + "]";
	}
}
