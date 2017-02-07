package sample.project1.repository;

import java.util.List;

import sample.project1.entity.Movie;

public interface MovieRepository {
	public List<Movie> findallMovies();
	public List<Movie> findallTv();
	public List<Movie> findtopmovie();
	public List<Movie> findtoptv();
	public Movie createmovie(Movie mve);
	public Movie updatemovie(Movie mve);
	public void deletemovie(Movie mve);
	public Movie findByTitle(String s);
	public String findimdbid(String id);
	
	// Methods for filtering and sorting the movies according to attribute type, genre, year, sort
	public List<Movie> filterbyattributeyear(String value);
	public List<Movie> filterbyattributetype(String value);
	public List<Movie> filterbyattributegenre(String value);
	public List<Movie> filterbysort(String value);
	public List<Movie> filterbytypeyear(String value,String value1);
	public List<Movie> filterbytypegenre(String value,String value1);
	public List<Movie> filterbytypesortattr(String value,String value1);
	public List<Movie> filterbyyeargenre(String value,String value1);
	public List<Movie> filteryearsortattr(String value,String value1);
	public List<Movie> filterbygenresortattr(String value,String value1);
	public List<Movie> filterbytypeyeargenre(String value,String value1,String value2);
	public List<Movie> filterbytypeyearsortattr(String value,String value1,String value2);
	public List<Movie> filterbytypegenresortattr(String value,String value1,String value2);
	public List<Movie> filteryeargenresortattr(String value,String value1,String value2);
	public List<Movie> filterbytypeyeargenresortattr(String value,String value1,String value2,String value3);
}
