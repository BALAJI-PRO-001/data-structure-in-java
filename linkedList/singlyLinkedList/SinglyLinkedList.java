package linkedList.singlyLinkedList;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
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
  

  public SinglyLinkedList() {
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
      tailNode = newNode;
    }
  }


  public void insertAtIndex(int index, T element) {
    checkIfElementIsNull(element);
    checkIfListIsEmpty();
    validateIndex(index);
    
    if (index == 0) {
      insertFirst(element);
      return;
    }

    int i = 0;
    Node prevNode = headNode;
    Node newNode = new Node(element);

    while (prevNode != null) {
      if (i == (index - 1)) {
        break;
      }
      prevNode = prevNode.nextNode;
      i++;
    }

    newNode.nextNode = prevNode.nextNode;
    prevNode.nextNode = newNode;
  }


  public T deleteFirst() {
    checkIfListIsEmpty();
    T removedElement = headNode.data;
    Node tempNode = headNode;
    headNode = tempNode.nextNode;
    size --;
    return removedElement;
  }


  public T deleteLast() {
    checkIfListIsEmpty();
    Node currentNode = headNode;
    T removedElement = tailNode.data;

    if (size == 1) {
      headNode = null;
      tailNode = null;
      size = 0;
      return removedElement;
    }

    while (currentNode != null && currentNode.nextNode.nextNode != null) {
      currentNode = currentNode.nextNode;
    }
    currentNode.nextNode = null;
    tailNode = currentNode;
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
    
    int i = 0;
    Node prevNode = headNode;
    while (prevNode != null) {
      if (i == (index - 1)) {
        break;
      }
      prevNode = prevNode.nextNode;
      i++;
    }
  
    T removedElement = prevNode.nextNode.data;
    prevNode.nextNode = prevNode.nextNode.nextNode;
    size--;
    return removedElement;
  }


  public void clear() {
    headNode = null;
    tailNode = null;
    size = 0;
  }


  public T removeElement(T element) {
    checkIfElementIsNull(element);
    checkIfListIsEmpty();
    T removedElement = null;

    if (headNode.data.equals(element)) {
      removedElement = headNode.data;
      headNode = headNode.nextNode;
      size--;
      return removedElement;
    }

    Node currentNode = headNode;
    while (currentNode != null && currentNode.nextNode != null) {
      if (currentNode.nextNode.data.equals(element)) {
        removedElement = currentNode.nextNode.data;
        tailNode = currentNode.nextNode == tailNode ? currentNode : tailNode;
        currentNode.nextNode = currentNode.nextNode.nextNode;
        size--;
        return removedElement;
      }
      currentNode = currentNode.nextNode;
    }

    return null;
  }


  public int indexOf(T element) {
    checkIfElementIsNull(element);
    checkIfListIsEmpty();
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
    checkIfElementIsNull(target);
    checkIfElementIsNull(newElement);
    checkIfListIsEmpty();
    Node tempNode = headNode;
    while (tempNode != null) {
      if (tempNode.data.equals(target)) {
        tempNode.data = newElement;
        return;
      }
      tempNode = tempNode.nextNode;
    }
  }


  public void reverse() {
    checkIfListIsEmpty();
    Node currentNode = headNode;
    Node prevNode = null;
    Node nextNode = null;
    while (currentNode != null) {
      nextNode = currentNode.nextNode;
      currentNode.nextNode = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }
    headNode = prevNode;
  }


  public int size() {
    return this.size;
  }


  public int getSize() {
    int size = 0;
    Node tempNode = headNode;
    while (tempNode != null) {
      size++;
      tempNode = tempNode.nextNode;
    }
    return size;
  }


  public void print() {
    System.out.print("\nList Elements: [ ");
    Node tempNode = headNode;
    while (tempNode != null) {
      System.out.print(tempNode.data);
      tempNode = tempNode.nextNode;

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
