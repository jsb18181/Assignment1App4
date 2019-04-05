package com.example.assignment1app.Model;

import java.util.ArrayList;

/**
 * An implementation of a Queue data structure using the ArrayList library class.
 */
public class QueueArray {

    private ArrayList<Student> queue;

    /**
     * Constructor to create new ArrayList which will contain Student class objects.
     */
    public QueueArray() {
        queue = new ArrayList<Student>();
    }

    /**
     * Getter for the queue.
     *
     * @return the queue
     */
    public ArrayList<Student> getQueue() {
        return queue;
    }

    /**
     * Setter for the queue.
     *
     * @param queue sets the queue
     */
    public void setQueue(ArrayList<Student> queue) {
        this.queue = queue;
    }

    /**
     * Add a Student object to the queue.
     *
     * @param enQueueValue takes in the Student object to add to the queue
     * @return the queue
     */
    public ArrayList<Student> enQueue(Student enQueueValue) {
        queue.add(enQueueValue);
        return queue;
    }

    /**
     * Removes the Student object at index zero in the queue.
     *
     * @return the queue
     */
    public ArrayList<Student> deQueue() {
        queue.remove(0);
        return queue;
    }

    /**
     * Enables you to peek at the first Student object in the queue.
     *
     * @return the value in index zero of the queue
     */
    public Student headOfQueue() {
        return queue.get(0);
    }
}
