package com.spring.took.api;

import com.spring.took.api.Todo.Entity.*;
import com.spring.took.api.Todo.Enum.BookingStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class Working implements CommandLineRunner {
private PassengerReposistory passengerReposistory;

@Lazy
private DriverRepository driverRepository;

private BookingRepository bookingRepository;
    public Working(PassengerReposistory passengerReposistory , DriverRepository driverRepository , BookingRepository bookingRepository) {
        this.passengerReposistory = passengerReposistory;
        this.driverRepository = driverRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Booking booking = new Booking();
//        Review review = new Review();
//Driver driver = new Driver();
//
//        review.setUsername("hoss");
//        review.setPassword("4ha3");
//        booking.setReview(review);
//        booking.setBookingStatus(BookingStatus.IN_RIDE);
//        booking.setTotalDistance(1200);
//        driver.setBookings();
//
//       passengerReposistory.save(booking);
//
//        Driver driver = driverRepository.HibernatefindbyDriverIdWithLicence(1, "80XXXo9214");
//if (driver.isPresent()){
//    List<Booking> byDriver = passengerReposistory.findByDriverId(1);
////    System.out.println(driver.get().getBookings());
//
//}
//        ArrayList<Long> driver_id = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
//        List<Driver> driverList = driverRepository.findAllByIdIn(driver_id);
////        List<Booking> bookingList = bookingRepository.findAllByDriverIn(driverList);
////        System.out.println(bookingList);
////        System.out.println(driverList);
//        for(Driver driver : driverList){
//           final List<Booking> bookings = driver.getBookings();
//            bookings.forEach(s-> System.out.println(s.getId()));
//        }
    }
}
