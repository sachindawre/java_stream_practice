package dsa.queue;


public class LinkedListQueue<T> {
    public class Node {
        T data;
        Node nextNode;
    }
    private Node frontNode;
    private Node rearNode;
    private int size;

    public LinkedListQueue() {
        this.frontNode = null;
        this.rearNode = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node newNode = new Node();
        newNode.data = data;

        if (rearNode == null) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.nextNode = newNode;
            rearNode = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T removed = frontNode.data;
        frontNode = frontNode.nextNode;
        if (frontNode == null) {
            rearNode = null;
        }
        size--;
        return removed;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return frontNode.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = frontNode;
        System.out.println("Queue: ");
        while (current != null) {
            System.out.print(current.data + " <- ");
            current = current.nextNode;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.printQueue(); // Output: 10 <- 20 <- 30 <- 40 <- null

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        queue.printQueue(); // Output: 20 <- 30 <- 40 <- null

        System.out.println("Front Element: " + queue.peek()); // Output: 20
    }

}
