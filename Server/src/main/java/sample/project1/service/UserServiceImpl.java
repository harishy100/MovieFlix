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
		// TODO Auto-generated method stub
		//User usr1= repository.findByEmail(usr.getEmail());
		//if(usr1!=null){
		//	throw new BadRequestException("Employee aready exists");
		//}
		return repository.create(usr);
	} 
}
