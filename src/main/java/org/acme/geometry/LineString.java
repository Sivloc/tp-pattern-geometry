package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

	private List<Point> points;

	public LineString() {
		this.points = new ArrayList<>();
	}

	public LineString(List<Point> points) {
		if (points != null) {
			this.points = points;
		} else {
			this.points = new ArrayList<>();
		}
	}

	public int getNumPoints() {
		return points.size();
	}

	public Point getPointN(int n) {
		return points.get(n);
	}

	public String getType() {
		return "LineString";
	}

	public boolean isEmpty() {
		for (Point p : this.points) {
			if (!p.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public void translate(double dx, double dy) {
		for (Point p : this.points) {
			p.translate(dx, dy);
		}
	}

	public Geometry clone() {
		return new LineString(this.points);
	}
}
