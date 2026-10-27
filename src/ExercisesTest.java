import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(17, Exercises.sum(head), "Sum of 4 -> 2 -> 10 -> 1 should be 17");
    }

    @Test
    public void testSumNull() {
        assertEquals(0, Exercises.sum(null), "Sum of null list should be 0");
    }

    @Test
    public void testSumSingle() {
        ListNode head = buildList(5);
        assertEquals(5, Exercises.sum(head), "Sum of 5 should be 5");
    }

    @Test
    public void testSumNegativesAtEnds() {
        ListNode head = buildList(-3, 2, -1, 4);
        assertEquals(2, Exercises.sum(head), "Sum of -3 -> 2 -> -1 -> 4 should be 2");
    }

    @Test
    public void testSumAllNegatives() {
        ListNode head = buildList(-1, -2, -3);
        assertEquals(-6, Exercises.sum(head), "Sum of -1 -> -2 -> -3 should be -6");
    }

    // ===== Tests for countNegative(ListNode) =====

    @Test
    public void testCountNegativeExample() {
        ListNode head = buildList(4, -6, 7, -3, 8);
        assertEquals(2, Exercises.countNegative(head), "countNegative of 4 -> -6 -> 7 -> -3 -> 8 should be 2");
    }

    @Test
    public void testCountNegativeNull() {
        assertEquals(0, Exercises.countNegative(null), "countNegative of null list should be 0");
    }

    @Test
    public void testCountNegativeSinglePositive() {
        ListNode head = buildList(5);
        assertEquals(0, Exercises.countNegative(head), "countNegative of 5 should be 0");
    }

    @Test
    public void testCountNegativeSingleNegative() {
        ListNode head = buildList(-5);
        assertEquals(1, Exercises.countNegative(head), "countNegative of -5 should be 1");
    }

    @Test
    public void testCountNegativeAtEnds() {
        ListNode head = buildList(-1, 2, 3, -4);
        assertEquals(2, Exercises.countNegative(head), "countNegative should count -1 -> 2 -> 3 -> -4 as 2 negatives");
    }

    @Test
    public void testCountNegativeAllNegatives() {
        ListNode head = buildList(-1, -2, -3);
        assertEquals(3, Exercises.countNegative(head), "countNegative of -1 -> -2 -> -3 should be 3");
    }

    // ===== Tests for addToEnd(ListNode, int) =====

    @Test
    public void testAddToEndExample() {
        ListNode head = buildList(8, 3, 2, 7);
        Exercises.addToEnd(head, 99);
        String expected = "8 -> 3 -> 2 -> 7 -> 99";
        assertEquals(expected, listToString(head),
            "After addToEnd, expected " + expected + ", got " + listToString(head));
    }

    @Test
    public void testAddToEndSingle() {
        ListNode head = buildList(1);
        Exercises.addToEnd(head, 8);
        String expected = "1 -> 8";
        assertEquals(expected, listToString(head),
            "After addToEnd on single-node list, expected " + expected + ", got " + listToString(head));
    }

    @Test
    public void testAddToEndSameNumbers() {
        ListNode head = buildList(1, 1, 1, 1);
        Exercises.addToEnd(head, 1);
        String expected = "1 -> 1 -> 1 -> 1 -> 1";
        assertEquals(expected, listToString(head),
            "After addToEnd same numbers list, expected " + expected + ", got " + listToString(head));
    }

    @Test
    public void testAddToEndNull() {
        ListNode head = null;
        assertDoesNotThrow(() -> Exercises.addToEnd(head, 5), "addToEnd(null,5) should not throw");
        assertNull(head, "Head should remain null after addToEnd(null,5)");
    }

    // ===== Tests for makePositive(ListNode) =====

    @Test
    public void testMakePositiveExample() {
        ListNode head = buildList(-4, 7, -8, 6, -2);
        Exercises.makePositive(head);
        String expected = "4 -> 7 -> 8 -> 6 -> 2";
        assertEquals(expected, listToString(head),
            "After makePositive, expected " + expected + ", got " + listToString(head));
    }

    @Test
    public void testMakePositiveNull() {
        ListNode head = null;
        assertNull(head, "Head should remain null after makePositive(null)");
    }

    @Test
    public void testMakePositiveSinglePositive() {
        ListNode head = buildList(3);
        Exercises.makePositive(head);
        assertEquals("3", listToString(head), "Single positive value should remain unchanged");
    }

    @Test
    public void testMakePositiveSingleNegative() {
        ListNode head = buildList(-3);
        Exercises.makePositive(head);
        assertEquals("3", listToString(head), "Single negative value should become positive");
    }

    @Test
    public void testMakePositiveAtEnds() {
        ListNode head = buildList(-1, 2, 3, -4);
        Exercises.makePositive(head);
        String expected = "1 -> 2 -> 3 -> 4";
        assertEquals(expected, listToString(head),
            "makePositive should flip negatives at both ends");
    }

    @Test
    public void testMakePositiveWithZero() {
        ListNode head = buildList(0, -5);
        Exercises.makePositive(head);
        String expected = "0 -> 5";
        assertEquals(expected, listToString(head),
            "Zero should remain unchanged and negative should flip");
    }

    // ===== Tests for isIncreasing(ListNode) =====

    @Test
    public void testIsIncreasingExampleTrue() {
        ListNode head = buildList(3, 7, 7, 12, 15);
        assertTrue(Exercises.isIncreasing(head), "3 -> 7 -> 7 -> 12 -> 15 should be increasing");
    }

    @Test
    public void testIsIncreasingExampleFalse() {
        ListNode head = buildList(3, 1, 7, 9);
        assertFalse(Exercises.isIncreasing(head), "3 -> 1 -> 7 -> 9 should not be increasing");
    }

    @Test
    public void testIsIncreasingNull() {
        assertTrue(Exercises.isIncreasing(null), "Null list should be considered increasing");
    }

    @Test
    public void testIsIncreasingSingle() {
        ListNode head = buildList(5);
        assertTrue(Exercises.isIncreasing(head), "5 should be considered increasing");
    }

    @Test
    public void testIsIncreasingDecreasesAtEnd() {
        ListNode head = buildList(1, 2, 7, 3);
        assertFalse(Exercises.isIncreasing(head), "1 -> 2 -> 7 -> 3 should not be increasing");
    }

    @Test
    public void testIsIncreasingConstant() {
        ListNode head = buildList(5, 5, 5);
        assertTrue(Exercises.isIncreasing(head), "5 -> 5 -> 5 should be increasing");
    }

    @Test
    public void testIsIncreasingNegativeValues() {
        ListNode head = buildList(-8, -2, -1, 0);
        assertTrue(Exercises.isIncreasing(head), "-8 -> -2 -> -1 -> 0 should be increasing");
    }
}
