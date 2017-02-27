package sample.project1.controller;
import sample.project1.entity.*;

import sample.project1.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sample.project1.service.*;

@RestController
@CrossOrigin("http://localhost:4000")
public class MovieController {
	@Autowired
	private MovieService service;
	
	
	@RequestMapping(method=RequestMethod.GET,value= "movies")
	@ApiOperation(value = "Find all Movies", notes = "Returns all the movies")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findallMovies(){
		return service.findallMovies();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "tv")
	@ApiOperation(value = "Find all Tv series", notes = "Returns all the tv series")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findallTv(){
		return service.findallTv();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "movies/toprated")
	@ApiOperation(value = "Find all topRated Movies", notes = "Returns all the toprated movies")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findtopmovie(){
		return service.findtopmovie();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "tv/toprated")
	@ApiOperation(value = "Find all toprated Tv", notes = "Returns all the toprated tv series")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> findtoptv(){
		return service.findtoptv();
	}
	
	@RequestMapping(method=RequestMethod.POST,value= "admin/createmovie")
	@ApiOperation(value = "Create Movie", notes = "Creates a movie in the app with all the details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie createmovie(@RequestBody Movie mve){
		return service.createmovie(mve); 
	}
	
	@RequestMapping(method=RequestMethod.PUT,value= "admin/updatemovie")
	@ApiOperation(value = "Update Movie", notes = "Update a movie in the application")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie updatemovie(@RequestBody Movie mve){
		return service.updatemovie(mve);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value= "admin/deletemovie/{id}")
	@ApiOperation(value = "Delete Movie", notes = "Deletes a movie in the application given the Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "NotFound"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public void deletemovie(@PathVariable("id") String id){
		service.deletemovie(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value= "movies/{id}")
	@ApiOperation(value = "Create User", notes = "Creates a user in the app with unique email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Movie findmovie(@PathVariable("id") String id){
		return service.findmovie(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="sort/{attribute}")
	@ApiOperation(value = "Sort movies", notes = "Sort the movies by given attribute")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> sortbyattribute(@RequestParam Map<String,String> reqparams){
		return service.filterbyattribute(reqparams);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="filter")
	@ApiOperation(value = "Filter movies", notes = "Sort the movies by given filters")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Movie> filterbyattribute(@RequestParam Map<String,String> reqparams){		
		return service.filterbyattribute(reqparams);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="imdb/{id}")
	@ApiOperation(value = "Get IMDB ID", notes = "Find the IMDB ID of the movie by the given movie ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findimdbid(@PathVariable("id") String id){
		return service.findimdbid(id);
	}
}
