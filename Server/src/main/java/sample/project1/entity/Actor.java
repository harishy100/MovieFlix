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
public class Actor {

	@Id
	private String actorname;
	
	public Actor(){
		this.actorname = "";
	}
	
	public Actor(String actorname){
		this.actorname = actorname;
	}
	
	public String getActorname() {
		return actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}
	
}