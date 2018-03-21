package com.dsib.dialect;

public class OrcaleDialect implements Dialect {

	public String getPaginationSql(String sql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return "select * from (select rownum rn, t.* from (" + sql
				+ ") t where rownum <= " + (pageNo * pageSize)
				+ ") t1 where t1.rn > " + ((pageNo - 1) * pageSize);
	}

}
