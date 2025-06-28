package com.spring.took.api.Todo.Controller;


import com.spring.took.api.Todo.Entity.Review;
import com.spring.took.api.Todo.Entity.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
ReviewRepository reviewRepository;
    List<Review> reviews = new ArrayList<>();

    @PostMapping()
public void addreview(@RequestBody Review review){
        reviewRepository.save(review);

}

    @GetMapping("/id:")
    public Review getreview(long id){
        Review review = reviewRepository.findById(id).get();
return review;
    }

}
