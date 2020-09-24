import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private static List<String> fizzBuzz (int n) {
        List<String> returnList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            if (i % 3 == 0) current.append("Fizz");
            if (i % 5 == 0) current.append("Buzz");
            if (current.toString().equals("")) current.append(i);
            returnList.add(current.toString());
        }
        return returnList;
    }

    private static List<String> fizzBuzz2 (int n) {
        List<String> returnList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                returnList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                returnList.add("Fizz");
            } else if (i % 5 == 0) {
                returnList.add("Buzz");
            } else {
                returnList.add(Integer.toString(i));
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

}
