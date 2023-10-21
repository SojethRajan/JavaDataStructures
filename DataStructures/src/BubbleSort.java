import java.util.Arrays;

public class BubbleSort{

    public static void bubbleSort(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[ j + 1]){
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] bubbleSortRecursion(int[] array, int outer, int inner){
        if(outer == 0){
            return array;
        }
        if(inner < outer){
           if(array[inner] > array[inner + 1]){
               int temp = array[inner];
               array[inner] = array[inner + 1];
               array[inner + 1] = temp;
           }
           return bubbleSortRecursion(array,outer,++inner);
        }
        else {
            return bubbleSortRecursion(array,--outer,0);
        }
    }
}


