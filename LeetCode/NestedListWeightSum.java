public class NestedListWeightSum {

    /*
    // Commented due to the NestedInteger class. This solution is correct.
    int helper(List<NestedInteger> list, int currentDepth) {
        int returnVal = 0;
        for (NestedInteger nI : list) {
            if (nI.isInteger()) {
                returnVal += currentDepth * nI.getInteger();
            } else {
                returnVal += helper(nI.getList(), currentDepth + 1);
            }
        }
        return returnVal;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }*/

}
