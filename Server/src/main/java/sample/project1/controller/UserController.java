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
		
		@RequestMapping(method=RequestMethod.POST, value= "login/{email/password}")
		public Boolean login( @PathVariable("email" ) String email, @PathVariable String password){
			return service.login(email,password);
		}
		@RequestMapping(method=RequestMethod.POST)
		public User create(@RequestBody User usr){
			return service.create(usr);	
		}
		
	}
	

		


