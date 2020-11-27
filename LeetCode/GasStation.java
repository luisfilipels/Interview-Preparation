public class GasStation {

    private static int canCompleteCircuit (int[] gas, int[] cost) {
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }

        if (total < 0) return -1;

        int startIndex = -1;
        int runningFuel = 0;
        for (int run = 0; run < gas.length; run++) {
            runningFuel += gas[run] - cost[run];
            if (runningFuel >= 0) {
                if (startIndex == -1) {
                    startIndex = run;
                }
            } else {
                runningFuel = 0;
                startIndex = -1;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {
        int [] gas = new int[] {3, 0, 0, 1, 0, 2};
        int [] cost = new int[]{0, 2, 2, 0, 2, 0};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
