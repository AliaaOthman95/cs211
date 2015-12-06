package eg.edu.alexu.csd.oop.db;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class InsertUpdateDelete {
	
	private Map <String , String> map = new HashMap<String,String>();
	private String[] condition=null;
	private String[][]newState=null;
	private String operand=null;
	private int n=0;
/*********************************************************************************/
	public LinkedList<Map<String,String>> insertInto(String file,String[] parameters,String[]values,LinkedList<Map<String,String>> rows,String[] partialParameters,boolean deleteAll){

		if(!deleteAll){
			map=new HashMap<String,String>();
			for(int i=0;i<parameters.length;i++){
				if(partialParameters!=null){
					map.put(partialParameters[i], values[i]);
				}
				else{
					map.put(parameters[i], values[i]);
				}
			}
			
			rows.addLast(map);
		}
		saveXml(file,parameters,rows);
		return rows;
	}
/*********************************************************************************/
	public int deleteOrUpdate(String file,LinkedList<Map<String,String>> rows,String cond,String[]parameters,String[] nState,boolean update,boolean delete) throws Exception{
		if(cond!=null){
			if(cond.contains("=")){
				condition=cond.split("=");
				operand="=";
			}else if(cond.contains(">")){
				condition=cond.split(">");
				operand=">";
			}else if(cond.contains("<")){
				condition=cond.split("<");
				operand="<";
			}else throw new Exception();
		}
		if(update){
				newState=new String[nState.length][2];
				for(int i=0;i<nState.length;i++){
					String[]dummy=nState[i].split("=");
					newState[i][0]=dummy[0];
					newState[i][1]=dummy[1];
				}
		}
		LinkedList <Integer> remove=new LinkedList<Integer>();
		int i=0;
		for(Map<String, String> x:rows){
			map=new HashMap<String,String>();
			map=x;
			if(cond==null){
				if(update){for(int t=0;t<nState.length;t++){map.put(newState[t][0], newState[t][1]);}}
				n++;
			}
			else{
			if(operand.equals("="))if(map.get(condition[0]).equals(condition[1])){if(delete)remove.add(i);else if(update){for(int t=0;t<nState.length;t++){map.put(newState[t][0], newState[t][1]);}}n++;}
			if(operand.equals("<"))if((int)Integer.parseInt(map.get(condition[0]))<(int)Integer.parseInt((condition[1]))){if(delete)remove.add(i);else if(update){for(int t=0;t<nState.length;t++){map.put(newState[t][0], newState[t][1]);}}n++;}
			if(operand.equals(">"))if((int)Integer.parseInt(map.get(condition[0]))>(int)Integer.parseInt((condition[1]))){if(delete)remove.add(i);else if(update){for(int t=0;t<nState.length;t++){map.put(newState[t][0], newState[t][1]);}}n++;}	
			}	
			i++;
		}i=0;
		for(Integer t:remove){
			rows.remove(t-i);
			i++;
		}
		saveXml(file,parameters,rows);
		return n;	
	}
/***********************************************************************************/	
	private void saveXml(String file,String[]parameters,LinkedList<Map<String,String>> rows){
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element mainRootElement = doc.createElement("table");	        
	        Element row = null ;
	        Element tag=null;
	        if(rows!=null){
	        for(Map<String, String> x:rows){
	        	row = doc.createElement("row");
	        	map=new HashMap<String,String>();
	        	map=x;
	        	for(int i=0;i<parameters.length;i++){
	        		tag=doc.createElement(parameters[i]);
	        		tag.appendChild(doc.createTextNode(map.get(parameters[i])));
	        		row.appendChild(tag);
	        	}
	        	mainRootElement.appendChild(row);	
	        }
	        }
	        doc.appendChild(mainRootElement);

	        TransformerFactory tFactory=TransformerFactory.newInstance();
            Transformer transformer=tFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            StreamResult streamResult=new StreamResult(new File(file+".xml"));
            
           
           
           
            transformer.transform(source,streamResult);
		}catch (TransformerException e) {
				e.printStackTrace();
		}catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		} 
}
