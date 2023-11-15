import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataStructures {
    
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(12);
        list.addFirst(11);
        list.addFirst(10);

        list.addLast(13);
        list.addLast(15);

        list.deleteAt(2);

        list.display();
    }
}

