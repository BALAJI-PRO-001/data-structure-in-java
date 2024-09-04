package linkedList.singlyLinkedList;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
  public static void main(String[] args) {
    menu();
  }

  private static void menu() {
    while (true) {
      clearConsole();
      System.out.println("=============================================================");
      System.out.println("\t\t     Singly Linked List");
      System.out.println("============================================================="); 
      System.out.println("Insert First    \t\t\t\t    Press: 1");
      System.out.println("Insert Last    \t\t\t\t\t    Press: 2");
      System.out.println("Insert At Index    \t\t\t\t    Press: 3");
      System.out.println("Delete First    \t\t\t\t    Press: 4");
      System.out.println("Delete End    \t\t\t\t\t    Press: 5");
      System.out.println("Delete At Index    \t\t\t\t    Press: 6");
      System.out.println("Remove Element    \t\t\t\t    Press: 7");
      System.out.println("Find Index    \t\t\t\t\t    Press: 8");
      System.out.println("Replace Element    \t\t\t\t    Press: 9");
      System.out.println("Load Sample Elements    \t\t\t    Press: 10");
      System.out.println("Exit    \t\t\t\t\t    Press: 11");
      System.out.println("============================================================="); 
      list.print();
      list.indexView();
      System.out.println("\nSize: " + list.size() + "\t\tSize: " + list.getSize() + "  (Using Loop)");
      System.out.println("\n============================================================="); 

      System.out.print("Enter Choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1: {
          try {
            int element = getInput("\nEnter Element: ");
            list.insertFirst(element);
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        } 
        case 2: {
          try {
            int element = getInput("\nEnter Element: ");
            list.insertLast(element);
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 3: {
          try {
            int index = getInput("\nEnter Index: ");
            int element = getInput("Enter Element: ");
            list.insertAtIndex(index, element);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 4: {
          try {
            list.deleteFirst();
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 5: {
          try {
            // array.deleteLast();
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        } 
        case 6: {
          try {
            int position = getInput("\nEnter Index: ");
            // array.deleteAtPosition(position);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        } 
        case 7: {
          try {
            int element = getInput("\nEnter Element: ");
            // array.removeElement(element);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 8: {
          try {
            int element = getInput("\nEnter Element: ");
            // int index = array.indexOf(element);
            // System.out.print("\nIndex: " + index);
            System.out.print("\nPress any key to exit: ");
            scanner.next();
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 9: {
          try {
            int target = getInput("\nEnter Target Element: ");
            int newElement = getInput("Enter New Element: ");
            // array.replace(target, newElement);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 10: {
          // array.loadSampleElements();
          break;
        }
        case 11: {
          System.exit(0);
          break;
        }
      }
    }
  }

  private static int getInput(String message) {
    System.out.print(message);
    return scanner.nextInt();
  }

  // * The method is used to execute the cls or clear command, which clears the console screen in a Windows command prompt or Linux terminal.
  private static void clearConsole() {
    try {
      if (System.getProperty("os.name").startsWith("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch(IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
