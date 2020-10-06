public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array Deque with starting size 8. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = minusOne(items.length);
        nextLast = size;
    }


    /** Resize the array to rFactor its current size. 
      * Rearrange the array so that nextFirst is 0. */
    private void resize(int rFactor) {
        T[] a = (T[]) new Object[rFactor * size];
        int startIndex = plusOne(nextFirst);
        // copy the addFirst Part
        System.arraycopy(items, startIndex, a, 0, size - startIndex);
        // copy the addLast Part, sum of total lengths copied should equal size
        System.arraycopy(items, 0, a, size - startIndex, startIndex);
        items = a;
        nextFirst = minusOne(items.length);
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


    /** Gets the item at the given index.
      * If no such item exists, returns null.  */
    public T get(int index) {
        if (((index > nextFirst) && (index < (items.length - 1)))
                || ((index > 0) && (index < nextLast))) {
            return items[index];
        } else {
            return null;
        }
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
        int startIndex = plusOne(nextFirst);
        // print the first part
        for (int i = 0; i < items.length - nextFirst - 1; i += 1) {
            System.out.print(items[startIndex + i] + " ");
        }
        // print size times
        for (int i = 0; i < size - items.length + nextFirst + 1; i += 1) {
            System.out.print(items[i] + " ");
        }
    }

   /*public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.addFirst(0);
        a1.addFirst(1);
        a1.addFirst(2);
        a1.removeFirst();
        a1.removeFirst();
        a1.removeFirst();
        System.out.println(a1.isEmpty());
        //a1.printDeque();
    }*/

}
