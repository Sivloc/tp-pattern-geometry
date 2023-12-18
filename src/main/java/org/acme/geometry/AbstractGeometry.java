package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
	

	public String asText() {
		WktVisitor wvisitor = new WktVisitor();
		accept(wvisitor);
		return wvisitor.getResult();
	}

	@Override
	public Geometry clone() {
		return this;
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.visit(this);
		return builder.build();
	}

}
