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
        nextLast = 0;
    }


    /** Resize the array to rFactor its current size. 
      * Rearrange the array so that nextFirst is 0. */
    private void resize(double rFactor) {
        T[] a = (T[]) new Object[(int) (rFactor * items.length)];
        int startIndex = plusOne(nextFirst);
        int endIndex = minusOne(nextLast);
        if (startIndex < endIndex) {
            System.arraycopy(items, startIndex, a, 0, size);
        } else {
            //two parts
            // copy the addFirst Part
            System.arraycopy(items, startIndex, a, 0, items.length - startIndex);
            // copy the addLast Part, sum of total lengths copied should equal size
            System.arraycopy(items, 0, a, items.length - startIndex, size - items.length + startIndex);
        }
        items = a;
        nextFirst = minusOne(items.length);
        nextLast = size;
    }

    /** Plus one modulo length. */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /** Minus one modulus length. */
    private int minusOne(int index) {
        return ((index - 1) + items.length) % items.length;
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
        boolean withinrange = (index >= 0) && (index < items.length);
        int lastIndex = minusOne(nextLast);
        int firstIndex = plusOne(nextFirst);
        if (withinrange && (index <= lastIndex || index >= firstIndex)) {
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
            // resize by half if usage ratio is lower than 0.25
            if (size >= 8 && (((double) size / items.length) < 0.25)) {
                resize(0.5);
            }
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
            // resize by half if usage ratio is lower than 0.25
            if (size >= 8 && (((double) size / items.length) < 0.25)) {
                resize(0.5);
            }
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
       for (int i = 0; i < 33; i += 1) {
           a1.addFirst(0);
       }
       for (int i = 0; i < 17; i += 1) {
           a1.removeFirst();
       }
       a1.removeFirst();
       // System.out.println(a1.isEmpty());
       a1.printDeque();
    }*/

}
