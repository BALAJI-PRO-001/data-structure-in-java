package array;
import java.util.Random;

public class Array {
  private int size = 0;
  private int[] array;
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


  private void checkIfValidPosition(int position) {
    if (position < 0 || position > size) {
      throw new IllegalArgumentException("Invalid position. Position must be between 0 and " + size + ".");
    }  
  }



  public void loadSampleElements() {
    Random random = new Random();
    for (int i = size; i < initialCapacity; i++) {
      array[i] = random.nextInt(1000 - 100 + 1) + 100;
      size++;
    }
  }



  public void insertBegin(int element) {
    checkIfArrayIsFull();
    if (size == 0) {
      array[0] = element;
      size++;
    } else {
      for (int i = initialCapacity - 1; i > 0; i--) {
        array[i] = array[i - 1];
      }
      array[0] = element;
      size++;
    }
  }



  public void insertLast(int element) {
    checkIfArrayIsFull();
    array[size] = element;
    size++;
  }



  public void insertAtPosition(int position, int element) {
    checkIfArrayIsEmpty();
    checkIfArrayIsFull();
    checkIfValidPosition(position);
    
    if (position == 0) {
      insertBegin(element);
      return;
    }

    if (position == size) {
      insertLast(element);
      return;
    }

    for (int i = initialCapacity - 1; i > position; i--) {
      array[i] = array[i - 1];
    }
    array[position] = element;
    size++;
  }



  public int deleteBegin() {
    checkIfArrayIsEmpty();
    int element = array[0];
    for (int i = 0; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    size --;
    return element;
  }


  
  public int deleteLast() {
    checkIfArrayIsEmpty();
    int element = size - 1;
    size--;
    return element;
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