public class LinkedQueueTest {
    public static void main(String[] agrs)
    {
        QueueInterface<String> queue1 = new LinkedQueue<>();
        queue1.enqueue("First");
        queue1.enqueue("Second");
        queue1.enqueue("Third");
        queue1.enqueue("Fourth");
        queue1.enqueue("Fifth");
        queue1.enqueue("Sixth");
        queue1.display();
        System.out.print("The queue after dequeuing is: ");
        queue1.dequeue();
        queue1.display();
        System.out.print("The result of getFront function is: ");
        System.out.println(queue1.getFront());
        queue1.clear();
        System.out.print("After clear the queue: ");
        queue1.display();

    }
}
