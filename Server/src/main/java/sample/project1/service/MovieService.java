package sample.project1.service;


import sample.project1.entity.Movie;
import java.util.*;

public interface MovieService {
	public List<Movie> findallMovies();
	public List<Movie> findallTv();
	public List<Movie> findtopmovie();
	public List<Movie> findtoptv();
	public Movie createmovie(Movie mve);
	public Movie updatemovie(Movie mve);
	public void deletemovie(Movie mve);
	public Movie findmovie(String id);
	public List<Movie> sortbyattribute(String attribute);
}
