/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author shraddhapatel
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int choice;
        String text;

        do {
            System.out.println("\n--- Simple Text Editor ---");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    text = input.nextLine();
                    editor.add(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.printCurrent();
                    break;
                case 5:
                    System.out.println("Exiting editor...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        input.close();
    }

}
