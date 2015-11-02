package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class NewShape implements Shape, Cloneable {

	private Point position;
	private Color inColor;
	private Color outColor;
	private Map<String, Double> properties = new HashMap<>();

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		this.position = position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub

		return this.position;
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub

		return this.properties;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		this.properties=properties;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.outColor = color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub

		return this.outColor;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		this.inColor = color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.inColor;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Map<String, Double> propertiesNew ;
		MyClassLoader loadJar = new MyClassLoader();
		Shape newShape = loadJar.reflectionShape(this.getClass().getName().replaceAll("eg.edu.alexu.csd.oop.draw.",""));
		Point newPoint = new Point(this.getPosition());
		System.out.println(this.getPosition());
		propertiesNew= new HashMap<>();
		propertiesNew = this.getProperties();
		Color newColor = this.getColor();
		newShape.setColor(newColor);
		Color newFillColor = this.getFillColor();
		newShape.setFillColor(newFillColor);
		System.out.println(propertiesNew);
		newShape.setPosition(newPoint);
		newShape.setProperties(propertiesNew);
		
		return newShape;
	}

}
	