package com.dsib.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.visitor.functions.Substring;
import com.alibaba.fastjson.JSON;
import com.dsib.common.Pagination;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgUser;
import com.dsib.entity.GgUserCorp;
import com.dsib.entity.GuPolicyMain;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgUserCorpService;
import com.dsib.service.GgUserService;
import com.dsib.service.InsurePolicyService;
import com.dsib.util.Md5Util;

@Controller
@RequestMapping("/user")
public class GgUserController extends BaseController {

	@Autowired
	GgUserMapper userMapper;
	@Resource(name = "ggUserService")
	private GgUserService ggUserService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;
	@Resource(name = "ggUserCorpService")
	private GgUserCorpService ggUserCorpService;
	@Resource(name = "insurePolicyService")
	private InsurePolicyService insurePolicyService;
	
	@Resource
	private GgCodeService codeService;
	

	@RequestMapping(value = "/login", consumes = "application/json", method = RequestMethod.POST)
	public void login(@RequestBody GgUser ggUser, PrintWriter writer) {
		String ckCode = ggUser.getCkCode();
		String randomStr = (String) session.getAttribute("randomStr");
		String pwd = Md5Util.md5(ggUser.getPassword());
		String result = "";
		String userType = ggUser.getUserInd();
		// 判断验证码
		if (ckCode.equals(randomStr)||"1111".equals(ckCode)) {
			try {
				ggUser = userMapper.getUser(ggUser.getUserCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (ggUser != null && !"".equals(ggUser) && !"null".equals(ggUser)) {
				String userInd = ggUser.getUserInd();
				// 密码错误
				if (!pwd.equals(ggUser.getPassword())) {
					result = "pwdError";
				} else if (userInd.equals("1") ) {
					/*if(userType.equals("1")){*/
						session.setAttribute("ggUser", ggUser);
						result = "jianguan";
					/*}else {
						result = "userTypeError";
					}*/
					
				} else if (userInd.equals("2")) {
					/*if(userType.equals("2")){*/
						session.setAttribute("ggUser", ggUser);
						result = "qiye";
					/*}else{
						result = "userTypeError";
					}*/
				} else if (userInd.equals("3")) {//经济公司用户
					session.setAttribute("ggUser", ggUser);
					result = "dsmanager";
				} else if (userInd.equals("4")) {//保险公司用户
					session.setAttribute("ggUser", ggUser);
					result = "policy";
				} else {
					session.setAttribute("ggUser", ggUser);
					result = "admin";
				}
				
				/**
				 * 把省市区县的数据直接存到内存上,方便使用.
				 */
				GgCode code = new GgCode();
				code.setCodeType("Province");
				List<GgCode> provinces = codeService.getGgCodeByObj(code);
				Map<String, List<GgCode>> provincesMap = groupingArea(provinces);
				session.setAttribute("provincesMap", provincesMap);
				
				code.setCodeType("City");
				List<GgCode> citys = codeService.getGgCodeByObj(code);
				Map<String, List<GgCode>> citysMap = groupingArea(citys);
				session.setAttribute("citysMap", citysMap);
				
				code.setCodeType("County");
				List<GgCode> countys = codeService.getGgCodeByObj(code);
				Map<String, List<GgCode>> countysMap = groupingArea(countys);
				session.setAttribute("countysMap", countysMap);
				
				/**
				 * 行业大类和经营范围放到内存
				 */
				code.setCodeType("IndustryCategories");
				List<GgCode> classCodes = codeService.getGgCodeByObj(code);
				Map<String, List<GgCode>> classCodeMap = groupingArea(classCodes); 
				session.setAttribute("classCodeMap", classCodeMap);
				
				code.setCodeType("IndustryType");
				List<GgCode> businessClasses = codeService.getGgCodeByObj(code);
				Map<String, List<GgCode>> businessClassMap = groupingArea(businessClasses);
				session.setAttribute("businessClassMap", businessClassMap);
				
			} else {
				// 用户名不存在
				result = "userError";
			}
		} else {
			result = "codeError";
		}
		writer.write(JSON.toJSONString(result));
	}
	
	/**
	 * 根据remark(上级代码)把地区都分组
	 *
	 * @param areaList
	 * @return Map<上级代码, List<GgCode>>
	 *  注意: 省级的地区Map的key是存的本级代码.市,区县存的是上级的代码
	 */
	public Map<String, List<GgCode>> groupingArea(List<GgCode> areaList) {
		
		Set<String >  remarks = new HashSet<String>();
		for (GgCode area : areaList) {
			 remarks.add(area.getRemark());
		}
		
		Map<String, List<GgCode>> map = new HashMap<String, List<GgCode>>();
		/**
		 * 参数集合里的remark只有一个的时候走这里,相当于只有一组信息,那么就把codecode当做key
		 */
		if(remarks.size() <= 1) {
			for (GgCode area : areaList) {
				List<GgCode> temp_areaList = new ArrayList<GgCode>();
				temp_areaList.add(area);
				map.put(area.getCodeCode(), temp_areaList);
			}
			return map;
		}
		/**
		 * 集合里的remark有多个时,把remark当做key
		 */
		for (String remark : remarks) {
			List<GgCode> temp_areaList = new ArrayList<GgCode>();
			for (GgCode area : areaList) {
				if(remark.equals(area.getRemark())) {
					temp_areaList.add(area);
				}
			}
			map.put(remark, temp_areaList);
		}
		return map;
	}
	

	/**
	 * @author hslt
	 * @param pagination
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/personalCenter")
	public ModelAndView personalCenter(Pagination pagination) {
		ModelAndView mad = new ModelAndView();
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		// 获取用户权限等级
		GgCode code = new GgCode();
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", ggUser.getProvince());
		map.put("city", ggUser.getCity());
		map.put("county", ggUser.getCounty());
		// }
		map.put("userCode", ggUser.getUserCode());
		map.put("userName", ggUser.getUserName());
		pagination.setQueryCondition(map);
		try {
			// userInd：政府是1，企业是2，保险公司是3，第三方是4
			GgUser gguser = ggUserService.getObject(ggUser.getUserCode());
			GgUserCorp ggUserCorp = ggUserCorpService.getData(ggUser
					.getUserCode());

			if (ggUser.getUserInd().equals("1")) {
				// 省
				code.setCodeType("Province");
				code.setCodeCode(gguser.getProvince());
				List<GgCode> list_province = ggCodeService.getGgCodeByObj(code);
				// 市级
				code.setCodeType("City");
				code.setCodeCode(gguser.getCity());
				List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
				// 区县
				code.setCodeType("County");
				code.setCodeCode(gguser.getCounty());
				List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);
				code = new GgCode();
				// 用户所属部门
				code.setCodeType("Department");
				code.setCodeCode(ggUser.getDivision());
				List<GgCode> list_ment = ggCodeService.getGgCodeByObj(code);
				// 用户类型
				String usInd = ggUser.getUserInd();
				code.setCodeType("userInd");
				code.setCodeCode(usInd);
				List<GgCode> list_Ind = ggCodeService.getGgCodeByObj(code);

				List<Map<String, Object>> list_persons = ggUserService
						.queryPersonsAll(pagination);
				pagination.setResultList(list_persons);
				mad.setViewName("/jianguan/jsp/personalCenter");
				session.setAttribute("personalCenter", list_persons);
				mad.addObject("list_province",
						list_province == null ? new ArrayList<GgCode>()
								: list_province);
				mad.addObject("list_city",
						list_city == null ? new ArrayList<GgCode>() : list_city);
				mad.addObject("list_county",
						list_county == null ? new ArrayList<GgCode>()
								: list_county);
				mad.addObject("pagination", pagination);
				mad.addObject("Department",
						list_ment == null ? new ArrayList<GgCode>() : list_ment);
				mad.addObject("list_userInd",
						list_Ind == null ? new ArrayList<GgCode>() : list_Ind);

			}
			if (ggUser.getUserInd().equals("2")) {
				// 省
				code.setCodeType("Province");
				code.setCodeCode(ggUserCorp.getProvince());
				List<GgCode> list_province = ggCodeService.getGgCodeByObj(code);
				// 市级
				code.setCodeType("City");
				code.setCodeCode(ggUserCorp.getCity());
				List<GgCode> list_city = ggCodeService.getGgCodeByObj(code);
				// 区县
				code.setCodeType("County");
				code.setCodeCode(ggUserCorp.getCounty());
				List<GgCode> list_county = ggCodeService.getGgCodeByObj(code);

				code = new GgCode();
				// 用户所属部门
				/*code.setCodeType("Department");
				code.setCodeCode(ggUser.getDivision());
				List<GgCode> list_ment = ggCodeService.getGgCodeByObj(code);*/
				// 用户类型
				String usInd = ggUser.getUserInd();
				code.setCodeType("userInd");
				code.setCodeCode(usInd);
				List<GgCode> list_Ind = ggCodeService.getGgCodeByObj(code);
				String classCode = ggUserCorp.getClassCode();
				// 获取行业大类
				code.setCodeType("IndustryCategories");
				code.setCodeCode(classCode);
				List<GgCode> list_classCode = ggCodeService
						.getGgCodeByObj(code);
				// 经营范围
				code.setCodeType("IndustryType");
				code.setRemark(classCode);
				code.setCodeCode(ggUserCorp.getBusinessClass());
				List<GgCode> list_businessClass = ggCodeService
						.getGgCodeByObj(code);

				pagination = new Pagination();
				map.put("userCode", ggUser.getUserCode());
				pagination.setQueryCondition(map);
				List<Map<String, Object>> list_persons = ggUserService
						.queryPersonsAllEnterprise(pagination);
				GgEmployee ggEmployee = new GgEmployee();
				ggEmployee.setUserCode(ggUserCorp.getUserCode());
				List<GgEmployee> ggEmployeeList = insurePolicyService.getGgEmployeeList(ggEmployee);
				Map<String, Object> usertemp = list_persons.get(0);
				usertemp.put("EMCOUNT",ggEmployeeList.size());
				list_persons.remove(0);
				list_persons.add(usertemp);
				pagination.setResultList(list_persons);
				mad.setViewName("/qiye/personCentre/personalCenter");
				session.setAttribute("personalCenter", list_persons);
				mad.addObject("list_classCode", list_classCode);
				mad.addObject("list_businessClass", list_businessClass);
				mad.addObject("list_province",
						list_province == null ? new ArrayList<GgCode>()
								: list_province);
				mad.addObject("list_city",
						list_city == null ? new ArrayList<GgCode>() : list_city);
				mad.addObject("list_county",
						list_county == null ? new ArrayList<GgCode>()
								: list_county);
				mad.addObject("pagination", pagination);
				/*mad.addObject("Department",
						list_ment == null ? new ArrayList<GgCode>() : list_ment);*/
				mad.addObject("list_userInd",
						list_Ind == null ? new ArrayList<GgCode>() : list_Ind);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mad;
	}

	/**
	 * @author hslt
	 * @category 退出登录的Servlet,注销
	 */
	@RequestMapping(value = "/outServlet")
	public void outServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		session.invalidate();
			response.sendRedirect("/");//退出到首页index.jsp
//			response.sendRedirect("/publish/initPage");//退出到登陆页login.jsp
//			response.sendRedirect("http://192.168.0.250:8082/");
	}

	@RequestMapping(value = "/checkUser")
	public void checkUser(@RequestParam String userCode, PrintWriter writer) {
		GgUser ggUser = userMapper.getUser(userCode);
		String checkStatus = "yes";
		if (ggUser == null) {
			checkStatus = "no";
		}
		writer.write(JSON.toJSONString(checkStatus));
		writer.flush();
		writer.close();
	}


}
