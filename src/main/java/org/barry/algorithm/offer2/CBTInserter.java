package org.barry.algorithm.offer2;

import org.barry.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class CBTInserter {

    ArrayList<TreeNode> treeNodes = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            treeNodes.add(node);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }

    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        treeNodes.add(newNode);
        int index = treeNodes.size() - 1;
        TreeNode parent = treeNodes.get((index - 1) / 2);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        if (treeNodes.size() == 0) {
            return null;
        }
        return treeNodes.get(0);
    }
}