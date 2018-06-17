import java.lang.Math;
/**
 * class Hashing.
 *
 * @author Nikita Gerasimov
 * @version 2018-06-17
 */
public class Hashing
{
    private int[] elements;
    private int size;

    public Hashing() {
        elements = new int[33];
        size = 0;
    }

    public int hash(int value) {
        return Math.abs(value) % elements.length;
    }

    public void add(int value) {
        if ((double)size / elements.length >= 0.75) {
            rehash();
        }
        int hashed = hash(value);
        while (elements[hashed] != 0 && elements[hashed] != value) {
            //linear probing
            hashed = (hashed + 1) % elements.length;
        }
        if (elements[hashed] != value) {
            elements[hashed] = value;
            size++;
        }
    }

    public boolean contains(int value) {
        int hashed = hash(value);
        while (elements[hashed] != 0) {
            if (elements[hashed] == value) {
                return true;
            }
            hashed = (hashed + 1) % elements.length;
        }
        return false;
    }

    public void remove(int value) {
        int hashed = hash(value);
        while (elements[hashed] != 0 && elements[hashed] != value) {
            hashed = (hashed + 1) % elements.length;
        }
        if (elements[hashed] == value) {
            elements[hashed] = -999;
            size--;
        }
    }

    public void rehash() {
        int[] old = elements;
        elements = new int[2 * old.length];        
        size = 0;
        for (int value: old) {
            if (value != 0) {
                add(value);
            }
        }
    }

    public static void printTable(Hashing table) {
        for (int value: table.elements) {
            System.out.print(value + " ");
        }
    }

    public static void test() {
        Hashing h = new Hashing();
        System.out.println("Hash table after creation: ");
        printTable(h);
        System.out.println("\nAdding 25, 15, 78, 83, 99, 75, 96, 158, 1, 48, 96, 73, 33, 44, 47, -75, - 18, -19, 83, 500, 89");
        int[] toAdd = {25, 15, 78, 83, 99, 75, 96, 158, 1, 48, 96, 73, 33, 44, 47, -75, - 18, -19, 83, 500, 89};
        for (int n: toAdd) {
            h.add(n);
        }

        System.out.println("Hash table now: ");
        printTable(h);
        System.out.println("\nAdd more value to reach rehash threshold: 7, 8, 9, 10, 12, 120, 130");
        int[] toAdd_2 = {7, 8, 9, 10, 12, 120, 130};
        for (int n: toAdd_2) {
            h.add(n);
        }

        System.out.println("Hash table now: ");
        printTable(h);
        System.out.println();
        System.out.println("Removing several value: 158, 1, 48, 96, 73, 33, 9, 10, 12");
        int[] toRemove = {158, 1, 48, 96, 73, 33, 9, 10, 12};
        for (int n: toRemove) {
            h.remove(n);
        }
        System.out.println("Hash table now: ");
        printTable(h);
    }
}
