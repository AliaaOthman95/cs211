package eg.edu.alexu.csd.oop.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.LinkedList;
import eg.edu.alexu.csd.oop.db.Implementation;
public class StatmentImplementation implements java.sql.Statement{
	private Implementation db = new Implementation().getInstance();
	private LinkedList<Integer> lista =new LinkedList<Integer>();
	private int []batchList=null;
	private String []parameters=null;
	private Object [][] select =null ;
	private String path=null;
	private boolean batchIncluded=false;
	private LinkedList<String> rows = new LinkedList<String>();
	
	private ConnectionEngine currentConnection;
	
	/******************************************************************/
	 
	StatmentImplementation(ConnectionEngine x) {
		// TODO Auto-generated constructor stub
		  currentConnection=x;
		
	}
	/***************************UNIMPLEMENTED******************/@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}

	/***************************UNIMPLEMENTED******************/@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void addBatch(String statment) throws SQLException {
		rows.add(statment);
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void cancel() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	/***************************IMPLEMENTED******************/@Override
	public void clearBatch() throws SQLException {
		rows.clear();
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void clearWarnings() throws SQLException {
		throw new UnsupportedOperationException();
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void close() throws SQLException {
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void closeOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean execute(String query) throws SQLException {
		// TODO Auto-generated method stub
		query=query.toLowerCase();
		path=currentConnection.getPath();
		
		if(query.contains("create")||query.contains("drop"))
		{	
			path=currentConnection.getPath();
			db.setPath(path);
			boolean x =db.executeStructureQuery(query);
			if(batchIncluded)lista.addLast(x?1:0);
			return x?true:false;
		}
		if(query.contains("select")){
			select=db.executeQuery(query);
			if(batchIncluded)lista.addLast(select.length);
			return select.length==0||select==null?false:true;
		}
		else {
			//System.out.println(query);
			int x=db.executeUpdateQuery(query);
			if(batchIncluded)lista.addLast(x);
			if(query.contains("update"))return false;
			return x==1?true:false;
		}
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean execute(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean execute(String arg0, int[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean execute(String arg0, String[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int[] executeBatch() throws SQLException {
		// TODO Auto-generated method stub
		batchList=new int[lista.size()];
		batchIncluded=true;
		for(String statment:rows){
			execute(statment);
		}
		int counter=0;
		for(int i:lista){
			batchList[counter++]=i;
		}
		lista.clear();
		rows.clear();
		batchIncluded=false;
		return batchList;
	}

	/***************************IMPLEMENTED******************/@Override
	public ResultSet executeQuery(String query) throws SQLException {
		// TODO Auto-generated method stub
		query=query.toLowerCase();
		if(query.contains("select")){
		select=db.executeQuery(query);
		String tableName=db.getTableName();
		parameters=db.getParameters(tableName);
		//ResultSet res = new ResultSetImpl(select,parameters,tableName,this);
		return new ResultSetImpl(select,parameters,tableName,this);
		}
		else return null;
	}

	/***************************IMPLEMENTED******************/@Override
	public int executeUpdate(String update) throws SQLException {
		update=update.toLowerCase();
		if(update.contains("update")||update.contains("delete")||update.contains("insert"))
		return db.executeUpdateQuery(update);
		else return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int executeUpdate(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int executeUpdate(String arg0, int[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int executeUpdate(String arg0, String[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return currentConnection;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getMaxFieldSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getMaxRows() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean getMoreResults() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean getMoreResults(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getQueryTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public ResultSet getResultSet() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getResultSetConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getResultSetType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public int getUpdateCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean isCloseOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public boolean isPoolable() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setCursorName(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setEscapeProcessing(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setFetchDirection(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setFetchSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setMaxFieldSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setMaxRows(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setPoolable(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/***************************UNIMPLEMENTED******************/@Override
	public void setQueryTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}