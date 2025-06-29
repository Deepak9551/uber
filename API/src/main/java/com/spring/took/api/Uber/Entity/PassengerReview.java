package com.spring.took.api.Uber.Entity;

import jakarta.persistence.Entity;

@Entity
public class PassengerReview extends Review{

    private String passengerReviewContent;

    private String passengerRating;

    public String getPassengerReviewContent() {
        return passengerReviewContent;
    }

    public void setPassengerReviewContent(String passengerReviewContent) {
        this.passengerReviewContent = passengerReviewContent;
    }

    public String getPassengerRating() {
        return passengerRating;
    }

    public void setPassengerRating(String passengerRating) {
        this.passengerRating = passengerRating;
    }
}
