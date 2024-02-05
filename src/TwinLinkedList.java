import java.util.Arrays;
import java.util.Comparator;

public class TwinLinkedList<E> {

    private int size;
    private Node<E> head;
    private Node<E> last;


    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (head != null) {
            newNode.next = head;
            head.previous = newNode;
        }
        head = newNode;
        last = newNode;
        size++;
    }

    public void deleteFirst() {
        if (head == null) return;
        if (head.next != null) {
            head.next.previous = null;
        }
        head = head.next;
        size--;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
        size++;
    }

    public void deleteLast() {
        if (last == null) return;
        if (last.previous == null) {
            head = null;
            last = null;
            return;
        }
        last.previous.next = null;
        last = null;
        size--;
    }

    public Node<E> find(E value) {
        if (head == null) return null;
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contain(E value) {
        return find(value) != null;
    }

    public void sort(Comparator<? super E> c) {
        if (size < 2) return;
        Object[] arr = new Object[size];
        Node<E> currentNode = head;
        for (Object o : arr) {
            o = currentNode;
            currentNode = currentNode.next;
        }
        Arrays.sort(arr, (Comparator<Object>) c);

        head = (Node) arr[0];
        head.next = (Node) arr[1];
        last = (Node) arr[-1];
        last.previous = (Node) arr[-2];

        currentNode = head.next;
        for (int i = 1; i < size - 1; i++) {
            currentNode.previous = (Node) arr[i - 1];
            currentNode = (Node) arr[i];
            currentNode.next = (Node) arr[i + 1];
            currentNode = currentNode.next;
        }
    }

    static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> previous;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }
}