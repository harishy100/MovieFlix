package sample.project1.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import sample.project1.entity.Actor;
import sample.project1.entity.Genre;
import sample.project1.entity.Movie;
import sample.project1.entity.Rating;
@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@Override
	public List<Movie> filterbyattributeyear(String value) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyattributeyear", Movie.class);
		query.setParameter("value",value);
		List<Movie> movies = query.getResultList();
		return movies;
		
	}

	@Override
	public List<Movie> filterbyattributetype(String value) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyattributetype", Movie.class);
		query.setParameter("value",value);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbyattributegenre(String value) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyattributegenre", Movie.class);
		query.setParameter("value",value);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbysort(String value) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbysort", Movie.class);
		query.setParameter("value",value);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypeyear(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypeyear", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypegenre(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypegenre", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypesortattr(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypesortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbyyeargenre(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyyeargenre", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filteryearsortattr(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyyearsortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbygenresortattr(String value, String value1) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbygenresortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypeyeargenre(String value, String value1, String value2) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypeyeargenre", Movie.class);
		query.setParameter("typ","Movie");
		query.setParameter("attribute","imdbRating");
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypeyearsortattr(String value, String value1, String value2) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypeyearsortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		query.setParameter("value2",value2);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypegenresortattr(String value, String value1, String value2) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypegenresortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		query.setParameter("value2",value2);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filteryeargenresortattr(String value, String value1, String value2) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbyyeargenresortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		query.setParameter("value2",value2);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@Override
	public List<Movie> filterbytypeyeargenresortattr(String value, String value1, String value2, String value3) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterbytypeyeargenresortattr", Movie.class);
		query.setParameter("value",value);
		query.setParameter("value1",value1);
		query.setParameter("value2",value2);
		query.setParameter("value3",value3);
		
		List<Movie> movies = query.getResultList();
		return movies;
	}

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findallMovies() {
		TypedQuery<Movie> query = em.createQuery("SELECT e FROM Movie e WHERE e.type= :typ",Movie.class);
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
		List<Genre> genres = mve.getGenres();
		for(Genre genre: genres){
			em.persist(genre);
		}
		
		List<Actor> actors = mve.getActors();
		for(Actor actor: actors){
			em.persist(actor);
		}
		
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

	@Override
	public String findimdbid(String id) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findimdbid", Movie.class);
		query.setParameter("movieid",id);
		Movie movie = query.getSingleResult();
		return movie.getImdbId();
	}
	

}
