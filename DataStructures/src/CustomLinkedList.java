public class CustomLinkedList{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value ;
        private Node next;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        Node pointer = head;
        while(pointer != null){
            System.out.print(pointer.value + " -> ");
            pointer = pointer.next;
        }
        System.out.println("END");
    }

    /*Adding*/
    public void addFirst(int element){
        Node node = new Node();
        node.value = element;
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void add(int element){
        if(tail == null){
            addFirst(element);
            return;
        }
        Node node = new Node();
        node.value = element;
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int index, int element){
        if(index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(index == 0){
            addFirst(element);
            return;
        }
        else if(index == size){
            add(element);
            return;
        }
        int counter = 0;
        Node node = new Node();
        node.value = element;
        Node temp = head;
        while(counter < index - 1){
            temp = temp.next;
            counter++;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    /*deletion*/
    public void deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        //System.out.println(value);
    }

    public void deleteLast(){
        Node pointer = head;
        int value = 0;
        while(pointer.next.next != null){
            pointer = pointer.next;
        }
        value = pointer.next.value;
        pointer.next = null;
        tail = pointer;
        size--;
        //System.out.println(value);
    }

    public void deleteAt(int index) {
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException("Linked list has not grown to that size");
        }
        else if(index == 0){
            deleteFirst();
            return;
        }
        else if(index == size - 1){
            deleteLast();
            return;
        }

        Node temp = head;
        int counter = 0;
        while(counter < index - 1){
            temp = temp.next;
            counter++;
        }
        //System.out.println(temp.next.value);
        temp.next = temp.next.next;
        size--;
    }
}
