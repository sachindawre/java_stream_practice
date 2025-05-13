package dsa.linked_list_1;

public class SingleLinkList<T> {

    public class Node {
        T data;
        Node nextNode;
    }

    public Node headNode;
    public int size;

    public SingleLinkList() {
        headNode = null;
        size = 0;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node currentNode = headNode;
            while(currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
    }

    /*public void insertAfter(T n, T data) {
        Node newNode = new Node();
        newNode.data = data;

        Node currentNode = headNode;

            while (currentNode != null) {
                //currentNode = currentNode.nextNode;
                if (currentNode.data == n) {
                    newNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode = newNode;
                }
                currentNode = currentNode.nextNode;
            }

    }*/

    public void insertAfter(T data, T previous) {
        if (isEmpty()) {
            return;
        }
        //first create new node with given data
       Node newNode = new Node();
       newNode.data = data;

       //take a current pointer, start from a head
        Node currentNode = this.headNode;

        //traverse the linked list until the current node is not null and node having data equal to previous is found
        while (currentNode != null && !currentNode.data.equals(previous) ) {
            //update the current node as well
            currentNode = currentNode.nextNode;
        }

        //if such node is found then point our new node to current nodes nextElement
        if (currentNode != null) {
            //update the next node of new node to next node of current node
            newNode.nextNode = currentNode.nextNode;
            //update the next node of current element to the new node
            currentNode.nextNode = newNode;
            //increase the size
            size++;
        }
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) return;
        Node currentNode = headNode;
        while (currentNode.nextNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = null;
    }


    public void traverse() {
        if (!isEmpty()) {
            Node temp = headNode;
            while(temp != null) {
                System.out.println(temp.data + " ");
                temp = temp.nextNode;
            }
        }
    }

    public boolean deleteByValue(T value) {
        boolean deleted = false;

        Node currentNode = this.headNode;
        Node previousNode = null;

        if (currentNode.data.equals(value)) {
            headNode = headNode.nextNode;
            deleted = true;
            return deleted;
        }

        while (currentNode != null) {
            if (currentNode.data.equals(value)) {
                previousNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = null;
                deleted = true;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return deleted;
    }


    public boolean isEmpty() {
        return headNode == null;
    }

    public static void main(String[] args) {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();
        System.out.println(singleLinkList.isEmpty());
        singleLinkList.insertAtHead(10);
        singleLinkList.insertAtEnd(190);
        singleLinkList.insertAfter(100, 190);
        //singleLinkList.traverse();
        /*singleLinkList.insertAtHead(20);
        //singleLinkList.traverse();
        singleLinkList.insertAtEnd(50);
        singleLinkList.insertAtEnd(100);
        //System.out.println("After inserting at end");
        //singleLinkList.traverse();
        singleLinkList.insertAfter(50, 120);
        singleLinkList.insertAfter(100, 130);*/
        singleLinkList.deleteAtEnd();
        singleLinkList.insertAtEnd(50);
        singleLinkList.insertAtEnd(300);
        singleLinkList.deleteByValue(50);
        singleLinkList.traverse();
    }
}
