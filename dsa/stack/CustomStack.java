package dsa.stack;

public class CustomStack<V> {
    private final int maxSize;
    private int top;
    private final V[] array;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.array = (V[]) new Object[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public V top() {
        if(isEmpty()) return null;
        return array[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.err.println("Stack is full");
            return;
        }
        array[++top] = value;
    }

    public V pop() {
        if(isEmpty()) {
            return null;
        }
        return array[top--];
    }
}
