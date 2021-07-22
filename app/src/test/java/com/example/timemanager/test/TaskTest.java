package com.example.timemanager.test;

import android.os.Parcel;

import com.example.timemanager.MockParcel;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.tasks.Task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TaskTest {

    Project project = new Project("Project1","Beschreibung", 20, "blue");
    Task t = new Task("Task1", true, project);

    /**
     * tests the method getTaskName, if the name is not null and if it is equal or not
     */
    @Test
    public void getTaskName() {
        assertNotNull(t.getTaskName());
        assertEquals("Task1", t.getTaskName());
        assertNotEquals("null", t.getTaskName());
    }

    /**
     * tests the method getProject, if the project is not null and if it is equal or not
     */
    @Test
    public void getProject() {
        Project proj = new Project("abcd", "Beschreibung", 28, "blue");
        assertNotNull(t.getProject());
        assertEquals(project, t.getProject());
        assertNotEquals( proj, t.getProject());
    }

    /**
     * tests the method getDefaultTask, if the boolean is not null and if it is equal or not
     */
    @Test
    public void getDefaultTask() {
        assertNotNull(t.getDefaultTask());
        assertEquals(true, t.getDefaultTask());
        assertNotEquals(false, t.getDefaultTask());
    }

    /**
     * tests the method setTaskName
     */
    @Test
    public void setTaskName() {
        t.setTaskName("Task1");
        assertNotNull(t.getTaskName());
        assertEquals("Task1", t.getTaskName());
    }

    /**
     * tests the method Project, if the test project is equal the project
     */
    @Test
    public void setProject() {
        t.setProject(project);
        assertNotNull(t.getProject());
        assertEquals(project, t.getProject());
    }

    /**
     * tests the method describeContents
     */
    @Test
    public void describeContents() {
        assertEquals(0,t.describeContents());
    }

    /**
     * tests the method writeToParcel
     */
    @Test
    public void writeToParcel() {
        Parcel parcel = MockParcel.obtain();
        t.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Task parcelableTask = Task.CREATOR.createFromParcel(parcel);
        assertEquals(t.getTaskName(), parcelableTask.getTaskName());
        assertNotEquals("kein Task", parcelableTask.getTaskName());
    }

}