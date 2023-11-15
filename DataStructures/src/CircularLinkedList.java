public class CircularLinkedList{

    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    public boolean contains(int element){
        Node temp = head;
        while(true){
            if(temp.value == element){
                return true;
            }
            temp = temp.next;
            if(temp == head){
                break;
            }
        }
        return false;
    }

    public void display(){
        Node temp = head;
        if(temp.next == null){
            System.out.println(temp.value + " -> END ");
            return;
        }
        while(true){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
            if(temp == head){
                break;
            }
        }
        System.out.println("END");
    }

    /*Adding*/
    public void addFirst(int element){
        Node node = new Node(element);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        tail.next = node;
        head = node;
    }

    public void addLast(int element){
        Node node = new Node(element);
        if(head == null){
            addFirst(element);
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void addAfter(int element, int newElement){
        Node temp = head;
        Node prev = null;
        while(true){
            if(temp.value == element){
                prev = temp;
                break;
            }
            temp = temp.next;
            if(temp == head){
                break;
            }
        }
        if(prev == null){
            return;
        }

        Node node = new Node(newElement);
        node.next = prev.next;
        prev.next = node;
    }

    /*Delete*/
    public void deleteFirst(){
        head = head.next;
        tail.next = head;
    }

    public void deleteLast(){
        if(head == tail){
            deleteFirst();
            return;
        }
        Node temp = head;
        Node prev = null;
        while(true){
            prev = temp;
            temp = temp.next;
            if(temp.next == head){
                break;
            }
        }

        prev.next = head;
        tail = prev;
    }

    public void deleteAfter(int element){
        Node temp = head;
        Node prev = null;
        while(true){
            if(temp.value == element){
                prev = temp;
                break;
            }
            temp = temp.next;
            if(temp == head){
                break;
            }
        }
        if(prev == null){
            return;
        }

        prev.next = prev.next.next;
    }


}
