/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;

/**
 *
 * @author shraddhapatel
 */
public class Ecosystem {
public static void main(String[] args){
        }
}
// Step 1: Abstract Animal class
abstract class Animal {
    public abstract String toString();
}

// Step 2: Concrete classes
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

// Step 3: Ecosystem class
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        // Populate river randomly with Bears, Fish, or null
        for (int i = 0; i < riverSize; i++) {
            int choice = random.nextInt(3); // 0: empty, 1: Fish, 2: Bear
            if (choice == 1) river[i] = new Fish();
            else if (choice == 2) river[i] = new Bear();
        }
    }

    public void runStep() {
        Animal[] nextRiver = new Animal[river.length];

        for (int i = 0; i < river.length; i++) {
            Animal current = river[i];
            if (current == null) continue;

            // Determine new position: stay, left, or right
            int move = random.nextInt(3); // 0: stay, 1: left, 2: right
            int newPos = i;
            if (move == 1 && i > 0) newPos = i - 1;
            if (move == 2 && i < river.length - 1) newPos = i + 1;

            // Handle collisions
            if (nextRiver[newPos] == null) {
                nextRiver[newPos] = current;
            } else if (nextRiver[newPos].getClass() == current.getClass()) {
                // Same type: reproduce in random empty spot
                placeRandom(current.getClass());
            } else {
                // Bear meets Fish: fish disappears
                if (current instanceof Bear) nextRiver[newPos] = current;
                // If Fish meets Bear, nothing happens (fish eaten)
            }
        }

        river = nextRiver; // Update river
    }

    private void placeRandom(Class<? extends Animal> cls) {
        int attempts = 0;
        while (attempts < river.length) {
            int pos = random.nextInt(river.length);
            if (river[pos] == null) {
                try {
                    river[pos] = cls.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            attempts++;
        }
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        Ecosystem eco = new Ecosystem(20); // River of size 20

        for (int step = 1; step <= 10; step++) { // Run 10 steps
            System.out.println("Step " + step + ":");
            eco.visualize();
            eco.runStep();
            Thread.sleep(500); // Pause for half a second
        }
    }
 
}
