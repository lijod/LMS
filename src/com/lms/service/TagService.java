package com.lms.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.lms.dao.TagDao;
import com.lms.model.Tag;

@Path("jwsTagService")
public class TagService {

	@GET
	@Path("findAllTags")
	public List<Tag> findAllTags(){
		return new TagDao().findAllTags();
	}
	
	@POST
	@Path("createTag")
	public Tag createTag(Tag tag){
		return new TagDao().createTag(tag);
	}

}
