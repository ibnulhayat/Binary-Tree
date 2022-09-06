package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements Tree {
    private int index = -1;

    public Node buildTree(int[] nodes) {
        if (nodes[++index] == -1) return null;
        Node root = new Node(nodes[index]);
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    public int[] preOrder(Node root) {
        index = 0;
        return preOrder(root, new int[totalNode(root)]);
    }

    private int[] preOrder(Node root, int[] ans) {
        if (root == null) return ans;
        ans[index++] = root.data;
        preOrder(root.left, ans);
        preOrder(root.right, ans);
        return ans;
    }

    public int[] inOrder(Node root) {
        index = 0;
        return inOrder(root, new int[totalNode(root)]);
    }

    private int[] inOrder(Node root, int[] ans) {
        if (root == null) return ans;
        inOrder(root.left, ans);
        ans[index++] = root.data;
        inOrder(root.right, ans);
        return ans;
    }

    public int totalNode(Node root) {
        if (root == null) return 0;
        int left = totalNode(root.left);
        int right = totalNode(root.right);
        return left + right + 1;
    }

    @Override
    public int height(Node root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
    @Override
    public int minHeight(Node root) {
        if (root == null) return 0;
        int left = minHeight(root.left);
        int right = minHeight(root.right);
        return Math.min(left, right) + 1;
    }

    @Override
    public int totalSumOfNode(Node root) {
        if (root == null) return 0;
        int left = totalSumOfNode(root.left);
        int right = totalSumOfNode(root.right);
        return left + right + root.data;
    }

    public int levelOfSum(Node root, int level){
        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            --level;
            while (size--> 0) {
                Node node = queue.poll();
                assert node != null;
                if (level == 0) sum += node.data;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return sum;
    }
}
