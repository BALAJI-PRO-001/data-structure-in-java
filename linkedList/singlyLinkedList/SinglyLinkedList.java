package linkedList.singlyLinkedList;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
  private Node headNode;
  private Node lastNode;
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

    int i = 0;
    Node preNode = headNode;
    Node newNode = new Node(element);

    while (true) {
      if (i == (index - 1)) {
        break;
      }
      preNode = preNode.nextNode;
      i++;
    }

    newNode.nextNode = preNode.nextNode;
    preNode.nextNode = newNode;
  }


  public T deleteFirst() {
    checkIfListIsEmpty();
    T element = headNode.data;
    Node tempNode = headNode;
    headNode = tempNode.nextNode;
    size --;
    return element;
  }


  public T deleteLast() {
    checkIfListIsEmpty();
    Node preNode = headNode;

    if (size == 1) {
      T element = headNode.data;
      headNode = null;
      lastNode = null;
      return element;
    }

    int i = 0;
    while (true) {
      if (i == (size - 2)) {
        break;
      }
      preNode = preNode.nextNode;
      i++;
    }
    T element = lastNode.data;
    preNode.nextNode = null;
    lastNode = preNode;
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

    int i = 0;
    Node preNode = headNode;
    while (true) {
      if (i == (index - 1)) {
        break;
      }
      preNode = preNode.nextNode;
      i++;
    }
  
    T element = preNode.nextNode.data;
    preNode.nextNode = preNode.nextNode.nextNode;
    size--;
    return element;
  }


  public void clear() {
    headNode = null;
    lastNode = null;
    size = 0;
  }


  public T removeElement(T element) {
    int index = indexOf(element);
    if (index == -1) return null;
    return deleteAtIndex(index);
  }


  public int indexOf(T element) {
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
    Node currentNode = headNode;
    Node preNode = null;
    Node nextNode = null;
    while (currentNode != null) {
      nextNode = currentNode.nextNode;
      currentNode.nextNode = preNode;
      preNode = currentNode;
      currentNode = nextNode;
    }
    headNode = preNode;
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
