package array;

import java.util.concurrent.ExecutionException;

public class Array {
  private int size = 0;
  private int[] array;
  private int currentIndex = 0;
  private int initialCapacity = 0;
  


  public Array(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("InitialCapacity must be greater than zero.");    
    }
    this.initialCapacity = initialCapacity;
    array = new int[initialCapacity];
  }



  private void checkIfArrayIsFull() {
    if (size == initialCapacity) {
      throw new IllegalStateException("Array is full. No more elements can be added.");
    }
  }



  private void checkIfArrayIsEmpty() {
    if (size == 0) {
      throw new IllegalStateException("Array is empty. Please add elements to the array.");
    }
  }



  public void loadSampleElements() {
    for (int i = 0; i < initialCapacity; i++) {
      System.out.println("HI");
      try {
        Thread.sleep(1000);
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }



  public void insertBegin(int element) {
    checkIfArrayIsFull();
    if (size == 0) {
      array[currentIndex++] = element;
      size++;
    } else {
      for (int i = initialCapacity - 1; i > 0; i--) {
        array[i] = array[i - 1];
      }
      array[0] = element;
      currentIndex++;
      size++;
    }
  }



  public void insertLast(int element) {
    checkIfArrayIsFull();
    array[currentIndex++] = element;
    size++;
  }



  public void insertAtPosition(int position, int element) {
    checkIfArrayIsEmpty();
    checkIfArrayIsFull();
    if (position < 0 || position > size) {
      throw new IllegalArgumentException("Position must be between 0 and " + size + ".");
    }   
    
    if (position == 0) {
      insertBegin(element);
      return;
    }

    if (position == size) {
      insertLast(element);
      return;
    }

    for (int i = size - 1; i >= position; i--) {
      array[i] = array[i - 1];
    }
    array[position] = element;
    currentIndex++;
    size++;
  }



  public int size() {
    return this.size;
  }


  
  public void print() {
    System.out.print("\nArray Elements: [ ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.print("]\n");
  }



  public void indexView() {
    if (size > 0) {
      System.out.println();
      for (int i = 0; i < size; i++) {
        System.out.println("Index: " + i + " Element: " + array[i]);
      }
    }
  }
}