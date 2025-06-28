import java.util.ArrayList;
import java.util.Arrays;

public class Permutations{

    public static void subSets(String processed, String unProcessed){

        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subSets(processed + ch,unProcessed.substring(1));
        subSets(processed,unProcessed.substring(1));
    }

    public static void possibleSequence(String processed, String unProcessed){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++){
            String prefix = processed.substring(0,i);
            String suffix = processed.substring(i);
            possibleSequence(prefix + ch + suffix,unProcessed.substring(1));
        }
    }

    public static void subSetsArray(String p, int[] up){
        if(up.length == 0){
            System.out.println(p);
            return;
        }
        int number = up[0];
        subSetsArray(p + number, Arrays.copyOfRange(up,1,up.length));
        subSetsArray(p , Arrays.copyOfRange(up,1,up.length));
    }

    public static void possibleSequenceArray(String p, int[] up){
        if(up.length == 0){
            System.out.println(p);
            return;
        }
        int number = up[0];
        for(int i = 0; i <= p.length(); i++){
            String prefix = p.substring(0,i);
            String suffix = p.substring(i);
            possibleSequenceArray(prefix + number + suffix,Arrays.copyOfRange(up,1,up.length));
        }
    }
}
