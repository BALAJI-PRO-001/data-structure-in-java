# Singly Linked List
Singly linked list can be defined as the collection of ordered set of elements. The number of elements may vary according to need of the program. A node in the singly linked list consist of two parts: data part and link part. Data part of the node stores actual information that is to be represented by the node while the link part of the node stores the address of its immediate successor. 
One way chain or singly linked list can be traversed only in one direction. In other words, we can say that each node contains only next pointer, therefore we can not traverse the list in the reverse direction. 

![image](https://media.geeksforgeeks.org/wp-content/uploads/singly-linkedlist.png)

## Usage of Singly Linked List
- Dynamic memory allocation is preferred over static arrays.
- Insertion and deletion operations are frequently required at the beginning or end of the list.
- A flexible data structure is needed that allows growth and shrinkage in size without reallocation or reorganization of the entire structure.

## Advantages of Singly Linked List
- **Dynamic Size:** Unlike arrays, linked lists do not require a fixed size at the time of creation. Nodes can be added or removed easily, which makes the size of the list dynamic.

- **Efficient Insertion/Deletion:** Inserting or deleting nodes at the beginning of the list is very efficient, typically O(1) time complexity, as it only requires changing the head pointer. This is much faster compared to arrays, where elements may need to be shifted.

- **Memory Utilization:** Memory is allocated only when a new node is added, so there’s no waste of space as might occur with arrays.

- **No Need for Contiguous Memory:** Unlike arrays, elements in a linked list do not need to be stored in contiguous memory locations, which can be useful in memory-constrained environments.

## Disadvantages of Singly Linked List
- **Access Time:** Accessing an element in a singly linked list takes O(n) time in the worst case since there is no way to directly access the nth element as in an array. You must traverse the list from the head to reach a specific element.

- **Memory Overhead:** Each node in a linked list requires additional memory for the pointer/reference to the next node. This can be significant if the data stored is small or if the list is very long.

- **Inefficient Search Operations:** Searching for an element in a singly linked list is O(n) since it requires traversing the list from the head to the desired element.

- **Reverse Traversal is Not Possible:** A singly linked list can only be traversed in one direction (from head to tail), making reverse traversal impossible without reversing the list or converting it to a doubly linked list.

## Complexity
| Operation   | Average Time Complexity | Worst Time Complexity | Worst Space Complexity |
|-------------|-------------------------|------------------------|------------------------|
| Access      | θ(n)                    | O(n)                   | O(n)                   |
| Search      | θ(n)                    | O(n)                   | O(n)                   |
| Insertion   | θ(1)                    | O(1)                   | O(1)                   |
| Deletion    | θ(1)                    | O(1)                   | O(1)                   |


#### File To Execute: [Main.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/singlyLinkedList/Main.java)
#### File To Study: [SinglyLinkedList.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/singlyLinkedList/SinglyLinkedList.java)