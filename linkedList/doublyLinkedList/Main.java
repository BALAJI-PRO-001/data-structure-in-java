package linkedList.doublyLinkedList;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
  public static void main(String[] args) {
    menu();
  }

  private static void menu() {
    while (true) {
      clearConsole();
      System.out.println("=============================================================");
      System.out.println("\t\t     Doubly Linked List");
      System.out.println("============================================================="); 
      System.out.println("Insert First    \t\t\t\t    Press: 1");
      System.out.println("Insert Last    \t\t\t\t\t    Press: 2");
      System.out.println("Insert At Index    \t\t\t\t    Press: 3");
      System.out.println("Delete First    \t\t\t\t    Press: 4");
      System.out.println("Delete End    \t\t\t\t\t    Press: 5");
      System.out.println("Delete At Index    \t\t\t\t    Press: 6");
      System.out.println("Clear List    \t\t\t\t\t    Press: 7");
      System.out.println("Remove Element    \t\t\t\t    Press: 8");
      System.out.println("Find Index    \t\t\t\t\t    Press: 9");
      System.out.println("Replace Element    \t\t\t\t    Press: 10");
      System.out.println("Reverse The List    \t\t\t\t    Press: 11");
      System.out.println("Load Sample Elements    \t\t\t    Press: 12");
      System.out.println("Exit    \t\t\t\t\t    Press: 13");
      System.out.println("============================================================="); 
      list.print(false);
      list.print(true);
      System.out.println("\nSize: " + list.size() + "\t\tSize: " + list.getSize() + "  (Using Loop)");
      System.out.println("\n============================================================="); 

      System.out.print("Enter Choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1: {
          int element = getInput("\nEnter Element: ");
          list.insertFirst(element);
          break;
        } 
        case 2: {
          int element = getInput("\nEnter Element: ");
          list.insertLast(element);          
          break;
        }
        case 3: {
          try {
            int index = getInput("\nEnter Index: ");
            int element = getInput("Enter Element: ");
            list.insertAtIndex(index, element);
          } catch(IllegalArgumentException e) {
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
            list.deleteLast();
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        } 
        case 6: {
          try {
            int index = getInput("\nEnter Index: ");
            list.deleteAtIndex(index);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        } 
        case 7: {
          list.clear();
          break;
        }
        case 8: {
          try {
            int element = getInput("\nEnter Element: ");
            list.removeElement(element);
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 9: {
          try {
            int element = getInput("\nEnter Element: ");
            System.out.println("Index: " + list.indexOf(element));
            System.out.print("Press any key to exit: ");
            scanner.next();
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 10: {
          int target = getInput("\nEnter Target Element: ");
          int newElement = getInput("Enter New Element: ");
          list.replaceElement(target, newElement);
          break;
        }
        case 11: {
          list.reverse();
          break;
        }
        case 12: {
          Random random = new Random();
          for (int i = 1; i <= 5; i++) {
            list.insertLast(random.nextInt(1000 - 100 + 1) + 100);
          }
          break;
        }
        case 13: {
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
