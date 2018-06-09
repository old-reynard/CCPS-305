/**
 * AVL Node class
 *
 * @author Nikita Gerasimov
 * @version 2018-06-07
 */

public class AVLNode {
    
    int data;
    int height;
    AVLNode left;
    AVLNode right;

    /**
     * Constructor for objects of class Node
     */
    public AVLNode(int data) {
        this.data = data;
        height = 1;
        left = null;
        right = null;
    }
}