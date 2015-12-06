package eg.edu.alexu.csd.oop.db;


import java.io.IOException;

import java.sql.SQLException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {

	public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

	  public static void main(String[] args) throws SQLException, SAXException, IOException, TransformerException, ParserConfigurationException {
		  Implementation x =new Implementation();
		//  x.createDatabase("create database testdb", true);
		  x.executeStructureQuery("create database testdb");
		  x.executeStructureQuery("drop database testdb");
		  x.executeStructureQuery("create table table_name1 (column_name1 varchar, column_name2 int, column_name3 varchar)");
		//  x.executeStructureQuery("create   table   table_name7 (column_name1 varchar , column_name2    int,  column_name3 varchar)");
		 // x.executeStructureQuery("create   table   table_name1 (column_name1 varchar , column_name2    int,  column_name3 varchar)");
	//	 x.executeUpdateQuery("insert into table_name7(column_name1, column_name3, column_name2) values ('value1', 'value3', 4");
		//  x.executeUpdateQuery("INSERT INTO table_name8(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)");
		  //x.executeUpdateQuery("INSERT INTO table_name8(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 5)");
		  //System.out.println(x.executeUpdateQuery("UPDATE table_name8 SET column_name1='11111111', COLUMN_NAME2=22222222, column_name3='333333333' WHERE coLUmn_NAME3='VALUE3'"));
	  }
}
