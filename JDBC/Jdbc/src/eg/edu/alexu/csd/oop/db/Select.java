package eg.edu.alexu.csd.oop.db;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.util.LinkedList;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;






public class Select {
	String [] tagsName;
	LinkedList<LinkedList<Object>> selectAll(String database ,String tableName,String conditionTag,String condition,Object value,String path){
		try{
			LinkedList<LinkedList<Object>> returnValues = new LinkedList<LinkedList<Object>>();
			if(path==null){
				String s = new File(this.getClass().getName()).getAbsolutePath().replaceAll((this.getClass().getName()), "");
				s = s.substring(0, s.length() - 1);
				path=s;
			}

	         File inputFile = new File(path+"/"+database+"/"+tableName+".xml");
	         
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("row");
	         getTagsName(database,tableName,path);
	        
	         for (int row = 0; row < nList.getLength(); row++) {
	        	 LinkedList<Object> temp=new LinkedList<Object>();
	        	 Node Node = nList.item(row);
	        	 Element eElement =  (Element) Node;
	        	 NodeList childs=eElement.getChildNodes();
	        	 for(int i =0;i<tagsName.length;i++){
	        		 String target =getNodeValue(tagsName[i], childs);
	        		 
	        		 if(condition==null){
		        		 if(!target.contains("'")){
		        			 temp.add(Integer.parseInt(target));
		        		 }else{
		        			 temp.add(target);
		        		 }
	        		 }else{
	        			 condition=condition.replace(" ", "");
	        			 String conditionValue =getNodeValue(conditionTag, childs);
	        			 if(conditionValue.contains("'")){
	        				 if(conditionValue.equals((String)value)&&condition.equals("=")){
	        					 if(!target.contains("'")){
	    		        			 temp.add(Integer.parseInt(target));
	    		        		 }else{
	    		        			 temp.add(target);
	    		        		 }
	        				 }
	        				 
	        			 }else{
	        				 conditionValue= conditionValue.replace("'", "");	
	        				 
	        				 int conditionIntValue=Integer.valueOf((String)conditionValue); 
	        				 int compareIntValue =Integer.valueOf((String)value);
	        				
	        				 condition=condition.replace(" ", "");
	        				 if((conditionIntValue>compareIntValue&&condition.equals(">")||(conditionIntValue<compareIntValue&&condition.equals("<")))||(conditionIntValue==compareIntValue&&condition.equals("="))){
	        					
	        					 if(!target.contains("'")){
	    		        			 temp.add(Integer.parseInt(target));
	    		        		 }else{
	    		        			 temp.add(target);
	    		        		 }
	        				 }
	        				 
	        			 }
	        		 }
	        	 }
	        	 if(temp.size()!=0){
	        		 returnValues.add(temp);
	        	 }
	        	 
	         }
	         if(returnValues.size()!=0)
	        	 return returnValues;
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		return null;
		
	   
	}
	
	
	LinkedList<Object> selectCol(String database ,String tableName,String colName,String condition,Object value ,String conditionTag,String path){
		
		try{
			LinkedList<Object> returnValues=new LinkedList<Object>();
			if(path==null){
				String s = new File(this.getClass().getName()).getAbsolutePath().replaceAll((this.getClass().getName()), "");
				s = s.substring(0, s.length() - 1);
				path=s;
			}
			
	         File inputFile = new File(path+"/"+database+"/"+tableName+".xml");
	         
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("row");
	         getTagsName(database,tableName,path);	         
	        
	         for (int row = 0; row < nList.getLength(); row++) {
	        	 Node Node = nList.item(row);
	        	 Element eElement =  (Element) Node;
	        	 NodeList childs=eElement.getChildNodes();
	        	 if(condition==null){
	        	 	for(int i =0;i<tagsName.length;i++){
	        		 
		        		 if(tagsName[i].equals(colName)){
		        			 
		        			 String target =getNodeValue(tagsName[i], childs);	        		 
			        		 if(!target.contains("'")){
			        			 returnValues.add(Integer.parseInt(target));
			        		 }else{
			        			 returnValues.add(target);
			        		 }
		        		 }
	        		 }
	        		}else{
	        			condition=condition.replace(" ", "");
	        			//System.out.println(eElement.getElementsByTagName(colName).item(0).getTextContent());
	        			if(eElement.getElementsByTagName(conditionTag).getLength()!=0&&eElement.getElementsByTagName(colName).getLength()!=0){
		        			String temp = eElement.getElementsByTagName(conditionTag).item(0).getTextContent();
		        			String colNameValue =eElement.getElementsByTagName(colName).item(0).getTextContent();
		        			
		        			 if(!temp.contains("'")){
		        				 int currentValue=Integer.valueOf((String)temp);
		        				 int targetValue = Integer.valueOf((String)value);
		        				 
		        				 if((currentValue> targetValue &&condition.equals(">"))||(currentValue<targetValue&&condition.equals("<"))||(currentValue==targetValue&&condition.equals("="))	){
		        					 if(!colNameValue.contains("'")){
		        						 returnValues.add(Integer.valueOf((String)colNameValue));
		        					 }else{
		        						 returnValues.add(colNameValue);
		        					 }
		        				 }
			        		 }else{
			        			 
			        			 if((temp.compareTo((String) value)>0&&condition.equals(">"))||(temp.compareTo((String) value)<0&&condition.equals("<"))||(temp.compareTo((String) value)==0&&condition.equals("="))){
			        				 if(!colNameValue.contains("'")){
		        						 returnValues.add(Integer.valueOf((String)colNameValue));
		        					 }else{
		        						 returnValues.add(colNameValue);
		        					 }
		        				 }	        			 
			        		 }
	        			}
	        		}
	         }
			
			
			
	         return returnValues;
		} catch (Exception e) {
            e.printStackTrace();
		}

		return null;
	}

	private String getNodeValue(String tagName, NodeList nodes ) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            NodeList childNodes = node.getChildNodes();
	            for (int y = 0; y < childNodes.getLength(); y++ ) {
	                Node data = childNodes.item(y);
	                if ( data.getNodeType() == Node.TEXT_NODE )
	                    return data.getNodeValue();
	            }
	        }
	    }
	    return "";
	}
	
	private void getTagsName (String database ,String tableName,String path) throws FileNotFoundException, IOException{
		StringBuilder sb = null;String everything = null;	

		try(BufferedReader br = new BufferedReader(new FileReader(path+"/"+database+"/"+tableName+".dtd"))) {
		     sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        
		    }
		     everything = sb.toString();
		     Pattern pattern = Pattern.compile("!ELEMENT row ((.*?))>");
		     Matcher matcher = pattern.matcher(everything);
		     String names = null ;
		    while (matcher.find()) {
		        names=matcher.group(1);
		    }
		    names=names.substring(1, names.length()-1);
		      tagsName = names.split(",");
		   
		      
		}
	}
	
	
	 
}