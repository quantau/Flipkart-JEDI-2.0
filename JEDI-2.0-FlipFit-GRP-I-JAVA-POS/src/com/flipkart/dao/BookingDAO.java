package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.BookingDetails;

import java.util.List;

public interface BookingDAO {

    public List<BookingDetails> getBookingByCustomerId(String username);

    public String addBooking(String username, String scheduleId);

    public void cancelBookingById(String bookingID);

    public Booking getBookingByBookingId(String bookingId);
}
