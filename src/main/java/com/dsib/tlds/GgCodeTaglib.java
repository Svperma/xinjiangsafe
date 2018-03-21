package com.dsib.tlds;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.dsib.entity.GgCode;
import com.dsib.service.GgCodeService;

public class GgCodeTaglib extends TagSupport {

	private String codeType;
	private String codeCode;
	private String remark;

	private GgCodeService ggCodeService;

	public GgCodeTaglib() {
		ApplicationContext context = ContextLoader
				.getCurrentWebApplicationContext();// WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		ggCodeService = (GgCodeService) context.getBean("ggCodeService");
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			GgCode ggCode = new GgCode();
			ggCode.setCodeCode(codeCode);
			ggCode.setCodeType(codeType);
			ggCode.setRemark(remark);
			List<GgCode> list = ggCodeService.getGgCodeByObj(ggCode);
			if (list != null && list.size() > 0)
				ggCode = list.get(0);
			out.write(ggCode.getCodeCName());
			out.flush();
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return super.doStartTag();
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
