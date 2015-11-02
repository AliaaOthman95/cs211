package eg.edu.alexu.csd.oop.draw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Element;

public class WriteJson {
	
	public void writeJson(String savingPath , Shape[] shapes ) {
		
		File file = new File(savingPath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
		bw.write("{");
		bw.newLine();
		bw.write("      \"SavedShapes\" :");//6 spaces
		bw.newLine();
		bw.write("                         [");
		bw.newLine();
		for (int i = 0; i < shapes.length; i++) {
			    bw.write("                            {");
			    bw.newLine();
				bw.write("                            \"shape\": \"" + shapes[i].getClass().toString() + "\",");
				bw.newLine();
				bw.write("                            \"XPosition\": \"" + Integer.toString(shapes[i].getPosition().x) + "\",");
				bw.newLine();
				bw.write("                            \"YPosition\": \"" + Integer.toString(shapes[i].getPosition().y) + "\",");
				bw.newLine();
				String rgbIn = Integer.toHexString(shapes[i].getFillColor().getRGB());
				//rgbIn = rgbIn.substring(2, rgbIn.length());
				bw.write("                            \"InColor\": \"" + rgbIn + "\",");
				bw.newLine();
				String rgbOut = Integer.toHexString(shapes[i].getColor().getRGB());
				//rgbOut = rgbOut.substring(2, rgbOut.length());
				bw.write("                            \"OutColor\": \"" + rgbOut + "\",");
				bw.newLine();
				int count = 0;
			
				String[] keys = new String[shapes[i].getProperties().size()];
				Double[] values = new Double[shapes[i].getProperties().size()];
				int index = 0;
				for (Entry<String, Double> mapEntry : shapes[i].getProperties().entrySet()) {
				    keys[index] = mapEntry.getKey();
				    values[index] = mapEntry.getValue();
				    index++;
				}
				
				for (int j = 0; j < values.length; j++) {
					System.out.println(keys[j]);
					System.out.println(values[j]);
				}
	    		
	    		 for (int j = 0; j < values.length; j++) {
	    			 
	    			 if(count == shapes[i].getProperties().size()-1){
	    				 bw.write("                            \"" + keys[j].replaceAll(" ", "") + "\": ");
	    				 if(values[j] != null){
	    				 bw.write("\""+ Double.toString(values[j]) + "\"");
	    				 }
	    			 }else{
	    				 bw.write("                            \"" + keys[j].replaceAll(" ", "") + "\": ");
	    				 if(values[j] != null){
	    				 bw.write("\""+ Double.toString(values[j]) + "\",");
	    				 }
	    			 }
	    			 bw.newLine();
	    			 count++;
	   			}
	    		    if(i == shapes.length -1){
	    		    	bw.write("                            }");
	    		    }else{
	    		    bw.write("                            },");
	    		    }
	    			bw.newLine();
			} 
		bw.write("                         ]");
		bw.newLine();
		bw.write("}");
		bw.close();	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
