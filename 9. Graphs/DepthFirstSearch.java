import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    //3rd function is of dfs here(Iterative approach)

    private LinkedList<Integer>[] adj;

    private int V;                  //vertices
    private int E;                  //edges

    public DepthFirstSearch(int nodes){
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

    //Depth first search
    public void DFS(int s){

        //making a boolean array for all vertices
        boolean[] visited = new boolean [V];

        //create a stack
        Stack<Integer> stack = new Stack<>();

        //push source in stack
        stack.push(s);
        //run the loop
        while(!stack.isEmpty()){
            int u = stack.pop();

            if(!visited[u]) {
                //mark it visited and offer it in queue
                visited[u] = true;
                System.out.print(u+"  ");

                //run the loop for it's adjacency list
                for(int v : adj[u]){

                    //condition if not visited again
                    if(!visited[v]){

                        //push if not
                        stack.push(v);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        DepthFirstSearch dfs = new DepthFirstSearch(7);
        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(3,0);
        dfs.addEdge(2,4);
        dfs.addEdge(4,3);
        dfs.addEdge(4,5);
        dfs.addEdge(5,6);
        dfs.addEdge(4,6);
        System.out.println(dfs);
        dfs.DFS(0);

    }


}

