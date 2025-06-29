package com.spring.took.api.Uber.Service;

import com.spring.took.api.Uber.Entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

   Optional<Review> findReviewById(Long id);

   List<Review> findAllReviews();

   Boolean deleteReviewById(Long id);

   Review publishReview(Review review);

   Review updateReview(Long id , Review review);


}
