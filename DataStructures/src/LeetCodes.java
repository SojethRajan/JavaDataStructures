import com.sun.source.tree.Tree;

import javax.management.ObjectName;
import java.util.*;

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

    public static void rotateArrayLeftKTimes(int[] array, int k){
        if( k > array.length){
            k = k % array.length;
        }
        rotateArray(array,0,array.length - 1);
        rotateArray(array,0,k - 1);
        rotateArray(array,k,array.length - 1 );

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

    public boolean check(int[] nums) {
        if(nums.length < 3){
            return true;
        }
        int rotate = smallest(nums);
        reverse(nums,rotate,nums.length - 1);
        reverse(nums,0,rotate - 1);

        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                return false;
            }
        }
        return true;

    }
    public int smallest(int[] array){
        int smallest = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] <= array[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }
    public void reverse(int[] array, int start, int stop){
        for(int i = start; i <= stop; i++){
            int temp = array[i];
            array[i] = array[stop];
            array[stop] = temp;
            stop--;
        }
    }

    public int removeDuplicates(int[] numbers) {
        int i = 0;
        int j = 0;
        while( j < numbers.length){
            if(numbers[i] == numbers[j]){
                j++;
            }
            else {
                i++;
                numbers[i] = numbers[j];
                j++;
            }
        }
        return i + 1;
    }

    public int missingNumber(int[] array) {
        TreeMap<Integer,Integer> maps = new TreeMap<>();
        for(int i = 0; i < array.length; i++){
            if(maps.containsKey(array[i])){
                maps.put(array[i], maps.get(array[i]) + 1);
            }
            else {
                maps.put(array[i], 1);
            }
        }
        int i = 0;
        for(Map.Entry entry : maps.entrySet()){
            if(i != (Integer) entry.getKey()){
                return i;
            }
            i++;
        }
        return array.length;
    }

    public void findMaxConsecutiveOnes(int[] array) {
        int pointerOne = 0;
        int pointerTwo = 0;
        int max = 0;
        int count = 0;
        /*while(pointerOne < array.length){
            while(pointerOne < array.length && array[pointerOne] != 1){
                pointerOne++;
                pointerTwo++;
            }

            while(pointerTwo < array.length && array[pointerTwo] == 1){
                pointerTwo++;
            }
            if(pointerTwo < array.length || pointerOne < array.length){
                int consecutive = pointerTwo - pointerOne;
                if(max < consecutive){
                    max = consecutive;
                }
                pointerOne = pointerTwo;
            }
        }
        System.out.println(max);*/


        for(int i = 0; i < array.length; i++){
            if(array[i] == 1){
                count++;
            }
            else {
                max = (count > max) ? count : max;
                count = 0;
            }
        }
        max = (count > max) ? count : max;
        System.out.println(max);
    }

    public int singleNumber(int[] numbers) {
        HashMap<Integer,Integer> maps = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            if(maps.containsKey(numbers[i])){
                maps.put(numbers[i], maps.get(numbers[i]) + 1);
            }
            else {
                maps.put(numbers[i], 1);
            }
        }

        int expectedValue = 1;
        for(Map.Entry entries : maps.entrySet()){
            if(expectedValue == (Integer) entries.getValue()){
                return (Integer) entries.getKey();
            }
        }
        return -1;
    }

    public String largestOddNumber(String num) {
        for(int i = num.length() - 1; i >= 0; i--){
            int number = num.charAt(i) - '0';
            if(number % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
