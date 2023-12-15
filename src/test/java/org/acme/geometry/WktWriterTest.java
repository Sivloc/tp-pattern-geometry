package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void test() {
		//////// WktWriter
		Point p = new Point();
		Point p2 = SampleGeometryFactory.createPointO();
		p2.translate(3.0, 9.2);
		LineString ls = SampleGeometryFactory.createLineStringOA();
		LineString ls2 = new LineString();
		WktWriter writer = new WktWriter();
		Assert.assertEquals(writer.write(p2), "POINT(3.0 9.2)");
		Assert.assertEquals(writer.write(p), "POINT EMPTY");
		Assert.assertEquals(writer.write(ls2), "LINESTRING EMPTY");
		Assert.assertEquals(writer.write(ls), "LINESTRING(0.0 0.0,3.0 4.0)");
	}

}
