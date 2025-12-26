public class Singleton{

    public Singleton _instance;
    private Object _lock = new Object();

    private Singleton(){
        // private constructor to prevent instantiation
    }

//    public static Singleton getInstance() {
//        if (_instance == null) {
//            Lock(_lock) {
//                if (_instance == null) { // double-checked locking
//                    _instance = new Singleton();
//                }
//                return _instance;
//            }
//        }
//    }
}
