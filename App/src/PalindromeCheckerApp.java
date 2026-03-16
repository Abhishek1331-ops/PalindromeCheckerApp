import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome Checker ---");
        System.out.print("Enter a string (try phrases with spaces/punctuation): ");
        String input = scanner.nextLine();

        String processedStr = preprocess(input);

        System.out.println("Normalized String: " + processedStr);

        if (isPalindrome(processedStr)) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failure. It is NOT a palindrome.");
        }

        scanner.close();
    }

    public static String preprocess(String str) {
        if (str == null) return "";

        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static boolean isPalindrome(String str) {
        if (str.isEmpty()) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}