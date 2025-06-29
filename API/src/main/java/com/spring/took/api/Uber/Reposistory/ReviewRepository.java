package com.spring.took.api.Uber.Reposistory;

import com.spring.took.api.Uber.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByRatingLessThanEqual(Integer givenRating);

    Integer countAllByRatingLessThan(Integer givenRating);



    List<Review> findAllByCreateAtBefore(Date date);

    Optional<Review> findReviewById(Long id);
}
