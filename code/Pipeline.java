/**
 * The data structure of wait-for graph.
 */
class ListNode {
      int tid;
      ListNode next;
      ListNode(int id) {
          tid = id;
          next = null;
      }
 }

/**
 * The implementation of root cause analysis pipeline.
 */
public class Pipeline {
    // Wait-for graph
    ListNode waitForGraph = null;

    // A set of regexs used to remove irrelevant information from the call stacks
    String[] regexs = null;

    /**
     * Find the end node of a wait-for graph.
     *
     * @param head Wait-for graph.
     * @return The end node.
     */
    ListNode findLastThread(ListNode head) {
        if (head == null)
            return null;

        // If there is no cycle in the graph
        else if (detectCycle(head) == null){
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            return p;
        }
    }

    /**
     * The implementation of cycle detection algorithm.
     *
     * @param head Wait-for graph.
     * @return The entrance of the cycle. NULL if there is no cycle.
     */
    ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode nodeOfCycle = getCycle(head);
        if (nodeOfCycle == null) {
            return null;
        }

        // Try to find the entrance of a detected cycle
        ListNode node1 = head;
        ListNode node2 = nodeOfCycle;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    /**
     * Detect and acquire the cycle of a graph.
     *
     * @param head Wait-for graph.
     * @return A node of the cycle. NULL if there is no cycle.
     */
    ListNode getCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        // The faster node will eventually collide with the slower node (if a cycle exists) or reach NULL.
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return slowNode;
            }
        }

        return null;
    }
}
