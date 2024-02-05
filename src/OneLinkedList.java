public class OneLinkedList<E> {

    private int size;
    private Node<E> head;


    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
        size--;
    }

    public void addLast(E value) {
        if (head == null) {
            head = new Node<>(value);
            size++;
            return;
        }
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(value);
        size++;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node<E> currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
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

    static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
