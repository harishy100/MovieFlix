package sample.project1.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findallMovies/TV", query = "SELECT e FROM Movie e WHERE e.type= :typ"),
	@NamedQuery(name = "Movie.findtoptv/movie", query = "SELECT e FROM Movie e WHERE e.type=:typ ORDERBY :attribute"),
	@NamedQuery(name = "Movie.findbytitle", query = "SELECT e FROM Movie e WHERE e.title=:name"),
	@NamedQuery(name="Movie.sortbyattribute", query="SELECT e FROM Movie e ORDERBY :attribute")
})
public class Movie {

	@Id
	private String id;
	@Column(unique=true)
	private String title;
	private String year;
	
	private String rated;
	private String director;
	private String released;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metaScore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbId;
	private String type;
	private String Actor;
	private String Writer;
	private String Genre;
	
	

	public String getActor() {
		return Actor;
	}



	public void setActor(String actor) {
		Actor = actor;
	}



	public String getWriter() {
		return Writer;
	}



	public void setWriter(String writer) {
		Writer = writer;
	}



	public String getGenre() {
		return Genre;
	}



	public void setGenre(String genre) {
		Genre = genre;
	}



	public Movie() {
		this.id = UUID.randomUUID().toString();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getRated() {
		return rated;
	}



	public void setRated(String rated) {
		this.rated = rated;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public String getReleased() {
		return released;
	}



	public void setReleased(String released) {
		this.released = released;
	}



	public String getPlot() {
		return plot;
	}



	public void setPlot(String plot) {
		this.plot = plot;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getAwards() {
		return awards;
	}



	public void setAwards(String awards) {
		this.awards = awards;
	}



	public String getPoster() {
		return poster;
	}



	public void setPoster(String poster) {
		this.poster = poster;
	}



	public String getMetaScore() {
		return metaScore;
	}



	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}



	public String getImdbRating() {
		return imdbRating;
	}



	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}



	public String getImdbVotes() {
		return imdbVotes;
	}



	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}



	public String getImdbId() {
		return imdbId;
	}



	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
}