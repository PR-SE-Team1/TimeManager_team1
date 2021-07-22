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
     * to insert: Project project, boolean defaultTask
     * @param taskName
     * @param
     */
    public Task (String taskName, boolean defaultTask, Project project ){
        this.taskName = taskName;
        this.defaultTask = defaultTask;
        this.project = project;
    }
//    public Task (String taskName){
//        this.taskName = taskName;
//
//    }

    /**
     * retrieving task-data
     * this constructor is invoked by method createFromParcel(Parcel source)
     * @param in
     */
    protected Task(Parcel in) {
        taskName = in.readString();
    }

    /**
     *
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

    //GETTER

    /**
     * gets the Name of the Task
     * @return taskName
     */
    public String getTaskName() { return taskName; }

    /**
     * gets the Project
     * @return project
     */
    public Project getProject(){ return project;}

    /**
     * gets the boolean if it is a default Task
     * @return defaultTask
     */
    public boolean getDefaultTask(){ return defaultTask;}

    //SETTER

    /**
     * sets the Name of the Task
     * @param taskName
     */
    public void setTaskName(String taskName){this.taskName = taskName;}

    /**
     * sets the Project
     * @param project
     */
    public void setProject(Project project){this.project = project;}
    //public boolean setDefaultTask(double num)
    //        {
    //            if(num%2 == 0)
    //            {
    //                System.out.print(true);
    //                return true;
    //            }
    //            else
    //            {
    //                System.out.print(false);
    //                return false;
    //            }
    //
    //        }


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



}
