public class Exercises {
    
    //TESTS ARE NOT WORKING
    //Had to test using a main method myself

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(-1);
        //ListNode l7 = new ListNode(-1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        //l6.next = l7;
        
        addToEnd(l1, -1);

        System.out.println(sum(l1));
        System.out.println(countNegative(l1));
    }
    
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
        int sum = 0;
        ListNode t1 = head;
        while(t1 != null)
        {
            sum += t1.data;
            t1 = t1.next;
        }
        return sum;
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
        int count = 0;
        ListNode t1 = head;
        while(t1 != null)
        {
            if(t1.data < 0){count++;}
            t1 = t1.next;
        }
        return count;
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
        ListNode newNode = new ListNode(toAdd);
        ListNode t1 = head;
        while(t1.next != null)
        {
            t1 = t1.next;
        }
        t1.next = newNode;
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
