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


  public void insertFirst(T element) {
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

  }


  public void insertAtIndex(int index, T element) {

  }


  public int size() {
    return this.size;
  }

  
  public int getSize() {
    Node tempNode = headNode;
    int size = 0;
    while (tempNode != headNode) {
      size++;
      tempNode = tempNode.nextNode;
    }
    return size;
  }


  public void print() {
    System.out.print("\nList Elements: [ ");
    Node tempNode = headNode;
    while (tempNode.nextNode == headNode) {
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
        return tempNode.nextNode != headNode;
      }

      public T next() {
        T element = tempNode.data;
        tempNode = tempNode.nextNode;
        return element;
      }
    };
  }
}
