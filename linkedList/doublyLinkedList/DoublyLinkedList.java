package linkedList.doublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable{
  private Node headNode, lastNode;
  private int size = 0;
  

  private class Node {
    T data;
    Node preNode;
    Node nextNode;

    public Node(T data) {
      this.data = data;
      this.preNode = null;
      this.nextNode = null;
      size++;
    }
  }


  public DoublyLinkedList() {
    headNode = null;
    lastNode = null;
  }

  
  public void insertFirst(T element) {\
    Node newNode = new Node(element);
    if (headNode == null) {
      headNode = newNode;
      lastNode = newNode;
    } else {
      headNode.preNode = newNode;
      newNode.nextNode = headNode;
      lastNode = newNode.nextNode;
      headNode = newNode;
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
    System.out.println("List Elements: [");
    Node tempNode = reverse ? lastNode : headNode;
    while (tempNode != null) {
      System.out.print(tempNode.data);
      tempNode = reverse ? tempNode.preNode : tempNode.nextNode;

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
