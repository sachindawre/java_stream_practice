package dsa.queue;

public class CircularQueue<T> {
    private T[] queue;
    private int front, rear, capacity, size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public  boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.err.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public T dequeue() {
        if(isEmpty()) {
            System.err.println("Queue is empty");
            return null;
        }
        T data = queue[front];
        //if there is only one element left, reset front and rear
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return queue[front];
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue: ");
        int i = front;
        for (int count = 0; count<size; count++) {
            System.out.print(queue[i] + " <- ");
            i = (i + 1) % capacity;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue(); // Output: 10 <- 20 <- 30 <- 40 <- 50 <- null

        System.out.println("Dequeued: " + q.dequeue()); // Output: 10
        q.printQueue(); // Output: 20 <- 30 <- 40 <- 50 <- null

        q.enqueue(60);
        q.printQueue(); // Output: 20 <- 30 <- 40 <- 50 <- 60 <- null

        System.out.println("Front Element: " + q.peek()); // Output: 20
    }

}
