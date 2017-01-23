package sample.project1.controller;
import java.util.List;


import sample.project1.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import sample.project1.entity.User;
import sample.project1.service.*;

@RestController

@RequestMapping(value= "user")

public class UserController {

		@Autowired
		private UserService service;
		@RequestMapping(method=RequestMethod.GET)
		
		public String findall(){
		return "hifi";
		}
	//	@RequestMapping(method=RequestMethod.GET, value= "{id}")
		//public User findone( @PathVariable("id" ) String id){
			//return service.findone(id);
		//}
		@RequestMapping(method=RequestMethod.POST)
		public User create(@RequestBody User usr){
			return service.create(usr);	
		}
		
	//	@RequestMapping(method=RequestMethod.PUT, value= "{id}")
		//public Employee update(String id, Employee emp){
			//return service.update(emp, id);
		//}
		
		//@RequestMapping(method=RequestMethod.DELETE, value= "{id}")
	//	public void delete(String id){
		//	service.delete(id);
			//}
		
	}
	

		


