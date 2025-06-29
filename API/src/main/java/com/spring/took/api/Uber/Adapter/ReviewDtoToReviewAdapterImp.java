package com.spring.took.api.Uber.Adapter;

import com.spring.took.api.Uber.DTO.ReviewDto;
import com.spring.took.api.Uber.Entity.Booking;
import com.spring.took.api.Uber.Entity.Review;
import com.spring.took.api.Uber.Reposistory.BookingRepository;
import com.spring.took.api.Uber.Reposistory.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewDtoToReviewAdapterImp implements ReviewDtoToReviewAdapter {

    private BookingRepository bookingRepository;

    public ReviewDtoToReviewAdapterImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(ReviewDto reviewDto) {
        Optional<Booking> booking =bookingRepository.findById(reviewDto.getBooking_id());
        return booking.map(value -> Review.builder().content(reviewDto.getContent()).rating(reviewDto.getRating()).booking(booking.get()).build()).orElse(null);
// if not null convert set Review Fetched object from DTO Review to original review
    }
}
