package com.spring.took.api.Todo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Passenger  extends BaseModel{

    @Column(name = "content")
    private String passengerReviewContent;

    @Column(name = "rating")
    private String passengerRating;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();

}
