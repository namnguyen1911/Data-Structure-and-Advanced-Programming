public class LinkedStackTest{
    public static void main(String[] args) {
        StackInterface<String> stackBag1 = new LinkedStack<>();
        stackBag1.push("Nam");
        stackBag1.push("Binh");
        stackBag1.push("Quoc");
        stackBag1.display();
        System.out.println(stackBag1.pop());
        stackBag1.clear();
        stackBag1.display();
    }
        
}