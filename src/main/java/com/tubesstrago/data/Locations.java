package com.tubesstrago.data;

import com.tubesstrago.entity.LocationName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Locations {
    private final ObservableList<LocationName> locationNames= FXCollections.observableArrayList();

    public Locations() {
        locationNames.add(new LocationName(1,"UKM"));
        locationNames.add(new LocationName(2,"Bandung Independent school"));
        locationNames.add(new LocationName(3,"Pertamina gas"));
        locationNames.add(new LocationName(4,"Kimia farma"));
        locationNames.add(new LocationName(5,"Domino pizza"));
        locationNames.add(new LocationName(6,"Oyo 794"));
        locationNames.add(new LocationName(7,"Oyo 1646"));
        locationNames.add(new LocationName(8,"Asoka inn"));
        locationNames.add(new LocationName(9,"Bank bni"));
        locationNames.add(new LocationName(10,"Zoe guest house"));
        locationNames.add(new LocationName(11,"Tambuhak food"));
        locationNames.add(new LocationName(12,"Starbuck"));
        locationNames.add(new LocationName(13,"Maybank kcp surya sumantri"));
        locationNames.add(new LocationName(14,"Soccer republik"));
        locationNames.add(new LocationName(15,"Zen family spa"));
        locationNames.add(new LocationName(16,"Vio hotel pasteur"));
        locationNames.add(new LocationName(17,"Btc mall"));
        locationNames.add(new LocationName(18,"Indomaret surya sumantri"));
        locationNames.add(new LocationName(19,"BCA kcp maranatha"));
        locationNames.add(new LocationName(20,"KFC"));
        locationNames.add(new LocationName(21,"Futsal 76"));
        locationNames.add(new LocationName(22,"Masjid al likhlas mosque"));
    }


    public ObservableList<LocationName> getLocationNames() {
        return locationNames;
    }








}
