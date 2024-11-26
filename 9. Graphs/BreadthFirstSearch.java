import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    //3rd function is of bfs here

    private LinkedList<Integer>[] adj;

    private int V;                  //vertices
    private int E;                  //edges

    public BreadthFirstSearch(int nodes){
        this.V = nodes;
        this.E = 0;

        this.adj = new LinkedList[nodes];

        for(int v = 0; v< V; v++){
            adj[v] = new LinkedList<>();

        }
    }

    public void addEdge(int u, int v){

        this.adj[u].add(v);
        this.adj[v].add(u);                 //undirected graph
        E++;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(V+" vertices "+E+" edges."+"\n");

        for(int v = 0; v< V; v++){
            sb.append(v+": ");

            for(int w : adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //breadth first search
    public void BFS(int s){

        //making a boolean array for all vertices
        boolean[] visited = new boolean [V];

        //create a queue
        Queue<Integer> q = new LinkedList<>();

        //mark the root node as true
        visited[s] = true;
        //offer it in queue
        q.offer(s);
        //run the loop
        while(!q.isEmpty()){

            //print the element in queue
            int u = q.poll();
            System.out.print(u+"  ");

            //run loop for it's adjacency list of vertices
            for(int v : adj[u]){

                //condition if visited or not
                if(!visited[v]){
                    //mark it visited and offer it in queue
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }


    public static void main(String[] args) {

        BreadthFirstSearch bfs = new BreadthFirstSearch(7);
        bfs.addEdge(0,1);
        bfs.addEdge(1,2);
        bfs.addEdge(2,3);
        bfs.addEdge(3,0);
        bfs.addEdge(2,4);
        bfs.addEdge(4,3);
        bfs.addEdge(4,5);
        bfs.addEdge(5,6);
        bfs.addEdge(4,6);
        System.out.println(bfs);
        bfs.BFS(0);
    }


}
