package com.example.assignment1app.Model;

import java.util.ArrayList;

/**
 * An implementation of a Stack data structure using the ArrayList library class.
 */
public class StackArray {

    private ArrayList<Student> stack;

    /**
     * Constructor to create new ArrayList that will contain Student objects.
     */
    public StackArray() {
        stack = new ArrayList<Student>();
    }

    /**
     * Return the stack in its current state.
     *
     * @return the stack
     */
    public ArrayList<Student> getStack() {
        return stack;
    }

    /**
     * Set the stack depending on the stack object you feed the method.
     *
     * @param stack the stack which you wish to set
     */
    public void setStack(ArrayList<Student> stack) {
        this.stack = stack;
    }

    /**
     * Adds a student object to the stack.
     *
     * @param itemToPush the student object to be added to the stack
     * @return the stack
     */
    public ArrayList<Student> push(Student itemToPush) {
        stack.add(itemToPush);
        return stack;
    }

    /**
     * Removes student object that is at the top of the stack.
     *
     * @return the stack
     */
    public ArrayList<Student> pop() {
        stack.remove(stack.size() - 1);
        return stack;
    }

    /**
     * Checks if the stack is currently empty or not.
     *
     * @return true if the stack is empty and false otherwise
     */
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the name of the Student that is currently at the top of the stack.
     *
     * @return the name field of the Student object at the top of the stack
     */
    public Student top() {
        return stack.get(stack.size() - 1);
    }

    /**
     * Allows the user to enter the name of a student and perform a search on the stack.
     *
     * @param studentName the name of the student being searched for
     * @return the position index in the stack
     */
    public int search(String studentName) {
        int i = 0;

        for (Student student : stack) {
            if (student.getName().contains(studentName)) {
                break;
            } else {
                i++;
            }
        }
        return i;
    }
}


