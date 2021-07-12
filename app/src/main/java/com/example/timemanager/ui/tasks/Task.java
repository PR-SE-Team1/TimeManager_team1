package com.example.timemanager.ui.tasks;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

// implements Parcelable to pass complex data from one activity to another activity
public class Task implements Parcelable{

    private String taskName;
    private Project project;
    private boolean defaultTask;

    private static List<Task> taskList = new ArrayList<>();


    /**
     * constructor to initialize a task object
     * @param taskName
     * @param project
     * @param defaultTask
     */
    public Task (String taskName, Project project, boolean defaultTask){
        this.taskName = taskName;
        this.defaultTask = defaultTask;
        this.project = project;
    }
    public Task (String taskName){
        this.taskName = taskName;

    }

    /**
     * retrieving task-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in
     */
    protected Task(Parcel in) {
        taskName = in.readString();
    }

    /**
     * delete after parcel is working
     */
    public Task() {

    }

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

    //GETTER
    public String getTaskName() {
        return taskName;
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
        dest.writeString(taskName);
    }

    public void changeText1 (String text){
        taskName = text;
    }


}
