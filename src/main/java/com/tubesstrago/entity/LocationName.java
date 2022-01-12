package com.tubesstrago.entity;

public class LocationName {
    private int idx;
    private String name;

    public LocationName() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public LocationName(int idx, String name) {
        this.idx=idx;
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
