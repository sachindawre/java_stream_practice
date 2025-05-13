package dsa.queue;

public class QueueUsingArray<T> {
    private T[] queue;
    private int front, rear, capacity, size;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = (T[])new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        if (isFull()) {
            System.err.println("Queue is Full");
            return;
        }
        if(front == -1)
            front = 0;
        queue[++rear] = data;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
        }
        T data = queue[front];
        //shifting all the elements
        for (int i = 0; i< rear; i++) {
            queue[i] = queue[i+1];
        }
        //reduce the rear position since elements shifted left
        rear--;
        size--;
        //if queue becomes empty after shifting, reset front and rear
        if (size == 0) {
            front = rear = -1;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            return null;
        }
        return queue[front];
    }

    public void printQueue() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            return;
        }
        System.out.println("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueUsingArray<Integer> queueUsingArray = new QueueUsingArray<>(5);
        queueUsingArray.enqueue(10);
        queueUsingArray.enqueue(20);
        queueUsingArray.enqueue(30);
        queueUsingArray.enqueue(40);
        queueUsingArray.enqueue(50);
        queueUsingArray.printQueue();

        System.out.println("Dequeued: " + queueUsingArray.dequeue());
        queueUsingArray.printQueue();

        queueUsingArray.enqueue(60);
        queueUsingArray.printQueue();
    }


}
