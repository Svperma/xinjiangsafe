package com.dsib.dialect;

public class MySQL5Dialect implements Dialect {

	public String getPaginationSql(String sql, int offset, int limit) {
		// TODO Auto-generated method stub
		return sql + " limit " + offset + "," + limit;
	}

}
