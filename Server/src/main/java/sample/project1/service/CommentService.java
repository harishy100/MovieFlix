package sample.project1.service;

import java.util.List;

import sample.project1.entity.Comment;

public interface CommentService {
	public List<Comment> getmoviecomments(String id);
	public void insertcomment(Comment cmt);
}
