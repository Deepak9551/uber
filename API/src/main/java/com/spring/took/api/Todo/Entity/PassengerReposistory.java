package com.spring.took.api.Todo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerReposistory extends JpaRepository<Booking, Long> {
    List<Booking>  findByDriverId(long id);
}
