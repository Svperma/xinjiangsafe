package com.dsib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.dao.GgCodeMapper;
import com.dsib.entity.GgCode;
import com.dsib.service.GgCodeService;

@Service("ggCodeService")
public class GgCodeServiceImpl implements GgCodeService {

	@Autowired
	private GgCodeMapper mapper;

	public List<GgCode> getGgCodeList(String remark) {
		List<GgCode> list = null;
		try {
			list = mapper.getGgCodeList(remark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public GgCode getGgCode(String codeCode) {
		GgCode code = null;
		try {
			code = mapper.getGgCode(codeCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

	public List<GgCode> getGgCodeByObj(GgCode code) {
		List<GgCode> list = null;
		try {
			list = mapper.getGgCodeByObj(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<GgCode> getIndustryCode(String remark) {
		List<GgCode> list = null;
		try {
			list = mapper.getIndustryCode(remark);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GgCode> getGgCodeByObjOtherCompany(GgCode code) {
		List<GgCode> list = null;
		try {
			list = mapper.getGgCodeByObjOtherCompany(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
