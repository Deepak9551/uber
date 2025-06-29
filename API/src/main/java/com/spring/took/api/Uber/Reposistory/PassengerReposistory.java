package com.spring.took.api.Uber.Reposistory;

import com.spring.took.api.Uber.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerReposistory extends JpaRepository<Booking, Long> {
    List<Booking>  findByDriverId(long id);
}
