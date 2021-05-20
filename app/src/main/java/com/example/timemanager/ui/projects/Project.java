package com.example.timemanager.ui.projects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// implements Parcelable to pass complex data from one activity to another activity
public class Project implements Parcelable {
    //public String projName;
    //public String description;
    //public double plannedHours;
    //public String color;
    private String projName;
    private String description;
    private double plannedHours;
    private String color;
    //tasks need to be implemented

//  //insert input with scanner?
//    Scanner input = new Scanner(System.in);
//
//    *//**
//     * constructor needed to create new Project
//     *//*
//    public Project (Scanner input){
//        projName = input.next();
//        description = input.next();
//        // plannedHours = input.next(); scanner works with String
//
//
//    }

    /**
     * constructor that initializes the Project object
     * @param projName
     * @param description
     * @param plannedHours
     * @param color
     */
    public Project (String projName, String description, double plannedHours, String color){
        this.projName = projName;
        this.description = description;
        this.plannedHours = plannedHours;
        this.color = color;
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
    }

    private static List<Project> projectList = new ArrayList<>();

    public static List<Project> getProjectList(){
        return projectList;
    }
}
