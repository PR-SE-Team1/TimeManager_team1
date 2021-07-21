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
    List<Project> list;
    Task t;
    Booking b;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        this.p = new Project ( "Projekt1", "kurzbeschreibung 1", 11.1, "blue");
        list.add(p);
        this.b = new Booking("test", 5);
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
         assertEquals("11.1", p.getPlannedHours());
         assertNotEquals("0", p.getPlannedHours());
    }

    @Test
    public void getColor() {
        assertNotNull(p.getColor());
        assertEquals("blue", p.getColor());
        assertNotEquals("red", p.getColor());
    }

    /*
    @Test
    public void getTaskList() {
          assertNotNull(p.getProjectList());
          assertEquals(list, p.getProjectList());
          assertNotEquals(null, p.getProjectList());
    }
     */

    /*
    @Test
    public void getBookingList() {
        assertNotNull(p.getProjectList());
        assertEquals(list, p.getProjectList());
        assertNotEquals(null, p.getProjectList());
    }
     */

    @Test
    public void describeContents() {

    }

    @Test
    public void writeToParcel() {
        Parcel parcel = MockParcel.obtain();
        p.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Project createdFromParcel = Project.CREATOR.createFromParcel(parcel);
        assertEquals(p.getProjName(), createdFromParcel.getProjName());
        assertNotEquals("TestParcle", createdFromParcel.getProjName());
    }
}