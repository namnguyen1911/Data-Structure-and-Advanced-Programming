public class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {
    private Node queueNode;
    private Node freeNode;

    public TwoPartCircularLinkedQueue()
    {
        freeNode = new Node(null,null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T newEntries, Node nextNode)
        {
            data = newEntries;
            next = nextNode;
        }

        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }

    }

    
}
