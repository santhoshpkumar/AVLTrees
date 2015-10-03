package org.santhoshkumar;

public class AVLTree {

    public static void main(String[] args) {
	// write your code here
    }

    //          z                    z
    //        /  \                  / \
    //      T4   [y]       =      T4  [x]
    //           /  \                /  \
    //          T3  [x]            [y]  T2
    //              / \           /  \
    //             T1 T2         T3  T1
    public void leftRotation(Node y){
        Node x = y.right;
        Node T1 = x.left;

        //Rotation
        x.left = y;
        y.right = T1;

    }

    //          z
    //        /  \
    //      [y]    T4
    //     /  \
    //   [x]    T3
    //   / \
    //  T1 T2
    public void rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;

        //Rotation
        x.right = y;
        y.left = T2;

        //Update height
    }

    public void insert(int data){

    }

}

class Node{
    Node left;
    Node right;
    int data;
    int height;
    Node(int data){
        this.data = data;
    }
    Node(int data, int height){
        this.data = data;
        this.height = height;
    }
}