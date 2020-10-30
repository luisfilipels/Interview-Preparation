import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        Stack<List<NestedInteger>> nestedIntStack = new Stack<>();
        Stack<Integer> currentIndexStack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            currentIndexStack.push(0);
            nestedIntStack.push(nestedList);
        }

        /*

         */
        @Override
        public Integer next() {
            if (nestedIntStack.peek().isEmpty()) {
                nestedIntStack.pop();
                currentIndexStack.pop();
                return null;
            }
            List<NestedInteger> nestedIntList = nestedIntStack.peek();
            int currentIndex = currentIndexStack.peek();
            if (currentIndex < nestedIntList.size()) {
                currentIndexStack.pop();
                currentIndexStack.push(currentIndex+1);
                if (nestedIntList.get(currentIndex).isInteger()) {
                    return nestedIntList.get(currentIndex).getInteger();
                } else {
                    nestedIntStack.push(nestedIntList.get(currentIndex).getList());
                    currentIndexStack.push(0);
                    return next();
                }
            } else {
                nestedIntStack.pop();
                currentIndexStack.pop();
                return next();
            }
        }

        /*
        This function has serves more than one purpose.
        The first and main purpose it has is to, of course, check if we can still iterate through the items.
        The second purpose it has is to move the index of the current stack level out of empty lists.
        So, if we have the following list:

        [ [ [],[] ], 1 ]

        We will enter the first level of the list, that contains  [ [],[] ], but before we do so, we push
        into the previous index stack, the index we had +1, so that when we come back to this level of the stack,
        we will be at the number 1. Now, our current level contains [],[]. We will enter the first sublist (once again,
        moving the index at our current to the right, so we are at [] when we come back to this level. Now, our list
        contains [], so we just pop the stack. Now, our list once again is []. We push [] onto the stack again,
        which makes us pop the stack once again due to the list being empty. Now, we have gone through all the sublevels
        of [ [],[] ], and when we pop the stack once again, our index will be at element 1, which will allow us to finallly
        return true.

         */
        @Override
        public boolean hasNext() {
            if (nestedIntStack.isEmpty() || (nestedIntStack.size() == 1 && currentIndexStack.peek() >= nestedIntStack.peek().size())) {
                return false;
            }

            List<NestedInteger> nestedIntList = nestedIntStack.peek();
            int currentIndex = currentIndexStack.peek();

            if (nestedIntList.isEmpty()) {
                nestedIntStack.pop();
                currentIndexStack.pop();

                return hasNext();
            } else {
                if (currentIndex < nestedIntList.size()) {
                    if (nestedIntList.get(currentIndex).isInteger()) {
                        return true;
                    } else {
                        int tmp = currentIndexStack.pop();
                        currentIndexStack.push(tmp+1);

                        nestedIntStack.push(nestedIntList.get(currentIndex).getList());
                        currentIndexStack.push(0);
                        return hasNext();
                    }
                }
                else {
                    nestedIntStack.pop();
                    currentIndexStack.pop();
                    return hasNext();
                }
            }
        }
    }

    // The following solution is accepted by LeetCode, however, it is entirely wrong, as it is not actually
    // implementing an iterator of NestedInteger. It's iterating over the numberList;
    /*
    public class NestedIterator implements Iterator<Integer> {
        List<Integer> numberList;
        int idx = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.numberList = new ArrayList<>();
            for (NestedInteger in : nestedList) {
                flattenList(in);
            }
        }

        void flattenList(NestedInteger integer) {
            if (integer.isInteger()) {
                numberList.add(integer.getInteger());
            } else {
                for (NestedInteger nI : integer.getList()) {
                    flattenList(nI);
                }
            }
        }

        @Override
        public Integer next() {
            return numberList.get(idx++);
        }

        @Override
        public boolean hasNext() {
            if (idx < numberList.size()) return true;
            return false;
        }
    }*/



}
