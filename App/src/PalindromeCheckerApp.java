import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        String processedInput = input.replaceAll("\\s+", "").toLowerCase();


        for (int i = 0; i < processedInput.length(); i++) {
            stack.push(processedInput.charAt(i));
        }


        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }


        if (processedInput.equals(reversed)) {
            System.out.println("Result: The string is a Palindrome.");
        } else {
            System.out.println("Result: The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}