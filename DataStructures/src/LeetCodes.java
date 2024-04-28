import com.sun.source.tree.Tree;

import javax.management.ObjectName;
import java.util.*;

public class LeetCodes{
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
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

    public boolean rotateString(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        String joined = goal + goal;
        int firstPointer = 0;
        int secondPointer = 0;

        if(joined.contains(s)){
            return true;
        }
        return false;
        /*while(secondPointer < joined.length()){
            if(s.charAt(firstPointer) == joined.charAt(secondPointer)){
                firstPointer++;
                secondPointer++;
                if(firstPointer == s.length()){
                    return true;
                }
            }
            else {
                if(firstPointer != 0){
                    firstPointer = 0; //resetting
                }
                else {
                    secondPointer++;
                }
            }
        }
        return false;*/
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sourceMap = new int[26];
        int[] targetMap = new int[26];

        for(int i = 0; i < s.length(); i++){
            int indexSource = s.charAt(i) - 'a';
            int indexTarget = t.charAt(i) - 'a';
            sourceMap[indexSource] += 1;
            targetMap[indexTarget] += 1;
        }

        for(int i = 0; i < sourceMap.length; i++){
            if(sourceMap[i] != targetMap[i]){
                return false;
            }
        };
        return true;
    }

    public void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros++;
            } else if(nums[i] == 1){
                ones++;
            } else{
                twos++;
            }
        }
        fillers(nums,zeros,0,0);
        fillers(nums,ones,zeros,1);
        fillers(nums,twos,ones + zeros,2);

        System.out.println(Arrays.toString(nums));
    }
    public void fillers(int[] nums, int count, int index, int number){
        while(count > 0){
            nums[index] = number;
            index++;
            count--;
        }
    }

    public void countCharacters(String s){
        int count = 1;
        for(int i = 0;  i < s.length()  - 1; i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                while(s.charAt(i) == s.charAt(i + 1)){
                    count++;
                    i++;
                    if( i == s.length() - 1){
                        break;
                    }
                }
                if(count > 1){
                    System.out.println(s.charAt(i) + " " + count);
                    count = 1;
                }
            }
        }
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> maps = new HashMap();
        for(int i = 0; i < nums.length ; i++){
            if(maps.containsKey(nums[i])){
                maps.put(nums[i],maps.get(nums[i]) + 1);
            }
            else {
                maps.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : maps.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = {0,1};
        if(nums.length == 2){
            return ans;
        }
        HashMap<Integer, Integer> maps = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int required = target - nums[i];
            if(maps.containsKey(required)){
                ans[0] = maps.get(required);
                ans[1] = i;
                break;
            }
            maps.put(nums[i],i);
        }
        return ans;
    }

    public static String reverseOnlyFirstWordButNotFirstLetter(String s){
        String firstWord = "" + (s.split(" ")[0]);
        String rev = "" + firstWord.charAt(0);
        for(int i = firstWord.length() - 1; i >= 1; i--){
            rev += (s.charAt(i));
        }
        rev += s.substring(rev.length());
        int a = 0;
        return rev;
    }

    public int[] rearrangeArray(int[] nums) {
        Stack<Integer> positives = new Stack<Integer>();
        Stack<Integer> negatives = new Stack<Integer>();
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < 0){
                negatives.push(nums[i]);
            }
            else {
                positives.push(nums[i]);
            }
        }
        for(int i = 0; i < ans.length; i++){
            if(i % 2 == 0){
                ans[i] = positives.pop();
            }
            else {
                ans[i] = negatives.pop();
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int potentialStart = 0;
        int end = 0;
        int sum = 0;
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum > maxSum){
                maxSum = sum;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                potentialStart = i;
            }
            if(potentialStart <= end){
                start = potentialStart;
            }
        }

        if(start == end){
            s = 0;
        }else {
            s = start + 1;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, s, end + 1)));
        return maxSum;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if((prices[i] - min) >= profit){
                profit = prices[i] - min;
            }
        }
        System.out.println(profit);
        return profit;
    }

    public void nextPermutation(int[] nums){
        int dipIndex = -1;
        int nextGreaterIndex = 0;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                dipIndex = i - 1;
                break;
            }
        }
        if(dipIndex != -1){
            for(int i = nums.length - 1; i > dipIndex; i--){
                if(nums[i] > nums[dipIndex]){
                    nextGreaterIndex = i;
                    break;
                }
            }
            int temp = nums[dipIndex];
            nums[dipIndex] = nums[nextGreaterIndex];
            nums[nextGreaterIndex] = temp;

            reverseHelper(nums,dipIndex + 1, nums.length - 1);
        }
        else {
            reverseHelper(nums,0,nums.length - 1);
        }

    }
    private void reverseHelper(int[] array, int start, int stop){
        for(int i = start; i <= stop; i++){
            int temp = array[i];
            array[i] = array[stop];
            array[stop] = temp;
            stop--;
        }
    }
}
