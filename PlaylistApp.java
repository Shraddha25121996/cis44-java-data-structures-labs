/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4playlist;
import java.util.Scanner;
/**
 *
 * @author shraddhapatel
 */
public class PlaylistApp {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    System.out.print("Enter title of song to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.playNext();
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

}
