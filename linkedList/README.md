# Linked List
Linked list is a linear data structure that includes a series of connected nodes. Linked list can be defined as the nodes that are randomly stored in the memory. A node in the linked list contains two parts, i.e., first is the data part and second is the address part. The last node of the list contains a pointer to the null. After array, linked list is the second most used data structure. In a linked list, every link contains a connection to another link.

## Representation of a Linked list
![image](https://lh6.googleusercontent.com/5lLKaW2XELSKW0CQu7-rEoqgpaNAJoGBXZID57iL2HLTXNrAfUtB4kzMcboZ4UQ5pgccU6SnFHSKAG-Yfo_3J-gWmFxpy7Mym-lhrIc6j9elYf_y16UoMkBZcAfcI2H8mGE1T7y-pDOl09QnSw)

## Types of Linked list
- **Singly-linked list** - Singly linked list can be defined as the collection of an ordered set of elements. A node in the singly linked list consists of two parts: data part and link part. Data part of the node stores actual information that is to be represented by the node, while the link part of the node stores the address of its immediate successor.

- **Doubly linked list** - Doubly linked list is a complex type of linked list in which a node contains a pointer to the previous as well as the next node in the sequence. Therefore, in a doubly-linked list, a node consists of three parts: node data, pointer to the next node in sequence (next pointer), and pointer to the previous node (previous pointer).

- **Circular singly linked list** - In a circular singly linked list, the last node of the list contains a pointer to the first node of the list. We can have circular singly linked list as well as circular doubly linked list.

- **Circular doubly linked list** - Circular doubly linked list is a more complex type of data structure in which a node contains pointers to its previous node as well as the next node. Circular doubly linked list doesn't contain NULL in any of the nodes. The last node of the list contains the address of the first node of the list. The first node of the list also contains the address of the last node in its previous pointer.

## Advantages of Linked list
- **Dynamic data structure** - The size of the linked list may vary according to the requirements. Linked list does not have a fixed size.
- **Insertion and deletion** - Unlike arrays, insertion, and deletion in linked list is easier. Array elements are stored in the consecutive location, whereas the elements in the linked list are stored at a random location. To insert or delete an element in an array, we have to shift the elements for creating the space. Whereas, in linked list, instead of shifting, we just have to update the address of the pointer of the node.
- **Memory efficient** - The size of a linked list can grow or shrink according to the requirements, so memory consumption in linked list is efficient.
- **Implementation** - We can implement both stacks and queues using linked list.

## Disadvantages of Linked list
- **Memory usage** - In linked list, node occupies more memory than array. Each node of the linked list occupies two types of variables, i.e., one is a simple variable, and another one is the pointer variable.
- **Traversal** - Traversal is not easy in the linked list. If we have to access an element in the linked list, we cannot access it randomly, while in case of array we can randomly access it by index. For example, if we want to access the 3rd node, then we need to traverse all the nodes before it. So, the time required to access a particular node is large.
- **Reverse traversing** - Backtracking or reverse traversing is difficult in a linked list. In a doubly-linked list, it is easier but requires more memory to store the back pointer.

## Time Complexity
| Operations  | Average Case Time Complexity | Worst-Case Time Complexity |
|-------------|------------------------------|----------------------------|
| Insertion   | O(1)                          | O(1)                        |
| Deletion    | O(1)                          | O(1)                        |
| Search      | O(n)                          | O(n)                        |

## Space Complexity
| Operations | Space Complexity |
|------------|------------------|
| Insertion  | O(n)             |
| Deletion   | O(n)             |
| Search     | O(n)             |

[More ...](https://www.javatpoint.com/ds-linked-list)