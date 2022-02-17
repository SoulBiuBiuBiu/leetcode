package org.barry.algorithm.hot100;

import org.barry.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2022/2/16 16:42
 */
public class P105 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int[] inorder, int preS, int preE, int inS, int inE) {
        if (preS > preE || inS > inE) {
            return null;
        }
        int val = preorder[preS];
        Integer inIndex = map.get(val);
        int leftLen = inIndex - inS;
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, inorder, preS + 1, preS + leftLen, inS, inIndex - 1);
        node.right = build(preorder, inorder, preS + leftLen + 1, preE, inIndex + 1, inE);
        return node;
    }
}
