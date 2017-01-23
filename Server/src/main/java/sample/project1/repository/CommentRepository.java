package sample.project1.repository;
import sample.project1.entity.*;
import java.util.*;
public interface CommentRepository {
	public List<Comment> getmoviecomments(String id);
	public void insertcomment(Comment cmt);
	public void updatecomment(Comment cmt);
	public Comment findifcommentexists(Comment cmt);
	
}
