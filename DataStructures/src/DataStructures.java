import java.util.ArrayList;
import java.util.Arrays;

public class DataStructures {
    
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        CustomLinkedList list = new CustomLinkedList();
        addElements(array,list);
        list.display();
        list.call();
        list.display();



    }
    public static void addElements(int[] array, CustomLinkedList list){
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
    }
}

