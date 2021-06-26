package com.example.timemanager.ui.bookings;


import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.tasks.Task;

import java.util.ArrayList;
import java.util.List;

// implements Parcelable to pass complex data from one activity to another activity
public class Booking {

    private String booking;
    private Project project;
    private Task task;


    private static List<Booking> bookingList = new ArrayList<>();


    /**
     * constructor to initialize a task object
     * @param booking
     * @param project
     * @param
     */
    public Booking(String booking, Project project, Task task){
        this.booking = booking;
        this.task = task;
        this.project = project;
    }
    public Booking(String taskName){
        this.booking = taskName;

    }

//    /**
//     * retrieving task-data
//     * this constructor is invoked by method createFromParcel(Parcel source)
//     * @param in
//     */
//    protected Task(Parcel in) {
//        taskName = in.readString();
//        defaultTask = ;
//        project = ;
//    }

//    /**
//     * delete after parcel is working
//     */
//    public Project() {
//
//    }

    //GETTER
    public String getBooking() {
        return booking;
    }
    public Task getBookingTask() {
        return task;
    }
    public Project getBookingProject() {
        return project;
    }

    public static List<Booking> getTaskList(){
        return bookingList;
    }


//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    /**
//     * storing the project data to a parcel-object
//     * @param dest
//     * @param flags
//     */
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(projName);
//        dest.writeString(description);
//        dest.writeDouble(plannedHours);
//        dest.writeString(color);
//    }


}
