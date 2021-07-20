package com.example.timemanager.test;

import android.os.Parcel;

import com.example.timemanager.MockParcel;
import com.example.timemanager.ui.bookings.Booking;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {
    Booking booking = new Booking("Buchung 1", 1);

    @Test
    public void getBookingName() {
    }

    @Test
    public void getTimeWorked() {
    }

    @Test
    public void setBookingName() {
    }

    @Test
    public void setTimeWorked() {
    }

    @Test
    public void describeContents() {
    }

    @Test
    public void newParcelTest() {
        Parcel parcel = MockParcel.obtain();
        booking.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Booking createdFromParcel = Booking.CREATOR.createFromParcel(parcel);
        assertEquals(booking.getBookingName(), createdFromParcel.getBookingName());
        assertNotEquals("TestParcle", createdFromParcel.getBookingName());
    }

}