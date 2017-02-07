package sample.project1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Genre {


	@Id
	private String genrename;
	
	public Genre() {
		this.genrename = "";
	}
	
	public Genre(String genrename) {
		this.genrename = genrename;
	}

	public String getGenrename() {
		return this.genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}
	
	
}