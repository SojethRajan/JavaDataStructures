import java.util.*;

public class  HashingMaps{

    public static void countFrequenciesOfEachElement(int[] numbers){

        int[] hashArray = new int[11];
        boolean[] visited = new boolean[hashArray.length];
        for(int i = 0; i < numbers.length; i++){
            int element = numbers[i];
            hashArray[element] += 1;
        }

        for(int i = 0; i < numbers.length; i++){
            if(visited[numbers[i]]){
                continue;
            }
            int element = numbers[i];
            visited[element] = true;
            System.out.println(hashArray[element]);
        }
    }

    public static int[] countFrequency(int x, int max, int[] numbers){
        int[] hashArray = new int[max + 1];
        int[] answer = new int[x];

        for(int i = 0; i < numbers.length; i++){
            int element = numbers[i];
            hashArray[element] += 1;
        }
        ArrayList<Integer> list = arraySlicer(hashArray,max);
        for(int i = 0; i < numbers.length ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    private static ArrayList<Integer> arraySlicer(int[] array, int end){
        ArrayList<Integer> slicedArray = new ArrayList<>();
        for(int i = 1; i <= end; i++){
            slicedArray.add(array[i]);
        }
        return slicedArray;
    }

    public static void countFrequencyOfCharString(String word, char find){
        word = word.toLowerCase();
        int[] hashArray = new int[26];
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            hashArray[ch - 97] += 1;
        }

        System.out.println(hashArray[find - 97]);
    }

    public static void countUsingHashMaps(int[] array){
        HashMap<Integer,Integer> maps = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(maps.containsKey(array[i])){
                maps.put(array[i],maps.get(array[i]) + 1);
            }
            else {
                maps.put(array[i] , 1);
            }
        }

        for (HashMap.Entry entry : maps.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

    }


}
