package org.acme.geometry;

public class Envelope {
	private Coordinate bottomLeft, topRight;

	public Envelope() {
		this.bottomLeft = new Coordinate();
		this.topRight = new Coordinate();
	}

	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	public boolean isEmpty() {
		return (this.bottomLeft.isEmpty() || this.topRight.isEmpty());
	}

	public double getXmin() {
		return this.bottomLeft.getX();
	}

	public double getYmin() {
		return this.bottomLeft.getY();
	}

	public double getXmax() {
		return this.topRight.getX();
	}

	public double getYmax() {
		return this.topRight.getY();
	}

	public String toString() {
		return getXmin() + "," + getYmin() + "," + getXmax() + "," + getYmax();
	}
}
