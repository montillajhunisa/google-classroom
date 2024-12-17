package googleclassroom;

public class SearchNodes<T> {
    public static class Node<T> {
        T data;
        protected Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        public T getData() {
            return data;
        }
    }

    //Represent the head and tail of the singly linked list
    public Node<T> head;
    public Node<T> tail;

    //Add a new node to the list
    public void add(T data) {
        //Create a new node
        Node<T> newNode = new Node<>(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
        } tail = newNode;
    }


    //display all the nodes present in the list
    public void display() {
        //currentNode will point to head
        Node<T> currentNode = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(currentNode != null) {
            //Prints each node
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public static class ParentNode
    {
        Node data;
        ParentNode next;
        ParentNode(Node n) {
            data = n;
        }
        static ParentNode head;
    }

    //search function return boolean if found
    public static boolean returnBoolean(ParentNode head, String x)
    {
        ParentNode current = head; //Initialize current
        while (current != null)
        {
            if (current.data.data.equals(x)) {
                return true; //data found
            }
            current = current.next;
        }
        return false; //data not found
    }

    public static Node returnNode(ParentNode head, String y) {
        ParentNode current = head; //Initialize current
        while (current != null)
        {
            if (current.data.data.equals(y)) {
                return current.data; //data found
            }
            current = current.next;

        }
        return null; //data not found
    }

    public static String getData(ParentNode head, String y) //head,
    {
        ParentNode subList = new ParentNode(returnNode(head, y));
        if (returnBoolean(head, y)) {
            ParentNode current = subList; //Initialize current
            while (current != null)
            {
                if (current.data.data.equals(y)) {
                    return y; //data found
                }
                current = current.next;
            }
            return "Data not found (1)."; //data not found
        }
        else
            return "Data not found (2).";
    }
    public void printParent() {
        //point to head
        Node<T> parentNode = head;
        Node<T> currentBabyNode = new Node<T>(parentNode.data);
        System.out.println(parentNode.data);
    }
}
