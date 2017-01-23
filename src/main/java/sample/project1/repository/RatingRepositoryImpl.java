package sample.project1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import sample.project1.entity.Movie;
import sample.project1.entity.Rating;
import sample.project1.entity.User;
@Repository
public class RatingRepositoryImpl implements RatingRepository{

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Rating> getmovierating(String id) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.getmovierating", Rating.class);
		query.setParameter("movieid",id);
		List<Rating> ratings = query.getResultList();
		return ratings;
	}

	@Override
	public void insertrating(Rating rtg) {
		// TODO Auto-generated method stub
		em.persist(rtg);
	}

	@Override
	public void updaterating(Rating rtg) {
		// TODO Auto-generated method stub
		em.merge(rtg);
	}

	@Override
	public Rating findifratingexists(Rating rtg) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findIfRatingExists", Rating.class);
		query.setParameter("movie",rtg.getMve());
		query.setParameter("user", rtg.getUsr());
		Rating rating = query.getSingleResult();
		return rating;
	}

}
