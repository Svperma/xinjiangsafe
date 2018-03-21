package com.dsib.dao;

import java.util.List;

import com.dsib.entity.GgCode;

public interface GgCodeMapper {

	public GgCode getGgCode(String codeCode) throws Exception;

	public List<GgCode> getGgCodeList(String remark) throws Exception;

	public List<GgCode> getIndustryCode(String remark) throws Exception;

	public List<GgCode> getGgCodeByObj(GgCode code) throws Exception;

	public List<GgCode> getGgCodeByObjOtherCompany(GgCode code);
}
