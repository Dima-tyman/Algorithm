package Home2;

import java.util.Random;

public class LinkedListMain {
    public static void main(String[] args) {
        TwinLinkedList<Integer> list1 = new TwinLinkedList<>();
        TwinLinkedList<Integer> list2 = new TwinLinkedList<>();
        TwinLinkedList<Integer> list3 = new TwinLinkedList<>();

        for (int i = 0; i < 20; i++) {
            list1.addFirst(new Random().nextInt(0, 100));
        }
        list2.addFirst(12);
        list2.addLast(42);
        list3.addFirst(34);

        printList(list1);

        list1.deleteLast();
        list1.deleteFirst();
        System.out.println(list1.contain(30));
        list1.reverse();

//        list1.sort();

        printList(list1);

        printList(list2);

//        list2.sort();

        printList(list2);

        printList(list3);

//        list3.sort();

        printList(list3);
    }

    public static <E> void printList(TwinLinkedList<E> list) {
        TwinLinkedList.Node<E> currentNote = list.getHead();
        if (currentNote == null) {
            System.out.println("NONONO");
            return;
        }
        while (currentNote != null) {
            System.out.print(currentNote.value + " ");
            currentNote = currentNote.next;
        }
        System.out.println(" - head = " + list.getHead().value + " last = " + list.getLast().value +
                " size = " + list.getSize());
        System.out.println();
    }
}
