module com.example.tubesstrago {
    requires javafx.controls;
    requires javafx.fxml;

    requires jdk.jsobject;
    requires java.logging;
    requires java.desktop;


    opens com.tubesstrago to javafx.fxml;
    exports com.tubesstrago;
    exports com.tubesstrago.entity;
}