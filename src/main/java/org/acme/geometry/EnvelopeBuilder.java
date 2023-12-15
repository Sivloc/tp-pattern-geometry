package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
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
}
