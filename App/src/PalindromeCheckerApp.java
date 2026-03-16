import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC8: Linked List Based Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Basic cleaning: lowercase and alphanumeric only
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanStr.isEmpty()) {
            System.out.println("Result: Palindrome (Empty/Non-alphanumeric)");
        } else {
            Node head = buildLinkedList(cleanStr);
            if (isPalindrome(head)) {
                System.out.println("Result: '" + input + "' is a palindrome.");
            } else {
                System.out.println("Result: '" + input + "' is NOT a palindrome.");
            }
        }

        scanner.close();
    }

    private static Node buildLinkedList(String s) {
        if (s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        Node tempSecond = secondHalfHead;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}