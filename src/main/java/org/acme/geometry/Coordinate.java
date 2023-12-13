package org.acme.geometry;

public class Coordinate {
	
	private double x,y;
	
	public Coordinate() {
		this.x = Double.NaN;
		this.y = Double.NaN;
	}
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public boolean isEmpty() {
		return Double.isNaN(x) || Double.isNaN(y);
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}
