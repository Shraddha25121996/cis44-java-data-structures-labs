/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;

import java.util.Random;

abstract class Animal {
    public abstract String toString();
}

class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populateRiver(); // Initially populate the river
    }

    private void populateRiver() {
        for (int i = 0; i < river.length; i++) {
            int rand = random.nextInt(3); // 0 = empty, 1 = Fish, 2 = Bear
            if (rand == 1) river[i] = new Fish();
            else if (rand == 2) river[i] = new Bear();
            else river[i] = null;
        }
    }

    public void runStep() {
        Animal[] newRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal current = river[i];
            if (current == null) continue;

            int move = random.nextInt(3); // -1 = left, 0 = stay, 1 = right
            int newPos = i + (move - 1);

            if (newPos < 0) newPos = 0;
            if (newPos >= river.length) newPos = river.length - 1;

            Animal target = newRiver[newPos];

            if (target == null) {
                newRiver[newPos] = current; // Move to empty spot
            } else if (current.getClass() == target.getClass()) {
                // Same species: keep both in place and add a new one in random empty spot
                newRiver[newPos] = target; 
                int emptyIndex = findEmptySpot(newRiver);
                if (emptyIndex != -1) {
                    if (current instanceof Bear) newRiver[emptyIndex] = new Bear();
                    else newRiver[emptyIndex] = new Fish();
                }
            } else {
                // Bear eats fish
                if (current instanceof Bear) newRiver[newPos] = current;
                else newRiver[newPos] = target;
            }
        }

        river = newRiver;
    }

    private int findEmptySpot(Animal[] arr) {
        int[] emptyIndices = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) emptyIndices[count++] = i;
        }
        if (count == 0) return -1;
        return emptyIndices[random.nextInt(count)];
    }

    public void visualize() {
        for (Animal a : river) {
            System.out.print(a == null ? "-" : a.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        Ecosystem eco = new Ecosystem(20); // river size
        System.out.print("Initial River: ");
        eco.visualize();

        for (int step = 1; step <= 10; step++) { // run 10 steps
            eco.runStep();
            System.out.print("Step " + step + ": ");
            eco.visualize();
            Thread.sleep(500); // pause for readability
        }
    }
}
