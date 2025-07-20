import java.util.*;

public class graph {  // Class name should start with an uppercase letter as per convention
    public static class Edge {  // Made Edge class static
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    // Breath First Search ....-> Time comp : O(Vertices + Edge)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean seen[] = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!seen[curr]){
                System.out.println(curr+" ");
                seen[curr] = false;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //Depth First Search
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean seen[]){
        System.out.println(curr+" ");
        seen[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!seen[e.dest]){
                dfs(graph, e.dest,  seen);
            }
        }
    }
        // check path exist or not
    public static boolean hasPath(ArrayList<Edge>[] graph, int src,int dest,  boolean arr[]){
        if(src==dest){
            return true;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!arr[e.dest] && hasPath(graph, e.dest, dest, arr)){
                return  true;
            }
        }
        return false;
    }

        //  check cycle exist or not

        public static boolean checkCycle(ArrayList<Edge>[] graph){
            boolean seen[] = new boolean[graph.length];
            for(int i=0; i<graph.length; i++){
                if(!seen[i]){
                    if(checkCycleUtils(graph, seen,i, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }
        public static boolean checkCycleUtils(ArrayList<Edge>[] graph, boolean seen[], int curr , int par){
            seen[curr] = true;

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                //case 3 : 
                if(!seen[e.dest]){
                    if( checkCycleUtils(graph, seen, e.dest, curr)){
                        return true;
                    }
                    
                }
                // case 2 : 
                else if(seen[curr] && e.dest != par){
                    return true;
                }
                // case 1 : do nothing continue

            }
            return  false;
        }
        // check graph is Bipartite or not : If graph does not have cycle it is Bipartite; 
        public static boolean isBipartite(ArrayList<Edge>[] graph){
            int col[] = new int[graph.length];
            for(int i=0; i<col.length; i++){
                col[i] = -1;
            }

            Queue<Integer> q = new LinkedList<>();

            for(int i=0; i<graph.length; i++){
                if(col[i] == -1){
                    q.add(i);
                    col[i] = 0; // yellow
                    while(!q.isEmpty()){
                        int curr = q.remove();
                        for(int j=0; j<graph[curr].size(); j++){
                            Edge e = graph[curr].get(i); // e.dest
                            if(col[e.dest] == -1){
                                int nextCol = col[curr] == 0 ? 1 : 0;
                                col[e.dest] = nextCol;
                                q.add(e.dest);
                            }else if(col[e.dest] == col[curr]){
                                return false; 
                            }
                        }
                    }
                }
            }
            return true;
        }

    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>(); // Initialize empty lists
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));  // Fixed syntax error
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 2's neighbors
        // for (int i = 0; i < graph[2].size(); i++) {  // Fixed loop condition
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }
        //caling bfs function
        
        dfs(graph, 0, new boolean[V]);
    }
}
