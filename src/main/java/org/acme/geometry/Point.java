package org.acme.geometry;

public class Point extends AbstractGeometry {

	private Coordinate coordinate;

	public Point() {
		this.coordinate = new Coordinate();
	}

	public Point(Coordinate coordinate) {
		if (coordinate != null) {
			this.coordinate = coordinate;
		} else {
			this.coordinate = new Coordinate();
		}
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public String getType() {
		return "Point";
	}

	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
	}

	public Geometry clone() {
		return new Point(this.getCoordinate());
	}

	@Deprecated
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(getCoordinate());
		return builder.build();
	}

	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
