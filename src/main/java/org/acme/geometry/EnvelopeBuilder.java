package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
	private List<Coordinate> coords;

	public EnvelopeBuilder() {
		this.coords = new ArrayList<Coordinate>();
	}

	public void insert(Coordinate coordinate) {
		this.coords.add(coordinate);
	}

	public Envelope build() {
		List<Double> xlist = new ArrayList<Double>();
		List<Double> ylist = new ArrayList<Double>();
		for (Coordinate coord : coords) {
			xlist.add(coord.getX());
			ylist.add(coord.getY());
		}
		Coordinate BL = new Coordinate(Collections.min(xlist), Collections.min(ylist));
		Coordinate TR = new Coordinate(Collections.max(xlist), Collections.max(ylist));
		return new Envelope(BL, TR);
	}

	@Override
	public void visit(Point point) {
		insert(point.getCoordinate());
	}

	@Override
	public void visit(LineString LineString) {
		for (int i=0;i<LineString.getNumPoints();i++) {
			insert(LineString.getPointN(i).getCoordinate());
		}
	}

	public void visit(AbstractGeometry abstractGeometry) {
		
	}
}
