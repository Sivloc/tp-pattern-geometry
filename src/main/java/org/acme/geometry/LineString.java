package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

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
		List<Point> list = new ArrayList<Point>();
		for (Point p : points) {
			list.add((Point) p.clone());
		}
		return new LineString(list);
	}

	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		for (Point p : this.points) {
			builder.insert(p.getCoordinate());
		}
		return builder.build();
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
