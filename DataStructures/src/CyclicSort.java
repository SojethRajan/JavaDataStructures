import java.util.Arrays;

public class CyclicSort{

    /*For elements 0 to N*/
    public static void cylicSort(int[] numbers){

         for(int i = 0; i < numbers.length;){
            int value = numbers[i];
            if(value != i){
                int temp = numbers[value];
                numbers[value] = numbers[i];
                numbers[i] = temp;
            }
            else {
                i++;
            }
        }

         System.out.println(Arrays.toString(numbers));
    }

    /*for elements 1 to N*/
    public static void cylicSort(int[] array, String s){
        s = "1 to N";
        for(int i = 0; i < array.length;){
            int value = array[i];
            if(i != value - 1){
                int temp = array[value - 1];
                array[value - 1] = array[i];
                array[i] = temp;
            }
            else {
                i++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
