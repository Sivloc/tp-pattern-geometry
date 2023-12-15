package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer;

	public WktVisitor() {
		this.buffer = new StringBuilder();
	}

	@Override
	public void visit(Point point) {
		if (point.isEmpty()) {
			buffer.append("POINT EMPTY");
		} else {
			buffer.append("POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")");
		}
	}

	@Override
	public void visit(LineString LineString) {
		if (LineString.isEmpty()) {
			buffer.append("LINESTRING EMPTY");
		} else {
			buffer.append("LINESTRING(");
			for (int i = 0; i < LineString.getNumPoints(); i++) {
				buffer.append(LineString.getPointN(i).getCoordinate().getX() + " "
						+ LineString.getPointN(i).getCoordinate().getY() + ",");
			}
			buffer.deleteCharAt(buffer.length()-1);
			buffer.append(")");
		}
	}

	public String getResult() {
		return buffer.toString();
	}
}
