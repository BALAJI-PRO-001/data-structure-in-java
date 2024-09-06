package linkedList.doublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
  private Node headNode, lastNode;
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
    lastNode = null;
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
  
  
  public void insertFirst(T element) {
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      lastNode = newNode;
    } else {
      headNode.prevNode = newNode;
      newNode.nextNode = headNode;
      lastNode = headNode;
      headNode = newNode;
    }
  }


  public void insertLast(T element) {
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      lastNode = newNode;
    } else {
      lastNode.nextNode = newNode;
      newNode.prevNode = lastNode;
      lastNode = newNode;
    }
  }


  public void insertAtIndex(int index, T element) {
    
  }



  public T deleteFirst() {
    checkIfListIsEmpty();
    T element = headNode.data;
    headNode = headNode.nextNode;
    headNode.prevNode = null;
    return element;
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
    System.out.print("\nList Elements: [ ");
    Node tempNode = reverse ? lastNode : headNode;
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
