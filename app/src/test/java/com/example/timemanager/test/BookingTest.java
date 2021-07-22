package com.example.timemanager.test;

import android.os.Parcel;

import com.example.timemanager.MockParcel;
import com.example.timemanager.ui.bookings.Booking;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {
    private final Booking b1 = new Booking ("Buchung 1", 11);

    /**
     * tests the method getBookingName
     */
    @Test
    public void getBookingName() {
        assertNotNull(b1.getBookingName());
        assertEquals("Buchung 1", b1.getBookingName());
        assertNotEquals("keine Buchung", b1.getBookingName());
    }

    /**
     * tests the method getTimeWorked
     */
    @Test
    public void getTimeWorked() {
        assertNotNull(b1.getTimeWorked());
        assertEquals(11, b1.getTimeWorked());
        assertNotEquals(1, b1.getTimeWorked());
    }

    /**
     * tests the method setBookingName
     * should not be null
     */
    @Test
    public void setBookingName() {
        b1.setBookingName("Neue Buchung");
        assertNotNull(b1.getBookingName());
        assertEquals("Neue Buchung", b1.getBookingName());
    }

    /**
     * tests the method setTimeWorked
     * should not be null or smaller than 1
     */
    @Test
    public void setTimeWorked() {
        b1.setTimeWorked(20);
        assertNotNull(b1.getTimeWorked());
        assertEquals(20, b1.getTimeWorked());
        assertNotEquals(-1, b1.getTimeWorked());
    }

    /**
     * tests the method describeContents
     */
    @Test
    public void describeContents() {
        assertNotNull(b1.describeContents());
        assertEquals(0, b1.describeContents());
        assertNotEquals(1, b1.describeContents());
    }

    /**
     * Test to check the method writeToParcel
     */
    @Test
    public void writeToParcel() {
        Parcel parcel = MockParcel.obtain();
        b1.writeToParcel(parcel, b1.describeContents());
        b1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Booking parcelableBooking = Booking.CREATOR.createFromParcel(parcel);
        assertEquals(b1.getBookingName(), parcelableBooking.getBookingName());
        assertNotEquals("keine Buchung", parcelableBooking.getBookingName());
    }

}