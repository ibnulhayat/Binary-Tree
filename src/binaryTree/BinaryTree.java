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

    /** we are implement Breadth First Search(BFS) find the level of sum
     * this approach are very easy
     * */
    public int levelOfSum(Node root, int level){
        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);                // firstly add the main root in queue
        while (!queue.isEmpty()){       // we are checking until queue is not empty
            int size = queue.size();    // we are get the first queue size or number of node in a level
            --level;    // we want to be specific level of sum, so decrement the value
            while (size--> 0) {   // we get the all node until is zero
                Node node = queue.poll(); // we are polling all storing node, all node are level wise node
                assert node != null;
                if (level == 0) sum += node.data; // when level equal zero that's mean we are find the specific level, we want to sum all node value in this level
                if (node.left != null) queue.add(node.left); // we are adding node in queue until node left side equal not null
                if (node.right != null) queue.add(node.right); // we are adding node in queue until node right side equal not null
            }
        }
        return sum;
    }
}
