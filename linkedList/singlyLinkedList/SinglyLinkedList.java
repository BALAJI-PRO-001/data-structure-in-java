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


  public void insertFirst(T element) {
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
    T element = headNode.data;
    Node tempNode = headNode;
    headNode = tempNode.nextNode;
    size --;
    return element;
  }


  public T deleteLast() {
    checkIfListIsEmpty();
    Node prevNode = headNode;
    T element = tailNode.data;

    if (size == 1) {
      headNode = null;
      tailNode = null;
      size = 0;
      return element;
    }

    int i = 0;
    while (prevNode != null) {
      if (i == (size - 2)) {
        break;
      }
      prevNode = prevNode.nextNode;
      i++;
    }
    prevNode.nextNode = null;
    tailNode = prevNode;
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
    Node prevNode = headNode;
    while (prevNode != null) {
      if (i == (index - 1)) {
        break;
      }
      prevNode = prevNode.nextNode;
      i++;
    }
  
    T element = prevNode.nextNode.data;
    prevNode.nextNode = prevNode.nextNode.nextNode;
    size--;
    return element;
  }


  public void clear() {
    headNode = null;
    tailNode = null;
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
