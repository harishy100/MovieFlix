package sample.project1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.project1.entity.*;
import sample.project1.service.*;

@RestController
@RequestMapping(value="comment")
public class CommentController {
	@Autowired
	private CommentService service;
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public List<Comment> getmoviecomments(@PathVariable("id") String id){
		return service.getmoviecomments(id);
	}
	@RequestMapping(method=RequestMethod.POST)
	public void insertcomment(@RequestBody Comment cmt){
		service.insertcomment(cmt);
	}
}
