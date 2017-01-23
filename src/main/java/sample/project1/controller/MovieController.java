package sample.project1.controller;
import sample.project1.entity.*;
import sample.project1.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.project1.service.*;

@RestController

public class MovieController {
	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET,value= "{movies}")
	public List<Movie> findallMovies(){
		return service.findallMovies();
	}
	@RequestMapping(method=RequestMethod.GET,value= "{tv}")
	public List<Movie> findallTv(){
		return service.findallTv();
	}
	@RequestMapping(method=RequestMethod.GET,value= "{movies/toprated}")
	public List<Movie> findtopmovie(){
		return service.findtopmovie();
	}
	@RequestMapping(method=RequestMethod.GET,value= "{tv/toprated}")
	public List<Movie> findtoptv(){
		return service.findtoptv();
	}
	@RequestMapping(method=RequestMethod.POST,value= "{admin/createmovie}")
	public Movie createmovie(Movie mve){
		return service.createmovie(mve);
	}
	@RequestMapping(method=RequestMethod.POST,value= "{admin/updatemovie}")
	public Movie updatemovie(Movie mve){
		return service.updatemovie(mve);
	}
	@RequestMapping(method=RequestMethod.DELETE,value= "{admin/deletemovie}")
	public void deletemovie(Movie mve){
		service.deletemovie(mve);
	}
	@RequestMapping(method=RequestMethod.GET,value= "{movie/id}")
	public void findmovie(@PathVariable("id") String id){
		service.findmovie(id);
	}
	@RequestMapping(method=RequestMethod.GET, value="{sort/attribute}")
	public List<Movie> sortbyattribute(@PathVariable("attribute") String attribute){
		return service.sortbyattribute(attribute);
	}
	
}
