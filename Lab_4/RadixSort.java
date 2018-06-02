import java.util.LinkedList;
import java.util.Queue;
public class RadixSort     
{
    /**
     * Performs a radix sort on a set of numeric values.
	 */
    public static void main(String[] args)
    { 
            Long[] list = {
            3333322222L,
            2322222222L,
            1300210000L,
            1300220000L,
            2321222222L
        };

        String temp;
        Long numObj;
        int digit, num;

        Queue<Long>[] digitQueues = (LinkedList<Long>[])(new LinkedList[10]);
        for (int digitVal = 0; digitVal <= 9; digitVal++) {
            digitQueues[digitVal] = (Queue<Long>)(new LinkedList<Long>());
            //digitQueues[digitVal].add(new Long(digitVal));
            System.out.println(digitQueues[digitVal]);
        }
                    // sort the list
        for (int position=0; position <= 3; position++)
        {
            for (int scan=0; scan < list.length; scan++)
            {
                temp = String.valueOf(list[scan]);
                digit = Character.digit(temp.charAt(3-position), 10);
                //System.out.println(temp + " " + digit);
                digitQueues[digit].add(new Long(list[scan]));
                System.out.println(digitQueues[digit]);
            }

            // gather numbers back into list
            num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++)
            {
                while (!(digitQueues[digitVal].isEmpty()))
                {
                    numObj = digitQueues[digitVal].remove();
                    list[num] = numObj.longValue();
                    num++;
                }
            }
        }

        // output the sorted list
        for (int scan=0; scan < list.length; scan++)
            System.out.println(list[scan]);
    }
}