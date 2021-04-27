package com.example.timemanager.ui.projects;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


//probably should be outsourced to MainActivity as discussed yesterday

public class ProjectActivities {
    /**
     * list of all projects
     */
    public static final List<Project> projectList = new ArrayList<>();



    //Project proj = new Project();

    public static void createProjectList (){
        projectList.add(new Project ("Projekt 1", "dies ist ein Projekt. Es besteht aus mehreren Aufgaben", 12.5, "blue"));
    }

}
