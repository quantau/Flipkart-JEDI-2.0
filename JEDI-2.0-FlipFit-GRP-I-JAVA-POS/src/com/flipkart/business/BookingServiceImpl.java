package com.flipkart.business;

import com.flipkart.bean.BookingDetails;
import com.flipkart.dao.BookingDAOImpl;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingServiceInterface{
    private final BookingDAOImpl bookingDAO = new BookingDAOImpl();
//    private final SlotServiceImpl slotService = new SlotServiceImpl();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        return true;
    }

    public void addBooking(String userName, String scheduleID) {
    }

    public List<BookingDetails> getBookingByCustomerId(String username){
        return bookingDAO.getBookingByCustomerId(username);
    }

//

    public void cancelBooking(String bookingID) {
    }

}
