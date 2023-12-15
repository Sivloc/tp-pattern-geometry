package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {

	@Test
	public void test() {
		Point p = SampleGeometryFactory.createPointA();
		LineString ls = SampleGeometryFactory.createLineStringOA();
		Assert.assertEquals(p.asText(), "POINT(3.0 4.0)");
		Assert.assertEquals(ls.asText(), "LINESTRING(0.0 0.0,3.0 4.0)");
		Point emptyp = new Point();
		LineString emptyls = new LineString();
		Assert.assertEquals(emptyp.asText(), "POINT EMPTY");
		Assert.assertEquals(emptyls, "LINESTRING EMPTY");
		
	}

}
