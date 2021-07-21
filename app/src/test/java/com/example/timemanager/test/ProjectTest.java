package com.example.timemanager.test;

import android.os.Parcel;

import com.example.timemanager.MockParcel;
import com.example.timemanager.ui.bookings.Booking;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.tasks.Task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectTest {

    Project p;
    List<Project> projectList;
    Task t;
    List<Task>taskList;
    Booking b;
    List<Booking>bookingList;


    @Before
    public void setUp() throws Exception {
        projectList = new ArrayList<>();
        this.p = new Project ( "Projekt1", "kurzbeschreibung 1", 11.1, "blue");
        projectList.add(p);

        taskList = new ArrayList<>();
        this.t = new Task("TestTask");
        taskList.add(t);

        bookingList = new ArrayList<>();
        this.b = new Booking("TestBooking", 8);
        bookingList.add(b);
    }

    @Test
    public void getProjName() {
        assertNotNull(p.getProjName());
        assertEquals("Projekt1", p.getProjName());
        assertNotEquals("Projekt2", p.getProjName());
    }

    @Test
    public void getDescription() {
        assertNotNull(p.getDescription());
        assertEquals("kurzbeschreibung 1", p.getDescription());
        assertNotEquals("Kurzbeschreibung 1", p.getDescription());
    }

    @Test
    public void getPlannedHours() {
         assertNotNull(p.getPlannedHours());
         assertEquals(11.1, p.getPlannedHours(),0);
         assertNotEquals(0, p.getPlannedHours());
    }

    @Test
    public void getColor() {
        assertNotNull(p.getColor());
        assertEquals("blue", p.getColor());
        assertNotEquals("red", p.getColor());
    }


    @Test
    public void getTaskList() {
        Task taskExpected = new Task("TaskExpected");
        List<Task> taskListExpected = new ArrayList<>();
        taskListExpected.add(taskExpected);
        //Equal
        assertNotEquals(taskListExpected, taskList);
    }

    @Test
    public void describeContents() {
        assertNotNull(p.describeContents());
        assertEquals(0, p.describeContents());
        assertNotEquals(1, p.describeContents());
    }

    /**
     * Test to check
     */
    @Test
    public void writeToParcel() {
        Parcel parcel = MockParcel.obtain();
        p.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Project parcelableProject = Project.CREATOR.createFromParcel(parcel);
        assertEquals(p.getProjName(), parcelableProject.getProjName());
        assertNotEquals("keine Buchung", parcelableProject.getProjName());
    }

}