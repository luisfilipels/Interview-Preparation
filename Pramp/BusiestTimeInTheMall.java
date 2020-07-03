package Extras.Pramp;

import java.util.Arrays;

public class BusiestTimeInTheMall {

    /*
    data =     [ [1487799425, 14, 1],
                 [1487799425, 4,  0],
                 [1487799425, 2,  0],
                 [1487800378, 10, 1],
                 [1487801478, 18, 0],
                 [1487801478, 18, 1],
                 [1487901013, 1,  0],
                 [1487901211, 7,  1],
                 [1487901211, 7,  0] ]

                 answer = 1487799425
                 maxPeople = 14

                 currentPeople = 14
                 lastTimestamp = 1487799425

                 i = 1;
                 data[1][0] = 1487799425 equals
                 cP = cP - 4 = 10

                 i = 2;
                 cp = 8;

                 i = 3;
                 ltst = 1487799425
                 data[3][0] = 1487800378

                 8 > 14 ?

                 ltst = data[3][0] = 1487800378
                 cP = 1

                 i = 4;


     */

    static int findBusiestPeriod (int[][] data) {
        int n = data.length;
        int count = 0;
        int maxCount = 0;
        int maxPeriodTime = 0;

        for (int i = 0; i < n; i++) {
            if (data[i][2] == 1) {
                count += data[i][1];
            } else {
                count -= data[i][1];
            }

            if (i < n-1 && data[i][0] == data[i+1][0]) continue;

            if (count > maxCount) {
                maxPeriodTime = data[i][0];
                maxCount = count;
            }
        }

        /*for (int i = 0; i < n; i++) {
            if (i != 0) {
                if (data[i][0] != data[i-1][0]) { // different timestamps
                    if (count > maxCount) {
                        maxPeriodTime = data[i-1][0];
                        maxCount = count;
                    }
                    count = 0;
                }
                if (data[i][2] == 1) {
                    count += data[i][1];
                } else {
                    count -= data[i][1];
                }
            } else {
                if (data[i][2] == 1) {
                    count += data[i][1];
                } else {
                    count -= data[i][1];
                }
            }
        }*/
        return maxPeriodTime;
    }

    /*static int findBusiestPeriod (int[][] data) {
        int n = data.length;
        int count = 0;
        int maxCount = 0;
        int maxPeriodTime = 0;

        for (int i = 0; i < n; i++) {
            if (data[i][2] == 1 ) {
                count += data[i][1];
            } else {
                count -= data[i][1];
            }

            if (i < n-1 && data[i][0] == data[i+1][0]) continue;

            if (count > maxCount) {
                maxCount = count;
                maxPeriodTime = data[i][0];
            }
        }
        return maxPeriodTime;
    }*/

    public static void main(String[] args) {
        /*int[][] input = new int[][] {
                {1, 14, 1},
                {1, 4, 0},
                {1, 2, 0},
                {2, 10, 1},
                {3, 18, 0},
                {3, 18, 1},
                {4, 1, 0},
                {5, 7, 1},
                {5, 7, 0}
        };*/

        /*int [][] input = new int[][] {
                {1487799425,14,1},
                {1487799425,4,0},
                {1487799425,2,0},
                {1487800378,10,1},
                {1487801478,18,0},
                {1487801478,18,1},
                {1487901013,1,0},
                {1487901211,7,1},
                {1487901211,7,0}
        };*/

        int [][] input = new int[][] {
                {1487799425,8,1},
                {1487800378,10,1},
                {1487801478,0,1},
                {1487901013,1,0},
                {1487901211,0,1},
        };

        System.out.println(findBusiestPeriod(input));
    }

}
