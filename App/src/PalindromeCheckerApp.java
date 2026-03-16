import java.util.*;

// 1. Define the PalindromeStrategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome Checker ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Algorithm Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Selection: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
            System.out.println("Using Stack-based Algorithm...");
        } else {
            context.setStrategy(new DequeStrategy());
            System.out.println("Using Deque-based Algorithm...");
        }

        boolean result = context.check(input);
        System.out.println("\nIs Palindrome: " + result);

        scanner.close();
    }
}