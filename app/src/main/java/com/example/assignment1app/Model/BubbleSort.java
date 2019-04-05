package com.example.assignment1app.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class enables data to be bubble sorted using the ArrayList library class.
 * This involves creating a random list of numbers which are then compared one by one
 * with the larger number being swapped with the smaller. This process continues until
 * the list is in order of smallest to highest.
 */
public class BubbleSort {

    private ArrayList<Integer> array;
    private int length;
    private Random random;

    /**
     * A constructor which sets the initial structure of the list.
     */
    public BubbleSort() {

        array = new ArrayList<Integer>();
        random = new Random();
        length = 20;
        generateRandomArray();
    }

    /**
     * Returns the array in its current form.
     *
     * @return the array
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Return the size of the array.
     *
     * @return an int values representing the size of the array
     */
    public int getArrayLength() {

        return array.size();
    }

    /**
     * Creates a random array of numbers between 0 and 99.
     *
     * @return the array
     */
    public ArrayList<Integer> generateRandomArray() {
        array.clear();
        for (int i = 0; i < length - 1; i++) {
            array.add(random.nextInt(100));
        }
        return array;
    }

    /**
     * This method compares values which are next to each other in the array
     * then if first value is larger than the second, they will be swapped.
     *
     * @param j a value which is used to generalise the index of the array, to enable
     *          the array to be iterated over at a later stage.
     * @return the array
     */
    public ArrayList<Integer> bubbleSortArray(int j) {
        if (array.get(j - 1) > array.get(j)) {
            Collections.swap(array, j - 1, j);
        }
        return array;
    }
}

