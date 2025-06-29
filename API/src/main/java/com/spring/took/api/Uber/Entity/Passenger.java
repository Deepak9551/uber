package com.spring.took.api.Uber.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

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
