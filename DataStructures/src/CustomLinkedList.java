import java.util.List;

public class CustomLinkedList{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int value ;
        private Node next;
    }

/*LinkedList Internal Implementation*/

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

    public void insertAtRecursion(int index, int element){
        helper(index,element,head);
    }
    private void helper(int index, int element, Node temp){
        if(index == 1){
            Node node = new Node();
            node.value = element;
            node.next = temp.next;
            temp.next = node;
            size++;
            return;
        }
        helper(--index, element, temp.next);
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


    /*Questions*/
    public void removeDuplicates(){
        Node temp = head;
        while(temp.next.next != null){

            while(temp.value == temp.next.value){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        if(temp.value == temp.next.value){
            temp.next = null;
            tail = temp;
        }
    }

    public CustomLinkedList mergeTwoLinkedList(CustomLinkedList list1, CustomLinkedList list2){
        Node firstHead = list1.head;
        Node secondHead = list2.head;
        CustomLinkedList merged = new CustomLinkedList();
        while(firstHead != null && secondHead != null){
            if(firstHead.value < secondHead.value){
                merged.add(firstHead.value);
                firstHead = firstHead.next;
            }
            else {
                merged.add(secondHead.value);
                secondHead = secondHead.next;
            }
        }

        while(firstHead != null){
            merged.add(firstHead.value);
            firstHead = firstHead.next;
        }

        while(secondHead != null){
            merged.add(secondHead.value);
            secondHead = secondHead.next;
        }
        return merged;
    }

    public void call(){
        reArrange(head);
        //System.out.println(ans);
    }
    public void addDiff(int element){
        Node node = new Node();
        node.value = element;
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    public boolean hasCycle(Node head){
        Node fastPointer = head;
        Node slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer){
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int counter = 0;
                while(true){
                    slow = slow.next;
                    counter++;
                    if(slow == fast){
                        return counter;
                    }
                }
            }
        }
        return -1;
    }

    public Node startOfCycle(Node head){
        int length = lengthOfCycle(head);
        Node fisrt = head;
        Node second = head;
        if(length == -1){
            return null;
        }
        while(length > 0){
            second = second.next;
            length--;
        }
        while(fisrt != second){
            fisrt = fisrt.next;
            second = second.next;
        }
        return fisrt;
    }

    public boolean happyNumber(int number){
        int fast = number;
        int slow = number;

        while(true){
            fast = getSquare(getSquare(fast));
            slow = getSquare(slow);

            if(fast == 1 || slow == 1){
                return true;
            }

            else if (fast == slow){
                return false;
            }
        }
    }

    private int getSquare(int number){
        int answer = 0;
        while(number != 0){
            int remainder = number % 10;
            answer = answer + remainder * remainder;
            number = number / 10;
        }
        return answer;
    }

    public Node findMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node getNode(int index){
        Node temp = head;
        int counter = 0;
        while(counter < index && temp.next != null){
            temp = temp.next;
            counter++;
        }
        return temp;
    }

    public void bubbleSortLinkedList(int outer, int inner){
        if(outer == 0){
            return;
        }
        if(inner < outer){
            Node first = getNode(inner);
            Node second = getNode(inner + 1);
            if(first.value > second.value){
                if(first == head){
                    first.next = second.next;
                    second.next = first;
                    head = second;
                }
                else if(second == tail){
                    second.next = first;
                    first.next = null;
                    Node previous = getNode(inner - 1);
                    previous.next = second;
                    tail = first;
                }
                else {
                    first.next = second.next;
                    second.next = first;
                    Node previous = getNode(inner - 1);
                    previous.next = second;
                }
            }
            bubbleSortLinkedList(outer,inner + 1);
        }
        bubbleSortLinkedList(--outer, 0);
    }

    public Node reverse(Node head){
        Node previous = null;
        Node present = head;
        Node next = present.next;
        while(present != null){
            present.next = previous;
            previous = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = previous;
        return head;
    }

    public boolean isPalindrome(Node head){
        Node middle = findMiddle(head);
        Node first = head;
        Node second = reverse(middle);
        Node temp = second;

        while(first != null && second != null){
            if(first.value != second.value){
                break;
            }
            first = first.next;
            second = second.next;
        }
        reverse(temp);
        if(first == null || second == null){
            return true;
        }
        return false;
    }

    public void reArrange(Node head){
        Node mid = findMiddle(head);
        Node start = head;
        Node end = reverse(mid);
        while(start != null && end != null){
            Node temp = start.next;
            start.next = end;
            start = temp;

            temp = end.next;
            end.next = start;
            end = temp;
        }

        if(start != null){
            start.next = null;
        }

    }
}
