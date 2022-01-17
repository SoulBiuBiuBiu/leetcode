package org.barry.algorithm.offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> arr = new ArrayList<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int index = arr.size();
        arr.add(val);
        map.put(val, index);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);
        Integer lastNum = arr.get(arr.size() - 1);
        arr.set(index, lastNum);
        arr.remove(arr.size() - 1);
        map.put(lastNum, index);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(arr.size());
        return arr.get(index);
    }
}