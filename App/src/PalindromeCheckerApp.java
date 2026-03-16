import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindromeRecursive(cleanStr, 0, cleanStr.length() - 1)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }


        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}