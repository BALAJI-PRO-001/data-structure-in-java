package array;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  private static int initialCapacity = 5;
  private static Scanner scanner = new Scanner(System.in);
  private static Array array = new Array(initialCapacity);
  public static void main(String[] args) {
    menu();
  }

  private static void menu() {
    while (true) {
      clearConsole();
      System.out.println("=============================================================");
      System.out.println("\t\t\t   Array");
      System.out.println("============================================================="); 
      System.out.println("Insert Begin    \t\t\t\t    Press: 1");
      System.out.println("Insert Last    \t\t\t\t\t    Press: 2");
      System.out.println("Insert At Position    \t\t\t\t    Press: 3");
      System.out.println("Delete Begin    \t\t\t\t    Press: 4");
      System.out.println("Delete End    \t\t\t\t\t    Press: 5");
      System.out.println("Delete At Position    \t\t\t\t    Press: 6");
      System.out.println("Remove Element    \t\t\t\t    Press: 7");
      System.out.println("Find Index    \t\t\t\t\t    Press: 8");
      System.out.println("Replace Element    \t\t\t\t    Press: 9");
      System.out.println("Exit    \t\t\t\t\t    Press: 10");
      System.out.println("============================================================="); 
      array.print();
      array.indexView();
      System.out.println("\nSize: " + array.size() + "\t  Capacity: " + initialCapacity);
      System.out.println("\n============================================================="); 

      System.out.print("Enter Choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1: {
          try {
            int element = getInput("\nEnter Element: ");
            array.insertBegin(element);
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
            array.insertLast(element);
          } catch(IllegalStateException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 3: {
          try {
            int position = getInput("\nEnter Position: ");
            int element = getInput("Enter Element: ");
            array.insertAtPosition(position, element);
          } catch(IllegalStateException | IllegalArgumentException e) {
            System.out.println("\nMessage: " + e.getMessage());
            System.out.print("Press any key to exit: ");
            scanner.next();
          }
          break;
        }
        case 10: {
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
