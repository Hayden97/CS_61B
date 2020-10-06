public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array Deque with starting size 8. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = size;
    }


    /** Resize the array to rFactor its current size. 
      * Rearrange the array so that nextFirst is 0. */
    private void resize(int rFactor) {
        T[] a = (T[]) new Object[rFactor * size];
        // copy the addFirst Part
        System.arraycopy(items, plusOne(nextFirst), a, 0, size - nextFirst - 1);
        // copy the addLast Part, sum of total lengths copied should equal size
        System.arraycopy(items, 0, a, size - nextFirst - 1, nextFirst + 1);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Plus one modulo length. */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /** Minus one modulo length. */
    private int minusOne(int index) {
        return (index - 1) % items.length;
    }

    /** Add an item of type T to the front of the array. */
    public void addFirst(T x) {
        if (size == items.length) {
            resize(2);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Add an item of type T to the end of the array. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(2);
        }
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }


    /** Get the size of the array Deque. */
    public int size() {
        return size;
    }


    /** Get the index item of the array Deque. */
    public T get(int index) {
        return items[index];
    }


    /** Removes and returns the item at the front of the deque.
      * If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            int firstItemIndex = plusOne(nextFirst);
            T firstItem = items[firstItemIndex];
            items[firstItemIndex] = null;
            nextFirst = firstItemIndex;
            size -= 1;
            return firstItem;
        }
    }

    /** Removes and returns the item at the end of the deque. 
      * If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            int lastItemIndex = minusOne(nextLast);
            T lastItem = items[lastItemIndex];
            items[lastItemIndex] = null;
            nextLast = lastItemIndex;
            size -= 1;
            return lastItem;
        }
    }


    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        // print the first part
        for (int i = 0; i < items.length - nextFirst - 1; i += 1) {
            System.out.print(items[plusOne(nextFirst) + i] + " ");
        }
        for (int i = 0; i < size + nextFirst + 1 - items.length; i += 1) {
            System.out.print(items[i] + " ");
        }
    }

   /* public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.addLast(1);
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(1);
        a1.addLast(2);
        a1.addLast(3);
        a1.addLast(4);
        a1.addLast(1);
        a1.addFirst(0);
        System.out.println(a1.size());
        a1.printDeque();
    }*/

}
