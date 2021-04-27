package com.example.timemanager.ui.projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivities {
    /**
     * list of all projects
     */
    private static final List<Project> projectList = new ArrayList<>();

    Project proj = new Project();

    public static void createProjectList (){
        projectList.add(new Project ("Projekt 1", "dies ist ein Projekt. Es besteht aus mehreren Aufgaben", 12.5, "blue"));
    }

}
