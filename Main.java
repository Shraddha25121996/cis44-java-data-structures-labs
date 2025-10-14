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
        Playlist playlist = new Playlist();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Play Next");
            System.out.println("4. Remove Song");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = input.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = input.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    playlist.displayPlaylist();
                    break;
                case 3:
                    playlist.playNext();
                    break;
                case 4:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = input.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

}
