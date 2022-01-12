package com.tubesstrago.dijkstra;

public class AllPathDistances {
    public AllPathDistances() {
    }

    public int[] allDistance(int[][]graph, int[] path){
        int [] arr=new int[path.length];
        int j=path.length-1;
        for (int i=0;i<j;i++){
            arr[i]=(graph[path[j-i]][path[j-i-1]]);
        }
        return arr;
    }
}
