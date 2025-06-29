package com.spring.took.api.Uber.Service;

import com.spring.took.api.Uber.Entity.Review;

import com.spring.took.api.Uber.EntityNotFoundException;
import com.spring.took.api.Uber.Reposistory.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;



@Service
public class ReviewServiceImp implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {

        Optional<Review> review;
        review = this.reviewRepository.findReviewById(id);
        try {
            if (review.isEmpty()) throw new EntityNotFoundException("Review not found with id " + id);
        } catch (Exception e) {
            if (e.getClass() == EntityNotFoundException.class) {
                throw new EntityNotFoundException("Review not found with id " + id);
            }
            throw new RuntimeException("error in data fetching , please try again later");
        }

        return review;
    }

    @Override
    public List<Review> findAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        if (reviews.isEmpty()) {
            throw new EntityNotFoundException("No Review is avaialable");
        }
        return reviews;
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try {
            Review review = reviewRepository.findReviewById(id).orElseThrow(EntityNotFoundException::new);
          this.reviewRepository.delete(review);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    @Override
    public Review publishReview(Review review) {



        return reviewRepository.save(review);

    }

    @Override
    public Review updateReview(Long id, Review review) {

        Optional<Review> foundReview = reviewRepository.findReviewById(id);

        foundReview.ifPresent(
                review2 -> {
                    review2.setContent(review.getContent() != null
                            ? review.getContent() : review2.getContent());
                    review2.setRating(review.getRating() != null
                            ? review.getRating() : review2.getRating());
                }
        );

        return reviewRepository.save(review);

    }
}