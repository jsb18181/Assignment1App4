package com.example.assignment1app.Model;

/**
 * A class for creating Student objects which hold basic student information.
 */
public class Student {

    private String name;
    private String course;

    /**
     * A constructor for the student class which sets the students name and course.
     *
     * @param name   the name of the student
     * @param course the course the student is enrolled in
     */
    public Student(String name, String course) {

        this.name = name;
        this.course = course;
    }

    /**
     * Returns the course information for the student.
     *
     * @return the course name
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the name of the course.
     *
     * @param course takes in the name of the course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Returns the name of the student.
     *
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name the name of the student
     */
    public void setName(String name) {
        this.name = name;
    }
}
