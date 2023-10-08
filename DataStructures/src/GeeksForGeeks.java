public class GeeksForGeeks{

    public static void countFrequencies(int[] numbers){
        boolean[] visited = new boolean[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            if(visited[i]){
                continue;
            }
            int count = 0;
            for(int j = i; j < numbers.length; j++){
                if(numbers[i] == numbers[j]){
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(numbers[i] + " " + count );
        }
    }
}
