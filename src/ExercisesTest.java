import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

/**
 * JUnit tests for Exercises linked-list methods.
 */
public class ExercisesTest {

    /** Helper to build a linked list from an array of values. */
    private ListNode buildList(int... values) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Helper to convert a list to a string, detecting cycles gracefully.
     * Format: data1 -> data2 -> ...
     */
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                sb.append(" -> ...(cycle detected)...");
                break;
            }
            visited.add(curr);
            sb.append(curr.data);
            curr = curr.next;
            if (curr != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    // ===== Tests for sum(ListNode) =====

    @Test
    public void testSumExample() {
        ListNode head = buildList(4, 2, 10, 1);
        assertEquals("Sum of 4 -> 2 -> 10 -> 1 should be 17", 17, Exercises.sum(head));
    }

    @Test
    public void testSumNull() {
        assertEquals("Sum of null list should be 0", 0, Exercises.sum(null));
    }

    @Test
    public void testSumSingle() {
        ListNode head = buildList(5);
        assertEquals("Sum of 5 should be 5",5, Exercises.sum(head));
    }

    @Test
    public void testSumNegativesAtEnds() {
        ListNode head = buildList(-3, 2, -1, 4);
        assertEquals("Sum of -3 -> 2 -> -1 -> 4 should be 2",2, Exercises.sum(head));
    }

    @Test
    public void testSumAllNegatives() {
        ListNode head = buildList(-1, -2, -3);
        assertEquals("Sum of -1 -> -2 -> -3 should be -6", -6, Exercises.sum(head));
    }

    // ===== Tests for countNegative(ListNode) =====

    @Test
    public void testCountNegativeExample() {
        ListNode head = buildList(4, -6, 7, -3, 8);
        assertEquals("countNegative of 4 -> -6 -> 7 -> -3 -> 8 should be 2", 2, Exercises.countNegative(head));
    }

    @Test
    public void testCountNegativeNull() {
        assertEquals("countNegative of null list should be 0", 0, Exercises.countNegative(null));
    }

    @Test
    public void testCountNegativeSinglePositive() {
        ListNode head = buildList(5);
        assertEquals("countNegative of 5 should be 0", 0, Exercises.countNegative(head));
    }

    @Test
    public void testCountNegativeSingleNegative() {
        ListNode head = buildList(-5);
        assertEquals("countNegative of -5 should be 1", 1, Exercises.countNegative(head));
    }

    @Test
    public void testCountNegativeAtEnds() {
        ListNode head = buildList(-1, 2, 3, -4);
        assertEquals("countNegative should count -1 -> 2 -> 3 -> -4 as 2 negatives", 2, Exercises.countNegative(head));
    }

    @Test
    public void testCountNegativeAllNegatives() {
        ListNode head = buildList(-1, -2, -3);
        assertEquals("countNegative of -1 -> -2 -> -3 should be 3", 3, Exercises.countNegative(head));
    }

    // ===== Tests for addToEnd(ListNode, int) =====

    @Test
    public void testAddToEndExample() {
        ListNode head = buildList(8, 3, 2, 7);
        Exercises.addToEnd(head, 99);
        String expected = "8 -> 3 -> 2 -> 7 -> 99";
        assertEquals("After addToEnd, expected " + expected + ", got " + listToString(head), expected, listToString(head));
    }

    @Test
    public void testAddToEndSingle() {
        ListNode head = buildList(1);
        Exercises.addToEnd(head, 8);
        String expected = "1 -> 8";
        assertEquals("After addToEnd on single-node list, expected " + expected + ", got " + listToString(head), expected, listToString(head));
    }

    @Test
    public void testAddToEndNull() {
        ListNode head = null;
        assertDoesNotThrow(() -> Exercises.addToEnd(head, 5), "addToEnd(null,5) should not throw");
        assertNull("Head should remain null after addToEnd(null,5)", head);
    }

    // ===== Tests for makePositive(ListNode) =====

    @Test
    public void testMakePositiveExample() {
        ListNode head = buildList(-4, 7, -8, 6, -2);
        Exercises.makePositive(head);
        String expected = "4 -> 7 -> 8 -> 6 -> 2";
        assertEquals("After makePositive, expected " + expected + ", got " + listToString(head), expected, listToString(head));
    }

    @Test
    public void testMakePositiveNull() {
        ListNode head = null;
        assertNull("Head should remain null after makePositive(null)", head);
    }

    @Test
    public void testMakePositiveSinglePositive() {
        ListNode head = buildList(3);
        Exercises.makePositive(head);
        assertEquals("Single positive value should remain unchanged", "3", listToString(head));
    }

    @Test
    public void testMakePositiveSingleNegative() {
        ListNode head = buildList(-3);
        Exercises.makePositive(head);
        assertEquals("Single negative value should become positive", "3", listToString(head));
    }

    @Test
    public void testMakePositiveAtEnds() {
        ListNode head = buildList(-1, 2, 3, -4);
        Exercises.makePositive(head);
        String expected = "1 -> 2 -> 3 -> 4";
        assertEquals("makePositive should flip negatives at both ends", expected, listToString(head));
    }

    @Test
    public void testMakePositiveWithZero() {
        ListNode head = buildList(0, -5);
        Exercises.makePositive(head);
        String expected = "0 -> 5";
        assertEquals("Zero should remain unchanged and negative should flip", expected, listToString(head));
    }

    // ===== Tests for isIncreasing(ListNode) =====

    @Test
    public void testIsIncreasingExampleTrue() {
        ListNode head = buildList(3, 7, 7, 12, 15);
        assertTrue("3 -> 7 -> 7 -> 12 -> 15 should be increasing", Exercises.isIncreasing(head));
    }

    @Test
    public void testIsIncreasingExampleFalse() {
        ListNode head = buildList(3, 1, 7, 9);
        assertFalse("3 -> 1 -> 7 -> 9 should not be increasing", Exercises.isIncreasing(head));
    }

    @Test
    public void testIsIncreasingNull() {
        assertTrue("Null list should be considered increasing", Exercises.isIncreasing(null));
    }

    @Test
    public void testIsIncreasingSingle() {
        ListNode head = buildList(5);
        assertTrue("5 should be considered increasing", Exercises.isIncreasing(head));
    }

    @Test
    public void testIsIncreasingDecreasesAtEnd() {
        ListNode head = buildList(1, 2, 7, 3);
        assertFalse("1 -> 2 -> 7 -> 3 should not be increasing", Exercises.isIncreasing(head));
    }

    @Test
    public void testIsIncreasingConstant() {
        ListNode head = buildList(5, 5, 5);
        assertTrue("5 -> 5 -> 5 should be increasing", Exercises.isIncreasing(head));
    }

    @Test
    public void testIsIncreasingNegativeValues() {
        ListNode head = buildList(-8, -2, -1, 0);
        assertTrue("-8 -> -2 -> -1 -> 0 should be increasing", Exercises.isIncreasing(head));
    }
}
