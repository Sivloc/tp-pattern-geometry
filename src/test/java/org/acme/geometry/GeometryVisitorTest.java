package org.acme.geometry;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class GeometryVisitorTest {

	@Test
	public void test() throws UnsupportedEncodingException {
		////////GeometryVisitor
		Point p = new Point();
		LineString ls = new LineString();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = SampleGeometryFactory.createPointA();
		geometry.accept(visitor);
		String results = os.toString("UTF8");
		Assert.assertEquals(results, "Je suis un point avec x=3.0 et y=4.0.");
		os = new ByteArrayOutputStream();
		out = new PrintStream(os);
		visitor = new LogGeometryVisitor(out);
		p.accept(visitor);
		results = os.toString("UTF8");
		Assert.assertEquals("Je suis un point vide.", results);
		os = new ByteArrayOutputStream();
		out = new PrintStream(os);
		visitor = new LogGeometryVisitor(out);
		ls.accept(visitor);
		results = os.toString("UTF8");
		results = os.toString("UTF8");
		Assert.assertEquals("Je suis une polyligne vide.", results);
		geometry = SampleGeometryFactory.createLineStringOA();
		os = new ByteArrayOutputStream();
		out = new PrintStream(os);
		visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		results = os.toString("UTF8");
		results = os.toString("UTF8");
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s).", results);
	}

}
