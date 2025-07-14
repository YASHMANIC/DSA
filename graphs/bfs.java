import java.util.ArrayList;

public class bfs {
    public static void main(String[] args) {
        undirected_Graph graph = new undirected_Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        ArrayList<Integer> res = graph.bfs();
        for(Integer i : res){
            System.out.println(i);
        }
    }
}
