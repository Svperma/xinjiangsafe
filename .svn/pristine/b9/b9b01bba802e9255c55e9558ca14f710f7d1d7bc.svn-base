package com.dsib.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class BasePathHolder implements ServletContextAware {

	private ServletContext servletContext;
	private String basePath;

	public void init() {
		getServletContext().setAttribute("basePath",
				getServletContext().getContextPath());
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public String getBasePath() {
		return basePath;
	}

}
