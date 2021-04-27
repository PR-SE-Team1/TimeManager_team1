package com.example.timemanager.ui.projects;

import java.util.Scanner;

public class Project {
    public String projName;
    public String description;
    public double plannedHours;
    public String color;
    //tasks need to be implemented

    //insert input with scanner?
    Scanner input = new Scanner(System.in);

    /**
     * constructor needed to create new Project
     */
    public Project (Scanner input){
        projName = input.next();
        description = input.next();
        // plannedHours = input.next(); scanner works with String


    }

    public Project (String projName, String description, double plannedHours, String color){
        this.projName = projName;
        this.description = description;
        this.plannedHours = plannedHours;
        this.color = color;
    }






}
