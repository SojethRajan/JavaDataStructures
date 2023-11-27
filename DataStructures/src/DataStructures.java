import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataStructures {
    
    public static void main(String[] args){

    }
    public static void addElements(int[] array, CustomQueue queue){
        for(int i = 0; i < array.length; i++){
            queue.push(array[i]);
        }
    }
}

