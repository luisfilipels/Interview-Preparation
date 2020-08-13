import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class C4Q11 {

    /*
     Since we are creating this binary tree from scratch, it may be reasonable
     to keep a parent pointer in each node, as well as the count of children to the
     left of a particular node, and likewise towards the right. Why can this information be
     of use?
     Consider the following tree:

                                              1
                                             /
                                            2

    Considering we have only two nodes, and the questions asks for the probability of choosing
    any node to be the same for all nodes, we can say that each node should have a 50% chance of
    being selected. What if we added a node to the right of node 1? In this case, every node should
    have a 33% chance of being selected, likewise if we added a node to the left or right of node 2.
    Thus, the probability of choosing any particular node should be 1/<amount of nodes in the tree>.
    For the case above, it's trivial to say that the probability of choosing node 1 should be of 50%,
    and the probability of going to the left subtree should be of 50% as well. But what if we had the
    following tree?

                                             1
                                           /   \
                                          2     3
                                         /
                                        4

    Starting on node 1, and given what we have said above, the probability of choosing it should be
    of 25% (1/4). Given the right subtree only has 1 node, the probability of choosing to go to it
    should be of 25% as well. But what about the probability of going to the left subtree? At first
    glance, it's possible to assume that the probability of doing so should also be of 25%, as we
    are going to node 2 (that is, of course, just one node). However, this assumption is wrong for the
    following reason:

    The math simply does not add up. If, starting at node 1 (meaning we are only aware of the
    existence of node 1 and its children), the chance of choosing nodes 1, 2 or 3 is of 25% for each,
    then we have only a 75% of choosing any one of these three nodes, given that we are at node 1.
    What happened to the remaining 25% needed to complete 100%?

    So, what can we do to solve this incongruency? Well, if we randomly choose to go to the left subtree
    of node 1, we will reach node 2. Given that we are at node 2, and this node only has one other node on
    its left subtree, and 0 on the right, there should be a 50% probability of choosing node 2, and 50% of
    choosing node 4 (however, when we consider the entire tree rooted at 1, both of these nodes should have
    a 25% chance of being selected). How should this fact reflect on the probability of choosing the left
    subtree of node 1? Well, considering node 1 has 2 nodes to its left subtree, and 1 to its right, if we
    have a 50% chance of choosing the left subtree of node 1 (25% + 25%, due to its 2 nodes), 25% of choosing
    node 1 itself, and 25% of going to the right subtree, we reach a sum of 100%! And, if we move to the left
    subtree (that has only 2 nodes), there should be a 50% chance of selecting node 2, and 50% of choosing
    node 4, which also adds up to 50%. And if we once again go to the left subtree of 2, reaching node 4,
    logically there should be a 100% chance of selecting it, as it's a leaf. From this, we can derive the
    following algorithm to select a random node:

        if currentNode is leaf, return currentNode
        set the probability of choosing currentNode to 1 / <amount of nodes in this subtree>
        set the probability of choosing leftSubtree to <nodes in left> / <amount of nodes in this subtree>
        set the probability of choosing rightSubtree to <nodes in right> / <amount of nodes in this subtree>
        make a choice given the previous probabilities

    But how can we know the amount of nodes in a given subtree? One possible alternative is to recursively
    count the amount of nodes in the subtree of the current node, however that would entail going through the
    entire subtree to find this value, which would be quite time and space consuming. Another alternative is to,
    when add a new node to the tree, we increment the count of children of the parent of the new node by one, and
    continue to do so until we reach the root node of the entire tree (which is <almost> like a segment tree).
    This way, finding the information of the count of nodes in a given subtree can be done in O(1) when we are
    selecting a random node in the tree (although, of course, in a imbalanced tree, inserting a new node can be
    done in O(1), however propagating the count of nodes upward makes the insert method become O(n)).

     */

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        double childrenLeft = 0;
        double childrenRight = 0;

        TreeNode (int val) {
            this.val = val;
        }

        void createLeft (int val) {
            left = new TreeNode(val);
            left.parent = this;
            childrenLeft++;

            incrementParents(this);
        }

        void createRight (int val) {
            right = new TreeNode(val);
            right.parent = this;
            childrenRight++;

            incrementParents(this);
        }

        TreeNode getRandomNode() {
            if (left == null && right == null) return this;
            double totalNodes = childrenLeft + childrenRight + 1;
            double chooseThis = 1 / totalNodes;
            double chooseLeft = childrenLeft / totalNodes;

            double random = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
            if (random < chooseThis) return this;
            else if (random >= chooseThis && random < chooseThis + chooseLeft) {
                if (childrenLeft == 0) return this.getRandomNode();
                else return left.getRandomNode();
            }
            else {
                if (childrenRight == 0) return this.getRandomNode();
                else return right.getRandomNode();
            }
        }

        private void decrementParents(TreeNode root) {
            TreeNode temp = root;
            while (temp.parent != null) {
                if (temp.parent.left == temp) {
                    temp.parent.childrenLeft--;
                } else {
                    temp.parent.childrenRight--;
                }
                temp = temp.parent;
            }
        }

        private void incrementParents(TreeNode root) {
            TreeNode temp = root;
            while (temp.parent != null) {
                if (temp.parent.left == temp) {
                    temp.parent.childrenLeft++;
                } else {
                    temp.parent.childrenRight++;
                }
                temp = temp.parent;
            }
        }

        private int getToLeafAndRemove(TreeNode node) {
            while (node.left != null || node.right != null) {
                if (node.left != null)
                    node = node.left;
                else
                    node = node.right;
            }
            decrementParents(node);
            if (node.parent.left == node)
                node.parent.left = null;
            else
                node.parent.right = null;
            return node.val;
        }

        void delete() throws Exception{
            if (left == null && right == null) {
                if (parent != null) {
                    if (parent.left == this) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    decrementParents(this);
                    parent = null;
                } else {
                    throw new Exception();
                }
            } else if (right == null) {
                this.val = getToLeafAndRemove(left);
            } else {
                this.val = getToLeafAndRemove(right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.createLeft(2);
        root.createRight(4);
        root.left.createLeft(3);
        root.left.createRight(5);
        root.left.right.createLeft(7);
        root.left.right.createRight(8);
        root.right.createRight(6);

        int [] count = new int[9];

        try {
            root.left.delete();
            root.right.right.delete();
            root.right.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100000; i++)
            count[root.getRandomNode().val]++;

        System.out.println(Arrays.toString(count));
    }

}
