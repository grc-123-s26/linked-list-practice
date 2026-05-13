public class ListNode {
    public int data;
    public ListNode next;

    // chatgbt was used to create this empty constuctor cause i was lost on how to solve the HW
    public ListNode() {
        this.data = 0;
        this.next = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}