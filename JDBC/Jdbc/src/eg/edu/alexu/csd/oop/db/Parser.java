package eg.edu.alexu.csd.oop.db;



import java.util.LinkedList;

public class Parser {


	LinkedList<String> formula = new LinkedList<String>();
	String createDatabase = "CREATE DATABASE ([^]]+)";
	String createTable = "CREATE\\s*TABLE ([^]]+)\\((([^]]+)(VARCHAR|INT)\\s*,?\\s*)*\\)\\s*";
	String deleteTable = "DELETE FROM ([^]]+)";
	String deleteTable2 = "DELETE \\* FROM ([^]]+)";
	String deleteTable3 = "DELETE FROM ([^]]+) WHERE ([^]]+)\\s*=\\s*([^]]+)\\s*";
	String dropDatabase = "DROP DATABASE ([^]]+)";
	String dropTable = "DROP TABLE \\w+\\s*";
	String insert= "INSERT INTO ([^]]+)\\s*VALUES\\s*\\((\\s*\'?([^]]+)\\s*\'?\\s*,?\\s*)*\\)?";
	String insert2= "INSERT INTO ([^]]+)\\s*\\((([^]]+)\\s*,?\\s*)*\\)\\s*VALUES\\s*\\((\\s*([^]]+)\\s*,?\\s*)*\\)?";
	String selcetAll = "SELECT \\* FROM ([^]]+)";
	String selcetCol = "SELECT ([^]]+) FROM ([^]]+)";
	String update = "UPDATE ([^]]+) SET (\\w+\\s*=\\s*([^]]+),?)*\\s*WHERE\\s*\\w+\\s*=\\s*([^]]+)";
	String where = "SELECT ([^]]+) FROM ([^]]+) WHERE ([^]]+) (>|<|=) ([^]]+)\\s*";
	String update2="UPDATE ([^]]+) SET\\s*(\\s*([^]]+)\\s*=\\s*\'?\\s*([^]]+)+\\s*\'?\\s*,?\\s?)*\\s*";
	String currentFormula =null;
	int currentFormulaIndex =-1;
	
	
	
	boolean  check (String input){
		
	//	log(input+"\n",false);
		while(input.contains("  ")){
			input=input.replace("  ", " ");
		}
		//input=input.replaceAll("\\s{2,}", " ");
		//input=input.replaceAll("\\s+\\s+","");
		
		input=input.toUpperCase();
		//System.out.println(input);
		
		formula.add(createDatabase);
		formula.add(createTable);
		formula.add(deleteTable);
		formula.add(deleteTable2);
		formula.add(deleteTable3);
		formula.add(dropDatabase);
		formula.add(dropTable);
		formula.add(insert);
		formula.add(insert2);
		formula.add(selcetAll);
		formula.add(selcetCol);
		formula.add(update);
		formula.add(where);
		formula.add(update2);
		
		for(int i =0;i<formula.size();i++){
			
			if(input.matches(formula.get(i))){
				currentFormula=formula.get(i);
				currentFormulaIndex=i;
	
				return true;
			}
		}
		return false;
	}
	


}