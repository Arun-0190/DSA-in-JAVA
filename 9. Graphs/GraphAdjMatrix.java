public class GraphAdjMatrix {

    //In this the graph will be represented as adjacency matrix


    private int V;                      //for the number of vertices in graph
    private int E;                      //for edges in the graph

    int[][] adjMatrix;

    public GraphAdjMatrix(int nodes){

        this.V = nodes;
        this.E = 0;                 //for the start

        this.adjMatrix = new int[nodes][nodes];

    }

    public void addEdge(int u, int v){

        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;                   //for an undirected graph

        E++;                                //to know the number of edges

    }

    //string representation of the graph
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, "+E+" edges"+"\n");

        for(int v = 0; v< V; v++){
            sb.append(v+": ");
            for(int w : adjMatrix[v]){
                sb.append(w+" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        GraphAdjMatrix g= new GraphAdjMatrix(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        System.out.println(g);
    }



}
