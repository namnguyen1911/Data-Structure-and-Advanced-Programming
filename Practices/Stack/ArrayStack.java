import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    public T peek()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }

    public T pop()
    {
        T top = peek();
        stack[topIndex] = null;
        topIndex--;
        return top;
    }

    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    public void clear()
    {
        while(topIndex > -1)
        {
            pop();
        }
    }

    public void display()
    {
        if(topIndex == -1)
        {
            System.out.println("Empty stack!");
        }
        for(int i = topIndex; i > -1; i--)
        {
            System.out.print(stack[i] + " ");
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

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }




}
