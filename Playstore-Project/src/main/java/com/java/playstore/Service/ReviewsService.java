package com.java.playstore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.playstore.Entity.Reviews;
import com.java.playstore.Repository.ReviewsRepo;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepo reviewsRepo;

    public Reviews saveReviews(Reviews reviews) {
        return reviewsRepo.save(reviews);
    }

}
