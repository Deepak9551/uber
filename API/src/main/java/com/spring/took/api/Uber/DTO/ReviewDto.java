package com.spring.took.api.Uber.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.spring.took.api.Uber.Entity.Review}
 */
public class ReviewDto {
    private final String content;
    private final Double rating;
    private final long booking_id;

    public long getBooking_id() {
        return booking_id;
    }

    public ReviewDto(String content, Double rating, long bookingId) {
        this.content = content;
        this.rating = rating;
        booking_id = bookingId;
    }

    public String getContent() {
        return content;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto entity = (ReviewDto) o;
        return Objects.equals(this.content, entity.content) &&
                Objects.equals(this.rating, entity.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, rating);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "content = " + content + ", " +
                "rating = " + rating + ")";
    }
}