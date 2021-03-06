package com.dsib.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.naming.ConfigurationException;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.dsib.common.Pagination;
import com.dsib.dialect.Dialect;
import com.dsib.dialect.MySQL5Dialect;
import com.dsib.dialect.OrcaleDialect;
import com.dsib.dialect.SqlServerDialect;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {
	private final static Log log = LogFactory
			.getLog(PaginationInterceptor.class);

	public static ObjectFactory DEFAULT_OBJECTFACTORY = new DefaultObjectFactory();
	public static ObjectWrapperFactory DEFUALT_OBJECTWRAPPERFACTORY = new DefaultObjectWrapperFactory();
	public static ReflectorFactory DEFAULT_REFLECTORFACTORY = new DefaultReflectorFactory();

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statmentHandler = (StatementHandler) invocation
				.getTarget();
		BoundSql boundSql = statmentHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statmentHandler,
				DEFAULT_OBJECTFACTORY, DEFUALT_OBJECTWRAPPERFACTORY,
				DEFAULT_REFLECTORFACTORY);
		Object obj = boundSql.getParameterObject();
		// 如果参数对象不是pagination ，则进入下一个拦截器
		if (!(obj instanceof Pagination))
			return invocation.proceed();
		// 把参数对象转换成pagination对象
		Pagination page = (Pagination) obj;
		// 获取mybatis配置文件
		Configuration configuration = (Configuration) metaStatementHandler
				.getValue("delegate.configuration");
		Dialect.Type databaseType = null;
		try {
			databaseType = Dialect.Type.valueOf(configuration.getVariables()
					.getProperty("dialect").toUpperCase());
		} catch (Exception e) {
			throw new ConfigurationException(
					"the value of the dialect property in mybatis-config.xml is not defined : "
							+ configuration.getVariables().getProperty(
									"dialect"));
		}
		Dialect dialect = null;
		switch (databaseType) {
		case MYSQL:
			dialect = new MySQL5Dialect();
			break;
		case SQLSERVER:
			dialect = new SqlServerDialect();
			break;
		case ORACLE:
			dialect = new OrcaleDialect();
			break;
		}
	
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");
		 // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
		metaStatementHandler.setValue("delegate.rowBounds.offset",
				RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit",
				RowBounds.NO_ROW_LIMIT);

		Connection connection = (Connection) invocation.getArgs()[0];
		int totalCount = getRowCount(page, mappedStatement, connection);
		page.setTotalCount(totalCount);
		// 获取原sql
		String originalSql = boundSql.getSql();
		String pageSql = dialect.getPaginationSql(originalSql,
				page.getPageNo(), page.getPageSize());
		metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
		
		if (log.isDebugEnabled()) {
			log.debug("生成分页SQL : " + boundSql.getSql());
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取总数据量
	 * 
	 * @param page
	 * @param mappedStatement
	 * @param connection
	 * @return
	 * @throws SQLException
	 */
	private int getRowCount(Pagination page, MappedStatement mappedStatement,
			Connection connection) throws SQLException {
		int totalRecord = 0;
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		String sql = boundSql.getSql();
		String countSql = this.getCountSql(sql);
		List<ParameterMapping> parameterMappings = boundSql
				.getParameterMappings();
		BoundSql countBoundSql = new BoundSql(
				mappedStatement.getConfiguration(), countSql,
				parameterMappings, page);
		ParameterHandler parameterHandler = new DefaultParameterHandler(
				mappedStatement, page, countBoundSql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalRecord = rs.getInt(1);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();

			} finally {
				if (pstmt != null)
					pstmt.close();
			}
		}
		return totalRecord;
	}

	private String getCountSql(String sql) {
		return "select count(*) from (" + sql + ") a";
	}

}
