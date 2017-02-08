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
public class Writer {

	@Id
	private String writername;

	public Writer() {
		this.writername="";
	}

	public String getWritername() {
		return writername;
	}

	public void setWritername(String writername) {
		this.writername = writername;
	}


	
}