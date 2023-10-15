import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodes{
    public static void sortStringArray(String[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 1; j < array.length - i; j++){
                if(isSmaller(array[j],array[j - 1])){
                    String temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static boolean isSmaller(String one, String two){
        String smallerWord = one.length() > two.length() ? two : one;
        int index = 0;
        while(index < smallerWord.length()){
            char charOne = one.charAt(index);
            char charTwo = two.charAt(index);
            if(charTwo < charOne){
                return true;
            }
            index++;
        }
        return false;
    }

    public static void rotateArrayKTimes(int[] array, int k){
        k = k % array.length;
        rotateArray(array,0,array.length - 1);
        rotateArray(array,0,k - 1);
        rotateArray(array,k,array.length - 1);

        System.out.println(Arrays.toString(array));

    }
    public static void rotateArray(int[] array, int start, int end){
        for(int i = start; i < end; i++){
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;
            end--;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int search(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while(start <= end ){
            int middle = ((start + end) / 2);

            if(numbers[middle] == target){
                return middle;
            }
            else if(numbers[middle] > target){
                end = middle - 1;
            }
            else if(numbers[middle] < target){
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void longestSubArrayWithSum(int[] a, int k) {
        ArrayList<ArrayList> subSets = CodeShef.subsets(a);
        ArrayList<ArrayList> subSetsWthSum = new ArrayList<>();
        for(int i = 0; i < subSets.size(); i++){
            int sum = 0;
            for(int j = 0; j < subSets.get(i).size(); j++){
                sum = sum +  (Integer)subSets.get(i).get(j);
                if(sum > k){
                    break;
                }
            }
            if(sum == k){
                subSetsWthSum.add(subSets.get(i));
            }
        }

        int max = 0;
        for(int i = 0; i < subSetsWthSum.size(); i++){
            if(subSetsWthSum.get(i).size() > max){
                max = subSetsWthSum.get(i).size();
            }
        }
        System.out.println(max);
    }

    public static boolean isPalindrome(String s){
        String str = s.toLowerCase();
        if(str.isEmpty() || str.length() == 1){
            return true;
        }

        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);

        boolean firstCharValid = (firstChar >= 'a' && firstChar <= 'z' || firstChar >= '0' && firstChar <= '9');
        boolean lastCharValid = (lastChar >= 'a' && lastChar <= 'z' || lastChar >= '0' && lastChar <= '9');

        if(firstCharValid && lastCharValid){
            if(str.charAt(0) != str.charAt(str.length() - 1)){
                return false;
            }
        }
        if(!firstCharValid){
            return isPalindrome(str.substring(1));
        }
        else if(!lastCharValid){
            return isPalindrome(str.substring(0, str.length() - 1));
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }
}
