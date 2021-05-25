package com.example.timemanager.test;

import com.example.timemanager.ui.projects.Project;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

class ProjectTest {

    Project p;
    List<Project> list;
    List<Project> list1;



    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        this.p = new Project (1, "Projekt1", "kurzbeschreibung 1", 11.1, "blue");
        list.add(p);
    }

    @Test
    public void testGetProjId() {
        assertNotNull(p.getProjId());
        assertEquals(1, p.getProjId());
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

    @Test
    public void testGetPlannedHours() {
        assertNotNull(p.getPlannedHours());
        assertEquals("11.1", p.getPlannedHours());
        assertNotEquals("0", p.getPlannedHours());
    }

    @Test
    public void testGetColor() {
        assertNotNull(p.getColor());
        assertEquals("blue", p.getColor());
        assertNotEquals("red", p.getColor());
    }

    @Test
    public void testGetProjectList() {
        assertNotNull(p.getProjectList());
        assertEquals(list, p.getProjectList());
        assertNotEquals(null, p.getProjectList());
    }
}