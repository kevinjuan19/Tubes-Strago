package com.tubesstrago.entity;

import com.tubesstrago.data.Locations;
import javafx.collections.ObservableList;

public class DijkstraAttr {
    private int startPoint;
    private int destination;
    private int distance;
    private int [] path;
    private final Locations locations=new Locations();
    private final ObservableList<LocationName> locationNames=locations.getLocationNames();
    public DijkstraAttr() {
    }

    public DijkstraAttr(int i, int i1) {
        destination=i;
        distance=i1;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return locationNames.get(destination).getName();
    }
}
