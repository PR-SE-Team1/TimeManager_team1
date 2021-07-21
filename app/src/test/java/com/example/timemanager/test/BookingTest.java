package com.example.timemanager.test;

import android.os.Parcel;

import com.example.timemanager.MockParcel;
import com.example.timemanager.ui.bookings.Booking;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTest {
    private final Booking b1 = new Booking ("Buchung 1", 11);

    /**
     * test to check the getter for BookingName
     */
    @Test
    public void getBookingName() {
        assertNotNull(b1.getBookingName());
        assertEquals("Buchung 1", b1.getBookingName());
        assertNotEquals("keine Buchung", b1.getBookingName());
    }

    /**
     * test to check the getter for BookingName
     */
    @Test
    public void getTimeWorked() {
        assertNotNull(b1.getTimeWorked());
        assertEquals(11, b1.getTimeWorked());
        assertNotEquals(1, b1.getTimeWorked());
    }

    /**
     * test to check the getter for BookingName
     */
    @Test
    public void setBookingName() {
        b1.setBookingName("Neue Buchung");
        assertNotNull(b1.getBookingName());
        assertEquals("Neue Buchung", b1.getBookingName());
    }

    /**
     * test to check the getter for BookingName
     */
    @Test
    public void setTimeWorked() {
        b1.setTimeWorked(20);
        assertNotNull(b1.getTimeWorked());
        assertEquals(20, b1.getTimeWorked());
        assertNotEquals(-1, b1.getTimeWorked());
    }

//    /**
//     * test to check the getter for BookingName
//     */
//    @Test
//    public void describeContents() {
//        Parcel parcel = MockParcel.obtain();
//        b1.writeToParcel(parcel, b1.describeContents());
//        parcel.setDataPosition(0);
//        Booking parcelableBooking = Booking.CREATOR.createFromParcel(parcel);
//        assertEquals(b1.describeContents(), parcelableBooking.describeContents());
//    }

    /**
     * Test to check
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