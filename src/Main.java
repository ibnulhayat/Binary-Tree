import binaryTree.BinaryTree;
import binaryTree.Node;

public class Main {
    public static void main(String[] args) {
        int[] nodes = {5,3,2,1,-1,-1,-1,4,-1,-1,7,6,-1,-1,8,-1,9,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root: "+ root.data);
        int totalNode = tree.totalNode(root);
        System.out.println("Total Node: "+totalNode);
        System.out.println("Pre Order List:");
        int[] preOrder = tree.preOrder(root);
        for(int val : preOrder)
            System.out.print(val+" ");
        System.out.println("\nIn Order List:");
        int[] inOrder = tree.inOrder(root);
        for(int val : inOrder)
            System.out.print(val+" ");

        System.out.println("\nTotal Sum: "+tree.totalSumOfNode(root));
        System.out.println("Max height: "+tree.height(root));
        System.out.println("Min height: "+tree.minHeight(root));
        System.out.println("Level of sum: "+tree.levelOfSum(root, 5));
    }
}