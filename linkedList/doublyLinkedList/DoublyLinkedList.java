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
    checkIfListIsEmpty();
    validateIndex(index);

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
    T element = headNode.data;

    if (size == 1) {
      headNode = null;
      lastNode = null;
      size = 0;
      return element;
    }

    headNode = headNode.nextNode;
    headNode.prevNode = null;
    size--;
    return element;
  }


  public T deleteLast() {
    checkIfListIsEmpty();
    T element = lastNode.data;

    if (size == 1) {
      headNode = null;
      lastNode = null;
      size = 0;
      return element;
    }

    lastNode = lastNode.prevNode;
    lastNode.nextNode = null;
    size--;
    return element;
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
    T element = currentNode.data;
    currentNode.nextNode.prevNode = currentNode.prevNode;
    currentNode.prevNode.nextNode = currentNode.nextNode;
    size--;
    return element;
  }


  public void clear() {
    headNode = null;
    lastNode = null;
    size = 0;
  }


  public T removeElement(T element) {
    checkIfListIsEmpty();
    int index = indexOf(element);
    if (index == -1) return null;
    return deleteAtIndex(index);
  }


  public int indexOf(T element) {
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
    Node tempNode = reverse ? lastNode : headNode;
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
