 package eg.edu.alexu.csd.oop.draw;


import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 

 

public class TestD {
	//@Test

        public void testAddAndGet() {
		Engine e = Engine.getInstance();
		Circle c = new Circle();
		Square s = new Square();
		Rectangle r = new Rectangle();
		Map<String, Double> properties = new HashMap<>();

		c.setPosition(new Point(100, 100));
		properties = c.getProperties();
		properties.put("Radius", 100.0);
		c.setProperties(properties);

		s.setPosition(new Point(200, 200));
		properties.clear();
		properties = c.getProperties();
		properties.put("Side Length", 150.0);
		s.setProperties(properties);

		r.setPosition(new Point(300, 300));
		properties.clear();
		properties = c.getProperties();
		properties.put("Length", 150.0);
		properties.put("Width", 100.0);
		r.setProperties(properties);

		e.addShape(c);
		e.addShape(s);
		e.addShape(r);
		Shape[] array = { c, s, r };
	Assert.assertArrayEquals(array, e.getShapes());

	}

	  

		//@Test
		public void testAddRemove() {
			Engine e = Engine.getInstance();
			Circle c = new Circle();
			Square s = new Square();
			Rectangle r = new Rectangle();
			Map<String, Double> properties = new HashMap<>();

			c.setPosition(new Point(100, 100));
			properties = c.getProperties();
			properties.put("Radius", 100.0);
			c.setProperties(properties);

			s.setPosition(new Point(200, 200));
			properties.clear();
			properties = c.getProperties();
			properties.put("Side Length", 150.0);
			s.setProperties(properties);

			r.setPosition(new Point(300, 300));
			properties.clear();
			properties = c.getProperties();
			properties.put("Length", 150.0);
			properties.put("Width", 100.0);
			r.setProperties(properties);

			e.addShape(c);
			e.addShape(s);
			e.addShape(r);
			e.removeShape(s);
			e.removeShape(c);
			e.removeShape(r);
			Shape[] array = {};
			Assert.assertArrayEquals(array, e.getShapes());

		}
	//	@Test
		public void testaddUpdate() {
			Engine e = Engine.getInstance();
			Circle c = new Circle();
			Circle c2 = new Circle();
			Square s = new Square();
			Square s2 = new Square();
			Rectangle r = new Rectangle();
			Map<String, Double> properties = new HashMap<>();

			c.setPosition(new Point(100, 100));
			properties = c.getProperties();
			properties.put("Radius", 100.0);
			c.setProperties(properties);
			
			c2.setPosition(new Point(100, 100));
			properties.clear();
			properties = c2.getProperties();
			properties.put("Radius", 50.0);
			c2.setProperties(properties);

			s.setPosition(new Point(200, 200));
			properties.clear();
			properties = c.getProperties();
			properties.put("Side Length", 150.0);
			s.setProperties(properties);
			
			s2.setPosition(new Point(250, 250));
			properties.clear();
			properties = c.getProperties();
			properties.put("Side Length", 300.0);
			s2.setProperties(properties);

			r.setPosition(new Point(300, 300));
			properties.clear();
			properties = c.getProperties();
			properties.put("Length", 150.0);
			properties.put("Width", 100.0);
			r.setProperties(properties);

			e.addShape(c);
			e.addShape(s);
			e.addShape(r);
		 e.updateShape(c, c2);
		 e.updateShape(s, s2);
			Shape[] array = {c2,s2,r};
			Assert.assertArrayEquals(array, e.getShapes());

		}
		@Test
		public void testupdateUndo() {
			Engine e = Engine.getInstance();
			Circle c = new Circle();
			Circle c2 = new Circle();
			Square s = new Square();
			Square s2 = new Square();
			Rectangle r = new Rectangle();
			Map<String, Double> properties ;

			c.setPosition(new Point(100, 100));
			properties = new HashMap<>();
			properties.put("Radius", 100.0);
			c.setProperties(properties);
			
			c2.setPosition(new Point(100, 100));
			properties = new HashMap<>();
			properties.put("Radius", 50.0);
			c2.setProperties(properties);
		 

			s.setPosition(new Point(200, 200));
			properties = new HashMap<>();
			properties.put("SideLength", 150.0);
			s.setProperties(properties);
	 	
			s2.setPosition(new Point(250, 250));
			properties = new HashMap<>();
			properties = s2.getProperties();
			properties.put("SideLength", 300.0);
			s2.setProperties(properties);

			r.setPosition(new Point(300, 300));
			properties = new HashMap<>();
			properties.put("Length", 150.0);
			properties.put("Width", 100.0);
			r.setProperties(properties);

			e.addShape(c);
			e.addShape(s);
			e.addShape(r);
			e.updateShape(c, c2);
			e.updateShape(s, s2);
			/*e.addShape(s);
			e.addShape(r);
		 e.updateShape(c, c2);
		 e.updateShape(s, s2);
			Shape[] array = {c2,s2,r};
			Assert.assertArrayEquals(array, e.getShapes());*/
			Shape[] array2=e.getShapes();
			System.out.println(array2.length);
			double d =array2[0].getProperties().get("Radius");
			double d2 =array2[1].getProperties().get("SideLength");
			double d3 =array2[2].getProperties().get("Length");
			double d4 =array2[2].getProperties().get("Width");
			//double d5 =array2[3].getProperties().get("Width");
		 System.out.println(d); System.out.println(d2);System.out.println(d3);System.out.println(d4);
		 System.out.println(r.getProperties());
		 System.out.println(s2.getProperties());
		 e.undo();
		// System.out.println(e.getShapes());
		 System.out.println(s.getProperties());
		 Shape[] array=e.getShapes();
		 Shape[] array3 = {c2,s,r};
			Assert.assertArrayEquals(array3, array);
			System.out.println(array.length);
			double a =array[0].getProperties().get("Radius");
			double a2 =array[1].getProperties().get("SideLength");
			double a3 =array[2].getProperties().get("Length");
			double a4 =array[2].getProperties().get("Width");
			System.out.println(a); System.out.println(a2);System.out.println(a3);System.out.println(a4);
			//double d = s.getProperties().get("Side Length");
		
			/*e.undo();
			Shape[] array2={c2,s,r};
			Assert.assertArrayEquals(array2, e.getShapes());
			Assert.assertEquals(new Point(100, 100), c2.getPosition());*/
			
		}

		 
		public void initialize() {
			Engine.destoryInstance();
		}

		@Before
		public void initialize2() {
			History.destoryInstance();
		}
	
}
