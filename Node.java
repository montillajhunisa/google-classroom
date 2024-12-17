package googleclassroom;

public class Node <T> {
    private T data;
    private Node <T> next;

    public Node(T data){
        this.data = data;
        next = null;
    }

    public T getData(){ //getter method of 'data' (returns the data of the node)
        return data;
    }
    public void setNext(Node<T> nextNode){ //setter method of 'setNextNode' (sets the next node a node references to)
        this.next = nextNode;
    }
    public Node<T> getNext(){   //getter method of 'setNextNode' (returns the next node a node references to)
        return next;
    }
}
