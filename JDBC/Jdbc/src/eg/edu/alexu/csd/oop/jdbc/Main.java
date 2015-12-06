package eg.edu.alexu.csd.oop.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DriverEngine x = new DriverEngine ();
		Properties info = new Properties();
	//	info.put("path", "F:/");
			Connection y=x.connect("jdbc:xmldb://localhost", info);
			Statement z =y.createStatement();
			z.execute("CREATE DATABASE TestDB_Select");
			System.out.println(z.execute("CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)"));
			System.out.println(z.executeUpdate("INSERT INTO table_name13(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)"));
			
	}

}
/*
CREATE TABLE table_name1(column_name1 varchar, column_name2 int, column_name3 varchar)
INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 4)
INSERT INTO table_name1(column_NAME1, COLUMN_name3, column_name2) VALUES ('value1', 'value3', 5)
INSERT INTO table_name1(column_name1, COLUMN_NAME3, column_NAME2) VALUES ('value2', 'value4', 6)
DELETE From table_name1  WHERE coLUmn_NAME2=4
UPDATE table_name1 SET column_name1='11111111', COLUMN_NAME2=10, column_name3='333333333' WHERE coLUmn_NAME2=5
SELECT * FROM table_name1 WHERE coluMN_NAME2 > 4
*/