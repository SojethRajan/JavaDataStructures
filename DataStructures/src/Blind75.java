import javax.swing.plaf.synth.SynthUI;
import java.util.Arrays;
import java.util.HashMap;

public class Blind75 {


    public static void twoSum(int[] array, int target){
        /*Brute Force
        int[] result = new int[2];
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] + array[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;*/

        //HashMap
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            if(map.containsKey(Math.abs(target - array[i]))){
                ans[0] = i;
                ans[1] = map.get(target - array[i]);
                break;
            }
            else{
                map.put(array[i],i);
            }
        }

        System.out.println(Arrays.toString(ans));
    }
}
