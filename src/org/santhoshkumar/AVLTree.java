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
        x.height = 1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));

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
        x.height = 1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));

        return x;
    }

    public int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public int getBalance(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    public Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }

        if(node.data > data){
            node.left = insert(node.left, data);
        }else{
            node.right = insert(node.right, data);
        }
        node.height = 1+ Math.max(getHeight(node.left), getHeight(node.right));

        int balanceDiff = getBalance(node);

        if (balanceDiff > 1 && data < node.left.data){
            return rightRotation(node);
        }
        if (balanceDiff > 1 && data > node.left.data){
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        if (balanceDiff < -1 && data > node.right.data){
            return leftRotation(node);
        }
        if (balanceDiff < -1 && data < node.right.data){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

}

class Node{
    Node left;
    Node right;
    int data;
    int height;
    Node(int data){
        this.data = data;
        this.height = 1;
    }
    Node(int data, int height){
        this.data = data;
        this.height = height;
    }
}