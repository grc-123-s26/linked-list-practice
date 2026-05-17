public class Exercises {
    public static void main(String[]args){
    ListNode first = new ListNode();
        first.data = -4;
        //first.data = 8;
        //first.data = 4;
        //first.data = 4;

        ListNode second = new ListNode();
        second.data = 7;
        //second.data = 3;
        //second.data = -6;
        //second.data = 2;

        ListNode third = new ListNode();
        third.data = -8;
        //third.data = 2;
        //third.data = 7;
        //third.data = 10;

        ListNode fourth = new ListNode();
        fourth.data = 6;
        //fourth.data = -7;
        //fourth.data = -3;
        //fourth.data = 1;

        ListNode fifth = new ListNode();
        fifth.data = -2;
        //fifth.data = 8;

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        makePositive(first);
        //addToEnd(first, 99);
        //int result = countNegative(first);
        //int result = sum(first);

        System.out.println(first.data);
        System.out.println(second.data);
        System.out.println(third.data);
        System.out.println(fourth.data);
        System.out.println(fifth.data);
        //System.out.println(fourth.next.data);
        //System.out.println(result);
    }
    /* 
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
        if(head==null) return 0;
        int sum =0;
         ListNode current = head;
         //until end of list
        while(current!=null){
           sum+=current.data;
            // move current to the next node
            current=current.next;
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
        int count =0;
        ListNode current = head;
        if(head==null){
            return 0;
        }else{
          while(current!=null){
           if(current.data<0){
            count++;
            // move current to the next node
           }
           current=current.next; 
         }
            
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
        if(head==null){return;}
        ListNode addToEnd = new ListNode();
        addToEnd.data=toAdd;
         
        ListNode current = head;

        while(current.next!=null){
            current=current.next;
        }
        current.next=addToEnd;


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
        ListNode current = head;

        while(current!=null){
            if(current.data>=0){
                current.data = current.data;
            }else{
                current.data = current.data*-1;
            }
            current=current.next;
        }

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
        if (head == null || head.next ==null){
         return true;

        }

        ListNode current = head;

        while(current.next!= null){
            if(current.data > current.next.data){
                return false;
            }
            current = current.next;
        }
        return true;
    }

}
