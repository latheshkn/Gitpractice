public class LLMain {

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertLast(6);
        list.insert(10,3);
        list.display();
        System.out.println("the item is"+list.find(9));
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        System.out.println(list.getSize());
        list.display();
        System.out.println(list.delete(3));
        list.display();

    }
}
