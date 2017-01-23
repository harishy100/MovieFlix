package sample.project1.entity;
import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Comment.findCommentByMovie", query = "SELECT r.Comment FROM Comment r WHERE r.mve.id=:movieid"), 
	@NamedQuery(name= "Comment.findIfCommentExists", query= "SELECT r FROM Comment r WHERE r.mve=:movie AND r.usr=:user"),
	@NamedQuery(name = "Comment.updateComment", query="UPDATE Comment r SET r.comment= :newComment WHERE r=:Comment")
})
public class Comment {

	@Id
	private String id;
	private String comment;
	@ManyToOne
	private User usr;
	@ManyToOne
	private Movie mve;
	
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public Movie getMve() {
		return mve;
	}
	public void setMve(Movie mve) {
		this.mve = mve;
	}
	
	public Comment(){
		this.id= UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
