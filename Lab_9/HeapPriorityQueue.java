import java.util.Arrays;
/**
 * class HeapPriorityQueue.
 *
 * @author Nikita Gerasimov
 * @version 218-06-17
 */
public class HeapPriorityQueue
{
    private int[] elements;
    private int size;
    private int[] testable = {-6, 50, 11, 25, 42, 20, 104, 76, 19, 55, 88, 2};
    private int[] heapSorted = new int[testable.length];

    public HeapPriorityQueue() {
        elements = new int[10];
        size = 0;
    }

    private int parent(int idx) {return idx / 2;}

    private int leftChild(int idx) {return idx * 2;}

    private int rightChild(int idx) {return idx * 2 + 1;}

    private boolean hasParent(int idx) {return idx > 1;}

    private boolean hasLeftChild(int idx) {return leftChild(idx) <= size;}

    private boolean hasRightChild(int idx) {return rightChild(idx) <=size;}
    
    private void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    public static void print(int[] queue) {
        for (int value: queue) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void add(int value) {
        if (size == elements.length - 1) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
        elements[size + 1] = value;

        int idx = size + 1;
        boolean found = false;
        while (!found && hasParent(idx)) {
            int parent = parent(idx);
            if (elements[idx] < elements[parent]) {
                swap(elements, idx, parent);
                idx = parent;
            } else {
                found = true;
            }
        }
        size++;
    }

    public int peek() {
        return elements[1];
    }

    public int remove() {
        int removed = elements[1];
        elements[1] = elements[size];
        size--;

        int idx = 1;
        boolean found = false;

        while (!found && hasLeftChild(idx)) {
            int left = leftChild(idx);
            int right = rightChild(idx);
            int child = left;
            if (hasRightChild(idx) && elements[right] < elements[left]) {
                child = right;
            }
            if (elements[idx] > elements[child]) {
                swap(elements, idx, child);
                idx = child;
            } else {
                found = true;
            }
        }
        elements[size + 1] = 0;
        return removed;
    }

    public static void test() {
        HeapPriorityQueue pq = new HeapPriorityQueue();
        for (int n: pq.testable) {
           pq.add(n);
        }
        System.out.println("Start min heap tree: ");
        print(pq.elements);
        for (int n = 0; n < pq.testable.length; n++) {
            System.out.println("Cycle "  + (n + 1));
            pq.heapSorted[n] = pq.remove();
            System.out.println("Current buffer array: ");
            print(pq.elements);
            System.out.println("Current heap sorted array: ");
            print(pq.heapSorted);
            System.out.println();
        }
    }
}
