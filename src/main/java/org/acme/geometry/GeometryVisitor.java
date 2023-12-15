package org.acme.geometry;

public interface GeometryVisitor {

	public void visit(Point point);

	public void visit(LineString LineString);

}
