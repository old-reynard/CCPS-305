
/**
 * Demo implementation of the Binary Seacrh Tree class
 *
 * @author Nikita Gerasimov
 * @version 2018-05-28
 */
public class BSTree
{

    private static Node root;

    /**
     * Constructor for objects of class BSTree
     */
    public BSTree() {
        root = null;
    }

    /**
     * Traverse the tree from the root and find the place for the new value
     */
    public void add(int value) {        
        root = add(root, value);
    }

    /**
     * Returns the node that will be added to the tree
     * @return the new node
     */
    private static Node add(Node current, int value) {                   
        if (current == null) {                                          
            return new Node(value);
        } 

        if (value < current.data) {                                     
            current.left = add(current.left, value);                    
        } else if (value > current.data) {                              
            current.right = add(current.right, value);                  
        } else {                                                        
            return current;                                             
        }
        return current;
    }

    /**
     * Utility method to print out all nodes in-order
     */
    public static void print(Node current) {
        System.out.println("The size of the tree now is: " + size(current));
        System.out.println("Traversing the tree in order: ");
        inOrder(current);
    }

    /**
     * Traversing the tree inOrder for the print method
     */
    public static void inOrder(Node node) {                 
        if (node != null) {
            inOrder(node.left);
            System.out.println("" + node.data);
            inOrder(node.right);
        }
    }

    /**
     * Returns the number of nodes in the tree
     * @return int the number of nodes in the tree
     */
    public static int size(Node current) {                  
        if (current == null) {
            return 0;
        } else {
            return 1 + size(current.left) + size(current.right);        
        }
    }

    /**
     * Finds the data that needs to be removed and removes it
     */
    public void remove(int value) {
        root = remove(root, value);
    }

    /**
     * Decides how to remove the given node
     * @return the node that needs to be removed
     */
    private Node remove(Node current, int data) {                       
        if (current == null) {                                          
            return null;
        } else if (current.data > data) {                               
            current.left = remove(current.left, data);
        } else if (current.data < data) {
            current.right = remove(current.right, data);
        } else {                                                        
            if (current.right == null) {                                
                return current.left;                                    
            } else if (current.left == null) {
                return current.right;
            } else {                                                    
                current.data = getMinimum(current.right);               
                current.right = remove(current.right, current.data);    
            }
        }
        return current;                                                 
    }

    /**
     * returns the minimum value of the given subtree
     * @return the minimum value
     */
    private int getMinimum(Node current) {                              
        if (current.left == null) {                                     
        return current.data;                                            
        } else {                                                        
            return getMinimum(current.left);
        }
    }

    public static Node getRoot() {
        return root;
    }

    /**
     * Utility tester method
     */
    public static void test() {
        BSTree tree = new BSTree();
        System.out.println("Adding 7, 8, 9, 5, 6, 1, 4, 10, 1, 12");
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(4);
        tree.add(10);
        tree.add(1);
        tree.add(12);
        System.out.println("The root now is " + getRoot().data);
        print(root);
        System.out.println("Removing 12");
        tree.remove(12);
        System.out.println("The root now is " + getRoot().data);
        print(root);
        System.out.println("Removing the root");
        tree.remove(7);
        System.out.println("The root now is " + getRoot().data);
        print(root);
    }
}
