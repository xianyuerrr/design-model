import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        System.out.println("start");
        // objList = strList;
        System.out.println("end");

        int[] arr = {100, 101, 102};

        OUTER:
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 1) {
                    break OUTER;
                } else {
                    System.out.println("A");
                }
            }
            System.out.println("B");
        }
        System.out.println("C");
    }
}
