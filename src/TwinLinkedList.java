import java.util.Arrays;
import java.util.Comparator;


public class TwinLinkedList<E> {

    private int size;
    private Node<E> head;
    private Node<E> last;


    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
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
        last = last.previous;
        size--;
    }

    public Node<E> find(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contain(E value) {
        return find(value) != null;
    }

    public void reverse() {
        if (head == null || head == last) return;

        head.previous = head.next;
        head.next = null;
        Node<E> currentNode = head.previous;
        Node<E> nextNode = currentNode.next;
        while (nextNode != null) {
            currentNode.next = currentNode.previous;
            currentNode.previous = nextNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        last.next = last.previous;
        last = head;
        head = currentNode;
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

        head = (Node<E>) arr[0];
        head.next = (Node<E>) arr[1];
        last = (Node<E>) arr[-1];
        last.previous = (Node<E>) arr[-2];

        currentNode = head.next;
        for (int i = 1; i < size - 1; i++) {
            currentNode.previous = (Node<E>) arr[i - 1];
            currentNode = (Node<E>) arr[i];
            currentNode.next = (Node<E>) arr[i + 1];
            currentNode = currentNode.next;
        }
    }


    public int getSize() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getLast() {
        return last;
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