/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelitinerary;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author shraddhapatel
 */
public class LinkedPositionalList<E> implements Iterable<E> {

    // ----- Nested Node class (implements Position) -----
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e; prev = p; next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    }

    // ----- Fields -----
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // ----- Constructor -----
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    // ----- Utility helpers -----
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;
        return node; // Node implements Position<E>
    }

    @SuppressWarnings("unchecked")
    private Node<E> validate(Position<E> p) {
        if (p == null) throw new IllegalArgumentException("Position is null");
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) // convention for defunct node
            throw new IllegalStateException("Position is no longer in the list");
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    // ----- Accessors -----
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Position<E> first() { return position(header.getNext()); }
    public Position<E> last()  { return position(trailer.getPrev()); }

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // ----- Mutators -----
    public Position<E> addFirst(E e) { return addBetween(e, header, header.getNext()); }
    public Position<E> addLast(E e)  { return addBetween(e, trailer.getPrev(), trailer); }

    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> pred = node.getPrev();
        Node<E> succ = node.getNext();
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    // ----- Custom Iterator -----
    private class ElementIterator implements Iterator<E> {
        private Position<E> cursor = first();  // position of next element to report

        public boolean hasNext() {
            return cursor != null;
        }

        public E next() {
            if (cursor == null) throw new NoSuchElementException();
            E result = cursor.getElement();
            cursor = after(cursor); // advance to next position
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    // Optional - helpful for debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : this) {
            sb.append(e).append(" <- ");
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 4);
        return sb.toString();
    }
}