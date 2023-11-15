public class DoublyLinkedList{

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value;
        private Node next;
        private Node previous;

        Node(int value){
            this.value = value;
        }
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int getSize(){
        return size;
    }

    public void display(String s){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.value + " <- ");
            temp = temp.previous;
        }
        System.out.println("START");
    }

    /*Adding element*/
    public void addFirst(int element){
        Node node = new Node(element);
        node.next = head;
        node.previous = null;
        if(head != null){
            head.previous = node;
        }
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void addLast(int element){
        if(tail == null){
            addFirst(element);
            return;
        }
        Node node = new Node(element);
        tail.next = node;
        node.previous = tail;
        node.next = null;
        tail = node;
        size++;
    }

    public void insertAt(int element, int index){
        if(index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(index == 0){
            addFirst(element);
            return;
        }
        else if(index == size){
            addLast(element);
            return;
        }

        int counter = 0;
        Node temp = head;
        while(counter < index - 1){
            temp = temp.next;
            counter++;
        }
        Node node = new Node(element);
        node.next = temp.next;
        temp.next.previous = node;
        temp.next = node;
        node.previous = temp;
        size++;
    }

    /*Deleting elements*/
    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        head.previous = null;
        size--;
    }

    public void deleteLast(){
        if(tail == null){
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void deleteAt(int index){
        if(index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        else if(index == 0){
            deleteFirst();
            return;
        }
        else if(index == size - 1){
            deleteLast();
            return;
        }

        int counter = 0;
        Node temp = head;
        while(counter < index - 1){
            temp = temp.next;
            counter++;
        }

        temp.next.next.previous = temp;
        temp.next = temp.next.next;
        size--;
    }

    public boolean contains(int element){
        Node temp = head;
        while(temp != null){
            if(temp.value == element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
