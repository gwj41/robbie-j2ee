package com.exigen.robbie.dao;

import com.exigen.robbie.commons.EntityDao;
import com.exigen.robbie.domain.Content;

// @RepositoryDefinition(domainClass = Content.class, idClass = String.class)
public interface IContentDao extends EntityDao<Content, String> {

}
