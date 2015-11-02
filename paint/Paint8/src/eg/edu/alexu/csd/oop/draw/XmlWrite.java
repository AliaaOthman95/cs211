package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWrite{

	public void writeXml(String savingPath , Shape[] shapes ) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("SavedShapes");
		doc.appendChild(rootElement);
		for (int i = 0; i < shapes.length; i++) {
			Element staff = doc.createElement("Shape");
			rootElement.appendChild(staff);
			
			Attr attr = doc.createAttribute("id");
			attr.setValue(shapes[i].getClass().toString());
			staff.setAttributeNode(attr);
			
			Element xPos = doc.createElement("XPosition");
			xPos.appendChild(doc.createTextNode(Integer.toString(shapes[i].getPosition().x)));
			staff.appendChild(xPos);
			
			Element yPos = doc.createElement("YPosition");
			yPos.appendChild(doc.createTextNode(Integer.toString(shapes[i].getPosition().y)));
			staff.appendChild(yPos);
			
			Element inCol = doc.createElement("InColor");
			String rgbIn = Integer.toHexString(shapes[i].getFillColor().getRGB());
			//rgbIn = rgbIn.substring(2, rgbIn.length());
			inCol.appendChild(doc.createTextNode(rgbIn));
			staff.appendChild(inCol);
			
			Element outCol = doc.createElement("OutColor");
			String rgbOut = Integer.toHexString(shapes[i].getColor().getRGB());
			//rgbOut = rgbOut.substring(2, rgbOut.length());
			outCol.appendChild(doc.createTextNode(rgbOut));
			staff.appendChild(outCol);
			
            String[] keys = new String[shapes[i].getProperties().size()];
            Double[] values = new Double[shapes[i].getProperties().size()];
            shapes[i].getProperties().keySet().toArray(keys);
    		shapes[i].getProperties().values().toArray(values);
            for (int j = 0; j < values.length; j++) {
                Element  property = doc.createElement(keys[j].replaceAll(" ", ""));
                if(values[j] == null) continue;
                property.appendChild(doc.createTextNode(Double.toString(values[j])));
                staff.appendChild(property);
			}
		}
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(savingPath));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("File saved!");

	}

}
