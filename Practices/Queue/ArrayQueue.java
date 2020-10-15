public final class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        //Create an array with 1 extra storage
        //It helps to know when the array is full
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        integrityOK = true;
    }

    public void enqueue(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    public T getFront() throws EmptyQueueException
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return queue[frontIndex];
        }
    }

    public T dequeue()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    public boolean isEmpty()
    {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    public void clear()
    {
        while(!isEmpty())
        {
            T object = dequeue();
            object = null;
        } 
        frontIndex = 0;
        backIndex = queue.length - 1;
    }

    public void display()
    {
        if(isEmpty())
        {
            System.out.print("Empty Queue!");
        }
        else
        {
            int index = frontIndex;
            while(index != backIndex)
            {
                System.out.print(queue[index] + " ");
                index++;
            }
            System.out.println();
        }

    }



    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a stack whose " + 
                                            "capacity exceeds allowed maximum of " +
                                            MAX_CAPACITY);
        }
    }

    private void checkIntegrity()
    {
        if(!integrityOK)
        {
            throw new SecurityException("ArrayStack object is corrupt.");
        }
    }

    private void ensureCapacity()
    {
        if(frontIndex == ((backIndex + 2) % queue.length))
        {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize - 1);
            integrityOK = false;
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for(int index = 0; index < oldSize - 1; index++)
            {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    }

    
}
