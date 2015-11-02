 package eg.edu.alexu.csd.oop.draw;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class XmlRead{

	public Shape[] readXml(String savingPath) {
		
		Shape [] shapesLoaded = null;
		
		 try {

				File fXmlFile = new File(savingPath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
						
				doc.getDocumentElement().normalize();
						
				NodeList nList = doc.getElementsByTagName("Shapes");

				for (int i = 0; i < nList.getLength(); i++) {

					Node nNode = nList.item(i);
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						MyClassLoader loadJar = new MyClassLoader();
						String classLoaded = eElement.getAttribute("id").substring(32);
						shapesLoaded[i] = loadJar.reflectionShape(classLoaded);
						String x = eElement.getElementsByTagName("X Position").item(0).getTextContent();
						String y = eElement.getElementsByTagName("Y Position").item(0).getTextContent();
						shapesLoaded[i].setPosition(new Point(Integer.parseInt(x), Integer.parseInt(y)));
						String In = eElement.getElementsByTagName("In Color").item(0).getTextContent();
						shapesLoaded[i].setFillColor(Color.decode(In));
						String Out = eElement.getElementsByTagName("Out Color").item(0).getTextContent();
						shapesLoaded[i].setFillColor(Color.decode(Out));
						
						Map<String, Double> propertiesLoaded = new HashMap<>();
						
						Set<String> keys = shapesLoaded[i].getProperties().keySet();
						
						for (String S : keys) {
							String str = eElement.getElementsByTagName(S).item(0).getTextContent();
							propertiesLoaded.put(S, Double.valueOf(str));
						}
						
						shapesLoaded[i].setProperties(propertiesLoaded);
					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		
		return shapesLoaded;
	}

}
