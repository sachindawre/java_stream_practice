package dsa.revision.linkedlist;

public class SinglyLinkedList<T> {
    class Node{
        T data;
        Node nextNode;
    }
    Node headNode;
    public int size;

    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public void insertAtHead(T data) {
        Node node = new Node();
        node.data = data;

        node.nextNode = headNode;
        headNode = node;
        size++;
    }

    public void insertAfter(T data, T previous) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node node = new Node();
        node.data = data;

        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data == previous) {
                node.nextNode = currentNode.nextNode;
                currentNode.nextNode = node;
                size++;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void insertAtEnd(T data) {
        if(isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node node = new Node();
        node.data = data;

        Node currentNode = headNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = node;
        node.nextNode = null;
        size++;
    }

    public boolean search(T data) {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return false;
        }
        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public boolean searchRecursively(Node node, T data) {
        if (node == null) {
            return false;
        }

        if (node.data.equals(data)) {
            return true;
        }

        return searchRecursively(node.nextNode, data);
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        //if only one node exist
        if (headNode.nextNode == null) {
            headNode = null;
            return;
        }
        Node currentNode = headNode;
        while (currentNode.nextNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = null;
        size--;
    }

    public void printLinkedList() {
        Node currentNode = headNode;
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        while (currentNode.nextNode != null) {
            System.out.print(currentNode.data.toString() + " ->");
            currentNode = currentNode.nextNode;
        }
        System.out.println(currentNode.data.toString() + " ->null");
    }

    public boolean deleteByValue(T value) {
        Node currentNode = headNode;
        Node previousNode = headNode;
        while (currentNode.nextNode != null) {
            if (currentNode.data == value) {
                previousNode.nextNode = null;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        // Replace this placeholder return statement with your code
        return false;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertAtHead(10);
        singlyLinkedList.insertAtHead(20);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.insertAtEnd(30);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.insertAfter(100, 10);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.insertAfter(200, 30);
        singlyLinkedList.printLinkedList();
        System.out.println(singlyLinkedList.search(200));
        System.out.println(singlyLinkedList.searchRecursively(singlyLinkedList.headNode, 20));
    }

}
