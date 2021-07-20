package com.example.timemanager;

import android.os.Parcel;

import com.example.timemanager.ui.bookings.Booking;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.tasks.Task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    Project p;
    List<Project> list;
    List<Project> list1;
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
    public void testGetProjName() {
        assertNotNull(p.getProjName());
        assertEquals("Projekt1", p.getProjName());
        assertNotEquals("Projekt2", p.getProjName());
    }

    @Test
    public void testGetDescription() {
        assertNotNull(p.getDescription());
        assertEquals("kurzbeschreibung 1", p.getDescription());
        assertNotEquals("Kurzbeschreibung 1", p.getDescription());
    }

//    @Test
//    public void testGetPlannedHours() {
//        assertNotNull(p.getPlannedHours());
//        assertEquals("11.1", p.getPlannedHours());
//        assertNotEquals("0", p.getPlannedHours());
//    }

    @Test
    public void testGetColor() {
        assertNotNull(p.getColor());
        assertEquals("blue", p.getColor());
        assertNotEquals("red", p.getColor());
    }

//    @Test
//    public void testGetProjectList() {
//        assertNotNull(p.getProjectList());
//        assertEquals(list, p.getProjectList());
//        assertNotEquals(null, p.getProjectList());
//    }

    //-------------Task-------------
    @Test
    public void testGetTaskName(){
        assertNotNull(t.getTaskName());
        assertEquals("Aufgabe1", t.getTaskName());
        assertNotEquals("null", t.getTaskName());
    }

    @Test
    public void testSetTaskName(){ //bin ma nd sicher ob des so funktioniert, habs vo stachoverflow
        String input = "abc\n";
        String expected = "abc";

        Task task = new Task(input);
        task.setTaskName(input);

        assertEquals(expected, task.getTaskName());
    }

    //-------------Booking-------------
    private final Booking b1 = new Booking ("Buchung 1", 11);

    @Test
    public void testGetBookingName(){
        assertNotNull(b1.getBookingName());
        assertEquals("Buchung 1", b1.getBookingName());
        assertNotEquals("keine Buchung", b1.getBookingName());
    }

    @Test
    public void testGetTimeWorked(){
        assertNotNull(b1.getTimeWorked());
        assertEquals(11, b1.getTimeWorked());
        assertNotEquals(1, b1.getTimeWorked());
    }

    @Test
    public void testSetBookingName(){
        b1.setBookingName("Neue Buchung");
        assertNotNull(b1.getBookingName());
        assertEquals("Neue Buchung", b1.getBookingName());
    }

    @Test
    public void testSetTimeWorked(){
        b1.setTimeWorked(20);
        assertNotNull(b1.getTimeWorked());
        assertEquals(20, b1.getTimeWorked());
        assertNotEquals(-1, b1.getTimeWorked());
    }


}