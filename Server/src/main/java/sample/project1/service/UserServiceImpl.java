package sample.project1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.project1.repository.UserRepositoryImpl;
import sample.project1.exception.BadRequestException;
import sample.project1.entity.*;
import sample.project1.repository.*;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserRepository repository;
	@Override
	public User create(User usr) {

		User usr1= repository.findByEmail(usr.getEmail());
		if(usr1!=null){
			throw new BadRequestException("User aready exists");
		}
		return repository.create(usr);
	}
	@Override
	public Boolean login(String email, String password) {
		User usr=repository.findByEmail(email);
		if(usr==null){
			return false;
		}
		else{
			if(usr.getPassword().equals(password)){
				return true;
			}
			else{
				return false;
			}
		}
	
	} 
}
