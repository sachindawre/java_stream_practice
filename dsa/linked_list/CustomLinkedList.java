package dsa.linked_list;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

class LLCustom{
    Node head;
    Node tail;

    public LLCustom() {
        Node head = tail = null;
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public String toString() {
        return "LLCustom{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

public class CustomLinkedList {
    public static void main(String[] args) {
        LLCustom llCustom = new LLCustom();
        llCustom.pushFront(1);
        llCustom.pushFront(2);
        System.out.println(llCustom);
    }
}
