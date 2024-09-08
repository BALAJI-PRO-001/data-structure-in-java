# Circular Linked List
A Circular Linked List is a variation of the linked list in which the last node points back to the first node, forming a circle. Unlike singly and doubly linked lists, circular linked lists do not have NULL or None as the end of the list. This allows traversal from any node back to itself or to other nodes in the list without needing to start from the head.

![image](https://raw.githubusercontent.com/BALAJI-PRO-001/data-structure-in-java/main/images/cll.png)

## Advantages
- **Efficient Traversal:** You can traverse the entire list from any node since it forms a circle, making it useful for applications where you need to repeatedly go through the list.
- **Memory Efficiency:** No need for an extra end marker, like NULL in singly linked lists, slightly reducing memory usage.
- **Useful in Implementation of Queues:** Especially useful in implementing circular queues, where the last position is connected to the first, facilitating efficient use of memory.
- **Round-Robin Scheduling:** Circular linked lists are ideal for round-robin scheduling in computer science, where each task gets an equal share of time.

## Disadvantages
- **Complex Implementation:** Managing pointers can be more complex, especially when adding or removing nodes.
- **Difficult Debugging:** Due to the circular nature, bugs like infinite loops can occur more easily, making debugging challenging.
- **No Natural End:** There’s no natural termination point when traversing, so you need extra checks to avoid infinite loops.
- **Not Easily Reversible:** Unlike doubly linked lists, you cannot easily traverse the list in reverse order.

## Complexity

| **Operation** | **Average Time Complexity** | **Worst Time Complexity** | **Worst Space Complexity** |
|---------------|-----------------------------|---------------------------|----------------------------|
| **Access**    | θ(n)                         | O(n)                       | O(1)                        |
| **Search**    | θ(n)                         | O(n)                       | O(1)                        |
| **Insertion** | θ(1)                         | O(1)                       | O(1)                        |
| **Deletion**  | θ(1)                         | O(1)                       | O(1)                        |

#### File To Execute: [Main.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/circularLinkedList/Main.java)
#### File To Study: [CircularLinkedList.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/circularLinkedList/CircularLinkedList.java)