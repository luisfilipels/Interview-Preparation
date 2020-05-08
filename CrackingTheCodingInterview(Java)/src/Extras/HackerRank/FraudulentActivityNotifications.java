package Extras.HackerRank;

public class FraudulentActivityNotifications {

    static int findMedian (int [] count, int d, boolean findNext) {
        int daysToMedian = d/2;
        if (findNext) daysToMedian++;
        int i = 0;
        while (daysToMedian > 0) {
            if (count[i] == 0) {
                i++;
            } else {
                if (count[i] >= daysToMedian) {
                    return i;
                } else {
                    daysToMedian -= count[i];
                    i++;
                }
            }
        }
        return i;
    }

    static int activityNotifications (int[] expenditure, int d) {
        int [] count = new int[201];
        int left = 0, right = 0;

        for (right = 0; right < d; right++) {
            count[expenditure[right]]++;
        }

        int notifications = 0;

        while (right < expenditure.length) {
            int expenditureToday = expenditure[right];
            if (d % 2 == 0) {
                int num1 = findMedian(count, d, false);
                int num2 = findMedian(count, d, true);
                if (expenditureToday >= (num1 + num2)) {
                    notifications++;
                }
            } else {
                int num = findMedian(count, d, true);
                if (expenditureToday >= num * 2) {
                    notifications++;
                }
            }
            count[expenditure[left++]]--;
            count[expenditure[right++]]++;
        }

        return notifications;
    }

    public static void main(String[] args) {
        //int [] expenditures = new int[] {2,3,4,2,3,6,8,4,5};
        int [] expenditures = new int[] {1,2,3,4,4};
        System.out.println(activityNotifications(expenditures, 4));
    }

}
