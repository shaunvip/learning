package vipGraph;

import java.util.*;

public class Graph {
    public int V;

    // Adjacency List as ArrayList of ArrayList's
    public final ArrayList<ArrayList<Integer>> adj;

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) { adj.get(v).add(w); }


    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.bfs(5);
        System.out.println("\nDFS");
        g.dfs(5);
        System.out.println("\nSORT $$");
        g.TPSort();
    }
    boolean checkCycle() {
        boolean[] visited= new boolean[V];
        Stack<Integer> stack= new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                if (dfsRec(adj,i,visited,-1)) return true;
            }
        }
   return false;
    }

    private boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
        visited[i]=true;

            for (Integer cu: adj.get(i)) {
                if (!visited[cu] ){
                    if (dfsRec(adj,cu,visited,i))
                     return true;
                } else if (cu!=parent) {
                    return true;
                    
                }
            }
        return false;
    }
    private void TPSort() {
        Stack<Integer> stack= new Stack<Integer>();
        boolean[] visited= new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                topologicalSort(i,visited,stack);
            }
        }
        while (!stack.empty())
            System.out.print(stack.pop() + " ");

    }

    private void topologicalSort(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i]=true;
        for (Integer cu: adj.get(i)) {
            if (!visited[cu])
                topologicalSort(cu,visited,stack);
        }
        stack.push(i);
    }

    private void dfs(int i) {
        boolean[] visited = new boolean[6];
        visited[i]=true;
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while (!stack.isEmpty()) {
            int item= stack.pop();;
            System.out.print(item+" ");

            for (Integer items : adj.get(item)) {
                if (!visited[items]) {
                    visited[items] = true;
                    stack.add(items);
                }
            }
        }
    }

    private void bfs(int val) {
        boolean[] visited = new boolean[6];
        visited[val]=true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(val);
        while (!queue.isEmpty()) {
        int item= queue.poll();;
            System.out.print(item+" ");
            for (Integer items : adj.get(item)) {
                if (!visited[items]) {
                    visited[items] = true;
                    queue.add(items);
                }
            }
        }
    }


    public void sort(int i) {
        Stack<Integer> stack= new Stack<>();
        boolean[] vi=new boolean[V];
        for (int j = 0; j < V; j++) {
            if (!vi[j]){
                tps(stack,vi,j);
            }
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    private void tps(Stack<Integer> stack, boolean[] vi,int ele) {
        vi[ele]=true;
        for (Integer cu:adj.get(ele)) {
            if (!vi[cu]){
                tps(stack,vi,cu);
            }
        }
        stack.push(ele);
    }

    public void dfsD2(int i) {
        Stack<Integer> stack= new Stack<>();
        Set<Integer> set= new HashSet<>();
        stack.add(i);
        set.add(i);
        while (!stack.empty()){
            int cu=stack.pop();
            System.out.println(cu);
            for (Integer ele: adj.get(cu)) {
                if (!set.contains(ele)) {
                    stack.add(ele);
                    set.add(ele);
                }
            }
        }
    }
}
