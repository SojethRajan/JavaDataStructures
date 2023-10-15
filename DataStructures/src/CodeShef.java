import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class CodeShef{

    public static void run(int[] alice, int[] bob){
        int happinessCount = 0;
        for(int i = 0; i < alice.length; i++){
            if(alice[i] * 2 >= bob[i] && bob[i] * 2 >= alice[i]){
                happinessCount++;
            }
        }
        System.out.println(happinessCount);
    }

    public static void sumOfDistinct(int[] numbers){
        int firstLargest = numbers[0];
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > firstLargest){
                secondLargest = firstLargest;
                firstLargest = numbers[i];
            }
            else if(numbers[i] > secondLargest && numbers[i] != firstLargest){
                secondLargest = numbers[i];
            }
        }
        System.out.println(firstLargest + secondLargest);
    }

    public static void calculateMarketCost(int[] freshnessLevel, int[] items, int[] cost){
        int freshnessThreshold = freshnessLevel[1];
        int totalCost = 0;
        for(int i = 0; i < items.length; i++){
            if(items[i] >= freshnessThreshold){
                totalCost = totalCost + cost[i];
            }
        }
        System.out.println(totalCost);
    }

    public static void streakMaintaining(int[]om, int[] addy){
        int streakOm = 0;
        int streakAddy = 0;
        int tempOm = 0;
        int tempAddy = 0;
        int length = om.length;

        for(int i = 0; i < length; i++){
            if(om[i] != 0){
                tempOm = tempOm + 1;
            }
            else {
                tempOm = 0;
            }
            if(addy[i] != 0){
                tempAddy = tempAddy + 1;
            }
            else {
                tempAddy = 0;
            }
            streakOm = streakOm < tempOm ? tempOm : streakOm;
            streakAddy = streakAddy < tempAddy ? tempAddy : streakAddy;
        }

        System.out.println(streakOm + " " + streakAddy);
    }

    public static void decodeString(String s){
        for(int i = 0; i < s.length() - 1; i += 2){
            if(s.charAt(i) == '0' && s.charAt(i + 1) == '0'){
                System.out.print('A');
            }
            else if(s.charAt(i) == '0' && s.charAt(i + 1) == '1'){
                System.out.print('T');
            }
            else if(s.charAt(i) == '1' && s.charAt(i + 1) == '0'){
                System.out.print('C');
            }
            else if(s.charAt(i) == '1' && s.charAt(i + 1) == '1'){
                System.out.print('G');
            }
        }
    }

    public static void matchSubstitute(String first, String second){
        boolean flag = true;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                if(first.charAt(i) != '?' && second.charAt(i) != '?'){
                    flag = false;
                }
            }
        }
        System.out.println(flag);
    }

    public static void blobbyVolleyBall(String s){
        int aliceScore = 0;
        int bobScore = 0;
        char server = 'A';
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == server){
                if(server == 'A'){
                    aliceScore = aliceScore + 1;
                }
                else {
                    bobScore = bobScore + 1;
                }
            }
            server = s.charAt(i);
        }

        System.out.println(aliceScore + " " + bobScore);
    }

    private static ArrayList<String> subStringsVowels(String processed, String unProcessed, ArrayList<String> list){
        if(unProcessed.isEmpty()){
            return list;
        }
        char ch = unProcessed.charAt(0);
        if(ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u'){
            return subStringsVowels(processed + ch, unProcessed.substring(1),list);
        }
        else {
            list.add(processed);
           return subStringsVowels("", unProcessed.substring(1),list);
        }
    }
    public static void helper(String s){
        ArrayList<String> strings = subStringsVowels("", s, new ArrayList());
        int max = 0;
        String longestSubstring = "";
        for(String subStrings : strings){
            if(subStrings.length() > max){
                longestSubstring = subStrings;
            }
        }
        if(longestSubstring.length() > 2){
            System.out.println("HAPPY");
        }else {
            System.out.println("SAD");
        }
    }

    public static ArrayList subsets(int[] array){
        ArrayList<ArrayList> lists = new ArrayList();
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                lists.add(subSetsArray(array,i, j + 1));
            }
        }
        return lists;
    }
    private static ArrayList<Integer> subSetsArray(int[] array, int beginIndex, int endIndex){
        ArrayList<Integer> arraySliced = new ArrayList<Integer>();
        for(int i = beginIndex; i < endIndex; i++){
            arraySliced.add(array[i]);
        }
        return arraySliced;
    }
}
