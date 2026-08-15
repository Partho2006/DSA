class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next=null;
    } 
    Node(Node next, int data) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {
    public Node addHead(Node head, int val) {
        return new Node(head, val);
    }

    public Node addLast(Node head, int val) {
        if(head == null) {
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node N = new Node(val);
        temp.next = N;

        return head;
    }

    public Node removeHead(Node head) {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    public void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head=null;

        head = list.addHead(head, 10);
        head = list.addHead(head, 20);
        head = list.addLast(head, 30);

        list.printList(head);

        head = list.removeHead(head);

        list.printList(head);
    }
}
