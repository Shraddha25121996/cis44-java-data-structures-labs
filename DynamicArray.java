/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class DynamicArray<T> {
// Generic DynamicArray class

    
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    // Constructor
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY]; // Create generic array
        size = 0;
    }

    // Add element at the end
    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;
    }

    // Get element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    // Remove element at a specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // Optional: clear last element
        size--;
        return removedElement;
    }

    // Return current size
    public int size() {
        return size;
    }

    // Private resize method
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
}
