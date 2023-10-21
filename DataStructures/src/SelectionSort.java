import java.util.Arrays;

public class SelectionSort{

    public static void selectionSort(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            int max = getMax(numbers,numbers.length - 1 - i);
            int temp = numbers[max];
            numbers[max] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 -i] = temp;
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static int getMax(int[] array, int stop){
        int max = 0;
        for(int i = 1; i <= stop; i++){
            if(array[i] > array[max]){
                max = i;
            }
        }
        return max;
    }

    public static int[] selectionSortRecursion(int[] array, int outer, int inner, int max){
        if(outer == 0){
            return array;
        }
        if(inner < outer){
            if(array[inner] > array[max]){
                return selectionSortRecursion(array,outer,inner + 1,inner);
            }
            else {
                return selectionSortRecursion(array,outer,inner + 1,max);
            }
        }
        else {
            int temp = array[max];
            array[max] = array[outer - 1];
            array[outer - 1] = temp;
            return selectionSortRecursion(array,--outer,0,0);
        }
    }
}
