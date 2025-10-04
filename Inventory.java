/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author shraddhapatel
 */
public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory items:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) && !found1) {
                found1 = true;
                iter.remove();
            } else if (current.getName().equals(name2) && !found2) {
                found2 = true;
                iter.remove();
            }
        }

        if (found1 && found2) {
            Item combined = new Item(name1 + "-" + name2);
            items.add(combined);
            System.out.println("Combined " + name1 + " and " + name2 + " into " + combined + "!");
        } else {
            System.out.println("Could not combine items: one or both items not found.");
        }
    }
}

