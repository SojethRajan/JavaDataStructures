public class Singleton{

    public static int count = 0;

    public Singleton(){

        count++;
        if(count > 1){
            return;
        }
    }


}
