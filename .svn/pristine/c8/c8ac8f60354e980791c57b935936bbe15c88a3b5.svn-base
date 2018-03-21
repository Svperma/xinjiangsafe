package com.dsib.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.entity.GgCode;
import com.dsib.entity.GgEmployee;
import com.dsib.entity.GgUser;
import com.dsib.service.GgCodeService;
import com.dsib.service.GgEmployeeService;
import com.dsib.util.FileUtil;
import com.dsib.util.StringUtil;

@Controller
@RequestMapping("/employee")
public class GgEmployeeController extends BaseController {

	@Resource(name = "ggemployeeService")
	private GgEmployeeService ggemployeeService;
	@Resource(name = "ggCodeService")
	private GgCodeService ggCodeService;

	/**
	 * 初始化人员信息列表
	 * 
	 * @author hslt
	 * @return
	 */
	@RequestMapping("/userDetails")
	public ModelAndView userDetails() {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		 String departmentCode = "";
		// 获取登录对象
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCode", null);
		map.put("userCode", ggUser.getUserCode());

		pagination.setQueryCondition(map);

		List<Map<String, Object>> list = ggemployeeService
				.getEmployeeDetails(pagination);
		pagination.setResultList(list);
		mad.addObject("pagination", pagination);
		session.setAttribute("pagination", pagination);
		session.setAttribute("employeeDetails", list);
		mad.setViewName("/qiye/qiyeshuju/EmployeeLeft");
		return mad;
	}

