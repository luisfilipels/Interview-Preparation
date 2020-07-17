import java.security.InvalidParameterException;
import java.util.EmptyStackException;

public class C3Q1 {

    /*
        This is a theoretical question! (at least in part)

        A simple, quite trivial implementation of this question would be achieved by using, in the array,
        3 variables to control the start and end of each stack, dedicating, say, 1/3 of the array to stack 1, 1/3 to stack 2
        and so on. If each stack won't grow, this would probably be quite simple to implement.

               |-----------------------------------------------------------------------------------|
               |.........................|.............................|...........................|
                 h1                      maxHead1       h2           maxHead2           h3     maxHead3
                      Stack 1                     Stack 2                       Stack 3

        Another solution, albeit more complex, would be allowing each stack to grow. If one of the stacks exceeds
        maxHead(n) in size, another array would be created with twice (or 4/3?) the previous size.

        Below we have the implementation of the latter case.

     */

    static class ThreeStacks {
        int [] array;

        int[] arrStr = new int[3];
        int[] arrEnd = new int[3];
        int[] arrPtr = new int[3];

        int[] size = new int[3];

        ThreeStacks() {
            int individualSize = 2;

            array = new int[individualSize * 3];
            size[0] = individualSize;
            size[1] = individualSize;
            size[2] = individualSize;

            arrStr[0] = 0;
            arrEnd[0] = individualSize-1;
            arrPtr[0] = 0;

            arrStr[1] = individualSize;
            arrEnd[1] = (individualSize * 2)-1;
            arrPtr[1] = arrStr[1];

            arrStr[2] = individualSize * 2;
            arrEnd[2] = (individualSize * 3)-1;
            arrPtr[2] = arrStr[2];
        }

        void push(int stack, int x) {
            if (stack < 0 || stack >= 3) return;

            if (arrPtr[stack] == arrEnd[stack]) {
                int currentSize = array.length;
                int sizeIncrement = size[stack];
                size[stack] *= 2;
                int [] newArr = new int[currentSize+sizeIncrement];

                switch (stack) {
                    case 0:
                        for (int i = arrStr[1]; i <= arrEnd[1]; i++) {
                            newArr[i + sizeIncrement] = array[i];
                        }
                        for (int i = arrStr[2]; i <= arrEnd[2]; i++) {
                            newArr[i + sizeIncrement] = array[i];
                        }
                        for (int i = arrStr[0]; i <= arrEnd[0]; i++) {
                            newArr[i] = array[i];
                        }

                        arrEnd[0] += sizeIncrement;
                        arrStr[1] += sizeIncrement;
                        arrEnd[1] += sizeIncrement;
                        arrStr[2] += sizeIncrement;
                        arrEnd[2] += sizeIncrement;

                        arrPtr[1] += sizeIncrement;
                        arrPtr[2] += sizeIncrement;
                        break;
                    case 1:
                        for (int i = arrStr[2]; i <= arrEnd[2]; i++) {
                            newArr[i + sizeIncrement] = array[i];
                        }
                        for (int i = arrStr[1]; i <= arrEnd[1]; i++) {
                            newArr[i] = array[i];
                        }
                        for (int i = arrStr[0]; i <= arrEnd[0]; i++) {
                            newArr[i] = array[i];
                        }

                        arrEnd[1] += sizeIncrement;
                        arrStr[2] += sizeIncrement;
                        arrEnd[2] += sizeIncrement;

                        arrPtr[2] += sizeIncrement;
                        break;
                    case 2:
                        for (int i = 0; i < array.length; i++) {
                            newArr[i] = array[i];
                        }
                        arrEnd[2] += sizeIncrement;
                }
                array = newArr;
            }

            array[arrPtr[stack]] = x;
            arrPtr[stack]++;
        }

        int pop(int stack) {
            if (stack < 0 || stack >= 3) throw new InvalidParameterException();

            if (arrPtr[stack] == arrStr[stack]) throw new EmptyStackException();

            arrPtr[stack]--;

            return array[arrPtr[stack]];
        }
    }

    public static void main(String[] args) {
        ThreeStacks stacks = new ThreeStacks();
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(1, 10);
        stacks.push(2, 10);
        stacks.push(1, 11);
        stacks.push(2, 12);
        stacks.push(0, 4);
        stacks.push(1, 12);
        stacks.push(1, 13);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
    }

}
