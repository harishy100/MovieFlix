package sample.project1.entity;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findallMovies/Tv", query = "SELECT e FROM Movie e WHERE e.type= :typ"),
	@NamedQuery(name = "Movie.findtoptv/movie", query = "SELECT e FROM Movie e WHERE e.type=:typ order by :attribute DESC"),
	@NamedQuery(name = "Movie.findbytitle", query = "SELECT e FROM Movie e WHERE e.title=:name"),
	@NamedQuery(name="Movie.filterbyattributeyear",query = "SELECT m FROM Movie m WHERE m.year=:value"),
	@NamedQuery(name="Movie.filterbyattributetype",query = "SELECT m FROM Movie m WHERE m.type=:value"),
	@NamedQuery(name="Movie.filterbyattributegenre",query = "SELECT m FROM Movie m left join m.genres g where g.genrename=:value"),
	@NamedQuery(name="Movie.filterbysort",query = "SELECT m FROM Movie m ORDER BY :value"),
	@NamedQuery(name="Movie.filterbytypeyear",query = "SELECT m FROM Movie m WHERE m.type=:value AND m.year=:value1"),
	@NamedQuery(name="Movie.filterbytypegenre",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value1 and m.type=:value"),
	@NamedQuery(name="Movie.filterbytypesortattr",query="SELECT m FROM Movie m WHERE m.type=:value ORDER BY :value1"),
	@NamedQuery(name="Movie.filterbyyeargenre",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value1 and m.year=:value"),
	@NamedQuery(name="Movie.filterbyyearsortattr",query="SELECT m FROM Movie m WHERE m.year=:value ORDER BY :value1"),
	@NamedQuery(name="Movie.filterbygenresortattr",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value ORDER BY :value1 DESC"),
	@NamedQuery(name="Movie.filterbytypeyeargenre",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value2 and m.type=:value AND m.year=:value1"),
	@NamedQuery(name="Movie.filterbytypeyearsortattr",query="SELECT m FROM Movie m WHERE m.type=:value AND m.year=:value1 ORDER BY :value2 DESC"),
	@NamedQuery(name="Movie.filterbytypegenresortattr",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value1 and m.type=:value ORDER BY :value2 DESC"),
	@NamedQuery(name="Movie.filterbyyeargenresortattr",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value1 and m.year=:value ORDER BY :value2 DESC"),
	@NamedQuery(name="Movie.filterbytypeyeargenresortattr",query="SELECT m FROM Movie m join m.genres Genre where Genre.genrename=:value1 AND m.type=:value AND m.year=:value2 ORDER BY :value3 DESC"),
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
	

	@ManyToMany
	private List<Genre> genres;
	
	@ManyToMany
	private List<Actor> actors;
	
	@ManyToMany
	private List<Writer> writers;

	public List<Genre> getGenres() {
		return this.genres;
	}

		public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
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


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", director=" + director
				+ ", released=" + released + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + ", Writer="
				+ writers + ", genres=" + genres + ", actors=" + actors + "]";
	}
	
	
}