import java.util.Arrays;

public class SelectionSort{

    public static int[] selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int max = getMax(array,array.length - 1 - i);
                int temp = array[max];
                array[max] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
        }
        return array;
    }
    public static int getMax(int[] array, int stop){
        int max = 0;
        for(int i = 0; i <= stop; i++){
            if(array[i] > array[max]){
                max = i;
            }
        }
        return max;
    }
}
