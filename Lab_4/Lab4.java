import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nikita Gerasimov
 * @version 2018-05-16
 */

public class Lab4 {

    public static void test() {
        Long[] vectors = {
            3333322222L,
            2322222222L,
            1300210000L,
            1300220000L,
            2321222222L,
            1234567890L
        };


        Queue<Long>[] queues = (LinkedList<Long>[])(new LinkedList[10]);
        for (int digit = 0; digit <= 9; digit++) {
            queues[digit] = (Queue<Long>)(new LinkedList<Long>());
        }


        for (int place = 9; place >= 0; place--) {
            for (int vector = 0; vector < vectors.length; vector++) {
                String currentVector = String.valueOf(vectors[vector]);
                int currentDigit = Character.digit(currentVector.charAt(place), 10);
                queues[currentDigit].add(new Long(vectors[vector]));
            }

            int order = 0;
            for (int digit = 0; digit <= 9; digit++) {
                while(!queues[digit].isEmpty()){
                    Long thisVector = queues[digit].remove();
                    vectors[order] = thisVector;
                    order++;
                }
            }
        }

        for (Long vector: vectors) System.out.println(vector);
    }
}