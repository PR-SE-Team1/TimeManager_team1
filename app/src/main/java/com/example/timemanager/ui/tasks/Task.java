package com.example.timemanager.ui.tasks;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * class needed to create task-items used in other classes
 * implements Parcelable to pass complex data from one activity to another activity
 */
public class Task implements Parcelable{

    private String taskName;
    private Project project;
    private boolean defaultTask;

    /**
     * constructor to initialize a task object
     * @param taskName the name of the task
     * @param defaultTask true if the task is a default task of the assigned project; otherwise false
     * @param project project to which the task is assigned
     */
    public Task (String taskName, boolean defaultTask, Project project ){
        this.taskName = taskName;
        this.defaultTask = defaultTask;
        this.project = project;
    }

    /**
     * retrieving task-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * further information in implemented Parcelable
     * @param in retrieved data from parcel
     */
    protected Task(Parcel in) {
        taskName = in.readString();
    }

    /**
     * creating a new parcel
     * implemented from Parcel
     */
    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    /**
     * gets the name of the task
     * @return the name of the task
     */
    public String getTaskName() { return taskName; }

    /**
     * gets the project to which the task is assigned
     * @return the project to which the task is assigned
     */
    public Project getProject(){ return project;}

    /**
     * gets defaulttask
     * @return true if the task is a default task of the assigned project; otherwise false
     */
    public boolean getDefaultTask(){ return defaultTask;}

    /**
     * sets the Name of the Task
     * @param taskName name of the task
     */
    public void setTaskName(String taskName){this.taskName = taskName;}

    /**
     * sets the Project
     * @param project project to which the task is assigned
     */
    public void setProject(Project project){this.project = project;}

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
        dest.writeString(taskName);
    }



}
