package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	@Test
	public void test() {
		
		//////// Envelope & EnvelopeBuilder
		Point p = SampleGeometryFactory.createPointO();
		p.translate(3.0, 9.2);
		LineString ls = SampleGeometryFactory.createLineStringOA();
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		Envelope result = builder.build();
		Assert.assertEquals("0.0,0.0,2.0,3.0", result.toString());
		Envelope empty = new Envelope();
		Assert.assertTrue(empty.isEmpty());
		
		//////// Envelope Facade
		
		Assert.assertEquals("3.0,9.2,3.0,9.2", p.getEnvelope().toString());
		Assert.assertEquals("0.0,0.0,3.0,4.0", ls.getEnvelope().toString());
	}

}
