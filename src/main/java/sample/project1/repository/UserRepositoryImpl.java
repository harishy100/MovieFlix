package sample.project1.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import sample.project1.entity.*;
import java.util.*;
@Repository
public class UserRepositoryImpl implements UserRepository{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User create(User usr){
		 em.persist(usr);
		 return usr;
	}
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);

		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		} else {
			return null;}
		
	}
}
