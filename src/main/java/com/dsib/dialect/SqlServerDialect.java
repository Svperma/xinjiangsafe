package com.dsib.dialect;

public class SqlServerDialect implements Dialect {

	public String getPaginationSql(String sql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return "select top " + pageSize + " from (" + sql
				+ ") t where t.id not in (select top " + (pageNo - 1)
				* pageSize + " t1.id from (" + sql + ") t1)";
	}

}
