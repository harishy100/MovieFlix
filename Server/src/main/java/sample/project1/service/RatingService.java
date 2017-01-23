package sample.project1.service;

import sample.project1.entity.Rating;

public interface RatingService {
	public float getmovierating(String id);
	public void insertrating(Rating rtg);
}
