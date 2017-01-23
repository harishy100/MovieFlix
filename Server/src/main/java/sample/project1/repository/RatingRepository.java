package sample.project1.repository;

import java.util.List;

import sample.project1.entity.Comment;
import sample.project1.entity.Movie;
import sample.project1.entity.User;
import sample.project1.entity.Rating;

public interface RatingRepository {
	public List<Rating> getmovierating(String id);
	public void insertrating(Rating rtg);
	public void updaterating(Rating rtg);
	public Rating findifratingexists(Rating rtg);
}
