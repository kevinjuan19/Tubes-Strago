package com.tubesstrago;


import com.tubesstrago.data.Locations;
import com.tubesstrago.dijkstra.AllPathDistances;
import com.tubesstrago.dijkstra.DijkstraFindingPath;
import com.tubesstrago.dijkstra.ShortestList;
import com.tubesstrago.entity.DijkstraAttr;
import com.tubesstrago.entity.Graph;
import com.tubesstrago.entity.LocationName;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainController{
    public Pane mapPane;
    public ComboBox<LocationName> combo1;
    public ComboBox<LocationName> combo2;
    private final DijkstraFindingPath d=new DijkstraFindingPath();
    private final Graph graph=new Graph();
    private final Locations locations=new Locations();
    private final ObservableList<LocationName> locationNames=locations.getLocationNames();
    public TableView<DijkstraAttr> table;
    public TableColumn<DijkstraAttr,String> column1;
    public TableColumn<DijkstraAttr,String> column2;


    public ObservableList<LocationName> getLocationNames() {
        return locationNames;
    }

    private int [] a;
    public int[] getA(){
        return a;
    }
    private int [] x;
    public int[]getX(){
        return x;
    }
    int row = 22;
    int col = 22;
    private int[][] numArray = new int[row][col];

    public int[][] getNumArray() {
        return numArray;
    }

    public void initialize() throws FileNotFoundException {
        combo1.setItems(locationNames);
        combo2.setItems(locationNames);

        ShortestList t = new ShortestList();

        Scanner sc = new Scanner(choseTextFile());
        while (sc.hasNextLine()) {
            for (int i = 0; i < numArray.length; i++) {
                String[] line = sc.nextLine().trim().split("," + " ");
                for (int j = 0; j < line.length; j++) {
                    numArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        graph.setAdjacencyMatrix(numArray);
        t.setVertex(col);
        t.dijkstra(numArray, 0);
        table.setItems(t.getDijkstraAttrs());
        column1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().toString())));
        column2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getDistance())));
    }
    private static File choseTextFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }
    @FXML
    private void run() throws IOException {
        d.dijkstra(graph.getAdjacencyMatrix(),combo1.getSelectionModel().getSelectedIndex(),combo2.getSelectionModel().getSelectedIndex());
        DijkstraAttr dA=d.getAttr();
        a=dA.getPath();
        AllPathDistances allPathDistances = new AllPathDistances();
        x=allPathDistances.allDistance(graph.getAdjacencyMatrix(),dA.getPath());
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("modal-view.fxml"));
        Stage new_stage = new Stage();
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        ModalController controller= fxmlLoader.getController();
        controller.setController(this);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.initOwner(combo1.getScene().getWindow());
        new_stage.setScene(scene);
        new_stage.show();
    }
}
