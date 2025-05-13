package dsa.doubly_linked_list;

public class DoublyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        if (headNode != null) {
            headNode.prevNode = newNode;
        }
        this.headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (headNode == null) {
            headNode = newNode;
            return;
        }
        Node currentNode = headNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = newNode;
        newNode.prevNode = currentNode;
        size++;
    }


    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            return;
        }
        if (headNode.nextNode == null) {
            headNode = null;
            return;
        }
        Node currentNode = this.headNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.prevNode.nextNode = null;
        size--;

    }

    public void insertByValue(T data, T value) {
        if (isEmpty()) {
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
                newNode.nextNode = currentNode.nextNode;
                newNode.prevNode = currentNode;
                currentNode.nextNode.prevNode = newNode;
                currentNode.nextNode = newNode;
            }
            currentNode = currentNode.nextNode;
        }
        size++;
    }

    public void deleteByValue(T value) {
        if (isEmpty()) {
            return;
        }
        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null) {
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }
}
