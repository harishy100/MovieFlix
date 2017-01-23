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
public class Genre {

	@Id
	private String id;
	
	private String genrename;

	public Genre() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenrename() {
		return genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}
	
	
}