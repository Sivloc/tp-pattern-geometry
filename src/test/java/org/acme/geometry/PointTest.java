package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	///////// Point
	public void testConstructorPoint() {
		Point p = new Point();
		Assert.assertEquals("[NaN,NaN]", p.getCoordinate().toString());
		Coordinate c = new Coordinate(3.0, 4.0);
		Point p2 = new Point(c);
		Assert.assertEquals("[3.0,4.0]", p2.getCoordinate().toString());
		Assert.assertEquals("Point", p.getType());
		///////// LineString
		Coordinate c2 = new Coordinate(8.0, 9.0);
		Point p3 = new Point(c2);
		List<Point> list = new ArrayList<Point>();
		list.add(p2);
		list.add(p3);
		LineString ls = new LineString(list);
		Assert.assertEquals("LineString", ls.getType());
		Assert.assertEquals(2, ls.getNumPoints());
		Assert.assertEquals(p2, ls.getPointN(0));
		LineString ls2 = new LineString();
		Assert.assertEquals(0, ls2.getNumPoints());
		///////// IsEmpty
		Assert.assertTrue(p.isEmpty());
		List<Point> list2 = new ArrayList<Point>();
		list2.add(p);
		list2.add(p);
		LineString ls3 = new LineString(list2);
		Assert.assertTrue(ls3.isEmpty());
		Assert.assertFalse(ls.isEmpty());
		LineString ls4 = new LineString(null);
		Assert.assertTrue(ls4.isEmpty());
		Point p4 = new Point(null);
		Assert.assertTrue(p4.isEmpty());
		//////// Translate
		p2.translate(2.0, 1.0);
		Assert.assertEquals("[5.0,5.0]", p2.getCoordinate().toString());
		ls.translate(-2.0, 4.2);
		Assert.assertEquals("[6.0,13.2]", ls.getPointN(1).getCoordinate().toString());
		//////// Clone
		Geometry p2copy = p2.clone();
		p2copy.translate(10, 10);
		Assert.assertNotEquals(p2, p2copy);
		Geometry lscopy = ls.clone();
		lscopy.translate(-10, -10);
		Assert.assertNotEquals(ls, lscopy);
		//////// Envelope & EnvelopeBuilder
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0, 1.0));
		builder.insert(new Coordinate(2.0, 0.0));
		builder.insert(new Coordinate(1.0, 3.0));
		Envelope result = builder.build();
		Assert.assertEquals("0.0,0.0,2.0,3.0", result.toString());
		Envelope empty = new Envelope();
		Assert.assertTrue(empty.isEmpty());
		//////// Envelope Facade
		Assert.assertEquals("3.0,9.2,3.0,9.2", p2.getEnvelope().toString());
		Assert.assertEquals("3.0,9.2,6.0,13.2", ls.getEnvelope().toString());
	}
}
