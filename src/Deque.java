import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> front;
    private Node<Item> end;
    private int size = 0;

    // construct an empty deque
    public Deque() {
        front = null;
        end = null;
    } // end of constructord

    private static class Node<Item> {
        Item data;
        Node<Item> next;
        Node<Item> prev;

        public Node(Item data) {
            this.data = data;
            next = null;
            prev = null;
        } // end of constructor
    }

    // is the deque empty?
    public boolean isEmpty() {
        if (front == null) {
            return true;
        } else if (end == null) {
            return true;
        } else {
            return false;
        }
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (isEmpty()) {
            Node<Item> newNode = new Node<Item>(item);
            front = newNode;
            end = newNode;
            size++;
        } else {
            Node<Item> newNode = new Node<Item>(item);
            newNode.next = front;
            front = newNode;
            size++;
        }
    } // end of addFirst method

    // add the item to the back
    public void addLast(Item item) {
        if (isEmpty()) {
            Node<Item> newNode = new Node<Item>(item);
            front = newNode;
            end = newNode;
            size++;
        } else {
            Node<Item> newNode = new Node<Item>(item);
            end.next = newNode;
            newNode.prev = end;
            end = newNode;
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Node<Item> oldFirst = front;
        front = front.next;
        size--;
        return oldFirst.data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Node<Item> oldEnd = end;
        if (end != null) end.next = null;
        if (size == 1) front = null;
        end = end.prev;
        size--;
        return oldEnd.data;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Node<Item> current;

        public RandomizedQueueIterator() {
            current = front;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item result = current.data;
            current = current.next;

            return result;
        }

        public void remove() {
            Iterator.super.remove();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> list = new Deque<String>();

        list.addFirst("stuff");
        list.addFirst("larry");
        list.addLast("bob");
        list.addLast("tim");


        Iterator<String> x = list.iterator();

        while (x.hasNext()) {
            System.out.println(x.next());
        }

        System.out.println("--------------");

        System.out.println(list.removeFirst());

        System.out.println("--------------");

        System.out.println(list.removeLast());

        System.out.println("--------------");

        Iterator<String> y = list.iterator();

        while (y.hasNext()) {
            System.out.println(y.next());
        }
    } // end of main method

}
