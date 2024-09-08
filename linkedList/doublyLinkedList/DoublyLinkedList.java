package linkedList.doublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
  private Node headNode, tailNode;
  private int size = 0;
  

  private class Node {
    T data;
    Node prevNode;
    Node nextNode;

    public Node(T data) {
      this.data = data;
      this.prevNode = null;
      this.nextNode = null;
      size++;
    }
  }


  public DoublyLinkedList() {
    headNode = null;
    tailNode = null;
  }


  private void validateIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index. Index must be between 0 and " + (size - 1) + ".");
    }
  }


  private void checkIfListIsEmpty() {
    if (size == 0) {
      throw new IllegalStateException("List is empty. Please add elements to the list.");
    }
  }


  private void checkIfElementIsNull(T element) {
    if (element == null) {
      throw new IllegalArgumentException("Element cannot be null.");
    }
  }
  
  
  public void insertFirst(T element) {
    checkIfElementIsNull(element);

    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      tailNode = newNode;
    } else {
      headNode.prevNode = newNode;
      newNode.nextNode = headNode;
      headNode = newNode;
    }
  }


  public void insertLast(T element) {
    checkIfElementIsNull(element);

    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      tailNode = newNode;
    } else {
      tailNode.nextNode = newNode;
      newNode.prevNode = tailNode;
      tailNode = newNode;
    }
  }


  public void insertAtIndex(int index, T element) {
    checkIfListIsEmpty();
    validateIndex(index);
    checkIfElementIsNull(element);

    if (index == 0) {
      insertFirst(element);
      return;
    }

    Node newNode = new Node(element);
    Node prevNode = headNode;
    int i = 0;

    while (prevNode != null) {
      if (i == (index - 1)) {
        break;
      }      
      prevNode = prevNode.nextNode;
      i++;
    }

    newNode.nextNode = prevNode.nextNode;
    prevNode.nextNode.prevNode = newNode;
    prevNode.nextNode = newNode;
    newNode.prevNode = prevNode;
  }



  public T deleteFirst() {
    checkIfListIsEmpty();

    T removedElement = headNode.data;

    if (size == 1) {
      headNode = null;
      tailNode = null;
      size = 0;
      return removedElement;
    }

    headNode = headNode.nextNode;
    headNode.prevNode = null;
    size--;
    return removedElement;
  }


  public T deleteLast() {
    checkIfListIsEmpty();

    T removedElement = tailNode.data;

    if (size == 1) {
      headNode = null;
      tailNode = null;
      size = 0;
      return removedElement;
    }

    tailNode = tailNode.prevNode;
    tailNode.nextNode = null;
    size--;
    return removedElement;
  }


  public T deleteAtIndex(int index) {
    checkIfListIsEmpty();
    validateIndex(index);

    if (index == 0) {
      return deleteFirst();
    }

    if (index == (size - 1)) {
      return deleteLast();
    }

    Node currentNode = headNode;
    int i = 0;
    while (currentNode != null) {
      if (i == index) {
        break;
      }
      currentNode = currentNode.nextNode;
      i++;
    }
    T removedElement = currentNode.data;
    currentNode.nextNode.prevNode = currentNode.prevNode;
    currentNode.prevNode.nextNode = currentNode.nextNode;
    size--;
    return removedElement;
  }


  public void clear() {
    headNode = null;
    tailNode = null;
    size = 0;
  }


  public T removeElement(T element) {
    checkIfListIsEmpty();
    checkIfElementIsNull(element);

    T removedElement = null;

    if (size == 1 && headNode.data.equals(element)) {
      removedElement = headNode.data;
      headNode = null;
      tailNode = null;
      size = 0;
      return removedElement;
    }

    if (headNode.data.equals(element)) {
      removedElement = headNode.data;
      headNode = headNode.nextNode;
      headNode.prevNode = null;
      size --;
      return removedElement;
    }

    Node currentNode = headNode;
    while (currentNode != null && currentNode.nextNode != null) {
      if (currentNode.nextNode.data.equals(element)) {
        removedElement = currentNode.nextNode.data;

        if (currentNode.nextNode == tailNode) {
          tailNode = currentNode;
          currentNode.nextNode = null;
        } else {
          currentNode.nextNode = currentNode.nextNode.nextNode;
          currentNode.nextNode.prevNode = currentNode;
        }
        
        size--;
        return removedElement;
      }
      currentNode = currentNode.nextNode;
    }

    return null;
  }


  public int indexOf(T element) {
    checkIfListIsEmpty();
    checkIfElementIsNull(element);

    Node tempNode = headNode;
    int index = 0;
    while (tempNode != null) {
      if (tempNode.data.equals(element)) {
        return index;
      }
      tempNode = tempNode.nextNode;
      index++;
    }
    return -1;
  }


  public void replaceElement(T target, T newElement) {
    checkIfListIsEmpty();
    checkIfElementIsNull(target);
    checkIfElementIsNull(newElement);
    
    Node tempNode = headNode;
    while (tempNode != null) {
      if (tempNode.data.equals(target)) {
        tempNode.data = newElement;
        return;
      }
      tempNode = tempNode.nextNode;
    }
  }


  public int size() {
    return this.size;
  }


  public int getSize() {
    Node tempNode = headNode;
    int size = 0;
    while (tempNode != null) {
      size++;
      tempNode = tempNode.nextNode;
    }
    return size;
  }


  public void print(boolean reverse) {
    Node tempNode = reverse ? tailNode : headNode;
    String order = reverse ? "Backward" : "Forward";
    System.out.print("\nList Elements (" + order + "): [ ");
    while (tempNode != null) {
      System.out.print(tempNode.data);
      tempNode = reverse ? tempNode.prevNode : tempNode.nextNode;

      if (tempNode != null) {
        System.out.print(", ");
      }
    }
    System.out.println(" ]");
  }


  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node tempNode = headNode;

      public boolean hasNext() {
        return tempNode != null;
      }

      public T next() {
        T data = tempNode.data;
        tempNode = tempNode.nextNode;
        return data;
      }
    };
  }  
}
