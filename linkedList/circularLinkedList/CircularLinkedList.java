package linkedList.circularLinkedList;
import java.util.Iterator;

public class CircularLinkedList<T> implements Iterable<T> {
  private Node headNode, tailNode;
  private int size = 0;

  private class Node {
    T data;
    Node nextNode;

    public Node(T data) {
      this.data = data;
      this.nextNode = null;
      size++;
    }
  }

  public CircularLinkedList() {
    this.headNode = null;
    this.tailNode = null;
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
      tailNode.nextNode = headNode;
    } else {
      newNode.nextNode = headNode;
      headNode = newNode;
      tailNode.nextNode = headNode;
    }
  }


  public void insertLast(T element) {
    checkIfElementIsNull(element);
    
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      tailNode = newNode;
      tailNode.nextNode = newNode;
    } else {
      tailNode.nextNode = newNode;
      tailNode = newNode;
      tailNode.nextNode = headNode;
    }
  }


  public void insertAtIndex(int index, T element) {
    validateIndex(index);
    checkIfElementIsNull(element);

    if (index == 0) {
      insertFirst(element);
      return;
    }

    Node newNode = new Node(element);
    Node prevNode = headNode;
    int i = 0;

    do {
      if (i == (index - 1)) {
        break;
      }
      prevNode = prevNode.nextNode;
      i++;
    } while (prevNode != headNode);

    newNode.nextNode = prevNode.nextNode;
    prevNode.nextNode = newNode;
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
    tailNode.nextNode = headNode;
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

    Node prevNode = headNode;
    while (prevNode.nextNode.nextNode != headNode) {
      prevNode = prevNode.nextNode;
    }
    prevNode.nextNode = headNode;  
    tailNode = prevNode;
    tailNode.nextNode = headNode;
    size--;  
    return removedElement;
  }


  public int size() {
    return this.size;
  }

  
  public int getSize() {
    if (headNode == null) {
      return 0;
    }

    Node tempNode = headNode;
    int size = 0;
    do {
      size++;
      tempNode = tempNode.nextNode;
    } while (tempNode != headNode);
    return size;
  }


  public void print() {
    if (headNode == null) {
      System.out.println("\nList Elements: [ ]");
      return;
    }
    System.out.print("\nList Elements: [ ");
    Node tempNode = headNode;
    do {
      System.out.print(tempNode.data);
      tempNode = tempNode.nextNode;

      if (tempNode != headNode) {
        System.out.print(", ");
      }
    } while (tempNode != headNode);
    System.out.println(" ]");
  }


  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node tempNode = headNode;
      boolean firstIteration = true;

      public boolean hasNext() {
        return firstIteration || tempNode != headNode;
      }

      public T next() {
        T element = tempNode.data;
        tempNode = tempNode.nextNode;
        firstIteration = false;
        return element;
      }
    };
  }
}
