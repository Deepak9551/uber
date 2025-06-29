package com.spring.took.api.Uber.Adapter;

import com.spring.took.api.Uber.DTO.ReviewDto;
import com.spring.took.api.Uber.Entity.Review;

public interface ReviewDtoToReviewAdapter {

    Review convertDto(ReviewDto reviewDto);
}
