package com.spring.took.api.Uber.Controller;


import com.spring.took.api.Uber.Adapter.ReviewDtoToReviewAdapter;
import com.spring.took.api.Uber.DTO.ReturnReviewDto;
import com.spring.took.api.Uber.DTO.ReviewDto;
import com.spring.took.api.Uber.Entity.Review;
import com.spring.took.api.Uber.Reposistory.ReviewRepository;
import com.spring.took.api.Uber.Service.ReviewService;
import com.spring.took.api.Uber.Service.ReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {


private ReviewService reviewService ;
private ReviewDtoToReviewAdapter reviewDtoToReviewAdapter;
    public ReviewController(ReviewService reviewService , ReviewDtoToReviewAdapter reviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.reviewDtoToReviewAdapter = reviewDtoToReviewAdapter;
    }

    @PostMapping()
public ResponseEntity<?> addreview(@RequestBody ReviewDto review){

        Review incommingReview = reviewDtoToReviewAdapter.convertDto(review);
        if (incommingReview == null){
            return new ResponseEntity<>("Invalid Argument",HttpStatus.BAD_REQUEST);
        }
        Review publishReview = reviewService.publishReview(incommingReview);
        ReturnReviewDto returnReviewDto = ReturnReviewDto.builder().
                id(publishReview.getId()).content(publishReview.getContent()).
                rating(publishReview.getRating())
                .booking(publishReview.getBooking().getId()).createAt(publishReview.getCreateAt()).updateAt(publishReview.getModifiedAt()).build();
        return new ResponseEntity<>(returnReviewDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getreview(@PathVariable  Long id){
        try {
            Optional<Review> review = reviewService.findReviewById(id);

            return new ResponseEntity<>(review,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.findAllReviews();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable  Long id){
        try {
            Boolean isDeleted = reviewService.deleteReviewById(id);

            if (!isDeleted) return new ResponseEntity<>("Unable to delete review ",HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@RequestBody ReviewDto review , @PathVariable Long id){
        try {
            Review incommingReview = reviewDtoToReviewAdapter.convertDto(review);
            if (incommingReview == null){
                return new ResponseEntity<>("Invalid Argument",HttpStatus.BAD_REQUEST);
            }
            Review updateReview = reviewService.updateReview(id, incommingReview);
            return new ResponseEntity<>("Review updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>("Unable to update Review",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
