import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class racecarPalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {

        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanStr.isEmpty()) return true;

        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : cleanStr.toCharArray()) {
            deque.addLast(ch);
        }


        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }
}