package array;

public class Array {
  private int size = 0;
  private int[] array;

  public Array(int size) {
    this.size = size;
    array = new int[size];
  }

  public void insertBegin(int element) {

  }

  public void print() {
    System.out.print("\nArray Elements: ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + "");
    }
  }
}