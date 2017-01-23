package sample.project1.service;

import java.util.List;
import sample.project1.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.project1.entity.Movie;
import sample.project1.repository.*;
@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> findtopmovie() {
		
		return repository.findtopmovie();
	}

	@Override
	public List<Movie> findtoptv() {
		
		return repository.findtoptv();
	}

	@Override
	public Movie createmovie(Movie mve) {
		Movie mve1= repository.findByTitle(mve.getTitle());
		if(mve1!=null){
			throw new BadRequestException("Movie aready exists");
		}
		return repository.createmovie(mve);
	}

	@Override
	public Movie updatemovie(Movie mve) {
	
		Movie mve1= repository.findByTitle(mve.getTitle());
		if(mve1==null){
			throw new BadRequestException("Movie doesnt exist");
		}
		return repository.updatemovie(mve);
	}

	@Override
	public void deletemovie(Movie mve) {

		Movie mve1= repository.findByTitle(mve.getTitle());
		if(mve1==null){
			throw new BadRequestException("Movie doesnt exist");
		}
		repository.deletemovie(mve);
	}

	@Override
	public List<Movie> sortbyattribute(String attribute) {
		
		return repository.sortbyattribute(attribute);
	}

	@Override
	public List<Movie> findallMovies() {
		return repository.findallMovies();
	}
	
	@Override
	public Movie findmovie(String id) {
		repository.findByTitle(id);
		return null;
	}

	@Override
	public List<Movie> findallTv() {	
		return repository.findallTv();
	}
	
}
