package sample.project1.controller;
import sample.project1.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.project1.entity.*;

@RestController
@RequestMapping(value="rating")
public class RatingController {
	@Autowired
	private RatingService service;
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public float getmovierating(@PathVariable("id") String id){
		return service.getmovierating(id);
	}
	@RequestMapping(method=RequestMethod.POST)
	public void insertrating(@RequestBody Rating rtg){
		service.insertrating(rtg);
	}
}
