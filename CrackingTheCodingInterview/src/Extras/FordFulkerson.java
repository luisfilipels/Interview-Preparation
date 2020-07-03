package Extras;

import java.util.ArrayList;

public class FordFulkerson {

    static class Edge {
        Vertex from;
        Vertex to;
        int flow, capacity;
        Edge residual;

        Edge (Vertex start, Vertex end, int capacity) {
            this.from = start;
            this.to = end;
            this.capacity = capacity;
            this.flow = 0;
        }

        boolean isResidual () {
            return capacity == 0;
        }

        int remainingCapacity () {
            return capacity - flow;
        }

        void augment (int bottleneck) {
            this.flow += bottleneck;
            residual.flow -= bottleneck;
        }

    }

    static class Vertex {
        String id;
        ArrayList<Edge> in;
        ArrayList<Edge> out;
        int currentVisit;

        Vertex (String id) {
            this.id = id;
            in = new ArrayList<>();
            out = new ArrayList<>();
        }

        void addEdgeTo (Vertex to, int capacity) {
            Edge newEdge = new Edge(this, to, capacity);
            out.add(newEdge);
            to.addEdgeFrom(newEdge);
        }

        void addEdgeOut(Edge edge) {
            out.add(edge);
        }

        void addEdgeFrom (Edge edge) {
            in.add(edge);
        }

    }

    static class GraphFordFulkerson {
        ArrayList<Vertex> vertices;
        Vertex source;
        Vertex sink;
        int maxFlow;
        int visitedToken;

        GraphFordFulkerson (Vertex source, Vertex sink) {
            this.source = source;
            this.sink = sink;
            this.visitedToken = 0;
            vertices = new ArrayList<>();
            vertices.add(source);
            vertices.add(sink);
        }

        Vertex getVertex(String id) {
            for (Vertex v : vertices) {
                if (v.id.equals(id)) {
                    return v;
                }
            }
            return null;
        }

        void addVertex(String id) {
            vertices.add(new Vertex(id));
        }

        void addVertex(Vertex v) {
            vertices.add(v);
        }

        void createEdge(Vertex from, Vertex to, int capacity) {
            from.addEdgeTo(to, capacity);
        }

        void createEdge(String fromId, String toId, int capacity) {
            Vertex from = getVertex(fromId);
            Vertex to = getVertex(toId);
            Edge newEdge = new Edge(from, to, capacity);
            from.addEdgeOut(newEdge);
            Edge residual = new Edge(to, from, 0);
            from.out.get(from.out.size()-1).residual = residual;

        }

        void solve() {
            visitedToken = 1;
            int flow = Integer.MAX_VALUE;
            do {
                flow = hasAugmentPath(flow, source);

                maxFlow += flow;
                visitedToken++;
            } while (flow != 0);
        }

        int hasAugmentPath (int flow, Vertex vertex) {
            if (vertex == sink) {
                return flow;
            }
            vertex.currentVisit = visitedToken;

            for (Edge e : vertex.out) {
                if (e.remainingCapacity() > 0 && e.to.currentVisit != visitedToken) {
                    int bottleneck = hasAugmentPath(Integer.min(flow, e.remainingCapacity()), e.to);

                    if (bottleneck > 0) {
                        e.augment(bottleneck);
                        return bottleneck;
                    }
                }
            }
            return 0;
        }

    }

    public static void main(String[] args) {

        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");

        GraphFordFulkerson graphFordFulkerson = new GraphFordFulkerson(s, t);

        graphFordFulkerson.addVertex("0");
        graphFordFulkerson.addVertex("1");
        graphFordFulkerson.addVertex("2");
        graphFordFulkerson.addVertex("3");
        graphFordFulkerson.addVertex("4");
        graphFordFulkerson.addVertex("5");
        graphFordFulkerson.addVertex("6");
        graphFordFulkerson.addVertex("7");
        graphFordFulkerson.addVertex("8");

        graphFordFulkerson.createEdge("s", "0", 10);
        graphFordFulkerson.createEdge("s", "1", 5);
        graphFordFulkerson.createEdge("s", "2", 10);
        graphFordFulkerson.createEdge("0", "3", 10);
        graphFordFulkerson.createEdge("1", "2", 10);
        graphFordFulkerson.createEdge("2", "5", 15);
        graphFordFulkerson.createEdge("3", "1", 20);
        graphFordFulkerson.createEdge("3", "6", 15);
        graphFordFulkerson.createEdge("4", "3", 3);
        graphFordFulkerson.createEdge("4", "1", 15);
        graphFordFulkerson.createEdge("5", "4", 4);
        graphFordFulkerson.createEdge("5", "8", 10);
        graphFordFulkerson.createEdge("6", "7", 10);
        graphFordFulkerson.createEdge("6", "t", 15);
        graphFordFulkerson.createEdge("7", "4", 10);
        graphFordFulkerson.createEdge("7", "5", 7);
        graphFordFulkerson.createEdge("8", "t", 10);

        graphFordFulkerson.solve();
        System.out.println(graphFordFulkerson.maxFlow);

        for (Vertex v : graphFordFulkerson.vertices) {
            for (Edge e : v.out) {
                System.out.println(v.id + "->" + e.to.id + " | Flow: " + e.flow);
            }
        }

    }

}
