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

public class AddEmployeeController implements Initializable {


    protected Stage stage;
    protected Scene scene;

    ObservableList<ClassEmployee> grupa = FXCollections.observableArrayList();

    public ObservableList<ClassEmployee> getGrupa() {
        return grupa;
    }

    public void setGrupa(ObservableList<ClassEmployee> grupa) {
        this.grupa = grupa;
    }

    @FXML
    private Button apply;

    @FXML
    private TextField new_imie;

    @FXML
    private TextField new_nazwisko;

    @FXML
    private TextField new_rok;

    @FXML
    private TextField new_salary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apply.setOnAction(event -> {
            try {
            String imie = new_imie.getText();
            String nazwisko = new_nazwisko.getText();
            int rok = Integer.parseInt(new_rok.getText());
            double wyplata = Double.parseDouble(new_salary.getText());
            Employee pracownik = new Employee(imie, nazwisko, rok, wyplata);
            grupa.get(0).addEmployee(pracownik);

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