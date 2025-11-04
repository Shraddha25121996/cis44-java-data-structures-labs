/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // Build the tree for ((3 + 7) * (9 - 4))
        BinaryTreeNode root = new BinaryTreeNode("*");

        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");

        // Connect root to its children
        root.left = nodePlus;
        root.right = nodeMinus;
        nodePlus.parent = root;
        nodeMinus.parent = root;

        // Create leaf nodes (operands)
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");

        // Connect leaves to + and -
        nodePlus.left = node3;
        nodePlus.right = node7;
        nodeMinus.left = node9;
        nodeMinus.right = node4;

        node3.parent = nodePlus;
        node7.parent = nodePlus;
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;

        // Perform Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();
    }

}
