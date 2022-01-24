package org.barry.algorithm.offer2;

import java.util.LinkedList;

public class RecentCounter {

    LinkedList<Integer> list = new LinkedList<>();

    int cnt = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        list.addLast(t);
        cnt++;
        while (list.getFirst() < t - 3000) {
            list.removeFirst();
            cnt--;
        }
        return cnt;
    }
}