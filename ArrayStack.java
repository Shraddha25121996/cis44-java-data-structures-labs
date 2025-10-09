/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class ArrayStack<E> {
    private Object[] data;
    private int top; // index of the top element, -1 when empty

    // Constructors
    public ArrayStack(int capacity) {
        data = new Object[Math.max(1, capacity)];
        top = -1;
    }

    public ArrayStack() {
        this(10);
    }

    // Push: add an element on top
    public void push(E item) {
        if (top + 1 == data.length) resize(data.length * 2);
        data[++top] = item;
    }

    // Pop: remove and return top element
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        E item = (E) data[top];
        data[top--] = null; // avoid memory leak
        return item;
    }

    // Peek: view top element without removing
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return (E) data[top];
    }

    // Size and empty checks
    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Internal resize
    private void resize(int newCapacity) {
        Object[] tmp = new Object[newCapacity];
        System.arraycopy(data, 0, tmp, 0, top + 1);
        data = tmp;
    }

    // Simple display (top -> bottom)
    public void display() {
        System.out.print("Stack (top->bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Quick test main
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();                    // Stack (top->bottom): 30 20 10
        System.out.println(s.peek());   // 30
        System.out.println(s.pop());    // 30
        s.display();                    // Stack (top->bottom): 20 10
        System.out.println("Size: " + s.size()); // Size: 2
    }
}