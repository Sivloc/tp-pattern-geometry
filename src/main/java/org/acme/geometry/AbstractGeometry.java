package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
	

	public String asText() {
		WktVisitor wvisitor = new WktVisitor();
		wvisitor.visit(this);
		return wvisitor.getResult();
	}

	@Override
	public Geometry clone() {
		return this;
	}

}
