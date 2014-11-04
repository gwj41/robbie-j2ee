package com.exigen.robbie.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exigen.robbie.domain.Content;
import com.exigen.robbie.service.IContentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class CKEditorAction extends ActionSupport {
	
	private Content content;
	
	private String text;
	
	private String text1;
	
	@Autowired
	private IContentService contentService;
	
	@Action(value="showArticle",results={@Result(location="/WEB-INF/pages/article.jsp",type="dispatcher")})
	public String showArticle() {
		List<Content> contentList = null;
		content = null;
		contentList = contentService.findAll();
		if (contentList != null) {
			content = contentList.get(0);
		}
		text = content.getContent();
		return SUCCESS;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public IContentService getContentService() {
		return contentService;
	}

	public void setContentService(IContentService contentService) {
		this.contentService = contentService;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

}
