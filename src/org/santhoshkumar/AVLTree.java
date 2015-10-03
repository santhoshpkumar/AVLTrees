package org.santhoshkumar;

public class AVLTree {

    public static void main(String[] args) {

        Node root = null;
        AVLTree tree = new AVLTree();

        int[] inputs = {4,2,1,5,6,9,14,11,10,20};

        for (int input: inputs ){
            root = tree.insert(root, input);
            System.out.print("Inorder Traversal of Constructed AVL Tree :");
            tree.inOrder(root);
            System.out.println();
            System.out.println("New Root of AVL Tree is : " + root.data);
        }

    }

    /*
    //                Rotate Left
    //          z                    z
    //         / \                  / \
    //       T4  [y]      ->      T4  [x]
    //           /  \                /  \
    //          T3  [x]            [y]  T1
    //              / \           /  \
    //             T2 T1         T3  T2
    //
    */

    public Node leftRotation(Node y){
        Node x = y.right;
        Node T2 = x.left;

        //Rotation
        x.left = y;
        y.right = T2;

        //Update height
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    /*
    //               Rotate Right
    //          z                   z
    //        /  \                 / \
    //      [y]   T4     ->      [x]  T4
    //     /  \                /  \
    //   [x]    T3            T1   [y]
    //   / \                      /  \
    //  T1 T2                    T2  T3
    //
    */

    public Node rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Rotation
        x.right = y;
        y.left = T2;

        //Update height
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;

        return x;
    }

    public int getHeight(Node node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    public int getBalance(Node node) {
        if (node != null) {
            return (getHeight(node.left) - getHeight(node.right));
        }
        return 0;
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        }
        if (node.data > data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        // update the node height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balanceDiff = getBalance(node);

        // Left Rotate
        if (balanceDiff > 1 && data < node.left.data) {
            return rightRotation(node);
        }

        // Right Rotate
        if (balanceDiff < -1 && data > node.right.data) {
            return leftRotation(node);
        }

        // Left Right Rotate
        if (balanceDiff > 1 && data > node.left.data) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // Right Left Rotate
        if (balanceDiff < -1 && data < node.right.data) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(" " + root.data);
            inOrder(root.right);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
        height = 1;
    }
}