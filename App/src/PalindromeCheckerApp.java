import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC4 : Character Array Based Palindrome Check ===");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // converting the string to char array
        char[] chars = input.toCharArray();

        // initialize two pointers
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // now, we will compare characters using two-pointer approach
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        sc.close();
    }
}