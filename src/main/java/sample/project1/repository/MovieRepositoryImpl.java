package sample.project1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import sample.project1.entity.Movie;
import sample.project1.entity.Rating;
@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findallMovies() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findallMovies/Tv", Movie.class);
		query.setParameter("typ","Movie");
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findtopmovie() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findtoptv/movie", Movie.class);
		query.setParameter("typ","Movie");
		query.setParameter("attribute","imdbRating");
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> sortbyattribute(String attribute) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortbyattribute", Movie.class);
		query.setParameter("attribute",attribute);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public Movie findByTitle(String s) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findbytitle", Movie.class);
		query.setParameter("name",s);
		List<Movie> movies = query.getResultList();	
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie createmovie(Movie mve) {
		em.persist(mve);
		return mve;

	}

	@Override
	public Movie updatemovie(Movie mve) {
		return em.merge(mve);
	
	}

	@Override
	public void deletemovie(Movie mve) {	
		em.remove(mve);
	}

	@Override
	public List<Movie> findtoptv() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findtoptv/movie", Movie.class);
		query.setParameter("typ","tv");
		query.setParameter("attribute","imdbRating");
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> findallTv() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findallMovies/Tv", Movie.class);
		query.setParameter("typ","tv");
		List<Movie> movies = query.getResultList();
		return movies;
	}

}
