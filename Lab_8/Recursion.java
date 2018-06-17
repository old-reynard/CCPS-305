import java.lang.*;
/**
 * class Recursion
 *
 * @author Nikita Gerasimov
 * @version 2018-06-11
 */
public class Recursion
{
    public int gcd(int a, int b) {
       if (a < b) return gcd(b, a);
       if (b == 0) return a;
       return gcd(b, a % b);
    }
    
    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void printFibonacci(int n) {
        if (n==0) return;
        System.out.print(fibonacci(n-1) + " ");
        printFibonacci(n-1);
        //System.out.println();
    }

    public boolean isPalindrome(String s) {
       s = prepare(s);                                                      // cleans the string of non-letter characters
       return isPalindromeRecursive(s);
    }

    private String prepare(String s) {
        if (s.length() == 0) return "";
        if (!Character.isLetter(s.charAt(0))) {
            return prepare(s.substring(1));
        } else {
            return Character.toLowerCase(s.charAt(0)) + prepare(s.substring(1));
        }
    }

    private boolean isPalindromeRecursive(String s) {
        if (s.length() < 2) return true;
        return s.charAt(0) == s.charAt(s.length()-1) && 
            isPalindromeRecursive(s.substring(1, s.length() - 1));
    }

    public static void tester() {
        Recursion r = new Recursion();
        System.out.println("Testing the Recusion class:");

        System.out.println("The GCD for 72 and 60 is: " + r.gcd(72, 60));
        System.out.println("The GCD for 100 and 30 is: " + r.gcd(100, 30));
        System.out.println("The GCD for 144 and 360 is: " + r.gcd(144, 360));
        System.out.println("The GCD for 34 and 21 (two Fibonacci numbers) is: " + r.gcd(34, 21));
        System.out.println();
        System.out.println("The first 20 Fibonacci numbers: ");
        printFibonacci(20);
        System.out.println();
        System.out.println("Is 'civic' a palindrome? " + (r.isPalindrome("civic")? "Yes": "No"));
        System.out.println("Is 'redivider' a palindrome? " + (r.isPalindrome("redivider")? "Yes": "No"));
        System.out.println("Is 'Ryerson' a palindrome? " + (r.isPalindrome("Ryerson")? "Yes": "No"));
        String p = "Are we not pure? “No sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era.";
        System.out.println("Is '" + p + "' a palindrome? " + (r.isPalindrome(p)? "Yes": "No"));
    }
}
