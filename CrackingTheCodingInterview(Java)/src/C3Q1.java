public class C3Q1 {

    /*
        This is a theoretical question! (at least in part)

        A simple, quite trivial implementation of this question would be achieved by modifying C3Stack.ArrayStack with
        3 variables to control the start and end of each stack, dedicating, say, 1/3 of the array to stack 1, 1/3 to stack 2
        and so on. If each stack won't grow, this would probably be quite simple to implement.

               |-----------------------------------------------------------------------------------|
               |.........................|.............................|...........................|
                 h1                      maxHead1       h2           maxHead2           h3     maxHead3
                      Stack 1                     Stack 2                       Stack 3

        Another solution, albeit more complex, would be to also modify C3Stack.ArrayStack as before, but allowing each stack
        to grow. If one of the stacks exceeds maxHead(n) in size, another array would be created with twice (or 4/3?) the previous
        size.

        TODO Implement one of the above!

     */

}
