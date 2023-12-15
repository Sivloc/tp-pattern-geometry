package org.acme.geometry;

public class WktWriter {
	public String write(Geometry geometry) {
		if (geometry instanceof Point) {
			Point point = (Point) geometry;
			if (point.isEmpty()) {
				return "POINT EMPTY";
			}
			return "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
		} else if (geometry instanceof LineString) {
			LineString lineString = (LineString) geometry;
			if (lineString.isEmpty()) {
				return "LINESTRING EMPTY";
			}
			String result = "LINESTRING(";
			for (int i = 0; i < lineString.getNumPoints(); i++) {
				result += lineString.getPointN(i).getCoordinate().getX() + " "
						+ lineString.getPointN(i).getCoordinate().getY() + ",";
			}
			result = result.substring(0, result.length() - 1);
			result += ")";
			return result;
		} else {
			throw new RuntimeException("geometry type not supported");
		}
	}
}
