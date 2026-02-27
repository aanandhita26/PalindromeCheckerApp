import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String input = sc.nextLine();

        // Injecting strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        // PalindromeStrategy strategy = new DequeStrategy();

        boolean result = strategy.check(input);

        System.out.println("Is Palindrome? " + result);

        sc.close();
    }
}

/* ============================= */
/* STRATEGY INTERFACE */
/* ============================= */

interface PalindromeStrategy {
    boolean check(String input);
}

/* ============================= */
/* STACK STRATEGY */
/* ============================= */

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/* ============================= */
/* DEQUE STRATEGY */
/* ============================= */

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}