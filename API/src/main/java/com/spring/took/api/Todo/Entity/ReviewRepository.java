package com.spring.took.api.Todo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByRatingLessThanEqual(Integer givenRating);

    Integer countAllByRatingLessThan(Integer givenRating);



    List<Review> findAllByCreateAtBefore(Date date);
}
