
public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    }

    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry, null);
        if(isEmpty())
        {
            firstNode = newNode;
        }
        else{
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    public T getFront() throws EmptyQueueException 
    {
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return firstNode.getData();
        }
    }

    public T dequeue()
    {
        T front = getFront();
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if(firstNode == null)
        {
            lastNode = null;
        }
        return front;
    }

    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }

    public void display()
    {
        Node currentNode = firstNode;
        if(isEmpty())
        {
            System.out.print("Empty Queue!");
        }
        while(currentNode != lastNode)
        {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T newEntry, Node nextNode)
        {
            data = newEntry;
            next = nextNode;
        }

        public void setData(T newEntry)
        {
            data = newEntry;
        }

        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }

        public T getData()
        {
            return data;
        }

        public Node getNextNode()
        {
            return next;
        }
    }

    


}
