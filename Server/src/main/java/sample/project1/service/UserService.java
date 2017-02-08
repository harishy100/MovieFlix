package sample.project1.service;
import sample.project1.entity.*;

public interface UserService {
	public User create(User usr);
	public Boolean login(String email,String password);
}
