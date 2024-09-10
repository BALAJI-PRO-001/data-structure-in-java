# Data Structure
Data Structure is a branch of Computer Science. The study of data structure allows us to understand the organization of data and the management of the data flow in order to increase the efficiency of any process or program. Data Structure is a particular way of storing and organizing data in the memory of the computer so that these data can easily be retrieved and efficiently utilized in the future when required. The data can be managed in various ways, like the logical or mathematical model for a specific organization of data is known as a data structure.

## Need for Data Structures

Data structures play a crucial role in computer science and software development. Here’s why they are essential:

- **Efficient Data Management:**  Data structures organize and manage data efficiently, allowing for faster retrieval, insertion, and deletion operations.

- **Optimal Performance:** They help in optimizing the performance of algorithms by providing appropriate ways to access and manipulate data.

- **Problem Solving:** Different data structures are suited for different types of problems. Choosing the right data structure helps in solving complex problems more effectively.

- **Memory Utilization:** Data structures help in managing memory usage by allocating memory dynamically and optimizing the use of available memory.

- **Data Representation:** They provide ways to represent and model real-world data and relationships, such as hierarchical data with trees or network connections with graphs.

- **Algorithm Efficiency:** Many algorithms rely on specific data structures to work efficiently. For example, sorting algorithms often use arrays or linked lists.

- **Scalability:** Proper data structures support the scalability of applications by handling larger datasets and more complex queries.

- **Code Maintainability:** Well-chosen data structures lead to cleaner and more maintainable code, making it easier to understand and debug.

- **Application Development:** They are fundamental to developing various applications, from simple programs to complex systems like databases, operating systems, and real-time systems.


## Classification of Data Structures
We can classify Data Structures into two categories:
- Primitive Data Structure
- Non-Primitive Data Structure

![image](https://www.altexsoft.com/static/blog-post/2024/2/59771e86-6989-4a76-9695-1e572a24c2ed.png)

**Primitive Data Structures**
- Primitive Data Structures are the data structures consisting of the numbers and the characters that come in-built into programs.
- These data structures can be manipulated or operated directly by machine-level instructions.
- Basic data types like **Integer, Float, Character, and Boolean** come under the Primitive Data Structures.
- These data types are also called Simple data types, as they contain characters that can't be divided further

**Non-Primitive Data Structures**
- Non-Primitive Data Structures are those data structures derived from Primitive Data Structures.
- These data structures can't be manipulated or operated directly by machine-level instructions.
- The focus of these data structures is on forming a set of data elements that is either homogeneous (same data type) or heterogeneous (different data types).
- Based on the structure and arrangement of data, we can divide these data structures into two sub-categories.
  - **Linear Data Structures**
  - **Non-Linear Data Structures**

## Linear Data Structures
A data structure that preserves a linear connection among its data elements is known as a Linear Data Structure. 
The arrangement of the data is done linearly, where each element consists of the successors and predecessors except the first and the last data element. However, it is not necessarily true in the case of memory, as the arrangement may not be sequential.

Based on memory allocation, the Linear Data Structures are further classified into two types:

- **Static Data Structures:** The data structures having a fixed size are known as Static Data Structures. The memory for these data structures is allocated at the compiler time, and their size cannot be changed by the user after being compiled; however, the data stored in them can be altered.
  **The Array is the best example of the Static Data Structure as they have a fixed size, and its data can be modified later**.
- **Dynamic Data Structures:** The data structures having a dynamic size are known as Dynamic Data Structures. The memory of these data structures is allocated at the run time, and their size varies during the run time of the code. Moreover, the user can change the size as well as the data elements stored in these data structures at the run time of the code.
  **Linked Lists, Stacks, and Queues are common examples of dynamic data structures**.

### Types of Linear Data Structures:
- Arrays
- Linked Lists
- Stacks
- Queues

## Non-linear data structures
Non-linear data structures are data structures where the data elements are not arranged sequentially. Instead, the elements are arranged in a hierarchical or interconnected manner. This allows for more complex relationships between elements and is useful for modeling various real-world problems.

### Types of Non-Linear Data Structures:
**Trees:**
- Binary Tree
- Binary Search Tree (BST)
- AVL Tree
- Red-Black Tree
- B-Tree
- B+ Tree
- Trie (Prefix Tree)
- Segment Tree
- Fenwick Tree (Binary Indexed Tree)
**Graphs:**
- Undirected Graph
- Directed Graph (Digraph)
- Weighted Graph
- Unweighted Graph
- Cyclic Graph
- Acyclic Graph (including Directed Acyclic Graphs or DAGs)

## Basic Operations of Data Structures
- **Traversal:** Access each data element exactly once.
- **Search:** Find the location of data elements that meet certain criteria.
- **Insertion:** Add new data elements to the structure.
- **Deletion:** Remove a specific data element.
- **Sorting:** Arrange data elements in ascending or descending order.
- **Merge:** Combine elements from two sorted lists into one sorted list.
- **Create:** Reserve memory for data elements.
- **Selection:** Choose specific data based on conditions.
- **Update:** Modify existing data elements.
- **Splitting:** Divide data into smaller parts to improve efficiency.

## Correct Order to Study
- **Array [[code]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/array/Array.java) [[readme]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/array/README.md)** 
- **Linked List [[readme]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/README.md)**
    - **Singly Linked List [[code]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/singlyLinkedList/SinglyLinkedList.java) [[readme]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/singlyLinkedList/README.md)**
    - **Doubly Linked List [[code]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/doublyLinkedList/DoublyLinkedList.java) [[readme]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/doublyLinkedList/README.md)**
    - **Circular Linked List [[code]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/circularLinkedList/CircularLinkedList.java) [[readme]](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/linkedList/circularLinkedList/README.md)**
    - **Circular Doubly Linked List [[code]]() [[readme]]()**
- **Stack**
- **Queue**
- **Tree**

[More ....](https://www.javatpoint.com/data-structure-tutorial)