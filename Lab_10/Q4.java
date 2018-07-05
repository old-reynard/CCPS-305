import java.util.*;
/**
 * @author Nikita Gerasimov
 * @version 2018-06-21
 */
public class Q4
{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        
        map.put("A","Addelson-Velski");
        map.put("T","Turing");
        map.put("V", "Van Rossum");
        map.put("G", "Gosling");
        map.put("K", "Kernighan");
        
        System.out.println("Testing the map");
        System.out.println(map);
        
        System.out.println("Does the map have key V?");
        System.out.println(map.containsKey("V")? "Yes":"No");
        System.out.println("Does the map have key R?");
        System.out.println(map.containsKey("R")? "Yes":"No" + "\n");
        
        System.out.println("Does the map contain value 'Gosling'?");
        System.out.println(map.containsValue("Gosling")? "Yes":"No");
        System.out.println("Does the map contain value 'Ritchie'?");
        System.out.println(map.containsValue("Ritchie")? "Yes":"No" + "\n");
        
        System.out.println("The size of the map is: " + map.size() +"\n");
        
        System.out.println("Removing values at keys V and G");
        map.remove("V");
        map.remove("G");
        System.out.println("Map now: ");
        System.out.println(map);
        
        System.out.println();
        System.out.println("Collection of existing values: ");
        System.out.println(map.values());
        
        System.out.println();
        System.out.println("Is the map empty? " + (map.isEmpty()? "Yes":"No"));
        System.out.println("Removing all values");
        map.clear();
        System.out.println("Is the map empty? " + (map.isEmpty()? "Yes":"No"));
    }
}
