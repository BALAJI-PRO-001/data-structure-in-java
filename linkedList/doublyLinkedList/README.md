## Doubly Linked List 
A Singly Linked List (SLL) is a linear data structure where each element (node) points to the next element in the sequence. It consists of a sequence of nodes where each node contains:
- **Data:** The actual value stored in the node.
- **Pointer/Reference to the next node:** A link to the next node in the sequence.

The first node in the list is called the head, and the last node points to null, indicating the end of the list.

![image](https://raw.githubusercontent.com/BALAJI-PRO-001/data-structure-in-java/main/images/dll.png)

### Usage of Doubly Linked List
- Efficient traversal in both directions (forward and backward) is required.
- Frequent insertions and deletions are needed at both ends (head and tail) or in the middle of the list.
- Implementation of more complex data structures like deques, memory management (e.g., garbage collection), and undo operations in applications.

### Advantages of Doubly Linked List
- **Bidirectional Traversal:** The ability to traverse the list in both forward and backward directions is the key advantage of a doubly linked list. This makes operations like reverse traversal and bidirectional iteration much easier.
- **Efficient Insertion/Deletion:** Similar to singly linked lists, insertion and deletion operations at both ends of the list are efficient (O(1) time complexity). Additionally, deleting a node from the middle of the list is easier compared to a singly linked list since the node has a reference to its previous node.
- **Flexible Operations:** DLLs can be easily manipulated to implement more complex data structures like stacks, queues, and deques with efficient operations.
- **Undo Functionality:** Doubly linked lists are commonly used in applications requiring undo operations because they allow easy movement back and forth through the list.

### Disadvantages of Doubly Linked List
- **Increased Memory Usage:** Each node in a doubly linked list requires additional memory for the pointer to the previous node. This extra memory overhead can be significant if the list is long or if the data stored in each node is small.
- **Complexity in Implementation:** Maintaining the correct links between nodes during insertion and deletion operations is more complex in a doubly linked list compared to a singly linked list. The risk of errors like memory leaks or dangling pointers is higher.
- **Slower Operations:** While traversal in both directions is possible, the additional pointers mean that each node requires more time to allocate and manage. This can make operations slightly slower compared to singly linked lists.
- **Extra Handling for Edge Cases:** Special care is required to handle cases like inserting or deleting at the head or tail of the list, and keeping track of both next and previous pointers, which adds to the complexity.

## Complexity

| Operation | Average Time Complexity | Worst Time Complexity | Worst Space Complexity |
|-----------|-------------------------|-----------------------|------------------------|
| **Access**   | θ(n)                     | O(n)                   | O(n)                    |
| **Search**   | θ(n)                     | O(n)                   | O(n)                    |
| **Insertion**| θ(1)                     | O(1)                   | O(1)                    |
| **Deletion** | θ(1)                     | O(1)                   | O(1)   


#### File To Execute: [Main.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/doublyLinkedList/Main.java)
#### File To Study: [SinglyLinkedList.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/doublyLinkedList/DoublyLinkedList.java)