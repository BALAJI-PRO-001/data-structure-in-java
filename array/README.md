---
### File To Execute: [Main.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/array/Main.java)
### File To Study: [Array.java](https://github.com/BALAJI-PRO-001/data-structure-in-java/blob/main/array/Array.java)
---
# Array in Data Structure 
Arrays are defined as the collection of similar types of data items stored at contiguous memory locations. It is one of the simplest data structures where each data element can be randomly accessed by using its index number.

## Properties of array
- Elements in the array are stored at contiguous memory locations from which the first element is stored at the smallest memory location.
- Elements of the array can be randomly accessed since we can calculate the address of each element of the array with the given base address and the size of the data element.

## Why are arrays required?
- Sorting and searching a value in an array is easier.
- Arrays are best to process multiple values quickly and easily.
- Arrays are good for storing multiple values in a single variable

## Basic operations
- **Traversal** - This operation is used to print the elements of the array.
- **Insertion** - It is used to add an element at a particular index.
- **Deletion** - It is used to delete an element from a particular index.
- **Search** - It is used to search an element using the given index or by the value.
- **Update** - It updates an element at a particular index.

## Time Complexity
| Operation | Average Case |  Worst Case |
| :---      |   :----:     |     ----:   |
| Access    |   O(1)       |    O(1)     |
| Search 	  |   O(n) 	     |    O(n)     |
| Search 	  |   O(n) 	     |    O(n)     |
| Insertion |  	O(n) 	     |    O(n)     |
| Deletion  | 	O(n)       |   	O(n)     |

## Space Complexity
In array, space complexity for worst case is **O(n)**.

## Advantages of Array
- Array provides the single name for the group of variables of the same type. Therefore, it is easy to remember the name of all the elements of an array.
- Traversing an array is a very simple process; we just need to increment the base address of the array in order to visit each element one by one.
- Any element in the array can be directly accessed by using the index.

## Disadvantages of Array
- Array is homogenous. It means that the elements with similar data type can be stored in it.
- In array, there is static memory allocation that is size of an array cannot be altered.
- There will be wastage of memory if we store less number of elements than the declared size.

[More ....](https://www.javatpoint.com/data-structure-array)