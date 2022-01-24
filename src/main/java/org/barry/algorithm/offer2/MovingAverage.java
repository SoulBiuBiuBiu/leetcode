package org.barry.algorithm.offer2;

import java.util.LinkedList;

public class MovingAverage {

    LinkedList<Integer> arr;
    int length;
    int sum;
    int index;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        arr = new LinkedList<Integer>();
        length = size;
        index = sum = 0;
    }

    public double next(int val) {
        sum += val;
        index++;
        arr.addLast(val);
        if (index == length + 1) {
            index--;
            Integer first = arr.removeFirst();
            this.sum -= first;
        }
        return sum / (double) (index);

    }
}