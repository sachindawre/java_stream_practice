package dsa.accolite;

public class CustomStack {
    private int size;
    private int arr[];
    private int top = -1;

    public CustomStack(int size) {
        arr = new int[size];
    }

    public void push(int e) {
        arr[++top] = e;
    }

    public int pop() {
        int e = arr[top];
        top--;
        return e;
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

}
