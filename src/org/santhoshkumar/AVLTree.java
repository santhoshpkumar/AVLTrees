package org.santhoshkumar;

public class AVLTree {

    Node root;

    public static void main(String[] args) {
	// write your code here
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

    public Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        return null;
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