public class C4TestGraph {

    public static void main(String[] args) {
        C4Graph.AdjListGraph graph = new C4Graph.AdjListGraph(4);
        graph.setBidirEdge(0, 1);
        graph.setBidirEdge(0, 2);
        graph.setBidirEdge(0, 3);
        graph.setBidirEdge(1, 2);
        graph.setBidirEdge(1, 3);
        //graph.setBidirEdge(2, 3);
        System.out.println(graph.edgeConnected(1));
        //graph.setBidirEdge(2, 3);
        /*C4Graph.AdjListGraph graph = new C4Graph.AdjListGraph(8);
        graph.setBidirEdge(0, 1);
        graph.setBidirEdge(0, 2);
        graph.setBidirEdge(0, 3);
        graph.setBidirEdge(1, 2);
        graph.setBidirEdge(1, 5);
        graph.setBidirEdge(2, 3);
        graph.setBidirEdge(2, 4);
        graph.setBidirEdge(5, 7);
        graph.setBidirEdge(5, 6);
        graph.setBidirEdge(4, 6);
        graph.setBidirEdge(7, 6);
        graph.setBidirEdge(4, 5);*/
        //graph.setBidirEdge(7, 8);

        //System.out.println(graph.getMinDegree());
        //System.out.println(graph.isComplete());

        //C4Graph.AdjListGraph graph = new C4Graph.AdjListGraph(5);
        //graph.setBidirEdge(0, 1);
        //graph.setBidirEdge(0, 3);
        //graph.setBidirEdge(1, 2);
        //graph.setBidirEdge(2, 4);
        //graph.setBidirEdge(0, 4);
        //graph.setBidirEdge(1, 4);
        //System.out.println(graph.DFS(0, 4));
        //System.out.println(graph.pathDFS(0, 4));
        //System.out.println(graph.listPathsDFS(0, 4));
        //System.out.println(graph.BFS(0, 4));
        //System.out.println(graph.pathBFS(3, 1));
        //System.out.println(graph.listPathsBFS(3, 4));
    }

}
