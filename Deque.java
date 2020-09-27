public class Deque {

    private Node front;
    private Node rear;
    private int size;

    public class Node {
        // next node in the list
        Node next;
        // previous node in the list
        Node prev;

        String element;

        Node(String e){
            this.element = e;
        }
    }

    public Deque(){
        this.front = null;
        this.rear = null;
        this.size=0;
    }

    public boolean empty(){
        return front == null;
    }


    public void addFront(String i){
        //Create a new node
        Node newNode = new Node(i);

        if(empty()){
            rear = newNode;
        }else{
            front.prev = newNode;
        }
        newNode.next = front;
        front = newNode;
        this.size++;
    }


    public void addRear(String i){
        Node newNode = new Node(i);

        if(empty()){
            front = newNode;
        }else{
            rear.next = newNode;
            newNode.prev = front;
        }
        rear = newNode;
        this.size++;
    }

    public Node removeFront(){
        if(front == null){
            return null;
        }
        Node first = front;
        if(front.next == null){
            rear = null;
        }else{

            front.next.prev = null;
        }
        front = front.next;
        this.size--;
        return first;
    }

    public Node removeRear(){
        if(rear == null){
           return null;
        }
        Node last = rear;
        if(front.next == null){
            front = null;
        }else{
            // next of previous node (new last) becomes null
            rear.prev.next = null;
        }
        rear = rear.prev;
        this.size--;
        return last;
    }

    public  int size(){
        return  this.size;
    }

}
