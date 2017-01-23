package sample.project1.repository;
import sample.project1.entity.*;
public interface UserRepository {
	public User create(User usr);
	public User findByEmail(String email);
	
}
