package com.tubesstrago.dijkstra;

import com.tubesstrago.entity.DijkstraAttr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShortestList {
    private int V;
    private ObservableList<DijkstraAttr>dijkstraAttrs= FXCollections.observableArrayList();

    public ObservableList<DijkstraAttr> getDijkstraAttrs() {
        return dijkstraAttrs;
    }

    public void setVertex(int v) {
        V = v;
    }

    public ShortestList() {
    }

    public int minDistance(int[] dist, Boolean[] sptSet)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }


    public void printSolution(int[] dist)
    {
        ObservableList<DijkstraAttr>dList=FXCollections.observableArrayList();
        for (int i = 1; i < V; i++)
            dList.add(i-1,new DijkstraAttr(i,dist[i]));
//            System.out.println(i + " \t\t " + dist[i]);
        dijkstraAttrs.addAll(dList);
    }

    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        Boolean[] sptSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist);
    }
}