	/**
	 * 查询按钮
	 * 
	 * @author hslts
	 * @param session
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/formMit", method = RequestMethod.POST, produces = "application/*;chartset=UTF-8")
	public ModelAndView userCorpInfo(HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		try {
			String emName = request.getParameter("emName");
			String identityNo = request.getParameter("identityNo");
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("emName", emName.equals("请输入您要查询的员工姓名") ? "" : emName);
			map.put("identityNo", identityNo.equals("请输入查询的身份证号") ? ""
					: identityNo);
			map.put("userCode", ggUser.getUserCode());
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list_summit = ggemployeeService
					.getSubmit(pagination);
			pagination.setResultList(list_summit);
			session.setAttribute("pagination", pagination);
			mad.setViewName("/qiye/qiyeshuju/EmployeeInformation");
			mad.addObject("pagination", pagination);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	/**
	 * 逻辑删除员工
	 * 
	 * @author hslt
	 * @param session
	 * @param pagination
	 * @param identityNo
	 * @return
	 */
	@RequestMapping(value = "/deletePersons")
	public ModelAndView deletePersons(HttpSession session, GgEmployee ggemployee) {
		String identityNo = request.getParameter("identityNo");
		ModelAndView mad = new ModelAndView();
		Pagination pagination = null;
		try {
			ggemployee.setIdentityNo(identityNo);
			ggemployeeService.deletePersons(ggemployee);
			pagination = (Pagination) session.getAttribute("pagination");
			List<Map<String, Object>> list = ggemployeeService
					.getEmployeeDetails(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mad.setViewName("/qiye/qiyeshuju/EmployeeInformation");
		mad.addObject("pagination", pagination);
		return mad;
	}

	/**
	 * 添加按钮
	 * 
	 * @author hslt
	 * @param session
	 * @param ggemployee
	 * @return
	 */
	@RequestMapping(value = "/addButton")
	public ModelAndView addButton(HttpSession session) {
		ModelAndView mad = new ModelAndView();
		/*try {
			GgCode ggCode = new GgCode();
			ggCode.setCodeType("EnterpriseSector");
			List<GgCode> list_depart = ggCodeService.getGgCodeByObj(ggCode);//查询工种
			mad.addObject("list_depart", list_depart);
			session.setAttribute("list_depart", list_depart);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		mad.setViewName("/qiye/qiyeshuju/AddEmployeePersons");
		return mad;
	}

	/**
	 * 添加新人员
	 * 
	 * @author hslt
	 * @param session
	 * @param pagination
	 * @param idtyNo
	 * @param ggemployee
	 * @return
	 */
	@RequestMapping(value = "/addPersons", method = RequestMethod.POST)
	public ModelAndView addPersons(
			HttpSession session,
			Pagination pagination,
			@RequestParam(value = "identityNo", required = false) String idtyNo) {
		ModelAndView mad = new ModelAndView();
		GgEmployee ggemployee = new GgEmployee();
		try {
			String emName = request.getParameter("emName");
			String identityNo = request.getParameter("identityNo");
//			String sex = request.getParameter("sex");
//			String age = request.getParameter("age");
//			String telePhone = request.getParameter("telephone");
//			String address = request.getParameter("address");
//			String departmentCode = request.getParameter("departmentCode");
			/** 生成一个32位的随机数用作ID */
			String uuid = StringUtil.getUUID();
			/** 从gguser表中取出当前登录的userCode */
			GgUser gguser = (GgUser) session.getAttribute("ggUser");
			String userCode = gguser.getUserCode();

			ggemployee.setEmId(uuid);
			ggemployee.setUserCode(userCode);
			ggemployee.setEmName(emName);
			ggemployee.setIdentityNo(identityNo);
//			ggemployee.setSex(sex);
			/*if(!"请输入人员年龄".equals(age)){
				*//** 把string类型的age转换为integer类型的 *//*
				Integer ages = Integer.valueOf(age);
				ggemployee.setAge(ages);
			}else{
				ggemployee.setAge(0);
			}*/
//			ggemployee.setTelePhone(telePhone);
//			ggemployee.setAddress(address);
//			ggemployee.setDepartmentCode(departmentCode);
			ggemployee.setValidStatus("1");
			ggemployeeService.insertPersons(ggemployee);

			pagination = (Pagination) session.getAttribute("pagination");
			List<Map<String, Object>> list = ggemployeeService
					.getEmployeeDetails(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mad.setViewName("/qiye/qiyeshuju/EmployeeInformation");
		mad.addObject("pagination", pagination);
		return mad;
	}

	/**
	 * 修改按钮
	 * 
	 * @author hslt
	 * @param identityNo
	 * @param ggemployee
	 * @return
	 */
	@RequestMapping(value = "/updatePersons", method = RequestMethod.GET)
	public ModelAndView updatePersons(
			@RequestParam(value = "identityNo", required = false) String identityNo,
			GgEmployee ggemployee) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = new Pagination();
		try {
			GgUser user = (GgUser) session.getAttribute("ggUser");
			/*GgCode ggCode = new GgCode();
			ggCode.setCodeType("EnterpriseSector");
			List<GgCode> list_depart = ggCodeService.getGgCodeByObj(ggCode);*/
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("idNo", identityNo.equals("请输入您要查询的员工证件号") ? "" : identityNo);
			pagination.setQueryCondition(map);
			List<Map<String, Object>> list_summit = ggemployeeService.getSubmit(pagination);
			mad.addObject("list_summit", list_summit);
//			mad.addObject("list_depart", list_depart);
			mad.setViewName("/qiye/qiyeshuju/UpdateEmployeePersons");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mad;
	}

	/**
	 * 修改确认
	 * 
	 * @author hslt
	 * @param ggemployee
	 * @return
	 */
	@RequestMapping(value = "/updateForms", method = RequestMethod.POST)
	public ModelAndView updateForms(GgEmployee ggemployee) {
		ModelAndView mad = new ModelAndView();
		try {
			String emName = request.getParameter("emName");
			String identityNo = request.getParameter("identityNo");
//			String sex = request.getParameter("sex");
//			String age = request.getParameter("age");
//			String telePhone = request.getParameter("telephone");
//			String address = request.getParameter("address");
//			String departmentCode = request.getParameter("departmentCode");
			String emId = request.getParameter("emId");
			/** 从gguser表中取出当前登录的userCode */
			GgUser gguser = (GgUser) session.getAttribute("ggUser");
			String userCode = gguser.getUserCode();
			/** 把string类型的age转换为integer类型的 */
//			Integer ages = Integer.valueOf(age);

			ggemployee.setEmId(emId);
			ggemployee.setUserCode(userCode);
			ggemployee.setEmName(emName);
			ggemployee.setIdentityNo(identityNo);
//			ggemployee.setSex(sex);
//			ggemployee.setAge(ages);
//			ggemployee.setTelePhone(telePhone);
//			ggemployee.setAddress(address);
//			ggemployee.setDepartmentCode(departmentCode);
			ggemployee.setValidStatus("1");
			ggemployeeService.updatePersons(ggemployee);

			Pagination pagination = new Pagination();
			pagination = (Pagination) session.getAttribute("pagination");

			List<Map<String, Object>> list = ggemployeeService
					.getEmployeeDetails(pagination);
			pagination.setResultList(list);
			mad.addObject("pagination", pagination);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mad.setViewName("/qiye/qiyeshuju/EmployeeInformation");
		return mad;
	}

	/**
	 * 导报表
	 * 
	 * @author hslt
	 * @param response
	 */
	@RequestMapping("/exportToExcel")
	public void exportExcel(HttpServletResponse response,
			HttpServletRequest request) {
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		String emName = request.getParameter("emName");
		String identityNo = request.getParameter("identityNo");
		// 查询条件
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("emName", emName.equals("请输入您要查询的员工姓名") ? "" : emName);
		conditionMap.put("identityNo", identityNo.equals("请输入查询的身份证号") ? "" : identityNo);
		conditionMap.put("userCode", ggUser.getUserCode());
		ConditionAdapter adapter = new ConditionAdapter();
		adapter.setQueryCondition(conditionMap);
		// 查询信息
		List<Map<String, Object>> list_Persons = ggemployeeService.getEmployeeToExc(adapter);
		// 标题
		String[] titles = new String[] { "EMNAME:员工姓名", "IDENTITYNO:身份证号"
				/*,"SEX:性别", "AGE:年龄", "TELEPHONE:联系方式", "DEPARTMENTCODE:工种","ADDRESS:家庭住址"*/ 
				};
		// 内容
		List<Map<String, Object>> lists = list_Persons;
		// 类型
		Class clas = Map.class;
		// sheet名
		String sheetName = "员工信息";
		FileUtil.exportToExcel(titles, lists, clas, sheetName, response);
	}

	/**
	 * 员工信息 翻页
	 * 
	 * @author hslt
	 * @return
	 */
	@RequestMapping("/personsContinue")
	public ModelAndView personsContinue(@RequestParam("pageNo") String pageNo,
			HttpSession session) {
		ModelAndView mad = new ModelAndView();
		Pagination pagination = null;
		pagination = (Pagination) session.getAttribute("pagination");
		pagination.setPageNo(Integer.parseInt(pageNo));
		pagination = ggemployeeService.getPersonsPaginations(pagination);
		mad.addObject("pagination", pagination);
		mad.setViewName("/qiye/qiyeshuju/EmployeeInformation");
		return mad;
	}

	/**
	 * 批量导入人员信息 读取出filePath中的所有数据信息
	 * 
	 * @author hslt
	 * @param filePath
	 */
	@RequestMapping("/exportToInputValue")
	public void exportToInputValue(@RequestParam MultipartFile inp , PrintWriter writer) {
		GgEmployee ggEmployee = new GgEmployee();
		GgUser gguser = (GgUser) session.getAttribute("ggUser");
			String Filename = inp.getOriginalFilename();
			String checkStatus = "yes";
			InputStream fis = null;
			String idCardValidate = "";
			// 判断是否为excel类型文件
			if (!Filename.endsWith(".xls") && !Filename.endsWith(".xlsx")) {
//				System.out.println("文件不是excel类型");
				checkStatus = "typeNofind";
			}else {
				try {
					fis = inp.getInputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<Object[]> batchImport = FileUtil.batchImport(fis, 1, 0);
				System.out.println(JSON.toJSONString(batchImport));
				for (int i = 0; i < batchImport.size(); i++) {
					try {
						ggEmployee = (GgEmployee) FileUtil.arrayToBean(batchImport.get(i), "com.dsib.entity.GgEmployee");

						String emName = ggEmployee.getEmName();
						String identityNo = ggEmployee.getIdentityNo();
						
//						String sex = ggEmployee.getSex();
//						Integer age = ggEmployee.getAge();
//						String telePhone = ggEmployee.getTelePhone();
//						String departmentCode1 = ggEmployee.getDepartmentCode();
//						String address = ggEmployee.getAddress();
						// 校验身份证是否合法
//				Boolean idfFlag = StringUtil.idCardNumber(identityNo);
						//查询此条数据是否已经存在
						GgEmployee	Employee = null;
						if (identityNo != null) {
							Employee = ggemployeeService.selectByIdentityNo(identityNo);
						}
						if (Employee != null) {
							checkStatus = "IsHaveIdentityNoError"+"+"+(i+1);//数据库已存在这个身份证号
							break;
						}else {
							
							//校验名称不能为空
							if (emName != null) {
								if (emName.length()>0) {
									ggEmployee.setEmName(emName);
								}
							} else {
								checkStatus = "nameIsNotNull"+"+"+(i+1);//名称不能为空
								break;
							}
							//校验身份证号
							if (identityNo != null) {
								if (identityNo.length()>0) {
									idCardValidate = StringUtil.IDCardValidate(identityNo);
									if (!"".equals(idCardValidate)) {
										checkStatus = "IdCardError"+"+"+(i+1);
										break;
									}else {
										ggEmployee.setIdentityNo(identityNo);
									}
								}
							}
							else {
								checkStatus = "IdIsNotNull"+"+"+(i+1);//身份证号不可为空
							}
							
							//校验性别不能为空
							/*if (sex != null) {
							if (sex.length() > 0){
								if (sex.equals("男")) {
									ggEmployee.setSex("1");
								}else if (sex.equals("女")) {
									ggEmployee.setSex("2");
								}else {
									checkStatus = "sexError"+"+"+(i+1);//性别只能选择男、女
									break;
								}
							}
						}
						else{
							checkStatus = "sexIsNotNull"+"+"+(i+1);//性别必须选择男、女
							break;
						}*/
							//校验年龄不可为空
							/*if(age == null){
							checkStatus = "ageIsNotNull"+"+"+(i+1);//年龄不可为空
							break;
						}else {
							ggEmployee.setAge(age);
						}*/
							//校验手机号
							/*if (telePhone == null) {
							checkStatus = "telphoneIsNotNull"+"+"+(i+1);
						}else {
							Boolean phoneFlag = StringUtil.phoneNumber(telePhone);
							if (phoneFlag) {
								ggEmployee.setTelePhone(telePhone);
							}else {
								checkStatus = "telphoneError"+"+"+(i+1);
							}
						}*/
							//校验工种不可为空
							/*if (departmentCode1 != null) {
							if (departmentCode1.length()>0) {
								// 反编译部门代码
								String departmentCode = ggemployeeService.insertToExcelPersons(departmentCode1);
								if (departmentCode.length()>0) {
									ggEmployee.setDepartmentCode(departmentCode);
								}else {
									checkStatus = "departmentCodeError"+"+"+(i+1);
								}
							}
						} else {
							checkStatus = "departmentCodeIsNotNull"+"+"+(i+1);
							break;
						}*/
							//校验地址不可为空
							/*if (address != null) {
							if (address.length()>0) {
								ggEmployee.setAddress(address);
							}
						}
						else {
							checkStatus = "addressIsNotNull"+"+"+(i+1);//地址不可为空
						}*/
							ggEmployee.setEmId(gguser.getUserCode() + new Date().getTime() + i);
							ggEmployee.setUserCode(gguser.getUserCode());
							ggEmployee.setValidStatus("1");
							ggemployeeService.insertPersons(ggEmployee);
							
							checkStatus = "success"+"+"+(i+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			writer.write(checkStatus);
//			this.userDetails();
	}
}
