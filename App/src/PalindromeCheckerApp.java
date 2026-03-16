import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getName();
}

class StackStrategy implements PalindromeStrategy {
    public String getName() { return "Stack Strategy"; }
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return clean.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    public String getName() { return "Deque Strategy"; }
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- UC13: Palindrome Algorithm Performance Comparison ---");
        System.out.print("Enter a long string to test performance: ");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy()
        );

        System.out.println("\nPerformance Results:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-12s | %-15s\n", "Algorithm", "Is Palindrome", "Time (nanos)");
        System.out.println("---------------------------------------------------------");

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();

            boolean result = strategy.isPalindrome(input);

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-20s | %-13b | %-15d\n",
                    strategy.getName(), result, duration);
        }
        System.out.println("---------------------------------------------------------");

        scanner.close();
    }
}