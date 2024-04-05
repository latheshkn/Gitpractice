public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size =0;
    }
    public void insertFirst(int val){

        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail==null){
            tail = head;
        }
        size +=1;
    }

    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next =node;
        tail =node;
        size++;
    }

    public void insert(int val ,int index){
        if (tail==null){
            insertFirst(val);
            return;
        }

        if (index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(temp.next,val);
        temp.next =node;
        size++;
    }

    public int getSize(){
        return size;
    }
    public void display(){
        Node temp=head;
        while (temp !=null){
            System.out.print(temp.val+"-->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public Node get(int index){
        Node node =head;
        for (int i =1 ; i < index; i++) {
            node =node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;

        if (head==null){
            tail =null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        int val = tail.val;
        Node node = get(size-1);
        tail = node;
        tail.next =null;
        size--;
        return val;

    }

    public int delete(int index){

        if (index==0){
            return deleteFirst();
        }

        if (index==size){
            return deleteLast();
        }
        Node val = get(index);
        Node pre = get(index-1);
        pre.next =val.next;
        return val.val;
    }

    public Node find(int val){
        Node node = head;

        while (node !=null){
            if (node.val ==val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    private class Node{
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }
}
