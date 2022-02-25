package org.barry.algorithm.hot100;

import java.util.HashMap;

public class Trie {

    Node head;

    public Trie() {
        head = new Node(' ');
    }

    public void insert(String word) {
        Node cur = head;
        for (int i = 0; i < word.length(); i++) {
            HashMap<Character, Node> map = cur.map;
            char key = word.charAt(i);
            if (map.containsKey(key)) {
                if (i == word.length() - 1) {
                    Node node = map.get(key);
                    node.end = true;
                }
                cur = map.get(key);

            } else {
                Node node = new Node(key);
                map.put(key, node);
                cur = node;
                if (i == word.length() - 1) {
                    node.end = true;
                }
            }

        }
    }

    public boolean search(String word) {
        Node cur = head;
        for (int i = 0; i < word.length(); i++) {
            HashMap<Character, Node> map = cur.map;
            char key = word.charAt(i);
            if (map.containsKey(key)) {
                cur = map.get(key);
            } else {
                return false;
            }
        }

        return cur.map.size() == 0 || cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (int i = 0; i < prefix.length(); i++) {
            HashMap<Character, Node> map = cur.map;
            char key = prefix.charAt(i);
            if (map.containsKey(key)) {
                cur = map.get(key);
            } else {
                return false;
            }
        }
        return true;
    }

    class Node {
        boolean end;
        char c;
        HashMap<Character, Node> map;

        Node(char c) {
            this.c = c;
            map = new HashMap<>();
        }
    }
}