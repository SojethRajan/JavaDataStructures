import java.util.Arrays;

public class DataStructures {
    
    public static void main(String[] args){
        int[] array = {5,3,4,2,1};
        int[] answer = SelectionSort.selectionSortRecursion(array,array.length,0,0);
        System.out.println(Arrays.toString(answer));
    }
}

