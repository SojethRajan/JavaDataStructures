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
    public static boolean isSmaller(String one, String two){
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
}
