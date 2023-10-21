import java.util.Arrays;

public class MergeSort{

    public static int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }
        int middle =  array.length / 2;

        int[] rightHalf = mergeSort(Arrays.copyOfRange(array,0,middle));
        int[] leftHalf = mergeSort(Arrays.copyOfRange(array,middle ,array.length));

        return merge(rightHalf,leftHalf);
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf){
        int[] mergedArray = new int[firstHalf.length + secondHalf.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int merger = 0;
        while(firstPointer < firstHalf.length && secondPointer < secondHalf.length){
            if(firstHalf[firstPointer] < secondHalf[secondPointer]){
                mergedArray[merger] = firstHalf[firstPointer];
                firstPointer++;
            }
            else {
                mergedArray[merger] = secondHalf[secondPointer];
                secondPointer++;
            }
            merger++;
        }
        while( firstPointer < firstHalf.length){
            mergedArray[merger] = firstHalf[firstPointer];
            firstPointer++;
            merger++;
        }
        while( secondPointer < secondHalf.length){
            mergedArray[merger] = secondHalf[secondPointer];
            secondPointer++;
            merger++;
        }
        return mergedArray;
    }
}
