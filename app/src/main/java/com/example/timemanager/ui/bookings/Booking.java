package com.example.timemanager.ui.bookings;


import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

/**
 * class needed to create booking-items used in other classes
 * implements Parcelable to pass complex data from one activity to another activity
 */
public class Booking implements Parcelable {
    private String bookingName;
    private int timeWorked;


    /**
     * constructor to initialize a task object
     * @param bookingName name of the booking
     * @param timeWorked time worked
     */
    public Booking(String bookingName, int timeWorked){
        this.bookingName = bookingName;
        this.timeWorked = timeWorked;
    }


    /**
     * retrieving task-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in retrieved data from parcel
     */
    protected Booking(Parcel in) {
        bookingName = in.readString();
        timeWorked = in.readInt();
    }

    /**
     * creating a new parcel
     * implemented from Parcel
     */
    public static final Creator<Booking> CREATOR = new Creator<Booking>() {
        @Override
        public Booking createFromParcel(Parcel in) {
            return new Booking(in);
        }

        @Override
        public Booking[] newArray(int size) {
            return new Booking[size];
        }
    };

    /**
     * gets the name of the booking
     * @return the name of the booking
     */
    public String getBookingName() {return bookingName; }

    /**
     * gets the time worked
     * @return the time worked
     */
    public int getTimeWorked(){return timeWorked;}

    /**
     * sets the name of the booking
     * @param bookingName name of the booking
     */
    public void setBookingName(@NotNull String bookingName){this.bookingName = bookingName; }

    /**
     * sets the time worked and checks if time entered is over 0
     * @param timeWorked booked time
     */
    public void setTimeWorked(@NotNull int timeWorked){
        if (timeWorked <= 0){
            return;
        }
        this.timeWorked = timeWorked;
    }

    /**
     * describe the kinds of objects contained in this representation
     * further information in implemented Parcelable
     * @return 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * storing the project data to a parcel-object
     * further information in implemented Parcelable
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookingName);
        dest.writeInt(timeWorked);
    }

}
