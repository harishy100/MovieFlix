package sample.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.project1.entity.Comment;
import sample.project1.entity.Rating;
import sample.project1.repository.*;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository repository;
	@Override
	public List<Comment> getmoviecomments(String id) {
		List<Comment> cmt=repository.getmoviecomments(id);
		if(cmt==null){
			return null;
		}
		else{
			return cmt;
		}
		
	}

	@Override
	public void insertcomment(Comment cmt) {
		Comment cmt1=repository.findifcommentexists(cmt);
		if(cmt1!=null){
			repository.updatecomment(cmt);
		}
		else{
		repository.insertcomment(cmt);
		}
		
		
	}

}
