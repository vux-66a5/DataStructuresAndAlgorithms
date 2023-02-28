package Hw1.bai5;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data, Node link) {
            this.data = data;
            this.next = link;
        }
    }

    private int n;
    private Node top;
    private Node bot;

    public SimpleLinkedList() {
        n = 0;
        top = null;
        bot = null;
    }

    public void addTop(T data) {
        Node newFirst = new Node(data, null);
        newFirst.next = top;
        top = newFirst;
        n++;
    }

    public void addBot(T data) {
        if (top == null) {
            addTop(data);
            return;
        }
        Node temp = top;

        // loop until we find the end of the list
        while ((temp.next != null)) {
            temp = temp.next;
        }

        // set the new node to the Object x, next will be null.
        temp.next = new Node(data, null);
        n++;
    }

    public T get(int index) {
        rangeCheck(index);
        Node list = top;
        for (int k = 0; k < index; k++) {
            list = list.next;
        }
        return list.data;
    }

    public void set(int index, T data) {
        if (index < 0 || index > n) {
            System.out.println("index out of bounds " + index + " of " + (n - 1) + ", can't be set");
        }
        if (index == 0) {
            top = new Node(data, top.next);
        } else if (index == n) {
            bot = new Node(data, null);
        } else {
            Node tempNode = top;
            for (int k = 0; k < index - 1; k++) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node(data, tempNode.next.next);
        }
    }

    public boolean isContain(T data) {
        Node tempNode = top;
        for (int i = 0; i < n; i++) {
            if (tempNode.data.equals(data)) {
                return true;
            } else {
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            return null;
        }
        T deletedTopData = top.data;
        top = top.next;
        n--;
        return deletedTopData;
    }

    public T removeBot() {
        if (isEmpty() || top.next == null) {
            return null;
        }
        Node tempNode = top;
        for (int i = 0; i < n - 2; i++) {
            tempNode = tempNode.next;
        }
        T deletedBotData = tempNode.next.data;
        tempNode.next = null;
        n--;
        return deletedBotData;
    }

    public void remove(T data) {
        Node tempNode = top;
        Node previousTempNode = null;
        while (tempNode != null) {
            if (tempNode.data.equals(data)) {
                if (previousTempNode == null) {
                    top = top.next;
                } else {
                    previousTempNode.next = tempNode.next;
                }
                n--;

            }
            previousTempNode = tempNode;
            tempNode = tempNode.next;
        }

    }

    public void add(int index, T data) {
        if (index < 0 || index > n) {
            System.out.println(("index out of bounds " + index
                    + " of " + n));
        }
        if (index == 0) {
            addTop(data);
        } else if (index == n) {
            addBot(data);
        } else {
            Node tempNode = top;
            for (int k = 0; k < index - 1; k++) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node(data, tempNode.next);
        }
        n++;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = top;
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }

    public int indexOf(T data) {
        Node list = top;
        int count = 0;
        while (list != null) {
            if (list.data.equals(data)) {
                return count;
            }
            count++;
            list = list.next;
        }
        return -1;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("index out of bounds " + index
                    + " of " + n);
        }
    }

    public static void main(String[] args) {

        SimpleLinkedList<String> linkedListNodes = new SimpleLinkedList<>();
        linkedListNodes.addBot("phan tu thu 3");
        linkedListNodes.addTop("phan tu thu 2");
        linkedListNodes.addTop("phan tu thu 1");
        linkedListNodes.addBot("phan tu thu 4");
        linkedListNodes.addBot("phan tu thu 5");
//        System.out.println("removed: " + linkedListNodes.removeTop());
//        System.out.println("removed: " + linkedListNodes.removeBot());
        linkedListNodes.set(5, "phan tu 6 moi");
        linkedListNodes.remove("phan tu 1 moi");
        System.out.println("LinkedList size: " + linkedListNodes.size());
        System.out.println("linkedlist chua phan tu thu 4 : " + linkedListNodes.isContain("phan tu thu 4"));
        linkedListNodes.print();

    }
}