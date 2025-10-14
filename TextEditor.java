/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class TextEditor {
    // Inner Node class for the Doubly Linked List
    private class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node head;      // Start of the list (first state)
    private Node current;   // Current text state

    // Add new text to the editor
    public void add(String newText) {
        Node newNode = new Node(newText);

        // If this is the first text entry
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            // Clear redo history (delete everything after current)
            current.next = null;

            // Link new node after current
            newNode.prev = current;
            current.next = newNode;

            // Move current pointer to the new node
            current = newNode;
        }

        System.out.println("Added new text: \"" + newText + "\"");
    }

    // Undo the last operation
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    // Redo the undone operation
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("Nothing to redo!");
        }
    }

    // Print current text
    public void printCurrent() {
        if (current != null) {
            System.out.println("Current text: " + current.text);
        } else {
            System.out.println("No text in editor.");
        }
    }

}
