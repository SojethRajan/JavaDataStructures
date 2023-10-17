import java.util.Arrays;

public class InsertionSort{

    public static void insertionSort(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(numbers[j] < numbers[j - 1]){
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
