public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    // sentinel.next is always the first Node
    // sentinel.prev is always the last Node
    private Node sentinel;
    private int size;

    /** Create an empty Deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        Node prevFirst = sentinel.next;
        sentinel.next = new Node(item, sentinel, prevFirst);
        prevFirst.prev = sentinel.next;
        size += 1;
    }

    @Override
    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        Node prevLast = sentinel.prev;
        sentinel.prev = new Node(item, prevLast, sentinel);
        prevLast.next = sentinel.prev;
        size += 1;
    }

    @Override
    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    @Override
    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node p = sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    /* Removes and returns the item at the front of the deque.
    /* If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T firstItem = sentinel.next.item;
        Node newFirst = sentinel.next.next;
        newFirst.prev = sentinel;
        sentinel.next = newFirst;
        size -= 1;
        return firstItem;
    }

    @Override
    /** Removes and returns the item at the back of the deque.
      * If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T lastItem = sentinel.prev.item;
        Node newLast = sentinel.prev.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        size -= 1;
        return lastItem;
    }

    @Override
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and forth.
      * If no such item exists, returns null. Must not alter the deque. */
    public T get(int index) {
        Node p = sentinel.next;

        while (index != 0 && p != sentinel) {
            index -= 1;
            p = p.next;
        }

        if (p == sentinel) {
            return null;
        } else {
            return p.item;
        }
    }

    /** Same as get, but use recursion. */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    /** getRecursive Helper. */
    private T getRecursiveHelper(int index, Node start) {
        if (start == sentinel) {
            return null;
        } else if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelper(index - 1, start.next);
        }
    }

   /* public static void main(String[] args) {
        LinkedListDeque<Integer> s1 = new LinkedListDeque<>();
        s1.addFirst(0);
        s1.addLast(1);
        s1.removeFirst();
        s1.addLast(2);
        s1.addLast(3);
        s1.addLast(4);
        s1.addLast(5);
        s1.printDeque();
        System.out.println();

        System.out.println(s1.get(8));
        System.out.println(s1.get(0));
        System.out.println(s1.get(1));
        System.out.println(s1.get(2));
        System.out.println(s1.get(3));
        System.out.println(s1.size);
    }*/

}
