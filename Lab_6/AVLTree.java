/**
 * Demo implementation of the Binary Seacrh Tree class
 *
 * @author Nikita Gerasimov
 * @version 2018-05-28
 */
public class AVLTree {

    private static AVLNode root;

    /**
     * Constructor for objects of class BSTree
     */
    public AVLTree() {
        root = null;
    }

    /**
     * public add method, starts from root
     */
    public void add(int value) {        
        root = add(root, value);
    }

    /**
     * Traverse the tree from the root and find the place for the new value
     * @return the node that will be added to the tree
     */
    private static AVLNode add(AVLNode current, int value) {
        if (current == null) {                                          // if the current node is empty, the node will be inserted here
            return new AVLNode(value);
        } 

        if (value < current.data) {                                     // otherwise, if the given value is less than data from the current node,
            current.left = add(current.left, value);                    // the tree will be traversed to the left
        } else if (value > current.data) {                              // otherwise, if the given value is greater than data from the current node,
            current.right = add(current.right, value);                  // the tree will be traversed to the right
        } else {                                                        // otherwise, that is, if the the given value is equal to node data,
            current.data = value;
            return current;                                             // this is where the node has to be added
        }

        current.height = height(current);                               // update the height of the current node
        return balance(current);                                        // balance the tree after addition
        // return current;
    }

    /**
     * Balances the tree after adding or removing values
     * @return balanced subtree
     */
    private static AVLNode balance(AVLNode node) {
        if (getBalance(node) < - 1) {                                   // R case: balance factor of the node is less than -1
            if (getBalance(node.right) > 0) {                           // LR case: balance factor of the right child is greater than 0
                node.right = rotateRight(node.right);                   // rotate right around the right child
            }                                                           // then rotate left
            node = rotateLeft(node);                                    
        } else if (getBalance(node) > 1) {                              // L case: balance factor is greater than 1
            if (getBalance(node.left) < 0) {                            // RL case: balance factor of the left child is less than 0
                node.left = rotateLeft(node.left);                      // rotate left around the left child 
            }                                                           // then rotate right
            node = rotateRight(node);
        }
        return node;
    }

    /**
     * Removes the given value from the tree
     */
    public static void remove(int value) {
        root = remove(root, value);
    }

    /**
     * Removes the given value from the tree
     * @return the udpated subtree
     */
    private static AVLNode remove(AVLNode current, int data) {
        if (current == null) {                                          // if the tree is empty, nothing to delete
            return null;
        } else if (current.data > data) {                               // it is necessary to traverse the tree until the node is found
            current.left = remove(current.left, data);
        } else if (current.data < data) {
            current.right = remove(current.right, data);
        } else {                                                        // when this node is reached, this is the node that needs deleting
            if (current.right == null) {                                // this node has no right child, so return its left child
                return current.left;                                    // otherwise, this node has no left child, so return its right child
            } else if (current.left == null) {
                return current.right;
            } else {                                                    // the node has both children, traversing to find the inOrder successor
                current.data = getMinimum(current.right);               // after deletion, this node becomes the smallest value on the right
                current.right = remove(current.right, current.data);    
            }
        }
        current.height = height(current);
        return balance(current);
    }

    /**
     * Utility method used to get the balance factor of the given node
     * @return balance factor
     */
    private static int getBalance(AVLNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    /**
     * Utility method for left rotation
     * @return the left rotated subtree
     */
    private static AVLNode rotateLeft(AVLNode current) {
        AVLNode detached = current.right;                               // the node's right child 
        current.right = detached.left;                                  // attach the right child's left subtree to the old parent
        detached.left = current;                                        // attach the old parent to the former right child 

        current.height = height(current);                               // update heights
        detached.height = height(detached);

        return detached;
    }

    /**
     * Utility method for right rotation
     * @return the right rotated subtree
     */
    private static AVLNode rotateRight(AVLNode current) {
        AVLNode detached = current.left;                                // the node's left child 
        current.left = detached.right;                                  // attach the left child's right subtree to the old parent
        detached.right = current;                                       // attach the old parent to the former left child 

        current.height = height(current);                               // update heights
        detached.height = height(detached);

        return detached;
    }

    /**
     * Traversing the tree inOrder for the print method
     */
    public static void inOrder(AVLNode node) {                 
        if (node != null) {
            inOrder(node.left);
            System.out.println("" + node.data + " of height " + height(node));
            inOrder(node.right);
        }
    }

    /**
     * Returns the number of nodes in the tree
     * @return int the number of nodes in the tree
     */
    public static int size(AVLNode current) {                  
        if (current == null) {
            return 0;
        } else {
            return 1 + size(current.left) + size(current.right);        // recursively add together all the nodes in the tree
        }
    }

    /**
     * Utility method used to update heights of nodes
     * @return the height of the current node
     */
    private static int height(AVLNode node) {
        if (node == null) return 0;
        int left = (node.left == null) ? 0 : node.left.height;
        int right = (node.right == null) ? 0 : node.right.height;
        return max(left, right) + 1;
    }

    /**
     * Utility method to find the maximum of two numbers
     * @return the bigger of two integers
     */
    private static int max (int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Utility method to print out all nodes in-order
     */
    public static void print(AVLNode current) {
        System.out.println("The size of the tree now is: " + size(current));
        System.out.println("Traversing the tree in order: ");
        inOrder(current);
    }

    /**
     * Getter memthod for the root of the tree
     * @return the root
     */
    public static AVLNode getRoot() {
        return root;
    }


    /**
     * Checks if the tree is balanced
     * @return true if the tree is balanced
     */
    private static boolean isAVL() {
        return isAVL(root);
    }

    /**
     * Checks if the tree is balanced
     * @param subtree
     * @return true if the tree is balanced
     */
    private static boolean isAVL(AVLNode node) {
        if (node == null) return true;
        int bf = getBalance(node);
        if (bf > 1 || bf < -1) return false;
        return isAVL(node.left) && isAVL(node.right);
    }

    /**
     * returns the minimum value of the given subtree
     * @return the minimum value
     */
    private static int getMinimum(AVLNode current) {                              
        if (current.left == null) {                                     // if there is no left child of the current node,
            return current.data;                                        // this is the minimum
        } else {                                                        // otherwise, recursevily traverse to the left
            return getMinimum(current.left);
        }
    }

    /**
     * Utility tester method
     */
    public static void test() {
        AVLTree tree = new AVLTree();
        int[] added = {45, 20, 70, 10, 35, 60, 90, 30, 40, 50, 80, 99};
        for (int i: added) {
            System.out.println("Adding " + i);
            tree.add(i);

            System.out.println("Is the tree balanced? " + isAVL());
        }
        System.out.println("The root now is " + getRoot().data);
        print(root);
        
        int[] removed = {10, 30, 40, 35, 70, 90, 99};
        for(int n: removed) {
            System.out.println("Removing " + n);
            tree.remove(n);
            System.out.println("The root now is " + getRoot().data);
            System.out.println("Is the tree balanced? " + isAVL());
            System.out.println("Balance factor of the root " + getBalance(root));
            print(root);
        }     
    }
}