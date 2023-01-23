import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = new Item[];
        size = array.length;
    }

    private void resize(int capcity) {
        Item copy[] = new Item[capcity];

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
        return array.length;
    }

    // add the item
    public void enqueue(Item item) {
        if (isEmpty()) {
            array = new Item[1];
            array[0] = item;
        }

        if (size = array.length) {
            resize(2 * array.length);
            array[size++] = item;
        }

    }

    // remove and return a random item
    public Item dequeue(int random) {
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample(int random) {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> list = new RandomizedQueue();

        list.enqueue("stuff");
        list.enqueue("thing");
        list.enqueue("word");
    }

}
