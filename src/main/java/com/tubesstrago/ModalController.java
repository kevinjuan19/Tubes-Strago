package com.tubesstrago;

import com.tubesstrago.data.Locations;
import com.tubesstrago.dijkstra.AllPathDistances;
import com.tubesstrago.entity.LocationName;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ModalController {
    public TextArea path;
    public TextArea distance;
    public TextArea destination;
    private AllPathDistances allPathDistances;
    private MainController controller;
    public void setController(MainController controller) {
        this.controller = controller;
        int []a=controller.getA();
        int []x=controller.getX();
        path.setText("Jalur :");
        for(int i=0;i<a.length;i++){
            if (a[i]!=0){
                path.appendText(controller.getLocationNames().get(i).getName()+"->");
            }
        }
        path.appendText(controller.getLocationNames().get(2).getName());
        distance.setText("Jarak :");
        int total=0;
        for(int i=0;i<a.length-1;i++){
            if (x[i]!=0){
                distance.appendText(x[i]+"->");
                total+=x[i];
            }
        }
        distance.appendText(String.valueOf(total));
    }
}
