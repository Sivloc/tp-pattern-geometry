package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void test() {
		//////// WktVisitor
		WktVisitor wvisitor = new WktVisitor();
		Geometry geometry = SampleGeometryFactory.createPointA();
		geometry.accept(wvisitor);
		Assert.assertEquals("POINT(3.0 4.0)", wvisitor.getResult());
		geometry = new Point();
		wvisitor = new WktVisitor();
		geometry.accept(wvisitor);
		Assert.assertEquals("POINT EMPTY", wvisitor.getResult());
		geometry = new LineString();
		wvisitor = new WktVisitor();
		geometry.accept(wvisitor);
		Assert.assertEquals("LINESTRING EMPTY", wvisitor.getResult());
		geometry = SampleGeometryFactory.createLineStringOA();
		wvisitor = new WktVisitor();
		geometry.accept(wvisitor);
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wvisitor.getResult());
	}

}
