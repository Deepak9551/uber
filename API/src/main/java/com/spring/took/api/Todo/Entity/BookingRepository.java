package com.spring.took.api.Todo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
List<Booking> findAllByDriverIn(List<Driver> drivers);
    List<Booking> findAllByDriverId(long driversId);


}