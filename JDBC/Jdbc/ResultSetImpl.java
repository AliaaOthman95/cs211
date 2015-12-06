package eg.edu.alexu.csd.oop.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class ResultSetImpl implements java.sql.ResultSet {

	private Object[][] selected = null;
	private String[] columnsNames;
	private Object[] current;
	private String tableName;
	private int counter = -1;
	private Statement statementImpl;

	public ResultSetImpl(Object[][] result, String[] colsNames,
			String tableName, Statement statementImpl) {
		this.selected = result;
		this.columnsNames = colsNames;
		this.tableName = tableName;
		this.statementImpl = statementImpl;
System.out.println(result.length+"length");
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean absolute(int row) throws SQLException {

		if (row >= 0 && row <= selected.length - 1) {
			counter = row;
			current = selected[counter];
			return true;
		}
		return false;
	}

	@Override
	public void afterLast() throws SQLException {

		counter = selected.length + 1;
	}

	@Override
	public void beforeFirst() throws SQLException {

		counter = -1;
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void close() throws SQLException {

		if (selected != null) {
			selected = null;
		}

	}

	@Override
	public void deleteRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException {

		int index = 0;

		for (int i = 0; i < columnsNames.length; i++) {
			if (columnsNames[i].equalsIgnoreCase(columnLabel)) {
				index = i + 1; // updated
				break;
			}
		}

		return index;
	}

	@Override
	public boolean first() throws SQLException {

		if (selected.length != 0) {
			counter = 0;
			current = selected[counter];
			return true;
		}
		return false;
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Array getArray(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public String getCursorName() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();

	}

	@Override
	public double getDouble(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {

		return (int) getObject(columnIndex);
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {

		int index = findColumn(columnLabel);

		return getInt(index);
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public long getLong(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {

		return new ResultSetMetaDataImpl(selected, columnsNames, tableName);
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {

		if (columnIndex > selected.length || columnIndex < 0)
			throw new SQLException();
		Object value = null;
		try {
			value = current[columnIndex - 1];// updated
		} catch (Exception e) {
			throw new SQLException();
		}

		return value;
	}

	@Override
	public Object getObject(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Ref getRef(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Ref getRef(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public short getShort(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public short getShort(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Statement getStatement() throws SQLException {

		return statementImpl;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {

		return (String) getObject(columnIndex);
	}

	@Override
	public String getString(String columnLabel) throws SQLException {

		int index = findColumn(columnLabel);

		return (String) getObject(index);
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getType() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public URL getURL(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void insertRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean isAfterLast() throws SQLException {

		if (counter == selected.length + 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {

		if (counter == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isClosed() throws SQLException {

		if (selected != null) {
			return false;
		}
		return true;

	}

	@Override
	public boolean isFirst() throws SQLException {

		if (counter == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isLast() throws SQLException {

		if (counter == selected.length - 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean last() throws SQLException {

		if (selected.length != 0) {
			counter = selected.length - 1;
			current = selected[counter];
			return true;
		}
		return false;
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean next() throws SQLException {

		if (counter + 1 <= selected.length-1) {
 
				counter++;
				current = selected[counter];

			return true;
		}
		else if(counter+1== selected.length)
		{
			counter++;
			return false;
		}
		return false;
	}

	@Override
	public boolean previous() throws SQLException {

		
		if (counter - 1 >= 0) {

			 
				counter--;
				current = selected[counter];
			return true;
		}
		else if(counter-1==-1)
		{
			counter--;
			return false;
		}
		return false; 
		 
	}

	@Override
	public void refreshRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean relative(int rows) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean rowInserted() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader,
			int length) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(String columnLabel, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNString(int columnIndex, String nString)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNString(String columnLabel, String nString)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateNull(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateRow() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x)
			throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public boolean wasNull() throws SQLException {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException();
	}

}
