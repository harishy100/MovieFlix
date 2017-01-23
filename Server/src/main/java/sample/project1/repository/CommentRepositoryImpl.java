package sample.project1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import sample.project1.entity.Comment;
import sample.project1.entity.Movie;
import sample.project1.entity.Rating;
import sample.project1.entity.User;
@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Comment> getmoviecomments(String id) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.getmoviecomments", Comment.class);
		query.setParameter("movieid",id);
		List<Comment> comments = query.getResultList();
		return comments;
	}

	@Override
	public void insertcomment(Comment cmt) {
		// TODO Auto-generated method stub
		em.persist(cmt);
	}

	@Override
	public void updatecomment(Comment cmt) {
		// TODO Auto-generated method stub
		em.merge(cmt);
	}

	@Override
	public Comment findifcommentexists(Comment cmt) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findIfCommentExists", Comment.class);
		query.setParameter("movie",cmt.getMve());
		query.setParameter("user", cmt.getUsr());
		Comment comt = query.getSingleResult();
		return comt;	
		}

}
