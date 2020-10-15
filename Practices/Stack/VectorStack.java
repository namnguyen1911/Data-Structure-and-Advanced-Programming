import java.util.EmptyStackException;
import java.util.Vector;

public final class VectorStack<T> implements StackInterface<T> {
    private Vector<T> stack;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public VectorStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity);
        integrityOK = true;
    }

    public void push(T newEntry) {
        checkIntegrity();
        stack.add(newEntry);
    }

    public T pop() {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack.remove(stack.size() - 1);
        }
    }

    public T peek() {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack.lastElement();
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        checkIntegrity();
        stack.clear();
    }

    @Override
    public void display() 
    {
        if(isEmpty())
        {
            System.out.println("Empty stack!");
        }
        for(int i = stack.size() - 1; i > -1; i--)
        {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();

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

    
}
