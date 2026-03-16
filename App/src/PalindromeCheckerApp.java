import java.util.Scanner;

class PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String cleanStr = preprocess(input);
        return isLogicValid(cleanStr);
    }

    private String preprocess(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean isLogicValid(String str) {
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

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter text: ");
        String userInput = scanner.nextLine();

        boolean result = service.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: Success! It is a palindrome.");
        } else {
            System.out.println("Result: Failure. It is NOT a palindrome.");
        }

        scanner.close();
    }
}