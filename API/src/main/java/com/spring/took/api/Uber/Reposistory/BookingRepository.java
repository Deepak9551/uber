package com.spring.took.api.Uber.Reposistory;

import com.spring.took.api.Uber.Entity.Booking;
import com.spring.took.api.Uber.Entity.Driver;
import com.spring.took.api.Uber.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
List<Booking> findAllByDriverIn(List<Driver> drivers);
    List<Booking> findAllByDriverId(long driversId);

    @Query("select r from Booking b inner join Review r  where b.id = :id")
    Review findReviewByBooingId(Long id);

}