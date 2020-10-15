import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;

    public void push(T newEntry)
    {
        topNode = new Node(newEntry, topNode);
    }

    public T pop() {
        T top = peek();
        topNode = topNode.getNextNode();
        return top;
    }

    public T peek() {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return topNode.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    public void display()
    {
        Node currentNode = topNode;
        if(currentNode == null){
            System.out.println("Empty list!");
        }
        while(currentNode != null)
        {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public class Node {
        private T data;
        private Node next;
    
        Node(T newEntry, Node nextNode)
        {
            data = newEntry;
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