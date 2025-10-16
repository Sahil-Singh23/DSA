import java.util.Arrays;
import java.util.Scanner;

public class BelmanFord {
    
    static class Edge {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    static class Graph {
        int V, E;
        Edge[] edges;
        
        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[e];
        }
        
        void bellmanFord(int src) {
            int[] dist = new int[V];
            
            // Initialize distances
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            
            // Relax all edges V-1 times
            for (int i = 1; i < V; i++) {
                for (int j = 0; j < E; j++) {
                    int u = edges[j].src;
                    int v = edges[j].dest;
                    int weight = edges[j].weight;
                    
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
            
            // Check for negative-weight cycles
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
            
            printSolution(dist, src);
        }
        
        void printSolution(int[] dist, int src) {
            System.out.println("\nVertex Distance from Source " + src);
            System.out.println("-------------------------------");
            for (int i = 0; i < V; i++) {
                System.out.printf("  %d\t\t%d\n", i, 
                    dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        
        Graph graph = new Graph(V, E);
        
        System.out.println("\nEnter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.edges[i] = new Edge(src, dest, weight);
        }
        
        System.out.print("\nEnter source vertex: ");
        int source = sc.nextInt();
        
        graph.bellmanFord(source);
        
        sc.close();
    }
}