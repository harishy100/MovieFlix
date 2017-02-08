package sample.project1.service;

import java.util.List;
import java.util.Map;

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
		Movie m;
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
	public List<Movie> findallMovies() {
		return repository.findallMovies();
	}
	
	@Override
	public Movie findmovie(String id) {
		Movie m=repository.findByTitle(id);
		if(m==null){
			throw new EntityNotFoundException("Movie doesnt exist");
		}
		return null;
	}

	@Override
	public List<Movie> findallTv() {	
		return repository.findallTv();
	}
	
	@Override
	public List<Movie> filterbyattribute(Map<String,String> reqparam){
		
		String type=reqparam.get("type");String year=reqparam.get("year");String genre=reqparam.get("genre");String sortattr=reqparam.get("sort");
		if(type!=null && year==null&& genre==null &&sortattr==null){
			return repository.filterbyattributetype(type);
		}
		else if(type==null && year!=null && genre==null && sortattr==null ){
			return repository.filterbyattributeyear(year);
		}
		else if(type==null && year==null && genre!=null && sortattr==null){
			System.err.println("right place");
			return repository.filterbyattributegenre(genre);
		}
		else if(type==null && year==null && genre==null && sortattr!=null){
			return repository.filterbysort(sortattr);
		}
		else if(type!=null && year!=null && genre==null && sortattr==null){
			return repository.filterbytypeyear(type,year);
		}
		else if(type!=null && year==null && genre!=null && sortattr==null){
			return repository.filterbytypegenre(type,genre);
		}
		else if(type!=null && year==null && genre==null && sortattr!=null){
			return repository.filterbytypesortattr(type,sortattr);
		}
		else if(type==null && year!=null && genre!=null && sortattr==null){
			return repository.filterbyyeargenre(year,genre);
		}
		else if(type==null && year!=null && genre==null && sortattr!=null){
			return repository.filteryearsortattr(year,sortattr);
		}
		else if(type==null && year==null && genre!=null && sortattr!=null){
			return repository.filterbygenresortattr(genre,sortattr);
		}
		else if(type!=null && year!=null && genre!=null && sortattr==null){
			return repository.filterbytypeyeargenre(type,year,genre);
		}
		else if(type!=null && year!=null && genre==null && sortattr!=null){
			return repository.filterbytypeyearsortattr(type,year,sortattr);
		}
		else if(type!=null && year==null && genre!=null && sortattr!=null){
			return repository.filterbytypegenresortattr(type,genre,sortattr);
		}
		else if(type==null && year!=null && genre!=null && sortattr!=null){
			return repository.filteryeargenresortattr(year,genre,sortattr);
		}
		else if(type!=null && year!=null && genre!=null && sortattr!=null){
			return repository.filterbytypeyeargenresortattr(type,year,genre,sortattr);
		}
		return null;
	}

	@Override
	public String findimdbid(String id) {
		String s=repository.findimdbid(id);
		if(s==null){
			throw new EntityNotFoundException("imdb title doesnt exist");
		}
		return s;
		
	}
	
}
