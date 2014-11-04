package com.exigen.robbie.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.exigen.robbie.commons.IBaseService;
import com.exigen.robbie.domain.Class;
import com.exigen.robbie.domain.Content;
import com.exigen.robbie.domain.Student;
import com.exigen.robbie.service.IClassService;
import com.exigen.robbie.service.IContentService;
import com.exigen.robbie.service.IStudentService;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@ParentPackage(value="json-default")
@SuppressWarnings("serial")
@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Login extends ActionSupport {
	
//	private final Logger debugLog = Logger.getLogger("debug");
	
//	private final Logger infoLog = Logger.getLogger("info");
	
	private Configuration cfg;
	
	private List<Class> classList;
	
	private List<Student> studentList;
	
	private Pageable pageable;
	
	private int pageNo = 1;
	
	private String name;
	
	private String teacher;
	
	private String clazzId;
	
	private Class clazz;
	
	private Student student;
	
	private String birthday;
	
	private String result = "";
	
	private Content content;
	
	private String text;
	
	private String classIds = "";
	
	private String msg = "";
	
	@Resource
	private IClassService classService;
	
	@Resource
	private IStudentService studentService;
	
	@Resource
	private IContentService contentService;
	
	@Action(value="/flow/login",results={@Result(location="/WEB-INF/pages/success.jsp",type="dispatcher")})
	public String login(){
		return SUCCESS;
	}
	
	@Action(value="/flow/addClass",results={@Result(location="queryClasses",type="chain")})
	public String addClass() {
		Class clazz = new Class();
		clazz.setName(name);
		clazz.setTeacher(teacher);
		classService.save(clazz);
		return SUCCESS;
	}
	
	@Action(value="/flow/queryClasses",results={@Result(location="/WEB-INF/pages/classList.jsp",type="dispatcher")})
	public String queryClasses() {
		
		classList = classService.findAll();
		return SUCCESS;
	}
	
	@Action(value="/flow/getAllClass")
	public void getAllClass(){
//		JSONArray jsonArray = new JSONArray();
		classList = classService.findAll();
		
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		JsonFactory factory = new JsonFactory();
		try {
			JsonGenerator generator = factory.createJsonGenerator(sw);
			objectMapper.writeValue(generator, classList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		JSONArray jsonObject = JSONArray.fromObject(classList);
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(sw.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value="/flow/queryStudents")
	public void queryStudents(){
		cfg = new Configuration();
		ServletContext actionContext = ServletActionContext.getServletContext();
		cfg.setServletContextForTemplateLoading(actionContext, "WEB-INF/ftl");
		Map root = new HashMap();
		studentList = studentService.findAll();
		root.put("studentList", studentList);
		Template template;
		
		try {
			template = cfg.getTemplate("studentList.ftl");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			template.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value="/flow/saveContent",results={@Result(location="/WEB-INF/pages/success.jsp",type="dispatcher")})
	public String saveContent(){
		if (content != null) {
			contentService.save(content);
		}
		
		return SUCCESS;
	}
	
//	@Action(value="showArticle",results={@Result(location="/WEB-INF/pages/article.jsp",type="dispatcher")})
//	public String showArticle() {
//		List<Content> contentList = null;
//		content = null;
//		contentList = contentService.getAll();
//		if (contentList != null) {
//			content = contentList.get(0);
//			text = content.getContent();
//		}
//		
//		return SUCCESS;
//	}
	
	
	@Action(value="/flow/getStudents",results={@Result(type="json",params={"root","result"})})
	public String getStudents(){
		int nextPageNo = 0;
		int previousPageNo = 0;
		int currentPageNo = 0;
		long totlePage = 0;
		pageable = new PageRequest(pageNo,2);
		Page<Student> pageResult = null;
		pageResult = studentService.findAll(pageable);
		if (pageResult != null) {
			studentList = pageResult.getContent();
			currentPageNo = pageResult.getNumber();
			nextPageNo = pageResult.hasNextPage() ? currentPageNo + 1 : currentPageNo;
			previousPageNo = pageResult.hasPreviousPage() ? currentPageNo - 1 : currentPageNo;
			totlePage = pageResult.getTotalPages();
		} else {
			studentList = new ArrayList<Student>();
			pageNo = 1;
		}
		StringBuffer resultTemp = new StringBuffer();
		String pageString = ",\"previousPageNo\":" + previousPageNo + ",\"nextPageNo\":" + nextPageNo + 
			",\"currentPageNo\":" + currentPageNo + ",\"totlePage\":" + totlePage;
//		JSONArray jsonArray = new JSONArray();
//		for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext();) {
//			Student student = iterator.next();
//			JSONObject obj = JSONObject.fromObject(student);
//			jsonArray.add(obj);
//		}
		resultTemp.append("{\"result\":");
//		resultTemp.append(jsonArray);
		
		// students list
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		JsonFactory factory = new JsonFactory();
		try {
			JsonGenerator generator = factory.createJsonGenerator(sw);
			objectMapper.writeValue(generator, studentList);
			System.out.println("Jackson json:" + sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultTemp.append(sw.toString());
//		debugLog.debug(sw);
		
		resultTemp.append(pageString);
		resultTemp.append("}");
		
		result = resultTemp.toString();
//		infoLog.info(result);
		
		return SUCCESS;
	}
	
	@Action(value="/flow/addStudents",results={@Result(location="queryClasses",type="chain")})
	public String addStudents() {
		if (student != null) {
			if (StringUtils.isNotBlank(birthday)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date newbirthday;
				try {
					newbirthday = dateFormat.parse(birthday);
					student.setBirthday(newbirthday);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			studentService.save(student);
		}
		return SUCCESS;
	}
	
	@Action(value="/flow/deleteClasses",results={@Result(location="queryClasses",type="chain"),@Result(name=ERROR,location="/WEB-INF/pages/error.jsp",type="dispatcher")})
	public String deleteClasses() {
		if (StringUtils.isNotEmpty(classIds)) {
			String[] idArray = classIds.split(",");
			int length = idArray.length;
			for (int i = 0; i < length; i++) {
				try {
					classService.delete(idArray[i]);
				} catch (Exception e) {
					msg = "此班级含有学生，不能删除！";
					return ERROR;
				}
			}
		}
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public List<Class> getClassList() {
		return classList;
	}

	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}

	public IBaseService<Class, String> getClassService() {
		return classService;
	}

	public void setClassService(IClassService classService) {
		this.classService = classService;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public IBaseService<Student, String> getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getClazzId() {
		return clazzId;
	}

	public void setClazzId(String clazzId) {
		this.clazzId = clazzId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public IBaseService<Content, String> getContentService() {
		return contentService;
	}

	public void setContentService(IContentService contentService) {
		this.contentService = contentService;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getClassIds() {
		return classIds;
	}

	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
}
