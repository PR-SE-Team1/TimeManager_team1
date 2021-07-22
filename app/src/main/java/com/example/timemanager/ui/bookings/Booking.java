package com.example.timemanager.ui.bookings;


import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

// implements Parcelable to pass complex data from one activity to another activity
public class Booking implements Parcelable {
    //times need to be added
    private String bookingName;
    private int timeWorked;


    /**
     * constructor to initialize a task object
     * @param bookingName
     * @param
     * @param
     */
    public Booking(String bookingName, int timeWorked){
        this.bookingName = bookingName;
        this.timeWorked = timeWorked;

    }


    /**
     * retrieving task-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in
     */
    protected Booking(Parcel in) {
        bookingName = in.readString();
        timeWorked = in.readInt();

    }



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

    //GETTER
    public String getBookingName() {return bookingName; }
    public int getTimeWorked(){return timeWorked;}

    //SETTER
    public void setBookingName(@NotNull String bookingName){this.bookingName = bookingName; }
    public void setTimeWorked(@NotNull int timeWorked){
        if (timeWorked <= 0){
            return;
        }
        this.timeWorked = timeWorked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * storing the project data to a parcel-object
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookingName);
        dest.writeInt(timeWorked);
    }

}
