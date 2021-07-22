package com.example.timemanager.ui.projects;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.timemanager.ui.bookings.Booking;
import com.example.timemanager.ui.tasks.Task;

import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * class needed to create project-items used in other classes
 * implements Parcelable to pass complex data from one activity to another activity
 */
public class Project implements Parcelable {
    private String projName;
    private String description;
    private double plannedHours;
    private String color;


    /**
     * constructor that initializes the Project object
     * @param projName name of the project
     * @param description short description of the project
     * @param plannedHours hours planned to work on the project
     * @param color the color assigned to the project
     */
    public Project (String projName, String description, double plannedHours, String color){
        this.projName = projName;
        this.description = description;
        this.plannedHours = plannedHours;
        this.color = color;
    }

    /**
     * constructor needed to create new project in the project activity
     * @param projName name of the project
     */
    public Project ( String projName){
        this.projName = projName;
   }

    /**
     * retrieving project-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in retrieved data from parcel
     */
    protected Project(Parcel in) {
        projName = in.readString();
        description = in.readString();
        plannedHours = in.readDouble();
        color = in.readString();
    }

    /**
     * gets the name of the project
     * @return the name of the project
     */
    public String getProjName() {
        return projName;
    }

    /**
     * gets the description of the project
     * @return a short description of the project
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets the planned hours of the project
     * @return hours planned to work on the project
     */
    public double getPlannedHours() {
        return plannedHours;
    }

    /**
     * gets the color of the project
     * @return color assigned to the project
     */
    public String getColor() {
        return color;
    }

    /**
     * sets the name of the project
     * @param projName name of the project
     */
    public void setProjName(@NotNull String projName) {
        this.projName = projName;
    }

    /**
     * sets the short description of the project
     * @param description short description of the specific project
     */
    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    /**
     * sets the hours planned to work on the project and checks if hours entered are over 0
     * @param plannedHours hours planned to work on the project
     */
    public void setPlannedHours(@NotNull double plannedHours) {
        if (plannedHours <= 0){
            return;
        }
        this.plannedHours = plannedHours;
    }

    /**
     * sets the color assigned to the specific project
     * @param color color assigned to the specific project
     */
    public void setColor(String color) {
        this.color = color;
    }


    /**
     * creating a new parcel
     * implemented from Parcel
     */
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
        dest.writeString(projName);
        dest.writeString(description);
        dest.writeDouble(plannedHours);
        dest.writeString(color);
    }


}
