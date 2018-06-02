
/**
 * interface BinaryTreeADT.
 *
 * @author Nikita Gerasimov
 * @version 2018-05-28
 */
public interface BinaryTreeADT<T>
{
    /**
     * Returns a reference to the root element 
     * @return a reference to the root
     */

    public T getRoot();


    /** 
     * Returns true if this binary tree is empty and false otherwise.
     * @return true if this binary tree is empty, false otherwise
     */
    // public boolean isEmpty();


    public static void add(int value);


    public static T add(T current, int value);


    public static int size(T current);

    
    public static T remove(T current, int value);
}
