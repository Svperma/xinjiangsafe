package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgHonorMapper;
import com.dsib.entity.GgHonor;
import com.dsib.service.GgHonorService;

@Service("ggHonorService")
public class GgHonorServiceImpl implements GgHonorService {

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	GgHonorMapper ggHonorMapper;

	public List<Map<String, Object>> selectAll(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggHonorMapper.selectAll(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Map<String, Object>> selectQueryByHonorCode(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggHonorMapper.selectQueryByHonorCode(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void deleteById(GgHonor honor) {
		try {
			ggHonorMapper.deleteById(honor);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return;
	}

	public void addHonor(GgHonor ggHonor) {
		try {
			ggHonorMapper.addHonor(ggHonor);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Pagination getMyHonorPagination(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggHonorMapper.selectQueryByHonorCode(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

}
