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

public class EditEmployeeController implements Initializable {

    ObservableList<Employee> selected_Employee = FXCollections.observableArrayList();

    protected Stage stage;
    protected Scene scene;
    @FXML
    private Button apply;

    @FXML
    private TextField new_imie;

    @FXML
    private TextField new_nazwisko;

    @FXML
    private TextField new_rok;

    public ObservableList<Employee> getSelected_Employee() {
        return selected_Employee;
    }

    public void setSelected_Employee(ObservableList<Employee> selected_Employee) {
        this.selected_Employee = selected_Employee;
    }

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
                    selected_Employee.get(0).setImię(imie);
                    selected_Employee.get(0).setNazwisko(nazwisko);
                    selected_Employee.get(0).setRok_urodzenia(rok);
                    selected_Employee.get(0).setWynagrodzenie(wyplata);
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

