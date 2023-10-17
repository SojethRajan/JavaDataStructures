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
}
