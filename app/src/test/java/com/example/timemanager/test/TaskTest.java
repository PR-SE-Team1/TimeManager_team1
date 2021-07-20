package com.example.timemanager.test;

import com.example.timemanager.ui.tasks.Task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TaskTest {

    Task t = new Task("Task1");

    @Test
    public void getTaskName() {
        assertNotNull(t.getTaskName());
        assertEquals("Aufgabe1", t.getTaskName());
        assertNotEquals("null", t.getTaskName());
    }

    @Test
    public void getProject() {

    }

    @Test
    public void getDefaultTask() {
    }

    @Test
    public void setTaskName() {
        String input = "abc\n";
        String expected = "abc";

        Task task = new Task(input);
        task.setTaskName(input);

        assertEquals(expected, task.getTaskName());
    }

    @Test
    public void setProject() {
    }

    @Test
    public void describeContents() {
    }

    @Test
    public void writeToParcel() {
    }

    @Test
    public void changeText1() {
    }
}