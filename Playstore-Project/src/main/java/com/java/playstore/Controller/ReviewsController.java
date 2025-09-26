package com.java.playstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.playstore.Entity.Reviews;
import com.java.playstore.Service.ReviewsService;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;
    @PostMapping("/saveReviews")
    public ResponseEntity<Reviews> saveReviews(@RequestBody Reviews reviews) {
        return new ResponseEntity<Reviews>(reviewsService.saveReviews(reviews), HttpStatus.CREATED);
    }

}
