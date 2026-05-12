public class Exercises {
    /**
     * Returns the sum of the values in the linked list.
     * 
     * Returns 0 if head is null.
     * 
     * Example:
     * input: 4 -> 2 -> 10 -> 1
     * output: 17
     * 
     * @param head the head of the linked list
     * @return sum of the values in the list
     */
    public static int sum(ListNode head) {
        //grab the value of head
        ListNode current = head;
        if (current == null) {
            return 0;
        }

        int returnVal = 0;

        //go until you run out
        while(current != null) {
            returnVal += current.data;
            current = current.next;
        }
        return returnVal;
    }

    /**
     * Returns how many negative values there are in the linked list.
     * 
     * Returns 0 if the head is null.
     * 
     * Example:
     * input: 4 -> -6 -> 7 -> -3 -> 8
     * output: 2
     * 
     * @param head the head of the linked list
     * @return a count of the negative values in the list
     */
    public static int countNegative(ListNode head) {
        // grab the value of head
        ListNode current = head;
        // if current is null return 0
        if (current == null) {
            return 0;
        }
        // make a return val
        int returnVal = 0;

        // while loop
        while(current != null) {
            int currentVal = current.data;
            if (currentVal < 0) {
                returnVal++;
            }
            current = current.next;
        }
        return returnVal;
    }

    /**
     * Adds a new ListNode with the given value to the end of the linked list.
     * 
     * If head is null, no action is taken.
     * 
     * Example:
     * head: 8 -> 3 -> 2 -> 7
     * toAdd: 99
     * 
     * result: 8 -> 3 -> 2 -> 7 -> 99
     * 
     * @param head the head of the list
     * @param toAdd the value to append in a new node
     */
    public static void addToEnd(ListNode head, int toAdd) {
        ListNode current = head;
        if (current == null) {
            return;
        }

        // need to look ahead of where i am, not where i am in the chain to be able to do what i want
        // or else i loop forever with the change inside the while adding over and over
        // or lose the address i need because i jump past it
        while(current.next != null) {
            current = current.next;
        }
        //need to add the thing not to where i am, but to the next one
        current.next = new ListNode(toAdd);
    }

    /**
     * Modifies the list to make all negative values positive.
     * 
     * Positive and zero values are left unchanged.
     * If head is null, no action is taken.
     * 
     * Example:
     * head: -4 -> 7 -> -8 -> 6 -> -2
     * result: 4 -> 7 -> 8 -> 6 -> 2
     * 
     * @param head the head of the list
     */
    public static void makePositive(ListNode head) {

    }

    /**
     * Returns true if every value in the list is less than or equal to the next
     * value in the list and false otherwise.
     * 
     * Returns true if head is null or there is only one value in the list.
     * 
     * Examples:
     * input: 3 -> 7 -> 7 -> 12 -> 15
     * output: true
     * 
     * input: 3 -> 1 -> 7 -> 9
     * output: false
     * 
     * @param head the head of the list
     * @return whether the list is increasing
     */
    public static boolean isIncreasing(ListNode head) {
        return false;
    }
}
