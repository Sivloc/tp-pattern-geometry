package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertEquals(3.0, c.getX(), EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
        Assert.assertEquals("[3.0,4.0]", c.toString());
        Coordinate c2 = new Coordinate();
        Assert.assertTrue(c2.isEmpty());
        Coordinate c3 = new Coordinate(3.0,Double.NaN);
        Assert.assertTrue(c3.isEmpty());
        Assert.assertEquals("[NaN,NaN]",c2.toString());
	}

}
