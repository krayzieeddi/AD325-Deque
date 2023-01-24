import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[2];
        size = 0;
    }

    private void resize(int capcity) {
        Item[] copy = (Item[]) new Object[capcity];

        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }

        array = copy;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        if (array.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {

        if (size == array.length) {
            resize(2 * array.length);
        }

        array[size++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        int num = StdRandom.uniformInt(size);
        Item random = array[num];
        array[num] = null;
        return random;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int num = StdRandom.uniformInt(size);
        return array[num];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        int front;
        Item[] it = (Item[]) new Object[size];

        public RandomizedQueueIterator() {
            front = 0;
            for (int y = 0; y < size; y++) {
                it[y] = array[y];
            }
            StdRandom.shuffle(it);
        }

        public boolean hasNext() {
            return front < size;
        }

        public Item next() {
            Item x = null;

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (front < size) {
                x = it[front];
                it[front] = null;
                front++;
            }
            return x;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> list = new RandomizedQueue<String>();

        list.enqueue("stuff");
        list.enqueue("thing");
        list.enqueue("word");
        list.enqueue("godzilla");
        list.enqueue("poop");
        list.enqueue("pee pee");

        System.out.println(list.size());

        System.out.println("---------------------");
        System.out.println(list.dequeue());
        System.out.println("---------------------");
        System.out.println(list.sample());
        System.out.println("---------------------");

        Iterator<String> x = list.iterator();

        while (x.hasNext()) {
            System.out.println(x.next());
        }

    }

}

