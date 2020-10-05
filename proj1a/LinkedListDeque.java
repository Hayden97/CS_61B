public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    // sentinel.next is always the first Node
    // sentinel.prev is alway sthe last Node
    private Node sentinel = new Node(null, null, null);
    private int size;

    /** Create an empty Deque. */
    public LinkedListDeque() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Create a non-empty Deque. */
    public LinkedListDeque(T i) {
        sentinel.next = new Node(i, sentinel, null);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        Node p = sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }

        T firstItem = sentinel.next.item;
        Node newFirst = sentinel.next.next;
        if (newFirst == null) {
            // newFirst does not have prev
            sentinel.prev = newFirst;
        } else {
            // newFirst has a prev
            newFirst.prev = sentinel;
        }
        sentinel.next = newFirst;
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (sentinel.prev == null) {
            return null;
        }

        T lastItem = sentinel.prev.item;
        Node newLast = sentinel.prev.prev;
        if (newLast == null) {
            // newLast does not have next
            sentinel.next = newLast;
        } else {
            // newLast has a next
            newLast.next = sentinel;
        }
        sentinel.prev = newLast;
        return lastItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and forth.
    /** If no such item exists, returns null. Must not alter the deque. */
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
    public T getRecursiveHelper(int index, Node start) {
        if (start == sentinel) {
            return null;
        } else if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelper(index-1, start.next);
        }
    }



    /*public static void main(String[] args) {
        LinkedListDeque<Integer> s1 = new LinkedListDeque<>(5);
        s1.addFirst(0);
        s1.addLast(10);
        // s1.removeFirst();
        // s1.printDeque();
        // System.out.println(s1.size());
        System.out.println(s1.getRecursive(0));
        System.out.println(s1.getRecursive(1));
        System.out.println(s1.getRecursive(2));
        System.out.println(s1.getRecursive(3));

        *//*System.out.println(s1.size);
        System.out.println(s1.sentinel.prev.item);
        System.out.println(s1.sentinel.next.item);*//*
    }
*/

}
