package com.spring.took.api.Uber.Entity;

import com.spring.took.api.Uber.Enum.BookingStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class Booking extends BaseModel{




@Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @CreatedDate
    private Date startTime;


    private Date endTime;

    private long totalDistance;

    @ManyToOne( fetch = FetchType.LAZY)
    private Passenger passenger;

    @ManyToOne( fetch = FetchType.LAZY)
    private Driver driver;

    

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }



    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

}
