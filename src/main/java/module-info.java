module com.example.aoim_22_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aoim_22_11 to javafx.fxml;
    exports com.example.aoim_22_11;
}