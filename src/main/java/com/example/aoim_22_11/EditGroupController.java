package com.example.aoim_22_11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditGroupController implements Initializable {

    protected Stage stage;
    protected Scene scene;
    ObservableList<ClassEmployee> przekazana_grupa = FXCollections.observableArrayList();

    @FXML
    private Button apply;

    @FXML
    private TextField new_nazwa_grupy;

    @FXML
    private TextField new_pojemnosc_grupy;

    public ObservableList<ClassEmployee> getPrzekazana_grupa() {
        return przekazana_grupa;
    }

    public void setPrzekazana_grupa(ObservableList<ClassEmployee> przekazana_grupa) {
        this.przekazana_grupa = przekazana_grupa;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apply.setOnAction(event -> {
            try{
                String nazwa_grupy = new_nazwa_grupy.getText();
                int pojemnosc = Integer.parseInt(new_pojemnosc_grupy.getText());
                przekazana_grupa.get(0).setNazwa_grupy(nazwa_grupy);
                przekazana_grupa.get(0).setPojemnosc(pojemnosc);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/aoim_22_11/hello-view.fxml")));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch(Exception e){

            }
        });

    }
}
