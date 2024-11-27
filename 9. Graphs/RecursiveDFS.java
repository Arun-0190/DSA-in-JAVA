import java.util.LinkedList;
import java.util.Stack;

public class RecursiveDFS {
    //3rd function is of dfs here(Recursive approach)

    private LinkedList<Integer>[] adj;

    private int V;                  //vertices
    private int E;                  //edges

    public RecursiveDFS(int nodes){
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

    //Depth first search            we can mention the source node too if we want, but it's not necessary here
    public void DFS(){

        //making a boolean array for all vertices
        boolean[] visited = new boolean [V];

        //loop for visiting all the vertices
        for(int v = 0; v < V; v++){

            if(!visited[v]){                        //checking condition
                dfs(v,visited);                     //calling the function

            }
        }
    }

    public void dfs(int v, boolean[] visited){

        //marking the vertices as visited
        visited[v] = true;
        //printing the visited node
        System.out.print(v+"  ");

        //running loop for it's adjacent list
        for(int w : adj[v]){

            //condition check for visited or not
            if(!visited[w]){

                dfs(w, visited);                    //recursing the function here till every adjacent list is visited

            }
        }
    }


    public static void main(String[] args) {

        RecursiveDFS dfs = new RecursiveDFS(8);
        dfs.addEdge(0,7);
        dfs.addEdge(7,2);
        dfs.addEdge(3,4);
        dfs.addEdge(2,4);
        dfs.addEdge(4,5);
        dfs.addEdge(4,6);
        dfs.addEdge(5,6);
        dfs.addEdge(2,1);
        System.out.println(dfs);
        dfs.DFS();

    }


}
