package com.example.timemanager.ui.projects;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.timemanager.ui.bookings.Booking;
import com.example.timemanager.ui.tasks.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// implements Parcelable to pass complex data from one activity to another activity
//https://stackoverflow.com/questions/34503724/adding-data-to-a-parcelable-object-passed-to-another-activity

//dokumentation https://developer.android.com/reference/android/os/Parcelable

//another example https://www.vogella.com/tutorials/AndroidParcelable/article.html
public class Project  implements Parcelable {
    private String projName;
    private String description;
    private double plannedHours;
    private String color;
    //tasks need to be implemented
    private static List<Task> tasks;
    private static List<Booking> bookings;



    /**
     * constructor that initializes the Project object
     * @param projName
     * @param description
     * @param plannedHours
     * @param color
     *
     * to insert: , List<Task> tasks, List<Booking> bookings
     */
    public Project (String projName, String description, double plannedHours, String color){
        this.projName = projName;
        this.description = description;
        this.plannedHours = plannedHours;
        this.color = color;
//        this.tasks = new ArrayList<>();
//        this.bookings = new ArrayList<>();
    }

    public Project ( String projName){
        this.projName = projName;
    }

    /**
     * retrieving project-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in
     */
    protected Project(Parcel in) {
        projName = in.readString();
        description = in.readString();
        plannedHours = in.readDouble();
        color = in.readString();
//        tasks = in.createTypedArrayList(Task.CREATOR);
//        bookings = in.createTypedArrayList(Booking.CREATOR);
    }

    /**
     * delete after parcel is working
     */
    public Project() {

    }

    //GETTER

    public String getProjName() {
        return projName;
    }
    public String getDescription() {
        return description;
    }
    public double getPlannedHours() {
        return plannedHours;
    }
    public String getColor() {
        return color;
    }
    public static List<Task> getTaskList(){
        return tasks;
    }
    public static List<Booking> getBookingList(){
        return bookings;
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

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
        dest.writeString(projName);
        dest.writeString(description);
        dest.writeDouble(plannedHours);
        dest.writeString(color);
//        dest.writeTypedList(tasks);
    }


}
