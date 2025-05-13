package dsa.revision.linkedlist;

import jdk.jshell.spi.SPIResolutionException;

public class DoublyLinkedList<T> {
    class Node {
        T data;
        Node nextNode;
        Node prevNode;
    }

    public Node headNode;
    public int size;

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node node = new Node();
        node.data = data;

        node.nextNode = headNode;
        node.prevNode = null;
        if (headNode != null) {
            headNode.prevNode = node;
        }
        headNode = node;
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;

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
            System.out.println("Linked List is Empty");
            return;
        }
        if (headNode.nextNode == null) {
            headNode = null;
            size--;
        }
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void insertAfter(T data, T previous) {
        if(isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node newNode = new Node();
        newNode.data = data;

        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(previous)) {
                newNode.nextNode = currentNode.nextNode;
                newNode.prevNode = currentNode;
                currentNode.nextNode.prevNode = newNode;
                currentNode.nextNode = newNode;
                size++;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }
        if (headNode.data.equals(data)) {
            headNode = null;
            size--;
            return;
        }
        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null) {
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void printLinkedList() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node currentNode = headNode;
        while (currentNode != null) {
            System.out.print(currentNode.data.toString() + " ->");
            currentNode = currentNode.nextNode;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.printLinkedList();
        doublyLinkedList.insertAtHead(10);
        doublyLinkedList.insertAtHead(20);
        doublyLinkedList.printLinkedList();
        doublyLinkedList.deleteAtHead();
        doublyLinkedList.printLinkedList();
        doublyLinkedList.insertAtEnd(100);
        doublyLinkedList.insertAtEnd(30);
        doublyLinkedList.printLinkedList();
        doublyLinkedList.deleteByValue(100);
        doublyLinkedList.printLinkedList();
    }
}
