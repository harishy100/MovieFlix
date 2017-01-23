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
	public List<Movie> sortbyattribute(String attribute);
}
