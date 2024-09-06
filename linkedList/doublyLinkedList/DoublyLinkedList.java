package linkedList.doublyLinkedList;

public class DoublyLinkedList<T> {
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
      newNode.nextNode = headNode;
      lastNode = newNode.nextNode;
      headNode = newNode;
    }
  }

  
}
