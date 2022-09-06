package binaryTree;

public interface Tree {
    Node buildTree(int[] nodes);
    int totalNode(Node root);
    int height(Node root);
    int minHeight(Node root);
    int totalSumOfNode(Node root);
    int levelOfSum(Node root, int level);
}
