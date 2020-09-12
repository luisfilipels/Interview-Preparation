import java.util.ArrayList;
import java.util.HashSet;

public class C8Q12 {
    /*
    For each position in the board, we can either include a queen there, or not. However, given the constraints
    of the problem, we need to be a bit more strategic here. First, as obvious as it is, notice that if no two
    queens can share the same row, then we can only have one queen per row, the same goes for columns. If no two
    queens can be in the same row, then once we add a queen in a particular row, we can move on to the next row
    immediately. But how can we solve this for columns? Well, we could, before inserting a queen, manually iterate
    through its column to check for other queens, but we can also, as we add queens, remember that a particular
    column is already occupied using a HashSet. Now what about diagonals? Let's start with the main diagonal.
    Observe the following example, in a 5x5 board, with 5 queens.

         01234 -> Column numbers
        0...Q.
        1.Q...
        2..Q..
        3....Q
        4Q....
        ^
     Rows

    Looking at queens (1,1) and (2,2), we can visually check that they are in the same diagonal. However, we can
    also notice that 1-1 == 2-2 == 0. Is this valid for other diagonals?

         01234 -> Column numbers
        0...Q.
        1....Q
        2..Q..
        3Q....
        4.Q...
        ^
     Rows

    Notice that for the queens at (0,3) and (1,4), 3-0 == 4-1 == 3. You can try this with other cases, but you'll
    see that, in all cases, two queens are in the same left-to-right diagonal if the subtraction of each respective
    queen's column and row (or vice-versa) is the same. Thus, we can also store this information in a HashSet and
    use to check if two queens are sharing the same diagonal in O(1) time. But what about right-to-left diagonals?

         01234 -> Column numbers
        0...Q.
        1.Q...
        2..Q..
        3....Q
        4Q....
        ^
     Rows

     Looking at queens (4,0) and (2,2), we see that 4-0 != 2-2. What now? Well, if we were to suddenly flip the board
     horizontally, we'd see that the queens would be in the positions (4,4) and (2,2), and if we use the same observation
     that we did before, we can also store this information in a HashSet after converting the coordinates from a normal
     board, to that of that same board, but inverted horizontally! Notice that in the normal board or on the inverted
     board, the rows of each queen remain unchanged. But what about the columns? We can just get the complement! So, if
     a board is 8x8, and we have a queen at column 3, we can do 7-3=4 to get the equivalent column number in the inverted
     board (7 because our columns are 0-indexed).

     Using these rules to remember which columns, rows and diagonals we can or cannot insert a queen onto, and by recursively
     adding one queen at each possible column in a row (and doing so for each row), we can arrive at the following algorithm:

     function queensByRow
     input:
        returnList: a list in which each element is an 8x8 board with 8 queens in each, satisfying the question's constraints
        currentGrid: a board (represented by a string in which each line is a row in the board), as it's been built so far
        currLine: an integer representing the current row in the board we are adding a queen into
        busyCols: a HashSet, in which if an integer X is inside the set, then that means column X already has a queen in it
        busyMainDiags: same as above, but for left-to-right diagonals
        busySecDiags: same as above, but for right-to-left diagonals.
     start:
        if currLine == 8:    // Base case
            add currentGrid to returnList, return and stop
        for each currColumn, from 0 to 7 inclusive:
            if currColumn is not in busyCols and c-currLine is not in busyMainDiags and (7-c)-currLine is not in busySecDiags:
                add a new row onto the board, with a queen at column currColumn
                add currColumn into busyCols, c-currLine into busyMainDiags and 7-c-currLine into busySecDiags
                recursively call queensByRow with returnList, the board with the new row, and the hashsets with their new values
        return and stop

     */

    static ArrayList<String> eightQueens() {
        ArrayList<String> returnSet = new ArrayList<>();
        queensByRow(returnSet, new StringBuilder(), 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return returnSet;
    }

    static void queensByRow(ArrayList<String> returnList, StringBuilder currentGrid, int currentLine,
                            HashSet<Integer> busyCols, HashSet<Integer> busyMainDiags,
                            HashSet<Integer> busySecDiags) {
        if (currentLine == 8) {
            returnList.add(currentGrid.toString());
            return;
        }
        for (int c = 0; c < 8; c++) {
            if (!busyCols.contains(c) && !busyMainDiags.contains(c - currentLine) && !busySecDiags.contains((7 - c) - currentLine)) {
                StringBuilder newStr = new StringBuilder(currentGrid);
                for (int i = 0; i < 8; i++) {
                    if (i != c) {
                        newStr.append(". ");
                    } else {
                        newStr.append("O ");
                    }
                }
                newStr.append("\n");
                HashSet<Integer> newBusyCols = new HashSet<>(busyCols);
                newBusyCols.add(c);
                HashSet<Integer> newBusyMainDiags = new HashSet<>(busyMainDiags);
                newBusyMainDiags.add(c - currentLine);
                HashSet<Integer> newBusySecDiags = new HashSet<>(busySecDiags);
                newBusySecDiags.add((7 - c) - currentLine);
                queensByRow(returnList, newStr, currentLine+1, newBusyCols, newBusyMainDiags, newBusySecDiags);
            }
        }
    }

    public static void main(String[] args) {
        var result = eightQueens();
        for (String s : result) {
            System.out.println(s);
            System.out.println();
        }
        System.out.println(result.size());
    }

}
