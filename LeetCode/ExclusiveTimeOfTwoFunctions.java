import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfTwoFunctions {

    static public int[] exclusiveTime(int n, List<String> logs) {
        int [] returnList = new int[n];

        Stack<Integer> stack = new Stack<>();

        int lastTime = -1;

        for (String log : logs) {
            String[] data = log.split(":");
            int id = Integer.parseInt(data[0]);
            String oper = data[1];
            int time = Integer.parseInt(data[2]);

            if (oper.equals("start")) {
                if (!stack.isEmpty()) {
                    returnList[stack.peek()] += time - lastTime;
                }
                stack.push(id);
                lastTime = time;
            } else {
                int current = stack.pop();
                returnList[current] += time - lastTime + 1;
                lastTime = time + 1;
            }
        }

        return returnList;
    }
    /*

             |-----|-----|
        |----|           |----|
        0    2     5     6    7

        []
    */

    public static void main(String[] args) {
        String[] opers = new String[] {
                //"0:start:0","1:start:2","1:end:5","0:end:6"
                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"
        };

        System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList(opers))));
    }

}
