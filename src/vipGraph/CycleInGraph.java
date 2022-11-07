package vipGraph;

import java.util.Stack;

public class CycleInGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
       boolean res= g.checkCycle();
        System.out.println(res);
        System.out.println("SORT ");
        g.sort(5);
        System.out.println("DFS ");
        g.dfsD2(5);
    }


}
