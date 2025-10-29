import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Convert the LinkedList to an ArrayList
    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            arrayList.add(current.data);
            current = current.next;
        }
        return arrayList;
    }

    // Add an element at the end
    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator();
    }

    // LLIterator with additional functionality
    private class LLIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }

        // Add additional iterator methods (e.g., `addBefore` and `addAfter`) as needed
    }
}
