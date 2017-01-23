package sample.project1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.project1.entity.Rating;
import sample.project1.repository.*;
@Service
@Transactional
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository repository;
	private List<Integer> intg;
	@Override
	public float getmovierating(String id) {
		List<Rating> rtg=repository.getmovierating(id);
		if(rtg==null){
			return 0;
		}
		else{
			for (Rating result : rtg) {
			    intg.add(result.getRating());
			}
		return this.average(intg);
		}
	
	}
	public float average(List<Integer> list) {
	    
	    if (list == null || list.isEmpty())
	        return 0;
	    long sum = 0;
	    int n = list.size();
	    for (int i = 0; i < n; i++)
	        sum += list.get(i);
	    return (float) ((sum) / n);
	}

	@Override
	public void insertrating(Rating rtg) {
		Rating rtg1=repository.findifratingexists(rtg);
		if(rtg1!=null){
			repository.updaterating(rtg);
		}
		else{
		repository.insertrating(rtg);
		}
		
	}

}
