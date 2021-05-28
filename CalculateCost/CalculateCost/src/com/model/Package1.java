package com.model;

public class Package1 {
	
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private double basicFare;
	private int onOfDays;
	private double packageCost;
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public int getOnOfDays() {
		return onOfDays;
	}
	public void setOnOfDays(int onOfDays) {
		this.onOfDays = onOfDays;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	public Package1(String packageId, String sourcePlace, String destinationPlace, double basicFare, int onOfDays,
			double packageCost) {
		super();
		this.packageId = packageId;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.basicFare = basicFare;
		this.onOfDays = onOfDays;
		this.packageCost = packageCost;
	}
	
	

}
